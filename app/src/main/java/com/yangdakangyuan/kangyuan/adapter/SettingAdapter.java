package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.ClassBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */

public class SettingAdapter extends BaseAdapter
{
    private Context context;
    private List<ClassBean> data;
    private TextView textView;

    public SettingAdapter(Context context, List<ClassBean> data)
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
        TextView textView = null;
        if(data.get(position).getImage() == 0)
        {
            convertView = View.inflate(context, R.layout.item_list_setting, null);
            textView = (TextView) convertView.findViewById(R.id.item_tv_setting1);
        }
        else
        {
            convertView = View.inflate(context, R.layout.item_list_setting_switch, null);
            textView = (TextView) convertView.findViewById(R.id.item_tv_setting2);
            Switch aSwitch = (Switch) convertView.findViewById(R.id.item_switch);
        }
        textView.setText(data.get(position).getText());
        return convertView;
    }
}
