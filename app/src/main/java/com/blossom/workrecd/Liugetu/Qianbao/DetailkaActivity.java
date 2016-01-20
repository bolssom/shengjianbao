package com.blossom.workrecd.Liugetu.Qianbao;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.blossom.workrecd.R;
import com.blossom.workrecd.Setting.ModifyzhifuActivity;
import com.jungly.gridpasswordview.GridPasswordView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;


public class DetailkaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detailka);
        ViewUtils.inject(this);

    }

    @OnClick({R.id.left_btn, R.id.tianjia, R.id.jiechu})
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.tianjia:
                Intent tj = new Intent(DetailkaActivity.this, TianjiakaActivity.class);
                startActivity(tj);
                break;
            case R.id.jiechu:
                Input_zhifu();
                break;
        }
    }

    private void Input_zhifu() {
        LayoutInflater inflaterDl = LayoutInflater.from(this);
        final RelativeLayout layout = (RelativeLayout) inflaterDl.inflate(R.layout.dialog_edit, null);

        //对话框

        final Dialog dialog = new AlertDialog.Builder(DetailkaActivity.this).create();
        dialog.show();
        dialog.getWindow().setContentView(layout);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setBackgroundDrawableResource(android.R.color.transparent);
        dialogWindow.setGravity(Gravity.CENTER);

        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = 800; // 宽度
        lp.height = 550; // 高度
        dialogWindow.setAttributes(lp);

        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        //关闭
        ImageButton btnCancel = (ImageButton) layout.findViewById(R.id.dialog_close);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //忘记密码
        TextView btnmm = (TextView) layout.findViewById(R.id.dialog_mm);
        btnmm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mima = new Intent(DetailkaActivity.this, ModifyzhifuActivity.class);
                startActivity(mima);
                dialog.dismiss();
            }
        });

        //确定
        Button btnOK = (Button) layout.findViewById(R.id.dialog_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GridPasswordView gridPasswordView = (GridPasswordView) layout.findViewById(R.id.gpv_normal);
                String pass = gridPasswordView.getPassWord();
                System.out.println("pas------>" + pass);
                if (pass.equals("")) {
                    errordialog();
                    dialog.dismiss();

                } else {
                    dialog.dismiss();
                }


            }
        });

    }

    private void errordialog() {
        LayoutInflater inflaterDl = LayoutInflater.from(this);
        RelativeLayout layout = (RelativeLayout) inflaterDl.inflate(R.layout.dialog_mimaerror, null);

        //对话框

        final Dialog dialog = new AlertDialog.Builder(DetailkaActivity.this).create();
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

        //忘记密码
        Button btnCancel = (Button) layout.findViewById(R.id.dialog_close);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
                Intent mima = new Intent(DetailkaActivity.this, ModifyzhifuActivity.class);
                startActivity(mima);
                dialog.dismiss();
            }
        });


        //重新输入
        Button btnOK = (Button) layout.findViewById(R.id.dialog_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                Input_zhifu();
                dialog.dismiss();
            }
        });

    }
}
