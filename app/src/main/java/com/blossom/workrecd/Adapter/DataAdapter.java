package com.blossom.workrecd.Adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.blossom.workrecd.R;
import com.blossom.workrecd.View.swipelistview.SwipeListView;

public class DataAdapter extends BaseAdapter{
	private List<String> mDatas;  
    private LayoutInflater mInflater;  
    private SwipeListView mSwipeListView ;
  
    public DataAdapter(Context context, List<String> datas , SwipeListView swipeListView)  
    {  
        this.mDatas = datas;  
        mInflater = LayoutInflater.from(context);  
        mSwipeListView = swipeListView;  
    }  
  
    @Override  
    public int getCount()  
    {  
        return mDatas.size();
        
    }  
  
    @Override  
    public Object getItem(int position)  
    {  
        return mDatas.get(position);  
    }  
  
    @Override  
    public long getItemId(int position)  
    {  
        return position;  
    }  
  
    @Override  
    public View getView(final int position, View convertView, ViewGroup parent)  
    {  
        convertView = mInflater.inflate(R.layout.item_qingqiu, null);
  
        TextView tv = (TextView) convertView.findViewById(R.id.id_text);
        Button del = (Button) convertView.findViewById(R.id.id_remove);  
        tv.setText(mDatas.get(position));
        del.setOnClickListener(new OnClickListener()  
        {  
            @Override  
            public void onClick(View v)  
            {  
                mDatas.remove(position);  
                notifyDataSetChanged();  
                 /** 
                  * 关闭SwipeListView 
                  * 不关闭的话，刚删除位置的item存在问题 ，不能再次点击
                  */  
                mSwipeListView.closeOpenedItems();  
            }  
        });  
          
        return convertView;  
    }  
}
