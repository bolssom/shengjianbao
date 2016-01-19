package com.blossom.workrecd.Liugetu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.blossom.workrecd.CeshiActivity;
import com.blossom.workrecd.MsgActivity;
import com.blossom.workrecd.NewsdetailActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MytikuActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private Spinner spinner,spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mytiku);
        ViewUtils.inject(this);
        initview();


        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        //声明一个SimpleAdapter独享，设置数据与对应关系
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MytikuActivity.this, getData(), R.layout.item_spinner_tiku,
                new String[]{"ivLogo", "applicationName"}, new int[]{
                R.id.imageview, R.id.textview});
        //绑定Adapter到Spinner中
        spinner.setAdapter(simpleAdapter);
        spinner2.setAdapter(simpleAdapter);
        //Spinner被选中事件绑定。
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //parent为一个Map结构的和数据
                Map<String, Object> map = (Map<String, Object>) parent
                        .getItemAtPosition(position);
                Toast.makeText(MytikuActivity.this,
                        map.get("applicationName").toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    private void initview() {

        mtitleview.setTitle("我的题库");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent moreintent = new Intent(MytikuActivity.this, MsgActivity.class);
                startActivity(moreintent);
            }
        });

    }

    @OnClick({R.id.toutiao,R.id.tiku_title})
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.toutiao:
                Intent newsdetail = new Intent(MytikuActivity.this, NewsdetailActivity.class);
                startActivity(newsdetail);
                break;
            case R.id.tiku_title:
                Intent shiti = new Intent(MytikuActivity.this, CeshiActivity.class);
                startActivity(shiti);
                break;
        }
    }

    public List<Map<String, Object>> getData() {
        //生成数据源
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //每个Map结构为一条数据，key与Adapter中定义的String数组中定义的一一对应。
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ivLogo", R.mipmap.suofang);
        map.put("applicationName", "商家题库");
        list.add(map);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("ivLogo", R.mipmap.suofang);
        map2.put("applicationName", "表情2");
        list.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("ivLogo", R.mipmap.suofang);
        map3.put("applicationName", "表情3");
        list.add(map3);
        return list;
    }
}
