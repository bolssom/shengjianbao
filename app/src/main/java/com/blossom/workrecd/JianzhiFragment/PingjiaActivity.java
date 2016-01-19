package com.blossom.workrecd.JianzhiFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.blossom.workrecd.MsgActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class PingjiaActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pingjia);
        ViewUtils.inject(this);
        initview();
    }
    private void initview() {

        mtitleview.setTitle("评价");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(PingjiaActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

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
