package com.blossom.workrecd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.blossom.workrecd.Utils.ToastHelper;

public class MainActivity extends FragmentActivity  implements
        CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private RadioButton mTab1;
    private RadioButton mTab2;
    private RadioButton mTab3;
    private RadioButton mTab4;
    private RadioButton mTab5;

    private FrameLayout mContainer;

    public CompoundButton currentButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTab1 = (RadioButton) findViewById(R.id.radio_button0);
        mTab2 = (RadioButton) findViewById(R.id.radio_button1);
        mTab3 = (RadioButton) findViewById(R.id.radio_button2);
        mTab4 = (RadioButton) findViewById(R.id.radio_button3);
        mContainer = (FrameLayout) findViewById(R.id.container);

        mTab1.setOnCheckedChangeListener(this);
        mTab2.setOnCheckedChangeListener(this);
        mTab3.setOnCheckedChangeListener(this);
        mTab4.setOnCheckedChangeListener(this);

        mTab1.setOnClickListener(this);
        mTab2.setOnClickListener(this);
        mTab3.setOnClickListener(this);
        mTab4.setOnClickListener(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra("login",-1);
        if(id==1){
            mTab4.performClick();
        }else {
            mTab1.performClick();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Fragment fragment = (Fragment) mFragmentPagerAdapter
                    .instantiateItem(mContainer, buttonView.getId());
            mFragmentPagerAdapter.setPrimaryItem(mContainer, 0, fragment);
            mFragmentPagerAdapter.finishUpdate(mContainer);
        }
    }

    private FragmentPagerAdapter mFragmentPagerAdapter = new FragmentPagerAdapter(
            getSupportFragmentManager()) {

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case R.id.radio_button1:
                    return new Fragment2();
                case R.id.radio_button2:
                    return new Fragment3();
                case R.id.radio_button3:
                    return new Fragment4();
                case R.id.radio_button0:
                default:
                    return new HomeFragment();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

    };

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }
    public void setTab(int index){
        switch (index){
            case 0:
                mTab1.performClick();
                break;
            case 1:
                mTab2.performClick();
                break;
            case 2:
                mTab3.performClick();
                break;
            case 3:
                mTab4.performClick();
                break;
        }
    }
    private  long mExitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //监听按下返回键
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){

            if (this.getFragmentManager().getBackStackEntryCount()==0){
                if ((System.currentTimeMillis()-mExitTime) > 2000) {
                    ToastHelper.show(this, "再按一次退出！");
                    mExitTime = System.currentTimeMillis();
                }else {
                    finish();
                    System.exit(0);
                }
        }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

