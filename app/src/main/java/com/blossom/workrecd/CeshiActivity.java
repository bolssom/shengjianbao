package com.blossom.workrecd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class CeshiActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ceshi);
        ViewUtils.inject(this);
        initview();
    }

    private void initview() {

        mtitleview.setTitle("测试题");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(CeshiActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
}
