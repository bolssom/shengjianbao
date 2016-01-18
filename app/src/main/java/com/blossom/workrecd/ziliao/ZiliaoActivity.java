package com.blossom.workrecd.ziliao;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class ZiliaoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ziliao);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.per_info,R.id.gorenzheng})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.per_info:
                Intent zl = new Intent(ZiliaoActivity.this,JibenziliaoActivity.class);
                startActivity(zl);
                break;
            case R.id.gorenzheng:
                Intent grz = new Intent(ZiliaoActivity.this,WrenzhengActivity.class);
                startActivity(grz);
                break;
        }
    }
}
