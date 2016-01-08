package com.blossom.workrecd;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blossom.workrecd.Utils.ToastHelper;
import com.blossom.workrecd.View.ExpandTabView;
import com.blossom.workrecd.View.ViewMid1;
import com.blossom.workrecd.View.ViewLeft;
import com.blossom.workrecd.View.ViewMid2;
import com.blossom.workrecd.View.ViewRight;
import com.lidroid.xutils.ViewUtils;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    private View mParent;
    private FragmentActivity mActivity;
    private ExpandTabView expandTabView;
    private ArrayList<View> mViewArray = new ArrayList<View>();
    private ViewMid1  viewMid1;
    private ViewLeft  viewLeft;
    private ViewMid2 viewMid2;
    private ViewRight viewRight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mParent = getView();
        initView();
        initValue();
        initListener();
    }


    private void initView() {

        expandTabView = (ExpandTabView) mParent.findViewById(R.id.expandtab_view);
        viewLeft = new ViewLeft(mParent.getContext());
        viewMid1 = new ViewMid1(mParent.getContext());
        viewMid2 = new ViewMid2(mParent.getContext());
        viewRight = new ViewRight(mParent.getContext());

    }
    private  void  initValue(){
        mViewArray.add(viewLeft);
        mViewArray.add(viewMid1);
        mViewArray.add(viewMid2);
        mViewArray.add(viewRight);
        ArrayList<String> mTextArray = new ArrayList<String>();
        mTextArray.add("职位");
        mTextArray.add("结算方式");
        mTextArray.add("日期");
        mTextArray.add("智能筛选");
        expandTabView.setValue(mTextArray, mViewArray);
        expandTabView.setTitle(mTextArray.get(0), 0);
        expandTabView.setTitle(mTextArray.get(1), 1);
        expandTabView.setTitle(mTextArray.get(2),2);
        expandTabView.setTitle(mTextArray.get(3), 3);
    }
    private  void initListener(){
        viewLeft.setOnSelectListener(new ViewLeft.OnSelectListener() {
            @Override
            public void getValue(String showText) {
                onRefresh(viewLeft,showText);

            }
        });
        viewMid1.setOnSelectListener(new ViewMid1.OnSelectListener() {
            @Override
            public void getValue(String distance, String showText) {
                onRefresh(viewMid1, showText);
            }
        });
        viewMid2.setOnSelectListener(new ViewMid2.OnSelectListener() {
            @Override
            public void getValue(String distance, String showText) {
                onRefresh(viewMid2, showText);
            }
        });

        viewRight.setOnSelectListener(new ViewRight.OnSelectListener() {

            @Override
            public void getValue(String distance, String showText) {
                onRefresh(viewRight, showText);
            }
        });
    }

    private void onRefresh(View view,String showText){
        expandTabView.onPressBack();
        int position = getPosition(view);
        if (position >= 0 && !expandTabView.getTitle(position).equals(showText)) {
            expandTabView.setTitle(showText, position);
        }
        //Toast.makeText(MainActivity.this, showText, Toast.LENGTH_SHORT).show();
        ToastHelper.show(mParent.getContext(),showText);
    }
    private int getPosition(View tView){
        for (int i = 0;i < mViewArray.size();i++){
            if (mViewArray.get(i) == tView){
                return i;
            }
        }
        return -1;
    }

//    public void onBackPressed(){
//        if (!expandTabView.onPressBack()){
//            mActivity.finish();
//        }
//    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null)
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }
}

