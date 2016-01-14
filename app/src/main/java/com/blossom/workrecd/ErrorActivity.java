package com.blossom.workrecd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class ErrorActivity extends Activity {
    @ViewInject(R.id.left_btn)
    private ImageButton leftbutton;
    @ViewInject(R.id.img_err)
    private ImageView errmsg;
    @ViewInject(R.id.txt_err)
    private TextView errtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_error);
        ViewUtils.inject(this);

        Intent errintent = getIntent();
        String flag = errintent.getStringExtra("flag");
        switch (flag){
            case "nosearch":
                errtxt.setText("搜不到哦");
                errmsg.setImageResource(R.mipmap.nosearch);
                break;
            case "nonet":
                errtxt.setText("无网络");
                errmsg.setImageResource(R.mipmap.nosearch);
                break;
            case "nodata":
                errtxt.setText("暂无此数据");
                errmsg.setImageResource(R.mipmap.nodata);
                break;
            default:
                errtxt.setText("暂无此数据");
                errmsg.setImageResource(R.mipmap.nodata);
        }



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
