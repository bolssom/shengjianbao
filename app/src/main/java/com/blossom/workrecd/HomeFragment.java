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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blossom.workrecd.Adapter.JianZhiAdapter;
import com.blossom.workrecd.ContactList.CitylistActivity;
import com.blossom.workrecd.Dao.JFC;
import com.blossom.workrecd.Dao.JiFaBean;
import com.blossom.workrecd.Utils.CustomListView;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = HomeFragment.class.getSimpleName();
    private static final int WHAT_DID_LOAD_DATA = 0;
    private static final int WHAT_DID_REFRESH = 1;
    private static final int WHAT_DID_MORE = 2;


    private View mParent;
    private FragmentActivity mActivity;
    private String jsonstr;
    public int pagenum = 1;

    @ViewInject(R.id.mListView)
    private CustomListView mListView;
    @ViewInject(R.id.home_left_location)
    private ImageButton home_left_location;
    @ViewInject(R.id.home_right_btn)
    private ImageButton home_right_btn;
    @ViewInject(R.id.home_location)
    private LinearLayout home_linear_location;


    private ImageView home_dingyue;
    private Button btn_rjzq,btn_sjxt,btn_rmzx;

    private ArrayList<JFC> mList = new ArrayList<JFC>();
    private JianZhiAdapter mAdapter;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case WHAT_DID_LOAD_DATA:
                    if (msg.obj != null) {
                        JiFaBean jfdata = (JiFaBean) msg.obj;
                        mList.addAll(jfdata.getData());
                       // System.out.println("load--->" + mList + "/n");
                        mAdapter.notifyDataSetChanged();
                    }
                    break;
                case WHAT_DID_REFRESH:
                    if (mAdapter != null) {
                        JiFaBean jfdata = (JiFaBean) msg.obj;
                        mList.clear();
                        mList.addAll(jfdata.getData());
                       // System.out.println("refresh--->" + mList);
                        mAdapter.notifyDataSetChanged();
                    }
                    mListView.onRefreshComplete();//下拉刷新完成
                    break;
                case WHAT_DID_MORE:
                    if (mAdapter != null) {
                        JiFaBean jfdata = (JiFaBean) msg.obj;
                        mList.addAll(jfdata.getData());
                       // System.out.println("=======" + jfdata.getData().get(0).getId());
                        mAdapter.notifyDataSetChanged();
                    }
                    mListView.onLoadComplete();//加载更多完成
//                    }else{
//                        mAdapter.notifyDataSetChanged();
//                        mListView.onLoadMoreComplete(false);//加载完毕
//                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_home, container, false);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mParent = getView();
        initdata();
        View hv = LayoutInflater.from(mParent.getContext()).inflate(R.layout.home_listview_banner, null);
        btn_rjzq = (Button)hv.findViewById(R.id.btn_rjzq);
        btn_sjxt = (Button)hv.findViewById(R.id.btn_sjxt);
        btn_rmzx = (Button)hv.findViewById(R.id.btn_rmzx);
        home_dingyue = (ImageView)hv.findViewById(R.id.home_dingyue);
        btn_rjzq.setOnClickListener(this);
        btn_sjxt.setOnClickListener(this);
        btn_rmzx.setOnClickListener(this);
        home_dingyue.setOnClickListener(this);

        mListView.addHeaderView(hv);
        mAdapter = new JianZhiAdapter(mList, mActivity);
        mListView.setAdapter(mAdapter);

        mListView.setonRefreshListener(new CustomListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO 下拉刷新
                Datarefresh();
            }
        });
        mListView.setonLoadListener(new CustomListView.OnLoadListener() {

            @Override
            public void onLoad() {
                //TODO 加载更多
                loadmoreData();
            }
        });

    }

    @OnClick({R.id.home_right_btn, R.id.home_location})
    public void home_left_right(View v) {
        switch (v.getId()) {
            case R.id.home_right_btn:
                goMoreActivity();
                break;
            case R.id.home_location:
                goCityList();
                break;
        }
    }

    @OnItemClick(R.id.mListView)
    public void mingxviewClick(AdapterView<?> parent, View view, int position, long id) {
      System.out.println("__________"+parent.getAdapter().getItem(0));

    }
    //初始化页面
    public void initdata() {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("flag", "getjifa");
        String NewPath = CommonUrl.BASE_URL + "?pagenum=" + 0;

        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);
        http.send(HttpRequest.HttpMethod.GET, NewPath, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                jsonstr = responseInfo.result;
                Gson gson = new Gson();
                JiFaBean jifainfo = gson.fromJson(jsonstr, JiFaBean.class);
                Message msg = handler.obtainMessage(WHAT_DID_LOAD_DATA);
                msg.obj = jifainfo;
                msg.sendToTarget();
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }

    //加载更多
    public void loadmoreData() {

        RequestParams params = new RequestParams();
        params.addQueryStringParameter("flag", "getjifa");
        //params.addQueryStringParameter("pagenum", pagenum);
        String NewPath = CommonUrl.BASE_URL + "?pagenum=" + pagenum;

        System.out.println("-------->" + NewPath);

        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);
        http.send(HttpRequest.HttpMethod.GET, NewPath, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                jsonstr = responseInfo.result;
                Gson gson = new Gson();
                JiFaBean jifainfo = gson.fromJson(jsonstr, JiFaBean.class);
                System.out.println("loadmore=======" + jifainfo.getData().get(0).getId());
                Message msg = handler.obtainMessage(WHAT_DID_MORE);
                msg.obj = jifainfo;
                msg.sendToTarget();
                ++pagenum;
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }

    //下拉刷新获取数据
    public void Datarefresh() {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("flag", "getjifa");
        String NewPath = CommonUrl.BASE_URL + "?pagenum=" + 0;
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);
        http.send(HttpRequest.HttpMethod.GET, NewPath, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                jsonstr = responseInfo.result;
                Gson gson = new Gson();
                JiFaBean jifainfo = gson.fromJson(jsonstr, JiFaBean.class);
                Message msg = handler.obtainMessage(WHAT_DID_REFRESH);
                msg.obj = jifainfo;
                //System.out.println("测试--->"+jifainfo.getData().get(0).getAuthor_name());
                msg.sendToTarget();
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

    private void loadImgList(String url) {
        new HttpUtils().send(HttpRequest.HttpMethod.GET, url,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {

                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                    }
                });
    }


    private void goCityList() {
        Intent intent = new Intent(mActivity, CitylistActivity.class);
        startActivity(intent);
    }

    private void goMoreActivity() {
        Intent intent = new Intent(mActivity, MoreActivity.class);
        startActivity(intent);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null)
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_dingyue:
                Intent dy = new Intent(mParent.getContext(),DingyueActivity.class);
                startActivity(dy);
                break;
            case  R.id.btn_rjzq:
                break;
            case R.id.btn_sjxt:
                break;
            case R.id.btn_rmzx:
                Intent remen = new Intent(mParent.getContext(),RemenActivity.class);
                startActivity(remen);
                break;
        }
    }
}

