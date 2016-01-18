package com.blossom.workrecd.ziliao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class WrenzhengActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wrenzheng);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.renzheng_sfz,R.id.renzheng_xsz})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.renzheng_sfz:
                Intent sfz = new Intent(WrenzhengActivity.this,ShenfenrezhengActivity.class);
                startActivity(sfz);
                break;
            case R.id.renzheng_xsz:
                Intent xsz = new Intent(WrenzhengActivity.this,XueshengzhengActivity.class);
                startActivity(xsz);
                break;
        }
    }
}
