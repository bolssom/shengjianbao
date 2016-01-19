package com.blossom.workrecd.Setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class ShoujibiangengaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shoujibiangenga);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.next})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.next:
                Intent next = new Intent(ShoujibiangengaActivity.this, ShoujibiangengbActivity.class);
                startActivity(next);
                break;
        }
    }
}
