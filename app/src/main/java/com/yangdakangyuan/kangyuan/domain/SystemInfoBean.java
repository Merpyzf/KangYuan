package com.yangdakangyuan.kangyuan.domain;

/**
 * Created by Administrator on 2017/3/17.
 */

public class SystemInfoBean
{
    private String title;
    private String content;
    private String time;

    public SystemInfoBean(String title, String content, String time)
    {
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
}