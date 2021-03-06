package com.blossom.workrecd.Setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class AnquanmimaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_anquanmima);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.godenglu,R.id.gozhifu})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.godenglu:
                Intent gomima = new Intent(AnquanmimaActivity.this, ModifydengluActivity.class);
                startActivity(gomima);
                break;
            case R.id.gozhifu:
                Intent goshouji = new Intent(AnquanmimaActivity.this, ModifyzhifuActivity.class);
                startActivity(goshouji);
                break;
        }
    }
}
