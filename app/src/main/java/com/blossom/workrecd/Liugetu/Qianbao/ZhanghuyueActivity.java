package com.blossom.workrecd.Liugetu.Qianbao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.MsgActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class ZhanghuyueActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zhanghuyue);
        ViewUtils.inject(this);
        initview();

    }
    private void initview() {

        mtitleview.setTitle("账户余额");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(ZhanghuyueActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
    @OnClick({R.id.goyu_e,R.id.gochongzhi,R.id.gotixian,R.id.goka})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.goyu_e:
                Intent mx = new Intent(ZhanghuyueActivity.this, MingxiActivity.class);
                startActivity(mx);
                break;
            case R.id.gochongzhi:
                Intent ka = new Intent(ZhanghuyueActivity.this, ChongzhiActivity.class);
                startActivity(ka);
                break;
            case R.id.gotixian:
                Intent tx = new Intent(ZhanghuyueActivity.this, TixianActivity.class);
                startActivity(tx);
                break;
            case R.id.goka:
                Intent yhk = new Intent(ZhanghuyueActivity.this, YinhangkaActivity.class);
                startActivity(yhk);
                break;
        }
    }
}
