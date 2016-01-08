package com.blossom.workrecd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.blossom.workrecd.Utils.ToastHelper;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class DingyueActivity extends Activity {

    @ViewInject(R.id.left_btn)
    private ImageButton leftbutton;
    @ViewInject(R.id.right_txt)
    private TextView righttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dingyue);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.right_txt,R.id.diquxuanze})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.right_txt:
                ToastHelper.show(this,"保存");
                break;
            case R.id.diquxuanze:
                Intent diqu = new Intent(DingyueActivity.this,XuanzediquActivity.class);
                startActivity(diqu);
                break;
        }
    }

}
