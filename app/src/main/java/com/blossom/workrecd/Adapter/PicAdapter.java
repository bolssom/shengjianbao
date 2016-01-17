package com.blossom.workrecd.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.blossom.workrecd.R;

/**
 * Created by zxw on 2016/1/9.
 */
public class PicAdapter extends BaseAdapter {
    private Context context;
    private int[] imgs ={
      R.mipmap.xuetang_01,R.mipmap.xuetang_02,R.mipmap.xuetang_03,R.mipmap.xuetang_04,R.mipmap.xuetang_05,R.mipmap.xuetang_06,R.mipmap.xuetang_07,R.mipmap.xuetang_08,
    };

    public PicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));//设置ImageView对象布局
            imageView.setAdjustViewBounds(false);//设置边界对齐
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置刻度的类型
            imageView.setPadding(0, 20, 0, 20);//设置间距
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imgs[position]);//为ImageView设置图片资源
        return imageView;
    }

}
