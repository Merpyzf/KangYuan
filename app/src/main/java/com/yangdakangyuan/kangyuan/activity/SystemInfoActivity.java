package com.yangdakangyuan.kangyuan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.adapter.InfoListAdapter;
import com.yangdakangyuan.kangyuan.domain.SystemInfoBean;

import java.util.ArrayList;
import java.util.List;

public class SystemInfoActivity extends AppCompatActivity
{
    private ListView listView;
    private InfoListAdapter adapter;
    private List<SystemInfoBean> data;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);

        initView();
        initData();

    }

    private void initView()
    {
        listView = (ListView) findViewById(R.id.info_listView);
        title = (TextView) findViewById(R.id.tv_title);
    }

    private void initData()
    {
        title.setText("系统通知");

        data = new ArrayList<>();
        SystemInfoBean bean = new SystemInfoBean("康源大放送活动开始啦！",
                "从3月18日开始，使用康源APP订购乳品达到200即可获得免费抽奖机会一次，最高可获得iPhone8一部哦！",
                "2017-03-17 21:46:31");
        data.add(bean);
        data.add(bean);

        adapter = new InfoListAdapter(this, data);
        listView.setAdapter(adapter);
    }
}
