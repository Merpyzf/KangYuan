package com.yangdakangyuan.kangyuan.domain;

/**
 * 封装购物车对象
 */

public class ShoppingCarBean {

    //商品名字
    private String GoodName;
    //容量
    private String Capacity;
    //送货方式
    private String Type;

    //订购商品的总价格
    private int price;

    //单个商品的价格
    private int goodPrice;


    //总数量
    private int number;

    //商品图片
    private int goodImage;

    //订购的份数
    private int copies;

    public ShoppingCarBean(String goodName, String capacity, String type, int goodPrice, int number, int goodImage, int copies) {

        GoodName = goodName;
        Capacity = capacity;
        Type = type;
        this.goodPrice = goodPrice;
        this.number = number;
        this.goodImage = goodImage;
        this.copies = copies;
        this.price = goodPrice*number*copies;

    }

    public String getGoodName() {
        return GoodName;
    }

    public void setGoodName(String goodName) {
        GoodName = goodName;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(int goodImage) {
        this.goodImage = goodImage;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
