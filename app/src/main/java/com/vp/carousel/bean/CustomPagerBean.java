package com.vp.carousel.bean;

import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;

import com.vp.carousel.click.IVpClick;
import com.vp.carousel.config.ViewPagerEnum;

import java.util.List;

/**
 * Created by zdd
 * on 2018/11/29
 * at 14:30
 * summary:
 */
public class CustomPagerBean {
    /**
     * 轮播时间
     */
    private int interval = 5000;
    private int idOrImgMode; // 是展示图片还是本地图片
    private int bookMarkMode = ViewPagerEnum.point.getCode(); // 页签显示的模样 显示点、数字等等
    private int mode = ViewPagerEnum.noBanner.getCode(); // 显示模式  无线轮播、不轮播、轮播一次等等
    private String imageHeadUrl = ""; // 如果是网络图片的话，是否需要传递网址头（此一般为公共的网络路径）
    private List<Integer> ids; // 传递的是本地的id串
    private List<String> images; // 传递的是一串网址
    private String imageName; // 如果是把数据源扔进来需要把具体获取图片路径的方法名传递进来(不推荐使用，因为涉及到反射。影响性能)
    private List<Object> datas; // 可以扔一个数据源进来
    private int defaultImage = -1; // 默认图
    private AppCompatImageView.ScaleType scaleType = null;

    private int grivate = ViewPagerEnum.bottomOrCenter.getCode(); // 所在位置
    private int paddLeft, paddTop, paddRight, paddBottom;
    private int marginLeft, marginTop, marginRight, marginBottom;
    /**
     * 指示器如果是数字的话。设置数字的颜色。和默认的值
     *
     * @return
     */
    private int totalSize;
    private String defaultTextIndex;
    private int defaultTextBg = -1;
    private int defaultTextColor = -1;
    private int defaultTextSize = -1;

    private int startBg = -1; // 启动按钮背景
    private String startBtn; // 启动按钮文字
    private int startBtnSize = -1; // 启动按钮字体大小
    private int startBtnColor = -1; // 启动按钮字体颜色
    private int startBtnMgBottom; // 启动按钮距离底部的距离
    private int startBtnPaddLeft, startBtnPaddTop, startBtnPaddRight, startBtnPaddBottom;

    private IVpClick iVpClick;

    private int child = -1;
    private List<Integer> childs;
    private int childGrivate;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getBookMarkMode() {
        return bookMarkMode;
    }

