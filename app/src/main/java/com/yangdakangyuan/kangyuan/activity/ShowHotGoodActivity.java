package com.yangdakangyuan.kangyuan.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.adapter.HotGoodListViewAdapter;
import com.yangdakangyuan.kangyuan.customui.PagingListView;
import com.yangdakangyuan.kangyuan.domain.HotGoodBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * 显示热门商品
 */
public class ShowHotGoodActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_title;
    private ImageView iv_menu;
    private Context context;

    //用于刷新的View
    private SwipeRefreshLayout refresh;

    //自定义ListView增加分页加载的功能
    private PagingListView pagingListView;

    private ArrayList<HotGoodBean> HotGoodList = GlobalValue.getHotGoods();

    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hot_good);

        context = this;
        //初始化控件
        InitUI();

        String titleName = getIntent().getStringExtra("titleName");
        tv_title.setText(titleName);


        final HotGoodListViewAdapter listViewAdapter = new HotGoodListViewAdapter(HotGoodList, this);

        pagingListView.setAdapter(listViewAdapter);

        /**
         * 进行分页加载时的事件监听
         */
        pagingListView.setOnLoadingListener(new PagingListView.onLoadingListener() {
            @Override
            public void onLoading() {


                /**
                 * 模拟网络请求时的数据延迟
                 */


                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        for(int i=0;i<GlobalValue.getHotGoods().size();i++){

                            HotGoodList.add(GlobalValue.getHotGoods().get(i));

                        }


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //告诉ListView数据已经加载完成
                                pagingListView.setLoadingComplete();
                                listViewAdapter.notifyDataSetChanged();
                            }
                        });


                    }
                },2000);

                Toast.makeText(ShowHotGoodActivity.this,"正在加载",Toast.LENGTH_SHORT).show();


            }
        });


        /**
         *
         * SwipeRefreshLayout进行刷新时的事件监听
         */
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                /**
                 *
                 * 模拟下拉刷新
                 */
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        Random random = new Random();
                        int index = random.nextInt(GlobalValue.getHotGoods().size() - 1);
                        HotGoodList.add(0,GlobalValue.getHotGoods().get(index));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //停止刷新操作
                                refresh.setRefreshing(false);
                                //刷新数据
                                listViewAdapter.notifyDataSetChanged();
                            }
                        });



                    }
                },2000);


            }
        });


        pagingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HotGoodBean bean = (HotGoodBean) adapterView.getItemAtPosition(i);

                View imageView = adapterView.getChildAt(i);


                int childCount = adapterView.getChildCount();

                Log.i("wk",childCount+"");

                Toast.makeText(context,bean.getGoodName()+"",Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(context,GoodDetailActivity.class);

                intent.putExtra("hotGood",HotGoodList.get(i));

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context,imageView,"share").toBundle());


            }
        });



    }

    private void InitUI() {

        tv_title = (TextView) findViewById(R.id.tv_title);


        iv_menu = (ImageView) findViewById(R.id.tv_menu);
        iv_menu.setOnClickListener(this);

        refresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh_hot_good);
        pagingListView = (PagingListView) findViewById(R.id.pagingListView);



    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){

            //返回键
            case R.id.tv_menu:

                onBackPressed();

                break;



        }



    }
}
