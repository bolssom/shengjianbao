package com.blossom.workrecd.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.blossom.workrecd.R;

/**
 * Created by zxw on 2015/10/20.
 */
public class TitleView extends FrameLayout implements View.OnClickListener {
    private ImageButton mleftImageButton;
    private ImageButton mrightImageButton;
    private TextView mTitle;

    private OnLeftImageButtonClickLister mOnLeftImageButtonClickLister;
    private OnRightImageButtonClickLister mOnRightImageButtonClickLister;

    public TitleView(Context context) {
        this(context,null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.title_view,this,true);

        mleftImageButton = (ImageButton)findViewById(R.id.left_btn);
        mleftImageButton.setVisibility(View.VISIBLE);
        mleftImageButton.setOnClickListener(this);
        mrightImageButton = (ImageButton)findViewById(R.id.right_btn);
        mrightImageButton.setVisibility(View.VISIBLE);
        mrightImageButton.setOnClickListener(this);
        mTitle = (TextView)findViewById(R.id.title_text);
        mTitle.setVisibility(View.VISIBLE);
    }


    public  interface OnLeftImageButtonClickLister{
        public  void  onClick(View button);
    }
    public  interface OnRightImageButtonClickLister{
        public  void onClick(View button);
    }

    public void  setLeftImageButton(OnLeftImageButtonClickLister lister){
        //mleftImageButton.setText(text);
        mleftImageButton.setVisibility(View.VISIBLE);
        mOnLeftImageButtonClickLister = lister;
    }
//    public  void  setLeftImageButton(int stringID,OnLeftImageButtonClickLister lister){
//        //mleftImageButton.setText(stringID);
//        mleftImageButton.setVisibility(View.VISIBLE);
//        mOnLeftImageButtonClickLister = lister;
//    }
    public void  removeLeftButton(){
       // mleftImageButton.setText("");
        mleftImageButton.setVisibility(View.INVISIBLE);
        mOnLeftImageButtonClickLister = null;
    }
    public void  hiddenLeftImageButton(){
        mleftImageButton.setVisibility(View.INVISIBLE);
    }
    public void showLeftImageButton(){
        mleftImageButton.setVisibility(View.VISIBLE);
    }

    public void  setRightImageButton(OnRightImageButtonClickLister lister){
        //mrightImageButton.setText(text);
        mrightImageButton.setVisibility(View.VISIBLE);
        mOnRightImageButtonClickLister = lister;

    }
//    public  void  setRightImageButton(int stringID,OnRightImageButtonClickLister lister){
//       // mrightImageButton.setText(stringID);
//        mrightImageButton.setVisibility(View.VISIBLE);
//        mOnRightImageButtonClickLister = lister;
//    }
    public void  removeRightImageButton(){
       // mrightImageButton.setText("");
        mrightImageButton.setVisibility(View.INVISIBLE);
        mOnRightImageButtonClickLister = null;
    }
    public void  hiddenRightImageButton(){
        mrightImageButton.setVisibility(View.INVISIBLE);
    }
    public void  showRightImageButton(){
        mrightImageButton.setVisibility(View.VISIBLE);
    }

    public void setTitle(String text){
        mTitle.setVisibility(View.VISIBLE);
        mTitle.setText(text);

    }
    public void  setTitle(int stringID){
        mTitle.setVisibility(View.VISIBLE);
        mTitle.setText(stringID);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.left_btn:
                if (mOnLeftImageButtonClickLister!=null)
                    mOnLeftImageButtonClickLister.onClick(v);
                break;
            case R.id.right_btn:
                if(mOnRightImageButtonClickLister!= null)
                    mOnRightImageButtonClickLister.onClick(v);
                break;
        }
    }
}
