package com.blossom.workrecd.Liugetu.Qianbao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class DetailkaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detailka);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.tianjia})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.tianjia:
                Intent tj = new Intent(DetailkaActivity.this, TianjiakaActivity.class);
                startActivity(tj);
                break;
        }
    }
}
