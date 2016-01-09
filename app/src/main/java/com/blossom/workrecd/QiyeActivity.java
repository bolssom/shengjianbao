package com.blossom.workrecd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class QiyeActivity extends Activity {
    @ViewInject(R.id.mingqi_01)
    private ImageButton mingqi_01;
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qiye);
        ViewUtils.inject(this);
        initview();

    }
    //初始化界面
    private void initview() {

        mtitleview.setTitle("企业精选");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(QiyeActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
    @OnClick(R.id.mingqi_01)
    public void myClick(View v){
        switch (v.getId()){
            case R.id.mingqi_01:
                Intent mx01 = new Intent(QiyeActivity.this,MingqidetailActivity.class);
                startActivity(mx01);
                break;
        }
    }
}
