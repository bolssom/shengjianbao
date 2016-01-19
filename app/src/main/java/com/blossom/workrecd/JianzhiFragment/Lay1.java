package com.blossom.workrecd.JianzhiFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blossom.workrecd.R;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class Lay1 extends Fragment {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private View mParent;
    private FragmentActivity mActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lay1, container, false);
        ViewUtils.inject(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mParent = getView();
    }
    @OnClick(R.id.quxiaobaoming)
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.quxiaobaoming:
                Intent qxbm = new Intent(mParent.getContext(), BaomingquxiaoActivity.class);
                startActivity(qxbm);
                break;
        }
    }
}
