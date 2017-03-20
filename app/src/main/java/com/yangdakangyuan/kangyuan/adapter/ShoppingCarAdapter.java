package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.ShoppingCarBean;

import java.util.ArrayList;

/**
 * 购物车的Adapter
 */

public class ShoppingCarAdapter extends BaseAdapter {

    private ArrayList<ShoppingCarBean> ShoppingCarList;
    private Context context;

    public ShoppingCarAdapter(ArrayList<ShoppingCarBean> shoppingCarList, Context context) {
        ShoppingCarList = shoppingCarList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return ShoppingCarList.size();
    }

    @Override
    public Object getItem(int position) {
        return ShoppingCarList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if(convertView == null){

            convertView = View.inflate(context, R.layout.listview_item_shopping_car,null);

            viewHolder = new ViewHolder();

            /**
             * 初始化UI
             */
            InitUI(viewHolder,convertView);

            convertView.setTag(viewHolder);


        }else {


            viewHolder = (ViewHolder) convertView.getTag();


        }


        ShoppingCarBean bean = ShoppingCarList.get(position);


        viewHolder.tv_all_price.setText(""+bean.getGoodPrice());
        viewHolder.tv_name.setText(bean.getGoodName());
        viewHolder.tv_all_number.setText("总数量: 88 份 ");
        viewHolder.tv_price.setText("￥ "+bean.getGoodPrice());
        viewHolder.tv_all_price.setText("总金额: "+bean.getPrice());
        viewHolder.tv_time.setText("从2017-03-18到2017-04-30");
        viewHolder.tv_type.setText(bean.getType());
        viewHolder.tv_ml.setText(""+bean.getCapacity());
        viewHolder.tv_number.setText("×"+bean.getNumber());

        Glide.with(context).load(bean.getGoodImage()).into(viewHolder.iv_pic);


        return convertView;
    }

    private void InitUI(ViewHolder viewHolder, View convertView) {


        viewHolder.iv_pic = (ImageView) convertView.findViewById(R.id.iv_show_shopping_good);
        viewHolder.tv_name = (TextView)convertView.findViewById(R.id.tv_show_shopping_name);
        viewHolder.tv_ml = (TextView)convertView.findViewById(R.id.tv_show_shopping_capacity);
        viewHolder.tv_type = (TextView)convertView.findViewById(R.id.tv_show_shopping_type);
        viewHolder.tv_time = (TextView)convertView.findViewById(R.id.tv_show_hot_price);
        viewHolder.tv_price = (TextView)convertView.findViewById(R.id.tv_show_shopping_price);
        viewHolder.tv_number = (TextView)convertView.findViewById(R.id.tv_show_shopping_number);
        viewHolder.tv_all_number = (TextView)convertView.findViewById(R.id.tv_show_shopping_all_number);
        viewHolder.tv_all_price = (TextView)convertView.findViewById(R.id.tv_show_shopping_all_price);
    }


    static class ViewHolder{

        ImageView iv_pic;
        TextView tv_name;
        TextView tv_ml;
        TextView tv_type;
        TextView tv_time;
        TextView tv_price;
        TextView tv_number;

        //总数
        TextView tv_all_number;

        //总价
        TextView tv_all_price;











    }



}
