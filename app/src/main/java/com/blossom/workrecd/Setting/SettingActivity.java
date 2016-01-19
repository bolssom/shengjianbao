package com.blossom.workrecd.Setting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.blossom.workrecd.NewsdetailActivity;
import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class SettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.gomima,R.id.goshouji,R.id.gocache})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.gomima:
                Intent gomima = new Intent(SettingActivity.this, AnquanmimaActivity.class);
                startActivity(gomima);
                break;
            case R.id.goshouji:
                Intent goshouji = new Intent(SettingActivity.this, ShoujibiangengaActivity.class);
                startActivity(goshouji);
                break;
            case R.id.gocache:
                customdialog();
                break;
        }
    }
    private void customdialog() {
        LayoutInflater inflaterDl = LayoutInflater.from(this);
        RelativeLayout layout = (RelativeLayout)inflaterDl.inflate(R.layout.dialog_cache, null );

        //对话框

        final Dialog dialog = new AlertDialog.Builder(SettingActivity.this).create();
        dialog.show();
        dialog.getWindow().setContentView(layout);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setBackgroundDrawableResource(android.R.color.transparent);
        dialogWindow.setGravity(Gravity.CENTER);

        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = 800; // 宽度
        lp.height = 480; // 高度
        dialogWindow.setAttributes(lp);

        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        //取消按钮
        Button btnCancel = (Button) layout.findViewById(R.id.dialog_close);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        //确定按钮
        Button btnOK = (Button) layout.findViewById(R.id.dialog_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
