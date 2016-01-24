package com.blossom.workrecd;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blossom.workrecd.Adapter.JianZhiAdapter;
import com.blossom.workrecd.Adapter.LuntanAdapter;
import com.blossom.workrecd.Dao.JianZhiBean;
import com.blossom.workrecd.Dao.LuntanBean;
import com.blossom.workrecd.Dao.TuiJianBean;
import com.blossom.workrecd.Dao.UserBean;
import com.blossom.workrecd.Utils.CustomListView;
import com.blossom.workrecd.View.TitleView;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {
    private static final int WHAT_DID_LOAD_DATA = 0;
    private static final int WHAT_DID_REFRESH = 1;
    private static final int WHAT_DID_MORE = 2;
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private View mParent;
    private FragmentActivity mActivity;
    private String jsonstr;

    private ArrayList<UserBean> mList = new ArrayList<UserBean>();
    private LuntanAdapter mAdapter;
    @ViewInject(R.id.mListView)
    private CustomListView mListView;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case WHAT_DID_LOAD_DATA:
                    if (msg.obj != null) {
                        LuntanBean data = (LuntanBean) msg.obj;
                        mList.addAll(data.getData());
                        System.out.println("load--->" + mList + "/n");
                        mAdapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };

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
        initdata();
        BitmapUtils bitmapUtils = new BitmapUtils(mParent.getContext());
        mAdapter = new LuntanAdapter(mActivity, mList,bitmapUtils);
        mListView.setAdapter(mAdapter);

        mListView.setonRefreshListener(new CustomListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO 下拉刷新
                //Datarefresh();
            }
        });
        mListView.setonLoadListener(new CustomListView.OnLoadListener() {

            @Override
            public void onLoad() {
                //TODO 加载更多
                // loadmoreData();
            }
        });
    }


    private void initview() {

        mtitleview.setTitle("生兼社区");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                ((MainActivity) getActivity()).setTab(0);
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

    public void initdata() {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("_dc", "1451015677046");
        params.addQueryStringParameter("start", "0");
        params.addQueryStringParameter("limit", "10");
        params.addQueryStringParameter("sort", "[{\"property\":\"dateAdd\",\"direction\":\"DESC\"}]");
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);
        http.send(HttpRequest.HttpMethod.POST, CommonUrl.Luntan_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                jsonstr = responseInfo.result;
                System.out.println("json------------->" + jsonstr);
                Gson gson = new Gson();
                LuntanBean info = gson.fromJson(jsonstr, LuntanBean.class);
                Message msg = handler.obtainMessage(WHAT_DID_LOAD_DATA);
                msg.obj = info;
                msg.sendToTarget();
            }

            @Override
            public void onFailure(HttpException e, String s) {
            }
        });

    }

    @OnClick({R.id.zhiding_01, R.id.zhiding_02, R.id.tianjiahaoyou})
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.zhiding_01:
                Intent intent = new Intent(mParent.getContext(), HuatiActivity.class);
                startActivity(intent);
                break;
            case R.id.zhiding_02:
                Intent intent1 = new Intent(mParent.getContext(), FabuActivity.class);
                startActivity(intent1);
                break;
            case R.id.tianjiahaoyou:
                Intent intent2 = new Intent(mParent.getContext(), TianjiafriendActivity.class);
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
