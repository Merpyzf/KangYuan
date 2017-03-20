package com.yangdakangyuan.kangyuan.domain;

/**
 * 封装订单对象
 */

public class IndentBean {

    private int indentImage;
    private String indentNumber;
    private String date;
    private String indentUser;
    private String indentMoney;
    private String indentAddress;


    public IndentBean(int indentImage, String indentNumber, String date, String indentUser, String indentMoney, String indentAddress) {
        this.indentImage = indentImage;
        this.indentNumber = indentNumber;
        this.date = date;
        this.indentUser = indentUser;
        this.indentMoney = indentMoney;
        this.indentAddress = indentAddress;
    }


    public int getIndentImage() {
        return indentImage;
    }

    public void setIndentImage(int indentImage) {
        this.indentImage = indentImage;
    }

    public String getIndentNumber() {
        return indentNumber;
    }

    public void setIndentNumber(String indentNumber) {
        this.indentNumber = indentNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;


    }

    public String getIndentUser() {
        return indentUser;
    }

    public void setIndentUser(String indentUser) {
        this.indentUser = indentUser;
    }

    public String getIndentMoney() {
        return indentMoney;
    }

    public void setIndentMoney(String indentMoney) {
        this.indentMoney = indentMoney;
    }

    public String getIndentAddress() {
        return indentAddress;
    }

    public void setIndentAddress(String indentAddress) {
        this.indentAddress = indentAddress;
    }
}
