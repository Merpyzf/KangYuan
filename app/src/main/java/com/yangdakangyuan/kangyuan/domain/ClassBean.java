package com.yangdakangyuan.kangyuan.domain;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ClassBean {

    private String text;
    private int image = 0;

    public ClassBean(String text)
    {
        this.text = text;
    }

    public ClassBean(String text, int res)
    {
        this(text);
        this.image = res;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
