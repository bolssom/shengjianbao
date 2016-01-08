package com.blossom.workrecd.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blossom.workrecd.Dao.JFC;
import com.blossom.workrecd.R;
import com.blossom.workrecd.Utils.DateUtils;

import java.util.List;

/**
 * Created by zxw on 2016/1/7.
 */
public class JianZhiAdapter extends BaseAdapter {
    //private LayoutInflater mInflater;
    private List<JFC> mList;
    private Context context;
//    public JianZhiAdapter(Context context List<JianZhiBean> mList){
//        mInflater = LayoutInflater.from(context);
//    }


    public JianZhiAdapter(List<JFC> mList, Context context) {
        super();
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(getCount()==0){
            return null;
        }
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_jianzhi,null);
            holder = new ViewHolder();
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.location = (TextView)convertView.findViewById(R.id.location);
            holder.datetime = (TextView)convertView.findViewById(R.id.datetime);
            holder.price = (TextView)convertView.findViewById(R.id.price);
            convertView.setTag(holder);

        }else {
            holder =(ViewHolder)convertView.getTag();
        }

        holder.name.setText(mList.get(position).getAuthor_name());
        // holder.location.setText(mList.get(position).getLocation());
        DateUtils dateUtils = new DateUtils();
        holder.datetime.setText( dateUtils.timet(mList.get(position).getAddtime()));
        holder.price.setText(Html.fromHtml("<font color='#ffc50a'>￥" + mList.get(position).getId() + "</font>"));
        return convertView;
    }

    public static class ViewHolder {
        private TextView name;
        private TextView location;
        private TextView datetime;
        private TextView price;

    }


}