    public void setBookMarkMode(int bookMarkMode) {
        this.bookMarkMode = bookMarkMode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getImageHeadUrl() {
        return imageHeadUrl;
    }

    public void setImageHeadUrl(String imageHeadUrl) {
        this.imageHeadUrl = imageHeadUrl;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
//        if (null != this.ids) {
//            this.ids.clear();
//        }
        if (null != this.images) {
            this.images.clear();
        }
        if (null != this.datas) {
            this.datas.clear();
        }
        if (null != ids) {
            idOrImgMode = ViewPagerEnum.ids.getCode();
            totalSize = ids.size();
        }
        this.ids = ids;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        if (null != this.ids) {
            this.ids.clear();
        }
//        if (null != this.images) {
//            this.images.clear();
//        }
        if (null != this.datas) {
            this.datas.clear();
        }
        if (null != images) {
            idOrImgMode = ViewPagerEnum.images.getCode();
            totalSize = images.size();
        }
        this.images = images;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    public int getIdOrImgMode() {
        return idOrImgMode;
    }

    public int getDefaultImage() {
        return defaultImage;
    }

    public AppCompatImageView.ScaleType getScaleType() {
        return scaleType;
    }

    public void setScaleType(AppCompatImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public int getGrivate() {
        return grivate;
    }

    public void setGrivate(int grivate) {
        this.grivate = grivate;
    }

    public int getPaddLeft() {
        return paddLeft;
    }

    public void setPaddLeft(int paddLeft) {
        this.paddLeft = paddLeft;
    }

    public int getPaddTop() {
        return paddTop;
    }

    public void setPaddTop(int paddTop) {
        this.paddTop = paddTop;
    }

    public int getPaddRight() {
        return paddRight;
    }

    public void setPaddRight(int paddRight) {
        this.paddRight = paddRight;
    }

    public int getPaddBottom() {
        return paddBottom;
    }

    public void setPaddBottom(int paddBottom) {
        this.paddBottom = paddBottom;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalSize() {
        return totalSize == 0 ? 1 : totalSize;
    }

    public void setDefaultImage(int defaultImage) {
        this.defaultImage = defaultImage;
    }

    public int getDefaultTextBg() {
        return defaultTextBg;
    }

    public void setDefaultTextBg(int defaultTextBg) {
        this.defaultTextBg = defaultTextBg;
    }

    public String getDefaultTextIndex() {
        return defaultTextIndex;
    }

    public void setDefaultTextIndex(Object defaultTextIndex) {
        this.defaultTextIndex = String.format("%s", defaultTextIndex);
        if (!TextUtils.isEmpty(this.defaultTextIndex)) {
            mode = ViewPagerEnum.selectBanner.getCode();
        }
    }

    public int getDefaultTextColor() {
        return defaultTextColor;
    }

    public void setDefaultTextColor(int defaultTextColor) {
        this.defaultTextColor = defaultTextColor;
    }

    public int getDefaultTextSize() {
        return defaultTextSize;
    }

    public void setDefaultTextSize(int defaultTextSize) {
        this.defaultTextSize = defaultTextSize;
    }

    public int getStartBg() {
        return startBg;
    }

    public void setStartBg(int startBg) {
        this.startBg = startBg;
    }

    public String getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(Object startBtn) {
        this.startBtn = String.format("%s", startBtn);
    }

    public int getStartBtnSize() {
        return startBtnSize;
    }

    public void setStartBtnSize(int startBtnSize) {
        this.startBtnSize = startBtnSize;
    }

    public int getStartBtnColor() {
        return startBtnColor;
    }

    public void setStartBtnColor(int startBtnColor) {
        this.startBtnColor = startBtnColor;
    }

    public int getStartBtnMgBottom() {
        return startBtnMgBottom;
    }

    public void setStartBtnMgBottom(int startBtnMgBottom) {
        this.startBtnMgBottom = startBtnMgBottom;
    }

    public int getStartBtnPaddLeft() {
        return startBtnPaddLeft;
    }

    public void setStartBtnPaddLeft(int startBtnPaddLeft) {
        this.startBtnPaddLeft = startBtnPaddLeft;
    }

    public int getStartBtnPaddTop() {
        return startBtnPaddTop;
    }

    public void setStartBtnPaddTop(int startBtnPaddTop) {
        this.startBtnPaddTop = startBtnPaddTop;
    }

    public int getStartBtnPaddRight() {
        return startBtnPaddRight;
    }

    public void setStartBtnPaddRight(int startBtnPaddRight) {
        this.startBtnPaddRight = startBtnPaddRight;
    }

    public int getStartBtnPaddBottom() {
        return startBtnPaddBottom;
    }

    public void setStartBtnPaddBottom(int startBtnPaddBottom) {
        this.startBtnPaddBottom = startBtnPaddBottom;
    }

    public void setStartBtn(String startBtn) {
        this.startBtn = startBtn;
    }

    public IVpClick getiVpClick() {
        return iVpClick;
    }

    public void setiVpClick(IVpClick iVpClick) {
        this.iVpClick = iVpClick;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child, int childGrivate) {
        this.child = child;
        this.childGrivate = childGrivate;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public void setChildGrivate(int childGrivate) {
        this.childGrivate = childGrivate;
    }

    public int getChildGrivate() {
        return childGrivate;
    }

    public List<Integer> getChilds() {
        return childs;
    }

    public void setChilds(List<Integer> childs) {
        this.childs = childs;
    }
}
