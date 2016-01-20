package com.blossom.workrecd.Liugetu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class JifenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jifen);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.jfmx,R.id.shangpin})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.jfmx:
                Intent jf = new Intent(JifenActivity.this,JifenmingxiActivity.class);
                startActivity(jf);
                break;
            case R.id.shangpin:
                Intent sp = new Intent(JifenActivity.this,ShangpindetailActivity.class);
                startActivity(sp);
                break;
        }
    }
}
