package com.blossom.workrecd.Login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.blossom.workrecd.R;
import com.blossom.workrecd.ziliao.JibenziliaoActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class SuccessregActivity extends Activity {
    @ViewInject(R.id.txt_wanshanziliao)
    private TextView wanshangziliao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_successreg);
        ViewUtils.inject(this);

        String url_0_text = "个人资料";
        wanshangziliao.setText("赶紧去完善");
        String str = "吧~";

        SpannableString spStr = new SpannableString(url_0_text);

        spStr.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.wanshanziliao));      //设置文件颜色
                ds.setUnderlineText(true);      //设置下划线
            }

            @Override
            public void onClick(View widget) {
                //Log.d("", "onTextClick........");
                Intent zl = new Intent(SuccessregActivity.this, JibenziliaoActivity.class);
                startActivity(zl);
            }
        }, 0, url_0_text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        wanshangziliao.setHighlightColor(Color.TRANSPARENT); //设置点击后的颜色为透明，否则会一直出现高亮
        wanshangziliao.append(spStr);
        wanshangziliao.append(str);
        wanshangziliao.setMovementMethod(LinkMovementMethod.getInstance());//开始响应点击事件
    }

    @OnClick({R.id.left_btn})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.left_btn:
                finish();
                break;
        }
    }
}
