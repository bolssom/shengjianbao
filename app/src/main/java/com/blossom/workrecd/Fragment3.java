package com.blossom.workrecd;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private View mParent;
    private FragmentActivity mActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mParent = getView();
    initview();
    }


    private void initview() {

        mtitleview.setTitle("生兼社区");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                ( (MainActivity)getActivity()).setTab(0);
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(mParent.getContext(), MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }
    @OnClick({R.id.zhiding_01,R.id.zhiding_02,R.id.tianjiahaoyou})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.zhiding_01:
                Intent intent = new Intent(mParent.getContext(),HuatiActivity.class);
                startActivity(intent);
                break;
            case R.id.zhiding_02:
                Intent intent1 = new Intent(mParent.getContext(),FabuActivity.class);
                startActivity(intent1);
                break;
            case R.id.tianjiahaoyou:
                Intent intent2 = new Intent(mParent.getContext(),TianjiafriendActivity.class);
                startActivity(intent2);
                break;
        }
    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null)
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }
}
