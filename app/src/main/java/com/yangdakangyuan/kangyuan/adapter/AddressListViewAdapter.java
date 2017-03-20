package com.yangdakangyuan.kangyuan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.customui.SwipeLayout;
import com.yangdakangyuan.kangyuan.domain.AddressBean;

import java.util.ArrayList;

/**
 *
 */

public class AddressListViewAdapter extends BaseAdapter {

    private  Context context;
    private ArrayList<AddressBean> addressBeenList;
    private int position;


    public AddressListViewAdapter(Context context, ArrayList<AddressBean> addressBeenList){

        this.context = context;
        this.addressBeenList = addressBeenList;
    }

    @Override
    public int getCount() {

        return addressBeenList.size();

    }

    @Override
    public Object getItem(int i) {

        return addressBeenList.get(i);


    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView( int i, View convertView, ViewGroup viewGroup) {


        Viewholder viewholder = null;


        if(convertView == null){

           convertView = View.inflate(context,R.layout.listview_item_address,null);
            viewholder = new Viewholder();

            viewholder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewholder.tv_address = (TextView)convertView.findViewById(R.id.tv_address);
            viewholder.tv_phone = (TextView)convertView.findViewById(R.id.tv_phone);
            viewholder.tv_ok = (TextView)convertView.findViewById(R.id.tv_ok);
            viewholder.tv_delete = (TextView)convertView.findViewById(R.id.tv_delete);
            viewholder.swipe_layout = (SwipeLayout) convertView.findViewById(R.id.swipe_layout);

            convertView.setTag(viewholder);
        }else {


            viewholder = (Viewholder) convertView.getTag();
        }


        viewholder.tv_name.setText("收货人:"+addressBeenList.get(i).getName());
        viewholder.tv_address.setText("收货地址:"+addressBeenList.get(i).getAddress());
        viewholder.tv_phone.setText("联系方式:"+addressBeenList.get(i).getPhone());


        final Viewholder finalViewholder = viewholder;
        viewholder.tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finalViewholder.swipe_layout.close();

            }
        });


        position = i;
        viewholder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addressBeenList.remove(position);

                notifyDataSetChanged();

            }
        });



        return convertView;
    }

    static class Viewholder{

        TextView tv_name;
        TextView tv_phone;
        TextView tv_address;
        TextView tv_ok;
        TextView tv_delete;
        SwipeLayout swipe_layout;
    }


}
