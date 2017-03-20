package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.ClassBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */

public class IndentListAdapter extends BaseAdapter
{
    private List<ClassBean> data;
    private Context context;

    public IndentListAdapter(Context context, List<ClassBean> data)
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
        convertView = View.inflate(context, R.layout.item_list_indent, null);

        TextView textView = (TextView) convertView.findViewById(R.id.item_tv_order);
        textView.setText(data.get(position).getText());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_image_order);
        Glide.with(context).load(data.get(position).getImage()).into(imageView);

        return convertView;
    }
}
