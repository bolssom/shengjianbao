package com.blossom.workrecd.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.blossom.workrecd.CommonUrl;
import com.blossom.workrecd.R;
import com.blossom.workrecd.Utils.ToastHelper;
import com.blossom.workrecd.View.TitleView;
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

public class RegisterActivity extends Activity {
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @ViewInject(R.id.reg_shouji)
    private EditText reg_shouji;
    @ViewInject(R.id.name)
    private EditText name;
    @ViewInject(R.id.reg_pass1)
    private EditText reg_pass1;
    @ViewInject(R.id.reg_pass2)
    private EditText reg_pass2;
    @ViewInject(R.id.yanzhengma)
    private EditText yanzhengma;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        ViewUtils.inject(this);
        initview();
    }

    private void initview() {

        mtitleview.setTitle("注册");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.hiddenRightImageButton();

    }

    @OnClick({ R.id.sendcode,R.id.submit})
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.sendcode:
                sendcode();
                break;
            case R.id.submit:
                if(checkEdit()){
                    submit();
                }
                break;
        }
    }

    public void sendcode() {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("tel", reg_shouji.getText().toString().trim());
        params.addQueryStringParameter("role", "3");
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);
        http.send(HttpRequest.HttpMethod.GET, CommonUrl.REGPHONE_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                res = responseInfo.result;
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(res);
                    String rs =  jsonObject.getString("result");
                    if (rs.equals("1")) {
                        ToastHelper.show(RegisterActivity.this, "发送成功");
                    } else if (res.equals("2")) {
                        ToastHelper.show(RegisterActivity.this, "该手机号码已注册");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                System.out.println("手机验证码返回err--->" + s);
            }
        });
    }

    private boolean checkEdit(){
        if(name.getText().toString().trim().equals("")){
            Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if(reg_pass1.getText().toString().trim().equals("")){
            Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }else if(reg_pass2.getText().toString().trim().equals("")){
            Toast.makeText(RegisterActivity.this, "确认密码不能为空", Toast.LENGTH_SHORT).show();
        }else if(reg_shouji.getText().toString().trim().equals("")){
            Toast.makeText(RegisterActivity.this, "手机不能为空", Toast.LENGTH_SHORT).show();
        }else if(yanzhengma.getText().toString().trim().equals("")){
            Toast.makeText(RegisterActivity.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
        }else if(!reg_pass1.getText().toString().trim().equals(reg_pass2.getText().toString().trim())){
            Toast.makeText(RegisterActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
        }else{
            return true;
        }
        return false;
    }
    public void submit() {

            RequestParams params = new RequestParams();
            params.addQueryStringParameter("tel", reg_shouji.getText().toString().trim());
            params.addQueryStringParameter("password", reg_pass1.getText().toString().trim());
            params.addQueryStringParameter("userName", name.getText().toString().trim());
            params.addQueryStringParameter("smsVerify", yanzhengma.getText().toString().trim());
            params.addQueryStringParameter("role", "3");
            HttpUtils http = new HttpUtils();
            http.configCurrentHttpCacheExpiry(1000 * 10);
            http.send(HttpRequest.HttpMethod.GET, CommonUrl.REG_URL, params, new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    res = responseInfo.result;
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                       String rs =  jsonObject.getString("result");
                        System.out.println("res--->" + rs);
                        switch (rs){
                            case "1":
                                ToastHelper.show(RegisterActivity.this, "用户已存在");
                                break;
                            case "2":
                                ToastHelper.show(RegisterActivity.this, "短信验证码过期");
                                break;
                            case "3":
                                ToastHelper.show(RegisterActivity.this, "短信验证码错误");
                                break;
                            case "4":
                                ToastHelper.show(RegisterActivity.this, "短信验证码为空");
                                break;
                            case "6":
                                ToastHelper.show(RegisterActivity.this, "注册成功");
                                Intent rg = new Intent(RegisterActivity.this, SuccessregActivity.class);
                                startActivity(rg);
                                break;
                            case "7":
                                ToastHelper.show(RegisterActivity.this, "用户注册成功/环信添加失败");
                                break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(HttpException e, String s) {
                    System.out.println("手机注册返回err--->" + s);
                }
            });
        }
}
