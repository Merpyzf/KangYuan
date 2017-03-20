package com.yangdakangyuan.kangyuan.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.adapter.MyIdentListViewAdapter;

import java.util.ArrayList;

public class MyIndentActivity extends AppCompatActivity {

    String [] mTabTitle = {"代付款","配送中","已完成","已取消"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<View> mViewList;
    private TextView tv_title;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_indent);

        InitUI();
        InitData();


    }
    private void InitData() {

        mViewList = new ArrayList<View>();
        for(int i=0;i<mTabTitle.length;i++){


            View view = View.inflate(this, R.layout.view_indent, null);


            ListView mListView = (ListView) view.findViewById(R.id.ListView_ident);


            mListView.setAdapter(new MyIdentListViewAdapter(MyIndentActivity.this,i));


            mViewList.add(view);

        }

        mViewPager.setAdapter(new myPagerAdapter());

        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void InitUI() {

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        tv_title = (TextView)findViewById(R.id.tv_title);

        iv_back = (ImageView)findViewById(R.id.tv_menu);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });


        tv_title.setText("我的订单");

    }


    class  myPagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(mViewList.get(position));

            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public CharSequence getPageTitle(int position) {


            return mTabTitle[position];

        }
    }
}
