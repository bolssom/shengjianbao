package com.blossom.workrecd;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blossom.workrecd.Login.RegisterActivity;
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
import com.lidroid.xutils.view.annotation.event.OnFocusChange;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment{

    private View mParent;
    private FragmentActivity mactivity;
    private TitleView mTitle;
    @ViewInject(R.id.login_username)
    private EditText login_username;
    @ViewInject(R.id.login_password)
    private EditText login_password;
    @ViewInject(R.id.user_login_button)
    private Button user_login_button;
    @ViewInject(R.id.user_register_button)
    private Button user_register_button;
    @ViewInject(R.id.result_txt)
    private TextView resultText;
    private EditText reregister_passwd;
    private Button register_submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment4,null);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mactivity = getActivity();
        mParent = getView();
        mTitle = (TitleView)mParent.findViewById(R.id.title);
        mTitle.setTitle("登录");
        mTitle.hiddenLeftImageButton();
        mTitle.hiddenRightImageButton();

    }

@OnFocusChange({R.id.login_username,R.id.login_password})
public void focuschage(View v,boolean hasFocus){
    switch (v.getId()){
        case R.id.login_username:
            if (!hasFocus){
                String username = login_username.getText().toString().trim();
                if (username.length()<4){
                    ToastHelper.show(this.getContext(),"用户名不能少于4个字符！");
                }
            }
            break;
        case R.id.login_password:
            if (!hasFocus){
                String password = login_password.getText().toString().trim();
                if (password.length()<6){
                    ToastHelper.show(this.getContext(),"密码不能少于6个字符");
                }
            }
    }
}

@OnClick({R.id.user_login_button,R.id.user_register_button})
public  void login(View v){
    switch (v.getId()){
        case R.id.user_login_button:
            if(checkEdit()) {
               login_submit();
            }
            break;
        case R.id.user_register_button:
            Intent intent = new Intent(this.getContext(), RegisterActivity.class);
            startActivity(intent);
            break;
    }

}
    private boolean checkEdit(){
        if(login_username.getText().toString().trim().equals("")){
            Toast.makeText(this.getContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if(login_password.getText().toString().trim().equals("")){
            Toast.makeText(this.getContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            return true;
        }
        return false;
    }
    public void login_submit(){

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
       // String time = dateFormat.format(date);
        String time = ""+System.currentTimeMillis();
       String httpUrl = "http://42.51.27.36/recruit/sys/sysuser/appLogin";
        //System.out.println(httpUrl+"?time="+time);
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("tel","13994243208");
        params.addQueryStringParameter("password", "123123");
        params.addQueryStringParameter("time",time);
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10);
        http.send(HttpRequest.HttpMethod.POST, httpUrl, params,new RequestCallBack<String>() {
            @Override
            public void onStart() {
                resultText.setText("conn.....");
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                if (isUploading){
                    resultText.setText("upload:"+current+"/"+total);
                }else {
                    resultText.setText("replay:"+current+"/"+total);
                }
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                resultText.setText("replay:"+responseInfo.result);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                resultText.setText("login msg----"+s);
            }
        });
    }


    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null)
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }
}
