package com.yangdakangyuan.kangyuan.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.activity.IndentCalendarActivity;
import com.yangdakangyuan.kangyuan.activity.MyIndentActivity;
import com.yangdakangyuan.kangyuan.activity.SettingActivity;
import com.yangdakangyuan.kangyuan.activity.ShowAddressActivity;
import com.yangdakangyuan.kangyuan.activity.SystemInfoActivity;
import com.yangdakangyuan.kangyuan.adapter.IndentListAdapter;
import com.yangdakangyuan.kangyuan.domain.ClassBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的订单
 *
 * @author lirui
 */
public class IndentFragment extends Fragment implements View.OnClickListener
{
    private ListView listView;
    private TextView point, username;
    private ImageView head, setting;
    private LinearLayout point_press, address_press;
    private ImageView iv_address;
    private Activity mActivity;
    private List<ClassBean> data;
    private IndentListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return initView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private View initView()
    {
        View view = View.inflate(mActivity, R.layout.fragment_indent, null);

        listView = (ListView) view.findViewById(R.id.indent_list);
        point = (TextView) view.findViewById(R.id.indent_tv_point);
        username = (TextView) view.findViewById(R.id.indent_tv_username);
        head = (ImageView) view.findViewById(R.id.indent_image_head);
        setting = (ImageView) view.findViewById(R.id.indent_image_setting);
//        point_press = (LinearLayout) view.findViewById(R.id.indent_layout_point);
        address_press = (LinearLayout) view.findViewById(R.id.indent_layout_address);

        iv_address = (ImageView) view.findViewById(R.id.iv_address);

        setting.setOnClickListener(this);
//        point_press.setOnClickListener(this);
        address_press.setOnClickListener(this);

        iv_address.setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){


                    case 0:

                        startActivity(new Intent(getActivity(), MyIndentActivity.class));


                        break;
                    case 1:

                        startActivity(new Intent(getActivity(), IndentCalendarActivity.class));

                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), SystemInfoActivity.class));

                        break;
                }


            }
        });



        return view;
    }

    private void initData()
    {
        data = new ArrayList<>();
        ClassBean bean1 = new ClassBean("我的订单", R.drawable.ic_action_order);
        ClassBean bean2 = new ClassBean("订单日历", R.drawable.ic_action_orderlist);
        ClassBean bean3 = new ClassBean("系统消息", R.drawable.ic_action_info);
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);

        adapter = new IndentListAdapter(mActivity, data);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.indent_image_setting:
                Intent intent = new Intent(mActivity, SettingActivity.class);
                startActivity(intent);
                break;

            case R.id.indent_layout_address:

                break;

            case R.id.iv_address:


                Intent intent1 = new Intent(getActivity(),ShowAddressActivity.class);
                startActivity(intent1);


                break;
        }
    }
}
