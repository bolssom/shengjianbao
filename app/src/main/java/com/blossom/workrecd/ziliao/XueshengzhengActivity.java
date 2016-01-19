package com.blossom.workrecd.ziliao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.blossom.workrecd.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class XueshengzhengActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_renzheng);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.left_btn,R.id.submit})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
            case R.id.submit:
                dialog_fail();
                break;
        }
    }
    private void  dialog_fail(){
        LayoutInflater inflater = LayoutInflater.from(this);
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.dialog_fail,null);

        AlertDialog adialog = new AlertDialog.Builder(XueshengzhengActivity.this).create();
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
}
