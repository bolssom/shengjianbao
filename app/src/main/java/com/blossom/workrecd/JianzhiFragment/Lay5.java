package com.blossom.workrecd.JianzhiFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blossom.workrecd.PingjiaActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.TousuActivity;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lay5 extends Fragment {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private View mParent;
    private FragmentActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lay5, container, false);
        ViewUtils.inject(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mParent = getView();

    }
    @OnClick({R.id.left_btn,R.id.qupingjia,R.id.tousu})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                mActivity.finish();
                break;
            case R.id.qupingjia:
                Intent pj = new Intent(mParent.getContext(), PingjiaActivity.class);
                startActivity(pj);
                break;
            case R.id.tousu:
                Intent ts = new Intent(mParent.getContext(), TousuActivity.class);
                startActivity(ts);
                break;

        }
    }
}
