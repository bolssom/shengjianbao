package com.blossom.workrecd.Setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.NewsdetailActivity;
import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class SettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.gomima,R.id.goshouji,R.id.gocache})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.gomima:
                Intent gomima = new Intent(SettingActivity.this, AnquanmimaActivity.class);
                startActivity(gomima);
                break;
            case R.id.goshouji:
                Intent goshouji = new Intent(SettingActivity.this, ShoujibiangengaActivity.class);
                startActivity(goshouji);
                break;
            case R.id.gocache:
                Intent gocache = new Intent(SettingActivity.this, NewsdetailActivity.class);
                startActivity(gocache);
                break;
        }
    }
}
