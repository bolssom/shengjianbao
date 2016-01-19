package com.blossom.workrecd.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.R;
import com.blossom.workrecd.SuccessregActivity;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class RegisterActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        ViewUtils.inject(this);
        initview();
    }
    private void initview() {

        mtitleview.setTitle("注册");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.hiddenRightImageButton();

    }
    @OnClick({R.id.button_reg})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.button_reg:
                Intent rg = new Intent(RegisterActivity.this, SuccessregActivity.class);
                startActivity(rg);
                break;
        }
    }
}
