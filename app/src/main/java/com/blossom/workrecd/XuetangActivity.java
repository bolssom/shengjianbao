package com.blossom.workrecd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import com.blossom.workrecd.Adapter.PicAdapter;
import com.blossom.workrecd.Utils.ToastHelper;
import com.blossom.workrecd.View.GridViewForScrollView;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

public class XuetangActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @ViewInject(R.id.gridview_xuetang)
    private GridViewForScrollView gv_xuetang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xuetang);
        ViewUtils.inject(this);
        initview();
        gv_xuetang.setAdapter(new PicAdapter(this));

    }
    private void initview() {

        mtitleview.setTitle("生兼学堂");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(XuetangActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
    @OnClick(R.id.toutiao)
    public void myClick(View v){
        switch (v.getId()){
            case R.id.toutiao:
                Intent newsdetail = new Intent(XuetangActivity.this, NewsdetailActivity.class);
                startActivity(newsdetail);
                break;
        }
    }
    @OnItemClick(R.id.gridview_xuetang)
    public void myItemClick(AdapterView<?> parent,View v,int position,long id){
        ToastHelper.show(this,"点击了-->"+position);
    }
}
