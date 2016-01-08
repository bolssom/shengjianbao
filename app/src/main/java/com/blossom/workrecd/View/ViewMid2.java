package com.blossom.workrecd.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.blossom.workrecd.Adapter.TextAdapter;
import com.blossom.workrecd.R;

/**
 * Created by zxw on 2016/1/7.
 */
public class ViewMid2 extends RelativeLayout implements ViewBaseAction {
    private ListView mListView;
    private Context mContext;
    private String mDistance;
    private TextAdapter adapter;
    private String showText = "item1";
    private OnSelectListener mOnSelectListener;
    private final String[] items = new String[] { "item1", "item2", "item3", "item4", "item5", "item6" };//显示字段
    private final String[] itemsVaule = new String[] { "1", "2", "3", "4", "5", "6" };//隐藏id

    public ViewMid2(Context context) {
        super(context);
        init(context);
    }

    public String getShowText() {
        return showText;
    }
    public ViewMid2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewMid2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public  void  init(Context context){
        mContext = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_distance,this,true);
        setBackground(getResources().getDrawable(R.drawable.choosearea_bg_mid));
        mListView = (ListView)findViewById(R.id.listView);
        adapter = new TextAdapter(context,items,R.drawable.choosearea_bg_right,R.drawable.choose_eara_item_selector);
        adapter.setTextSize(17);
        if (mDistance !=null){
            for (int i = 0;i <itemsVaule.length;i++){
                if (itemsVaule[i].equals(mDistance)){
                    adapter.setSelectedPositionNoNotify(i);
                    showText = items[i];
                    break;
                }
            }
        }
        mListView.setAdapter(adapter);
        adapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (mOnSelectListener != null){
                    showText = items[position];
                    mOnSelectListener.getValue(itemsVaule[position],items[position]);
                }
            }
        });
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        mOnSelectListener = onSelectListener;
    }
    public interface OnSelectListener {
        public void getValue(String distance, String showText);
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }
}
