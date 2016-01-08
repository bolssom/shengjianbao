package com.blossom.workrecd.Launcher;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.blossom.workrecd.MainActivity;
import com.blossom.workrecd.R;



public class  WellComeActivity  extends Activity implements Animation.AnimationListener {
    boolean isFirstIn = false;
    private ImageView  imageView = null;
    private Animation alphaAnimation = null;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_come);
        imageView = (ImageView)findViewById(R.id.welcome_image_view);
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.welcome_alpha);
        alphaAnimation.setFillEnabled(true); //启动Fill保持
        alphaAnimation.setFillAfter(true);  //设置动画的最后一帧是保持在View上面
        imageView.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(this);  //为动画设置监听
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //动画结束时结束欢迎界面并转到软件的主界面
        preferences = getSharedPreferences("isFirstIn",MODE_PRIVATE);
        isFirstIn = preferences.getBoolean("isFirstIn",true);
        if (isFirstIn){
            new Handler().postDelayed( new Runnable(){

                @Override
                public void run() {
                    goLauncher();
                }
            },3000);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }else {
            new  Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    goSplash();
                }
            },3000);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //在欢迎界面屏蔽BACK键
        if(keyCode== KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return false;
    }


    private  void goLauncher(){
        Intent intent = new Intent(WellComeActivity.this,LauncherActivity.class);
        startActivity(intent);
        finish();
    }
    private  void  goSplash(){
        Intent intent = new Intent(WellComeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
