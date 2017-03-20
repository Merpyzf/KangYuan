package com.yangdakangyuan.kangyuan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.HotGoodBean;
import com.yangdakangyuan.kangyuan.global.GlobalValue;

/**
 * 显示商品详情的页面
 */
public class GoodDetailActivity extends Activity implements View.OnClickListener {


    public ImageView iv_good_detail;
    private ImageView iv_menu;
    private TextView tv_title;
    //用于填充商品详情的线性布局haha
    private LinearLayout content_detail;

    private ImageView iv_more;

    private TextView tv_good_name;
    private TextView tv_good_price;

    private FloatingActionButton fab_add_shopping_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);

        InitUI();
        HotGoodBean hotGood = (HotGoodBean) getIntent().getSerializableExtra("hotGood");
        Toast.makeText(this,hotGood.getGoodName()+"",Toast.LENGTH_SHORT).show();
        iv_good_detail.setImageResource(hotGood.getImageId());
        tv_good_name.setText(hotGood.getGoodName());
        tv_good_price.setText(hotGood.getGoodPrice());


    }

    private void InitUI() {

        iv_good_detail = (ImageView) findViewById(R.id.iv_good_detail);
        content_detail = (LinearLayout) findViewById(R.id.content_detail_img);
        tv_title = (TextView)findViewById(R.id.tv_title);
        iv_menu  = (ImageView) findViewById(R.id.tv_menu);
        fab_add_shopping_car = (FloatingActionButton)findViewById(R.id.fab_add_shopping_car);

        tv_good_name = (TextView) findViewById(R.id.tv_good_name);
        tv_good_price = (TextView) findViewById(R.id.tv_good_price);


        iv_more = (ImageView) findViewById(R.id.iv_more);

        fab_add_shopping_car.setOnClickListener(this);

        iv_more.setOnClickListener(this);

        tv_title.setText("商品详情");
        iv_menu.setOnClickListener(this);
        //添加详情页的图片
        addDetailImages();



    }

    private void addDetailImages() {

        for(int i=0;i< GlobalValue.getGoodDetailImag().length;i++){

            ImageView imageView = new ImageView(this);
            Glide.with(this).load(GlobalValue.getGoodDetailImag()[i]).into(imageView);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);


            content_detail.addView(imageView);



        }





    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_menu:
                onBackPressed();
                break;

            case R.id.fab_add_shopping_car:


                Snackbar.make(view,"加入购物车成功",Toast.LENGTH_SHORT).setAction("关闭", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                }).show();

                break;

            case R.id.iv_more:

                Toast.makeText(this,"订购信息",Toast.LENGTH_SHORT).show();


                break;



        }


    }
}
