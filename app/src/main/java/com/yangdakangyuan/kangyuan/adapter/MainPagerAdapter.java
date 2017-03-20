package com.yangdakangyuan.kangyuan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 主页面上填充Fragment的ViewPager的适配器
 * @author lirui
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;

    public MainPagerAdapter(FragmentManager fm,ArrayList<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
