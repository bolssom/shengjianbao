package com.blossom.workrecd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blossom.workrecd.Utils.ToastHelper;
import com.blossom.workrecd.View.TitleView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MsgActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    private  RadioGroup clientRadioGroup;
    @ViewInject(R.id.radio_z)
    private RadioButton radio_z;
    @ViewInject(R.id.radio_y)
    private RadioButton radio_y;
    @ViewInject(R.id.layout1)
    private LinearLayout l1;
    @ViewInject(R.id.layout2)
    private LinearLayout l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_msg);
        ViewUtils.inject(this);
        initview();

        clientRadioGroup = (RadioGroup) findViewById(R.id.msg_radio);
        clientRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int radioButtonId = group.getCheckedRadioButtonId();
//                RadioButton rb = (RadioButton) findViewById(radioButtonId);
//                String radioButtonLabel = rb.getText().toString();
                if (radio_z.getId() == checkedId){
                   l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                }else if (radio_y.getId() == checkedId){
                    l2.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.GONE);
                }
            }
        });
       // radio_z.setChecked(true);
    }

    private void initview() {

        mtitleview.setTitle("消息");
        mtitleview.setLeftImageButton( new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.hiddenRightImageButton();
    }


}
