package com.yangdakangyuan.kangyuan.domain;

import java.io.Serializable;

/**
 * 封装热门商品的对象
 * @author lirui
 */

public class HotGoodBean implements Serializable {

    private String goodName;
    private String goodPrice;
    private int imageId;

    public HotGoodBean(String goodName, String goodPrice, int imageId) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }
}
