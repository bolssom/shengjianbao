package com.blossom.workrecd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.blossom.workrecd.Utils.Utils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class XuanzediquActivity extends Activity implements AMapLocationListener {
    @ViewInject(R.id.left_btn)
    private ImageButton leftbutton;
    @ViewInject(R.id.tvReult)
    private TextView tvReult;
    @ViewInject(R.id.qu)
    private TextView qu;
    String city;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xuanzediqu);
        ViewUtils.inject(this);

        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        // 设置定位监听
        locationClient.setLocationListener(this);
        initOption();
    }

    @OnClick({R.id.left_btn,R.id.tvReult})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                // 停止定位
                locationClient.stopLocation();
                finish();
                break;
            case R.id.tvReult:
                Intent amapintent = new Intent(XuanzediquActivity.this,MainActivity.class);
                amapintent.putExtra("city",city);
                startActivity(amapintent);
                break;
        }
    }

    // 根据控件的选择，重新设置定位参数
    private void initOption() {
        // 设置是否需要显示地址信息
        locationOption.setNeedAddress(true);
        locationOption.setInterval(2000);
        locationOption.setOnceLocation(true);
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
        mHandler.sendEmptyMessage(Utils.MSG_LOCATION_START);
    }
    // 定位监听
    @Override
    public void onLocationChanged(AMapLocation loc) {
        if (null != loc) {
            Message msg = mHandler.obtainMessage();
            msg.obj = loc;
            msg.what = Utils.MSG_LOCATION_FINISH;
            mHandler.sendMessage(msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

    Handler mHandler = new Handler() {
        public void dispatchMessage(android.os.Message msg) {
            switch (msg.what) {
                //开始定位
                case Utils.MSG_LOCATION_START:
                    tvReult.setText("正在定位...");
                    break;
                // 定位完成
                case Utils.MSG_LOCATION_FINISH:
                    AMapLocation loc = (AMapLocation) msg.obj;
                    //String result = Utils.getLocationStr(loc);
                    //System.out.println("city--------------" + loc.getCity());
                    qu.setText(loc.getDistrict());
                    tvReult.setText(loc.getCity());
                    city = loc.getCity();
                    SharedPreferences sharedPreferences = getSharedPreferences("cityInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                    editor.putString("city",loc.getCity());
                    editor.putString("district",loc.getDistrict());
                    editor.commit();//提交修改
                    break;
                //停止定位
                case Utils.MSG_LOCATION_STOP:
                    tvReult.setText("定位停止");
                    break;
                default:
                    break;
            }
        };
    };
}
