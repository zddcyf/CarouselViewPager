package com.vp.carousel.bean;

import com.vp.carousel.viewpager.bean.ConfigBean;

/**
 * Created by zdd
 * on 2018/12/25
 * at 15:56
 * summary:
 */
public class Banners implements ConfigBean {
    private Object pictures;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPictures(Object pictures) {
        this.pictures = pictures;
    }

    @Override
    public Object getPictures() {
        return pictures;
    }

    public Banners(Object pictures, String type) {
        this.pictures = pictures;
        this.type = type;
    }
}
