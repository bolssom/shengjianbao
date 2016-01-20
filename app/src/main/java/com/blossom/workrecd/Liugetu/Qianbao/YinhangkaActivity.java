package com.blossom.workrecd.Liugetu.Qianbao;

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

public class YinhangkaActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_yinhangka);
        ViewUtils.inject(this);
        initview();

    }
    private void initview() {

        mtitleview.setTitle("银行卡");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(YinhangkaActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
    @OnClick({R.id.tianjia,R.id.goyinhangka})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.goyinhangka:
                Intent goka = new Intent(YinhangkaActivity.this, DetailkaActivity.class);
                startActivity(goka);
                break;
            case R.id.tianjia:
                Intent tk = new Intent(YinhangkaActivity.this, TianjiakaActivity.class);
                startActivity(tk);
                break;
        }
    }
}
