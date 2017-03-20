package com.yangdakangyuan.kangyuan.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * 用于显示广告图的ViewPager
 * @author lirui
 */

public class AdPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
