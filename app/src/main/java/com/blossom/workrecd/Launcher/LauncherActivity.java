package com.blossom.workrecd.Launcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.blossom.workrecd.R;
import com.blossom.workrecd.Utils.AnimationUtil;

import java.util.ArrayList;
import java.util.List;

public class LauncherActivity extends FragmentActivity {
    private ViewPager mVPActivity;
    private Fragment1 mFragment1;
    private Fragment2 mFragment2;
    private Fragment3 mFragment3;
    private List<Fragment> mListFragment = new ArrayList<Fragment>();
    private PagerAdapter mPgAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
        initView();
    }

    private void initView() {
        mVPActivity = (ViewPager) findViewById(R.id.vp_activity);
        mFragment1 = new Fragment1();
        mFragment2 = new Fragment2();
        mFragment3 = new Fragment3();
        mListFragment.add(mFragment1);
        mListFragment.add(mFragment2);
        mListFragment.add(mFragment3);
        mPgAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                mListFragment);
        mVPActivity.setAdapter(mPgAdapter);
        AnimationUtil.activityZoomAnimation(mVPActivity.getContext());
    }
}
