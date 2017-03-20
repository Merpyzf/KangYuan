package com.yangdakangyuan.kangyuan.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.adapter.ShoppingCarAdapter;
import com.yangdakangyuan.kangyuan.customui.PagingListView;
import com.yangdakangyuan.kangyuan.domain.ShoppingCarBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 购物车
 *
 * @author lirui
 */
public class ShoppingCartFragment extends Fragment implements View.OnClickListener {

    private TextView tv_title;
    private ImageView iv_menu;
    private PagingListView mPagingListView;
    private ArrayList<ShoppingCarBean> BeanList = GlobalValue.getShoppingGoodList();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Timer mTimer;
    private AlertDialog alertDialog;
    private ShoppingCarAdapter mAdapter;
    private FloatingActionButton fab_add_shopping_car;
    private TextView tv_money;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        InitUI(view);


        mAdapter = new ShoppingCarAdapter(BeanList, getContext());
        mPagingListView.setAdapter(mAdapter);

        loadData();
        update();


        tv_money.setText(calPrice());




        return view;
    }

    /**
     *
     * 计算订购费用
     */
    private String calPrice() {

        int sum = 0;
        for(int i=0;i<BeanList.size();i++){

            sum+= BeanList.get(i).getPrice();

        }

        return sum+"";

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_delete:

                //删除全部的购物车



                showAlertDialog();


                break;

            case R.id.fab_add_shopping_car:

                Snackbar.make(view,"调用微信支付",Toast.LENGTH_SHORT).setAction("关闭", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();

                break;


        }



    }

    /**
     * 显示一个清空购物车的弹窗提示
     */
    private void showAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("提示");
        builder.setMessage("将要清空您的购物车");



        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //清空
                BeanList.clear();
                //刷新数据
                mAdapter.notifyDataSetChanged();

                mPagingListView.setLoadingComplete();




            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });


        alertDialog = builder.create();

        alertDialog.show();

    }
    /**
     * 模拟加载数据
     */
    private void loadData() {
        mPagingListView.setOnLoadingListener(new PagingListView.onLoadingListener() {
            @Override
            public void onLoading() {

                mTimer = new Timer();

                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(new Runnable() {


                            @Override
                            public void run() {
                                mPagingListView.setLoadingComplete();
                                Toast.makeText(getContext(),"加载完毕",Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                },2000);

            }
        });
    }
    /**
     * 模拟更新操作
     */
    private void update() {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getContext(),"没有更新的数据",Toast.LENGTH_SHORT).show();

                        //停止刷新
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });


            }
        },2000);
    }

    /**
     * 初始化UI
     * @param view
     */
    private void InitUI(View view) {

        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("购物车");
        iv_menu = (ImageView)view.findViewById(R.id.tv_delete);
        iv_menu.setOnClickListener(this);
        mPagingListView = (PagingListView) view.findViewById(R.id.pagingListView_shopping_car);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh_shopping_car);
        fab_add_shopping_car = (FloatingActionButton) view.findViewById(R.id.fab_add_shopping_car);
        fab_add_shopping_car.setOnClickListener(this);
        tv_money = (TextView) view.findViewById(R.id.tv_money);
    }
}
