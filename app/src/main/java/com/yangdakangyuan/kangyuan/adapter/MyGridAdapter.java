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

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class MyGridAdapter extends BaseAdapter
{
    private Context context;
    private List<HotGoodBean> data;

    public MyGridAdapter(Context context, List<HotGoodBean> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
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

        viewHolder.tv_show_hot_name.setText(data.get(position).getGoodName());
        viewHolder.tv_show_hot_price.setText(data.get(position).getGoodPrice());

        Glide.with(context).load(data.get(position).getImageId()).into(viewHolder.iv_show_hot_good);

        return convertView;
    }

    static class ViewHolder{

        ImageView iv_show_hot_good;
        TextView tv_show_hot_name;
        TextView tv_show_hot_price;

    }
}
