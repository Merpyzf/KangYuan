package com.yangdakangyuan.kangyuan.global;

import com.yangdakangyuan.kangyuan.R;
import com.yangdakangyuan.kangyuan.domain.AddressBean;
import com.yangdakangyuan.kangyuan.domain.HotGoodBean;
import com.yangdakangyuan.kangyuan.domain.IndentBean;
import com.yangdakangyuan.kangyuan.domain.ShoppingCarBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/15.
 */

public class GlobalValue {

    /**
     * 模拟热销商品的数据
     *
     * @return
     */
    public static ArrayList<HotGoodBean> getHotGoods() {

        ArrayList<HotGoodBean> hotGoodBeens = new ArrayList<HotGoodBean>();

        hotGoodBeens.add(new HotGoodBean("印象牛奶" + "\n" + "(200ML)", "￥4.8", R.drawable.hot_good_one));

        hotGoodBeens.add(new HotGoodBean("八连杯" + "\n" + "(260ML)", "￥9.9", R.drawable.hot_good_two));

        hotGoodBeens.add(new HotGoodBean("巴氏鲜牛奶" + "\n" + "(195ML)", "￥5", R.drawable.hot_good_three));

        hotGoodBeens.add(new HotGoodBean("果然益生菌" + "\n" + "(180ML)", "￥6", R.drawable.hot_good_four));

        hotGoodBeens.add(new HotGoodBean("蓝莓之恋" + "\n" + "(300ML)", "￥4", R.drawable.hot_good_five));

        return hotGoodBeens;
    }

    /**
     * 模拟分类产品的数据
     *
     * @return
     */
    public static ArrayList<HotGoodBean> getClassify1Goods() {

        ArrayList<HotGoodBean> hotGoodBeens = new ArrayList<HotGoodBean>();

        hotGoodBeens.add(new HotGoodBean("大红枣酸奶" + "\n" + "(980g)", "￥15", R.drawable.classify_goods_one));

        hotGoodBeens.add(new HotGoodBean("扬大酸牛奶" + "\n" + "(488g)", "￥7", R.drawable.classify_goods_two));

        return hotGoodBeens;
    }

    /**
     * 模拟促销活动的图片的数据
     *
     * @return
     */
    public static int[] getHotActivityImages() {


        int[] images = {R.drawable.detail_six, R.drawable.detail_two};

        return images;
    }

    /**
     * 模拟商品详情的图片数据
     * @return
     */
    public static int[] getGoodDetailImag(){

        int[] images = {R.drawable.detail_one, R.drawable.detail_two, R.drawable.detail_three, R.drawable.detail_four, R.drawable.detail_five, R.drawable.detail_six};

        return images;

    }


    public static ArrayList<ShoppingCarBean> getShoppingGoodList(){

        ArrayList<ShoppingCarBean> beanList = new ArrayList<ShoppingCarBean>();

        beanList.add(new ShoppingCarBean("大红枣风味牛奶","200ML","每日送",5,44,R.drawable.classify_goods_one,2));
        beanList.add(new ShoppingCarBean("酸牛奶","300ML","每日送",5,44,R.drawable.classify_goods_two,1));
        beanList.add(new ShoppingCarBean("蓝莓之恋","250ML","每日送",8,44,R.drawable.hot_good_five,2));
        beanList.add(new ShoppingCarBean("果然益生菌","260ML","每日送",5,44,R.drawable.hot_good_four,1));

        return beanList;

    }


    /**
     * 模拟收货地址的信息
     * @return
     */
    public static ArrayList<AddressBean> getAllAddress(){

        ArrayList<AddressBean> beanList = new ArrayList<AddressBean>();

        beanList.add(new AddressBean("小马","17617574909","江苏扬州市大学南路88号"));
        beanList.add(new AddressBean("阿正","17618977499","江苏扬州市大学南路89号"));
        beanList.add(new AddressBean("玉龙","17611674909","江苏扬州市大学南路108号"));
        beanList.add(new AddressBean("小花","17614574909","江苏扬州市大学南路89号"));
        beanList.add(new AddressBean("徐太浪","11217574909","江苏扬州市大学南路89号"));
        beanList.add(new AddressBean("阿正","17618977499","江苏扬州市大学南路89号"));
        beanList.add(new AddressBean("玉龙","17611674909","江苏扬州市大学南路108号"));

        return beanList;
    }


    /**
     * 模拟我的订单数据
     * @return
     */
    public static ArrayList<IndentBean> getAllIndent(){

        ArrayList<IndentBean> beanList = new ArrayList<IndentBean>();

//        (int indentImage, String indentNumber, String date, String indentUser, String indentMoney, String indentAddress)

        beanList.add(new IndentBean(R.drawable.hot_good_one,"1013199554","订奶用户:小花","2017-03-17","206","扬州市邗江区扬大"));
        beanList.add(new IndentBean(R.drawable.hot_good_two,"1013197954","订奶用户:小花","2017-03-17","206","扬州市邗江区扬大"));
        beanList.add(new IndentBean(R.drawable.hot_good_three,"1013199584","订奶用户:小花","2017-03-17","206","扬州市邗江区扬大"));


        return beanList;

    }


}
