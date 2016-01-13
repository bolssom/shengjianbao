package com.blossom.workrecd.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blossom.workrecd.Dao.JianZhiBean;
import com.blossom.workrecd.R;

import java.util.List;

/**
 * Created by zxw on 2016/1/7.
 */
public class JianZhiAdapter extends BaseAdapter {
    //private LayoutInflater mInflater;
    private List<JianZhiBean> mList;
    private Context context;
//    public JianZhiAdapter(Context context List<JianZhiBean> mList){
//        mInflater = LayoutInflater.from(context);
//    }


    public JianZhiAdapter(List<JianZhiBean> mList, Context context) {
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
            holder.title = (TextView)convertView.findViewById(R.id.rtitle);
            holder.address = (TextView)convertView.findViewById(R.id.addrcode);
            holder.datetime = (TextView)convertView.findViewById(R.id.datetime);
            holder.money = (TextView)convertView.findViewById(R.id.money);
            convertView.setTag(holder);

        }else {
            holder =(ViewHolder)convertView.getTag();
        }

        holder.title.setText(mList.get(position).getRecruitTitle());
        holder.address.setText(mList.get(position).getAddrCode());
       // DateUtils dateUtils = new DateUtils();
        holder.datetime.setText( mList.get(position).getDateBegin());
        holder.money.setText(Html.fromHtml("<font color='#ffc50a'>￥" + mList.get(position).getMoneyStandard() + "</font>"));
        return convertView;
    }

    public static class ViewHolder {
        private TextView title;
        private TextView address;
        private TextView datetime;
        private TextView money;

    }


}
