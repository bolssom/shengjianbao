package com.blossom.workrecd.Liugetu.Qianbao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class TixianActivity extends  Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tixian);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
        }
    }
}
