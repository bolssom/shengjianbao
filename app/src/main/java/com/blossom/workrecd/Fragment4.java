package com.blossom.workrecd;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.blossom.workrecd.JianzhiFragment.JianzhiActivity;
import com.blossom.workrecd.Login.LoginActivity;
import com.blossom.workrecd.View.GridViewForScrollView;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {

    private View myPartent;
    private FragmentActivity mactivity;
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @ViewInject(R.id.myinfogridview)
    private GridViewForScrollView myInFoGridView;
    private List<Map<String, Object>> data_list;
    private int[] icon_pic = {
            R.mipmap.person_gv_01,
            R.mipmap.person_gv_02,
            R.mipmap.person_gv_03,
            R.mipmap.person_gv_04,
            R.mipmap.person_gv_05,
            R.mipmap.person_gv_06};
    private String[] icon_name = {"生涯", "钱包", "积分", "收藏", "题库", "话题"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, null);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mactivity = getActivity();
        myPartent = getView();
        initview();
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        SimpleAdapter simpleAdapter = new SimpleAdapter(myPartent.getContext(), data_list, R.layout.person_gridview, new String[]{"image", "text"}, new int[]{R.id.mygridview_pic, R.id.mygridview_txt});
        myInFoGridView.setAdapter(simpleAdapter);
    }

    private void initview() {

        mtitleview.setTitle("个人中心");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                ((MainActivity) getActivity()).setTab(0);
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent msgintent = new Intent(myPartent.getContext(), MsgActivity.class);
                startActivity(msgintent);
            }
        });

    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < icon_pic.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon_pic[i]);
            map.put("text", icon_name[i]);
            data_list.add(map);
        }
        return data_list;
    }

    @OnClick({R.id.piv, R.id.baoming,R.id.luyong,R.id.wancheng,R.id.daipingjia})
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.piv:
                Intent login = new Intent(myPartent.getContext(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.baoming:
                Intent bm= new Intent(myPartent.getContext(),JianzhiActivity.class);
                bm.putExtra("flag","0");
                startActivity(bm);
                break;
            case R.id.luyong:
                Intent ly= new Intent(myPartent.getContext(),JianzhiActivity.class);
                ly.putExtra("flag","1");
                startActivity(ly);
                break;
            case R.id.wancheng:
                Intent wc= new Intent(myPartent.getContext(),JianzhiActivity.class);
                wc.putExtra("flag","2");
                startActivity(wc);
                break;
            case R.id.daipingjia:
                Intent pj= new Intent(myPartent.getContext(),JianzhiActivity.class);
                pj.putExtra("flag","3");
                startActivity(pj);
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
