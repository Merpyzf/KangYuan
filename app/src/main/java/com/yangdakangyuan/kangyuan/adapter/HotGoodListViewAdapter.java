package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.HotGoodBean;

import java.util.ArrayList;

/**
 * 展示热门商品的ListView的适配器
 */

public class HotGoodListViewAdapter extends BaseAdapter {

    private ArrayList<HotGoodBean> HotGoodList;
    private Context context;

    public HotGoodListViewAdapter(ArrayList<HotGoodBean> hotGoodList, Context context) {
        HotGoodList = hotGoodList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return HotGoodList.size();
    }

    @Override
    public Object getItem(int position) {
        return HotGoodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if(convertView == null){

            convertView = View.inflate(context, R.layout.listview_item_hot_good,null);
            viewHolder = new ViewHolder();

            viewHolder.iv_show_hot_good = (ImageView) convertView.findViewById(R.id.iv_show_hot_good);
            viewHolder.tv_show_hot_name = (TextView) convertView.findViewById(R.id.tv_show_hot_name);

            viewHolder.tv_show_hot_price = (TextView)convertView.findViewById(R.id.tv_show_hot_price);





            convertView.setTag(viewHolder);

        }else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.tv_show_hot_name.setText(HotGoodList.get(position).getGoodName());
        viewHolder.tv_show_hot_price.setText(HotGoodList.get(position).getGoodPrice());
//        viewHolder.iv_show_hot_good.setImageResource(HotGoodList.get(position).getImageId());

        //为了避免出现OOM 使用Glide进行图片加载,提升性能

        Glide.with(context).load(HotGoodList.get(position).getImageId()).into(viewHolder.iv_show_hot_good);



        return convertView;
    }


    /**
     * 使用ViewHolder进行ListView加载的优化,减少findViewById的次数
     */
    static class ViewHolder{

        ImageView iv_show_hot_good;
        TextView tv_show_hot_name;
        TextView tv_show_hot_price;

    }
}
