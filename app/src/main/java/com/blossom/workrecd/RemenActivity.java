package com.blossom.workrecd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.blossom.workrecd.Dao.ADInfo;
import com.blossom.workrecd.Utils.imagecycleview.ImageCycleView;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

public class RemenActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @ViewInject(R.id.ad_view)
    private ImageCycleView ad_view;
    private ArrayList<ADInfo> adInfos = new ArrayList<ADInfo>();
    private String[] imageurls = {
            "http://77l57k.com1.z0.glb.clouddn.com/productbanner1.jpg",
            "http://77l57k.com1.z0.glb.clouddn.com/productbanner2.jpg",
            "http://77l57k.com1.z0.glb.clouddn.com/productbanner3.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_remen);
        ViewUtils.inject(this);
        initview();

        for (int i = 0; i < imageurls.length; i++) {
            ADInfo info = new ADInfo();
            info.setUrl(imageurls[i]);
            info.setContent("top-->" + i);
            adInfos.add(info);
        }
        ad_view.setImageResources(adInfos, imageCycleViewListener);

    }
    //初始化界面
    private void initview() {

        mtitleview.setTitle("热门精选");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(RemenActivity.this, MoreActivity.class);
                startActivity(moreintent);
            }
        });

    }


    private ImageCycleView.ImageCycleViewListener imageCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            BitmapUtils bitmapUtils = new BitmapUtils(RemenActivity.this);
            bitmapUtils.display(imageView, imageURL);
        }
        @Override
        public void onImageClick(ADInfo info, int postion, View imageView) {
            //ToastHelper.show(LiuyanActivity.this, "content->" + info.getContent());
            Intent gongjiintent = new Intent(RemenActivity.this, MoreActivity.class);
            startActivity(gongjiintent);
        }
    };
}
