package com.blossom.workrecd;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
private LinearLayout xianzaibaoming;
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
                    container.addView(lf.inflate(R.layout.detail_qiye, null));
                }
            }
        });
        radio_zw.setChecked(true);
        xianzaibaoming = (LinearLayout)container.findViewById(R.id.xianzaibaoming);
        xianzaibaoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customdialog();
            }
        });

    }

    private void  dialog_success(){
        LayoutInflater inflater = LayoutInflater.from(this);
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.dialog_sucess,null);

        AlertDialog adialog = new AlertDialog.Builder(DetailActivity.this).create();
        adialog.show();
        adialog.setContentView(layout);

        Window dialogWindow = adialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setBackgroundDrawableResource(android.R.color.transparent);
        dialogWindow.setGravity(Gravity.CENTER);
       // lp.x = 10; // 新位置X坐标
       // lp.y = 345; // 新位置Y坐标
        lp.width = 600; // 宽度
        lp.height = 480; // 高度
        dialogWindow.setAttributes(lp);

    }

    private void customdialog() {
        LayoutInflater inflaterDl = LayoutInflater.from(this);
        RelativeLayout layout = (RelativeLayout)inflaterDl.inflate(R.layout.dialog_detail, null );

        //对话框
        final Dialog dialog = new AlertDialog.Builder(DetailActivity.this).create();
        dialog.show();
        dialog.getWindow().setContentView(layout);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setBackgroundDrawableResource(android.R.color.transparent);
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

//        //取消按钮
//        Button btnCancel = (Button) layout.findViewById(R.id.dialog_close);
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
//            }
//        });


        //确定按钮
        Button btnOK = (Button) layout.findViewById(R.id.dialog_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                dialog_success();
                dialog.dismiss();
            }
        });


        //关闭按钮
        ImageButton btnClose = (ImageButton) layout.findViewById(R.id.dialog_close);
        btnClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
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
//            case  R.id.xianzaibaoming:
//                System.out.println("对话框------------");
//                customdialog();
//                break;
        }
    }
}
