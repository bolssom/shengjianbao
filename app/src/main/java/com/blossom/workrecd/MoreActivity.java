package com.blossom.workrecd;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.blossom.workrecd.View.TitleView;

public class MoreActivity extends FragmentActivity {

    private TitleView mtitleview;
    private TextView mtextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_more);
        initview();
    }

    private void initview() {
        mtextview = (TextView)findViewById(R.id.more_text_id);
        mtitleview = (TitleView)findViewById(R.id.more_id);

        mtitleview.setTitle("更多菜单");
        mtitleview.setLeftImageButton( new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                finish();
            }
        });
        mtitleview.hiddenRightImageButton();
    }


}
