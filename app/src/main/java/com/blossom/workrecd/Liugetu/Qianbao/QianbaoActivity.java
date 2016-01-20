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

public class QianbaoActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qianbao);
        ViewUtils.inject(this);
        initview();

    }
    private void initview() {

        mtitleview.setTitle("钱包管理");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(QianbaoActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
    @OnClick({R.id.yu_e,R.id.yinhangka})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.yu_e:
                Intent yu_e = new Intent(QianbaoActivity.this, ZhanghuyueActivity.class);
                startActivity(yu_e);
                break;
            case R.id.yinhangka:
                Intent ka = new Intent(QianbaoActivity.this, YinhangkaActivity.class);
                startActivity(ka);
                break;
        }
    }
}
