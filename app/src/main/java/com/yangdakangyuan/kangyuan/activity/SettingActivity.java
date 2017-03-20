package com.yangdakangyuan.kangyuan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.adapter.SettingAdapter;
import com.yangdakangyuan.kangyuan.domain.ClassBean;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity
{
    private ListView listView;

    private List<ClassBean> data;
    private SettingAdapter adapter;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
        initData();
    }

    private void initView()
    {
        listView = (ListView) findViewById(R.id.setting_listView);
        back = (ImageView) findViewById(R.id.tv_menu);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    private void initData()
    {
        data = new ArrayList<>();

        ClassBean bean1 = new ClassBean("修改个人信息");
        ClassBean bean2 = new ClassBean("意见反馈");
        ClassBean bean3 = new ClassBean("修改密码");
        ClassBean bean4 = new ClassBean("检查版本信息");
        ClassBean bean5 = new ClassBean("是否接受消息", 1);
        ClassBean bean6 = new ClassBean("清除缓存");
        ClassBean bean7 = new ClassBean("是否自动清除缓存", 1);
        ClassBean bean8 = new ClassBean("关于康源");
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        data.add(bean5);
        data.add(bean6);
        data.add(bean7);
        data.add(bean8);

        adapter = new SettingAdapter(this, data);
        listView.setAdapter(adapter);
    }
}
