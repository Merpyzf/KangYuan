package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.ClassBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ClassListAdapter extends BaseAdapter
{
    private Context context;
    private LayoutInflater inflater;
    private List<ClassBean> data;
    private RadioGroup group;

    public ClassListAdapter(Context context, List<ClassBean> data)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        group = new RadioGroup(context);
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
    public View getView(int position, View conView, ViewGroup parent)
    {
        if (data.get(position).getImage() != 0)
        {
            conView = inflater.inflate(R.layout.item_list_image_tv, null);
            TextView textView = (TextView) conView.findViewById(R.id.item_tv_title);
            ImageView image = (ImageView) conView.findViewById(R.id.item_image_icon);

            textView.setText(data.get(position).getText());
            image.setImageResource(data.get(position).getImage());
        }
        else
        {
            TextView textView = new TextView(context);
            textView.setGravity(Gravity.CENTER);
            textView.setText(data.get(position).getText());
            textView.setPadding(10,10,10,10);

            conView = textView;
        }

        return conView;
    }

}
