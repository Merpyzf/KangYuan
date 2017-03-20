package com.yangdakangyuan.kangyuan.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.activity.GoodDetailActivity;
import com.yangdakangyuan.kangyuan.activity.LoginActivity;
import com.yangdakangyuan.kangyuan.activity.ShowHotGoodActivity;
import com.yangdakangyuan.kangyuan.domain.HotGoodBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 首页
 * @author lirui
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    //用于显示广告的ViewPager
    private ViewPager mViewPagerAd;
    //用于摆放小圆点的线性布局
    private LinearLayout mContentPoint;
    //小红点
    private ImageView mRedPoint;
    //放置图片的集合
    private int []images = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
    //方式imageView的List
    private ArrayList<ImageView> mImageViewList;
    //两个小圆点之间的间距
    private int mPointDistance;

    //线性布局用于填充热门商品
    private LinearLayout mContentHotGoods;

    //存放热门商品的所有View视图
    private ArrayList<View> HotGoodViews;

    //线性布局用于填充促销活动的view
    private LinearLayout mContentHotActivity;
    private SwipeRefreshLayout swipeRefresh;
    private TextView tv_get_order;
    private TextView tv_get_hot_good;
    private TextView tv_history_view;
    private Timer timer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        InitUI(view);
        InitData();

        //设置当前ViewPager的条目所在的位置,要设置的尽量大
        mViewPagerAd.setCurrentItem(5000000-(5000000%mImageViewList.size()));

        //设置ViewPager滑动的监听事件
        mViewPagerAd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mRedPoint.getLayoutParams();
                int newPosition = position%mImageViewList.size();
                //根据滑动的偏移量计算小圆点的位置

                int marginLeft = (int) (mPointDistance*positionOffset)+newPosition*mPointDistance;

                if(marginLeft> mContentPoint.getChildAt(images.length-1).getLeft()){

                    marginLeft = 0;
                }


                params.leftMargin = marginLeft;
                mRedPoint.setLayoutParams(params);

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }

        });


        /**
         * 当放置小红点的线性布局加载完毕后进行测量两个小圆点之间的间距
         */
        mRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {


                mPointDistance = mContentPoint.getChildAt(1).getLeft() - mContentPoint.getChildAt(0).getLeft();



            }
        });


        /**
         * 使用定时器设置ViewPager定时轮询播放广告
         */
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mViewPagerAd.setCurrentItem(mViewPagerAd.getCurrentItem()+1);


                    }
                });


            }
        },3000,3000);

        return view;
    }

    /**
     * 初始化UI的界面
     * @param view
     */
    private void InitUI(View view) {

        mViewPagerAd = (ViewPager) view.findViewById(R.id.viewPager_ad);
        mContentPoint = (LinearLayout)view.findViewById(R.id.content_point);
        mRedPoint = (ImageView)view.findViewById(R.id.red_point);
        mContentHotGoods = (LinearLayout) view.findViewById(R.id.content_hot_goods);
        mContentHotActivity = (LinearLayout)view.findViewById(R.id.content_hot_activity);
        mViewPagerAd.setAdapter(new viewPagerAdapter());
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        tv_get_order = (TextView)view.findViewById(R.id.tv_get_order);
        tv_get_hot_good = (TextView) view.findViewById(R.id.tv_get_hot_good);
        tv_history_view = (TextView)view.findViewById(R.id.tv_history_view);

        //给热门商品设置点击事件
        tv_get_hot_good.setOnClickListener(this);

        //给快速下单设置点击事件
        tv_get_order.setOnClickListener(this);

        //给历史查看记录设置点击事件
        tv_history_view.setOnClickListener(this);


        //用于模拟数据刷新
        swipeRefresh.setColorSchemeColors(Color.BLUE,Color.GREEN,Color.BLACK,Color.RED);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefresh.setRefreshing(false);

                            }
                        });



                    }
                },4000);


            }
        });






        //添加热门商品
        addHotGoodView();

        //添加热门活动
        addHotActivity();


    }

    /**
     *
     * 添加促销活动的View
     *
     */
    private void addHotActivity() {

        for(int i = 0; i< GlobalValue.getHotActivityImages().length; i++){

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
            params.setMargins(5,5,5,5);
            ImageView iv_hot_activity = new ImageView(getActivity());
            Glide.with(getContext()).load(GlobalValue.getHotActivityImages()[i]).centerCrop().into(iv_hot_activity);
            iv_hot_activity.setLayoutParams(params);
            mContentHotActivity.addView(iv_hot_activity);

        }
    }


    /**
     * 添加热门商品的View
     */
    private void addHotGoodView() {
        HotGoodViews = new ArrayList<View>();
        for(int i = 0; i< GlobalValue.getHotGoods().size(); i++) {

            final int position = i;

            View viewHotGood = View.inflate(getActivity(), R.layout.view_hot_good, null);
            HotGoodBean hotGoodBean = GlobalValue.getHotGoods().get(i);
            final ImageView iv_hot_good = (ImageView) viewHotGood.findViewById(R.id.iv_hot_good);
            final TextView tv_name = (TextView) viewHotGood.findViewById(R.id.tv_hot_good_name);
            final TextView tv_price = (TextView)viewHotGood.findViewById(R.id.tv_hot_good_price);
            Glide.with(getContext()).load(hotGoodBean.getImageId()).into(iv_hot_good);
            tv_name.setText(hotGoodBean.getGoodName());
            tv_price.setText(hotGoodBean.getGoodPrice());


            final int finalI = i;
            iv_hot_good.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(), GoodDetailActivity.class);

                    intent.putExtra("hotGood",GlobalValue.getHotGoods().get(position));

                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(),iv_hot_good,"share").toBundle());






                }
            });


            mContentHotGoods.addView(viewHotGood);


        }
    }


    /**
     * 初始化数据
     */
    private void InitData() {

        mImageViewList = new ArrayList<ImageView>();

        for(int i=0;i<images.length;i++){

            ImageView iv = new ImageView(getContext());
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setImageResource(images[i]);
            mImageViewList.add(iv);

            ImageView point_gray = new ImageView(getContext());

            point_gray.setImageResource(R.drawable.gray_point_shape);

            //灰色的小圆点的父布局是LinearLayout
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            if(i>0) {
                params.leftMargin = 20;
            }

            point_gray.setLayoutParams(params);
            mContentPoint.addView(point_gray);
        }













    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_get_order:

                //跳转到登录页面
                startActivity(new Intent(getActivity(), LoginActivity.class));


                break;

            case R.id.tv_get_hot_good:


                Intent intent_hot = new Intent(getActivity(), ShowHotGoodActivity.class);
                intent_hot.putExtra("titleName","热门商品");
                startActivity(intent_hot);

                break;

            case R.id.tv_history_view:


                Intent intent = new Intent(getActivity(),ShowHotGoodActivity.class);
                intent.putExtra("titleName","最近浏览");
                startActivity(intent);




                break;

        }


    }


    class viewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            int newPosition = position%mImageViewList.size();

            container.addView(mImageViewList.get(newPosition));


            return mImageViewList.get(newPosition);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);

        }
    }


}
