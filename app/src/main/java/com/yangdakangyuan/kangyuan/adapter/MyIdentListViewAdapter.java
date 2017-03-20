package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.IndentBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

import java.util.ArrayList;

/**
 * 显示订单信息的Adapter
 */

public class MyIdentListViewAdapter extends BaseAdapter{

    private Context context;
    private int type;
    private ArrayList<IndentBean> BeanList = GlobalValue.getAllIndent();

    public MyIdentListViewAdapter(Context context,int type){

        this.context = context;
        this.type = type;

    }

    @Override
    public int getCount() {

        if(type==0){

            return BeanList.size();


        }else if(type ==1){

            return 2;
        }else if(type ==2){

            return 1;
        }else if(type ==3){

            return 1;
        }


        return BeanList.size();

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder mViewHolder = null;

        IndentBean bean = BeanList.get(position);

        if(convertView  == null){

           convertView =  View.inflate(context, R.layout.listview_item_ident,null);
           mViewHolder = new ViewHolder();

           mViewHolder.iv_indent_img = (ImageView)convertView.findViewById(R.id.iv_indent_img);
           mViewHolder.tv_date = (TextView)convertView.findViewById(R.id.tv_date);
           mViewHolder.tv_ident_number = (TextView)convertView.findViewById(R.id.tv_ident_number);
           mViewHolder.tv_ident_address = (TextView)convertView.findViewById(R.id.tv_ident_address);
           mViewHolder.tv_money = (TextView)convertView.findViewById(R.id.tv_money);
           mViewHolder.tv_order_user = (TextView)convertView.findViewById(R.id.tv_order_user);
           mViewHolder.tv_status = (TextView)convertView.findViewById(R.id.tv_status);

           convertView.setTag(mViewHolder);

       }else {


           mViewHolder = (ViewHolder) convertView.getTag();
       }



        Glide.with(context).load(bean.getIndentImage()).into(mViewHolder.iv_indent_img);
        mViewHolder.tv_date.setText(bean.getDate());
        mViewHolder.tv_ident_number.setText(bean.getIndentNumber());
        mViewHolder.tv_ident_address.setText("收货地址:"+bean.getIndentAddress());
        mViewHolder.tv_money.setText("￥ "+bean.getIndentMoney());
        mViewHolder.tv_order_user.setText(bean.getIndentUser());

        if(type == 0){

            mViewHolder.tv_status.setText("未付款");

        }else if(type == 1){

            mViewHolder.tv_status.setText("配送中");
            mViewHolder.tv_status.setTextColor(Color.GREEN);
        }else if(type == 2){

            mViewHolder.tv_status.setText("已完成");
            mViewHolder.tv_status.setTextColor(Color.CYAN);
        }else if(type == 3){

            mViewHolder.tv_status.setText("已取消");
            mViewHolder.tv_status.setTextColor(Color.BLUE);
        }



        return convertView;
    }

    static class ViewHolder{

        private ImageView iv_indent_img;
        private TextView tv_ident_number;
        private TextView tv_date;
        private TextView tv_order_user;
        private TextView tv_money;
        private TextView tv_ident_address;
        private TextView tv_status;

    }
}
