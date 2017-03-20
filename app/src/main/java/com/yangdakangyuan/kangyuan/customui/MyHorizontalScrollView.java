package com.yangdakangyuan.kangyuan.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 *
 * 解决上下滑动出现的滑动冲突
 *
 */

public class MyHorizontalScrollView extends HorizontalScrollView {

    public MyHorizontalScrollView(Context context) {
        super(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 记录上一次按下的x,y的位置
     */
    private float downX;
    private float downY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);


        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN :

                downX = ev.getX();
                downX = ev.getY();



                break;

            case MotionEvent.ACTION_MOVE:


                float distanceX = ev.getX()-downX;
                float distanceY = ev.getY()- downY;

                //水平滑动
                if(Math.abs(distanceX)-Math.abs(distanceY)>0) {


                    //从内部进行事件的拦截
                    //不让父View拦截当前View的事件
                    requestDisallowInterceptTouchEvent(true);

                }

                downX = ev.getX();
                downY = ev.getY();

                break;
        }




        return true;
    }
}
