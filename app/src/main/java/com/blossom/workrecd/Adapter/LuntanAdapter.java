package com.blossom.workrecd.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blossom.workrecd.CommonUrl;
import com.blossom.workrecd.Dao.LuntanBean;
import com.blossom.workrecd.Dao.UserBean;
import com.blossom.workrecd.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by zxw on 2016/1/23.
 */
public class LuntanAdapter extends BaseAdapter {

    private Context context;
    private List<UserBean> list;
    private BitmapUtils bitmapUtils;

    public LuntanAdapter(Context context, List<UserBean> list, BitmapUtils bitmapUtils) {
        this.context = context;
        this.list = list;
        this.bitmapUtils = bitmapUtils;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_luntan,null);
            holder = new ViewHolder();
            com.lidroid.xutils.ViewUtils.inject(holder,convertView);

            holder.userName = (TextView)convertView.findViewById(R.id.username);
            holder.fromSchool = (TextView)convertView.findViewById(R.id.fromSchool);
            holder.dateAdd = (TextView)convertView.findViewById(R.id.dateAdd);
            holder.articleContent = (TextView)convertView.findViewById(R.id.articleContent);
            holder.praiseNum = (TextView)convertView.findViewById(R.id.praiseNum);
            holder.shareNum = (TextView)convertView.findViewById(R.id.shareNum);
            holder.evaluateNum = (TextView)convertView.findViewById(R.id.evaluateNum);
            convertView.setTag(holder);

        }else {
            holder =(ViewHolder)convertView.getTag();
        }

        holder.userName.setText(list.get(position).getUserName());
        holder.fromSchool.setText(list.get(position).getFromSchool());
        String str = list.get(position).getDateAdd();

        holder.dateAdd.setText(str.substring(0,10));
        holder.articleContent.setText(list.get(position).getArticleContent());
        holder.praiseNum.setText(list.get(position).getPraiseNum());
        holder.shareNum.setText(list.get(position).getShareNum());
        holder.evaluateNum.setText(list.get(position).getEvaluateNum());

        if (list.get(position).getSex().equals("1")){
            holder.psex.setImageResource(R.mipmap.icon_nv);
            System.out.println("男");
        }else if (list.get(position).getSex().equals("0")){
            holder.psex.setImageResource(R.mipmap.icon_nan);
        }
        System.out.println("imgurl------>"+list.get(position).getSex());
        String url = CommonUrl.BASE+list.get(position).getLogo();
        bitmapUtils.display(holder.logo, url);
//        DateUtils dateUtils = new DateUtils();
//        holder.datetime.setText( mList.get(position).getDateBegin());
//        holder.money.setText(Html.fromHtml("<font color='#ffc50a'>￥" + mList.get(position).getMoneyStandard() + "</font>"));
        return convertView;
    }

    public static class ViewHolder {
        private TextView userName;  //用户名
        private TextView sex;        //性别0女  1男
        private TextView fromSchool;  //毕业学校
        private TextView dateAdd;    //发布时间
        private TextView userCode;   // 用户编号
        private TextView articleContent;  //内容
        private TextView  praiseNum ;      //点赞数量
        private TextView shareNum;        //分享数量
        private TextView evaluateNum;    // 评论数量
        private TextView code;//编号
        @ViewInject(R.id.logo)
        private ImageView  logo;       //头像
        @ViewInject(R.id.psex)
        private ImageView psex;


    }
}
