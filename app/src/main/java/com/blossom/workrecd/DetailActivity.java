package com.blossom.workrecd;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blossom.workrecd.Utils.ToastHelper;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class DetailActivity extends Activity {
    private  RadioGroup mRadioGroup;
    @ViewInject(R.id.radio_zw)
    private RadioButton radio_zw;
    @ViewInject(R.id.radio_qy)
    private RadioButton radio_qy;
    @ViewInject(R.id.layout_container)
    private  LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);
        ViewUtils.inject(this);


        mRadioGroup = (RadioGroup) findViewById(R.id.detail_radiogroup);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radio_zw.getId() == checkedId) {
                   container.removeAllViews();
                    container.addView(View.inflate(DetailActivity.this, R.layout.detail_zhiwei, null));
                } else if (radio_qy.getId() == checkedId) {
                  container.removeAllViews();
                    LayoutInflater lf = LayoutInflater.from(DetailActivity.this);
                    container.addView(lf.inflate(R.layout.detail_qiye,null));
                }
            }
        });
        radio_zw.setChecked(true);
    }
    @OnClick({R.id.left_btn,R.id.right_btn})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.right_btn:
                ToastHelper.show(this, "导出");
                break;
        }
    }
}
