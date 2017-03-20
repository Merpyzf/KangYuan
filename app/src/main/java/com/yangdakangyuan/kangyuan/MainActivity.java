package com.yangdakangyuan.kangyuan;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.yangdakangyuan.kangyuan.adapter.MainPagerAdapter;
import com.yangdakangyuan.kangyuan.fragment.ClassifyGoodsFragment;
import com.yangdakangyuan.kangyuan.fragment.HomeFragment;
import com.yangdakangyuan.kangyuan.fragment.IndentFragment;
import com.yangdakangyuan.kangyuan.fragment.ShoppingCartFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;
    private RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitUI();
        InitData();


        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i){

                    case R.id.rb_home:


                        mViewPager.setCurrentItem(0);

                        break;

                    case R.id.rb_category:

                        mViewPager.setCurrentItem(1);

                        break;

                    case R.id.rb_shoping_car:

                        mViewPager.setCurrentItem(2);

                        break;

                    case R.id.rb_order:

                        mViewPager.setCurrentItem(3);

                        break;
                }





            }
        });

    }

    /**
     * 初始化数据
     */
    private void InitData() {

        mFragments = new ArrayList<Fragment>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ClassifyGoodsFragment());
        mFragments.add(new ShoppingCartFragment());
        mFragments.add(new IndentFragment());
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(pagerAdapter);

    }

    /**
     * 初始化界面UI
     */
    private void InitUI() {

        mViewPager = (ViewPager) findViewById(R.id.viewPager_main);

        mRadioGroup = (RadioGroup) findViewById(R.id.rg_group);


    }
}
