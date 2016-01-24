package com.blossom.workrecd.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blossom.workrecd.CommonUrl;
import com.blossom.workrecd.MainActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.Utils.ToastHelper;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends Activity {
    @ViewInject(R.id.login_username)
    private EditText login_username;
    @ViewInject(R.id.login_password)
    private EditText login_password;
    @ViewInject(R.id.user_login_button)
    private TextView user_login_button;
    @ViewInject(R.id.user_register_button)
    private TextView user_register_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.user_login_button,R.id.user_register_button,R.id.kankan,R.id.mima})
    public void myClick(View v){
        switch (v.getId()){
            case R.id.kankan:
                Intent shouye= new Intent(LoginActivity.this,MainActivity.class);
                startActivity(shouye);
                break;
            case R.id.user_login_button:
                if(checkEdit()) {
                    login_submit();
                }
                break;
            case R.id.user_register_button:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.mima:
                Intent mm = new Intent(LoginActivity.this, MimaActivity.class);
                startActivity(mm);
                break;
        }
    }

    private boolean checkEdit(){
        if(login_username.getText().toString().trim().equals("")){
            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if(login_password.getText().toString().trim().equals("")){
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            return true;
        }
        return false;
    }
    public void login_submit(){

//        SimpleDateFormat dateFormat = new SimpleDateFormat();
//        Date date = new Date(System.currentTimeMillis());
//        // String time = dateFormat.format(date);
//        String time = ""+System.currentTimeMillis();
//        String httpUrl = "http://42.51.27.36/recruit/sys/sysuser/appLogin";
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("phone","1");
        params.addQueryStringParameter("password", login_password.getText().toString().trim());
        params.addQueryStringParameter("role","3");
        params.addQueryStringParameter("tel",login_username.getText().toString().trim());
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);

        http.send(HttpRequest.HttpMethod.POST, CommonUrl.Login_URL, params,new RequestCallBack<String>() {
            @Override
            public void onStart() {
                //resultText.setText("conn.....");
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                if (isUploading){
                    //resultText.setText("upload:"+current+"/"+total);
                }else {
                   // resultText.setText("replay:"+current+"/"+total);
                }
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String res = responseInfo.result;
                try {
                    JSONObject jsonObject = new JSONObject(res);
                    String rs =  jsonObject.getString("result");
                    System.out.println("res--->" + rs);
                    switch (rs){
                        case "1":
                            ToastHelper.show(LoginActivity.this, "成功，返回用户实体详细见用户实体");
                            break;
                        case "-1":
                            ToastHelper.show(LoginActivity.this, "用户名有误或已被禁用");
                            break;
                        case "-2":
                            ToastHelper.show(LoginActivity.this, "密码错误");
                            break;

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
            }
        });
    }
}
