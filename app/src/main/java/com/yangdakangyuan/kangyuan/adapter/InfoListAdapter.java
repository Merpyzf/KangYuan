package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.SystemInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */

public class InfoListAdapter extends BaseAdapter
{
    private Context context;
    private List<SystemInfoBean> data;

    public InfoListAdapter(Context context, List<SystemInfoBean> data)
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
        convertView = View.inflate(context, R.layout.item_list_info, null);
        TextView title = (TextView) convertView.findViewById(R.id.item_tv_title_info);
        TextView content = (TextView) convertView.findViewById(R.id.item_tv_content);
        TextView time= (TextView) convertView.findViewById(R.id.item_tv_time);

        title.setText(data.get(position).getTitle());
        content.setText(data.get(position).getContent());
        time.setText(data.get(position).getTime());

        return convertView;
    }
}
