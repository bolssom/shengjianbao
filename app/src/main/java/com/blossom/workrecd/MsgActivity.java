package com.blossom.workrecd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blossom.workrecd.Adapter.DataAdapter;
import com.blossom.workrecd.Utils.ToastHelper;
import com.blossom.workrecd.View.TitleView;
import com.blossom.workrecd.View.swipelistview.BaseSwipeListViewListener;
import com.blossom.workrecd.View.swipelistview.SwipeListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private RadioGroup clientRadioGroup;
    @ViewInject(R.id.radio_z)
    private RadioButton radio_z;
    @ViewInject(R.id.radio_y)
    private RadioButton radio_y;
    @ViewInject(R.id.layout1)
    private LinearLayout l1;
    @ViewInject(R.id.layout2)
    private LinearLayout l2;

    SwipeListView swipeListView;
    List<String> mDatas;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_msg);
        ViewUtils.inject(this);
        initview();
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("记录" + i);
        }
        swipeListView = (SwipeListView) findViewById(R.id.example_lv_list);
        adapter = new DataAdapter(this, mDatas, swipeListView);
        swipeListView.setAdapter(adapter);

        swipeListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
            // 这里可以重写很多方法
            @Override
            public void onListChanged() {

                super.onListChanged();

            }

            @Override
            public void onClickFrontView(int position) {

                super.onClickFrontView(position);

            }

        });

    clientRadioGroup = (RadioGroup) findViewById(R.id.msg_radio);
            clientRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int radioButtonId = group.getCheckedRadioButtonId();
//                RadioButton rb = (RadioButton) findViewById(radioButtonId);
//                String radioButtonLabel = rb.getText().toString();
                    if (radio_z.getId() == checkedId) {
                        l1.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.GONE);
                    } else if (radio_y.getId() == checkedId) {
                        l2.setVisibility(View.VISIBLE);
                        l1.setVisibility(View.GONE);
                    }
                }
            });
            // radio_z.setChecked(true);
        }

    private void initview() {

        mtitleview.setTitle("消息");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.hiddenRightImageButton();
    }


}
