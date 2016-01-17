package com.blossom.workrecd.JianzhiFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;

import com.astuetz.PagerSlidingTabStrip;
import com.blossom.workrecd.MsgActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class JianzhiActivity extends FragmentActivity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;

    private    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jianzhi);
        ViewUtils.inject(this);

        initview();
        viewpager = (ViewPager) findViewById(R.id.viewpager); //获取ViewPager
        viewpager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip strip = (PagerSlidingTabStrip) findViewById(R.id.tabstrip);  //获取PagerSlidingTabStrip控件对象
        strip.setShouldExpand(true); //设置标签自动扩展——当标签们的总宽度不够屏幕宽度时，自动扩展使每个标签宽度递增匹配屏幕宽度，注意！这一条代码必须在setViewPager前方可生效
        strip.setViewPager(viewpager); //这是其所handle的ViewPager
        strip.setDividerColor(R.color.line); //设置每个标签之间的间隔线颜色 ->灰色
        strip.setTextColor(R.color.huitext);
        strip.setDividerPadding(0);
       strip.setUnderlineHeight(3); //设置标签栏下边的间隔线高度，单位像素
       strip.setIndicatorHeight(6); //设置Indicator 游标 高度，单位像素


        Intent flagintent = getIntent();
        String flag = flagintent.getStringExtra("flag");
        if (flag!=null){
        setViewpager(flag);}
    }
     private void initview() {

        mtitleview.setTitle("我的兼职");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(JianzhiActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }

    class myPagerAdapter extends FragmentPagerAdapter {
        String[] title = { "已报名", "已录用", "已完成","待评价" };
        Lay1 Lay1;
        Lay2 Lay2;
        Lay3 Lay3;
        Lay5 Lay5;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Lay1 = new Lay1();
                    return Lay1;
                case 1:
                    Lay2 = new Lay2();
                    return Lay2;
                case 2:
                    Lay3 = new Lay3();
                    return Lay3;
                case 3:
                    Lay5 = new Lay5();
                    return Lay5;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }


//    private void addFragmentToStack(Fragment fragment) {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        //        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left);
//        ft.replace(R.id.fragment_container, fragment);
//        ft.commit();
//    }
    public void setViewpager(String index){
        switch (index){
            case "0":
                viewpager.setCurrentItem(0);
                break;
            case "1":
                viewpager.setCurrentItem(1);
                break;
            case "2":
                viewpager.setCurrentItem(2);
                break;
            case "3":
                viewpager.setCurrentItem(3);
                break;
        }
    }
}
