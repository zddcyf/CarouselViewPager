package com.vp.carousel.viewpager.build;

import android.support.v7.widget.AppCompatImageView;

import com.vp.carousel.viewpager.bean.CustomPagerBean;
import com.vp.carousel.viewpager.click.IVpClick;
import com.vp.carousel.viewpager.view.PackViewPager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zdd
 * on 2018/11/29
 * at 14:30
 * summary:
 */
public class PackViewBuild {
    private CustomPagerBean cpBean = new CustomPagerBean();
    private PackViewPager view;

    public PackViewBuild setInterval(int interval) {
        cpBean.setInterval(interval);
        return this;
    }

    /**
     * 页签显示的模样 显示点、数字等等
     *
     * @param bookMarkMode
     * @return
     */
    public PackViewBuild setBookMarkMode(int bookMarkMode) {
        cpBean.setBookMarkMode(bookMarkMode);
        return this;
    }

    /**
     * 显示模式  无线轮播、不轮播、轮播一次等等
     *
     * @param mode
     * @return
     */
    public PackViewBuild setMode(int mode) {
        cpBean.setMode(mode);
        return this;
    }

    /**
     * 如果是网络图片的话，是否需要传递网址头（此一般为公共的网络路径）
     *
     * @param imageHeadUrl
     * @return
     */
    public PackViewBuild setImageHeadUrl(String imageHeadUrl) {
        cpBean.setImageHeadUrl(imageHeadUrl);
        return this;
    }

    /**
     * 传递的是本地的id串
     *
     * @param ids
     * @return
     */
    public PackViewBuild setIds(Integer... ids) {
        cpBean.setIds(Arrays.asList(ids));
        return this;
    }

    /**
     * 传递的是本地的id串
     *
     * @param ids
     * @return
     */
    public PackViewBuild setIds(List<Integer> ids) {
        cpBean.setIds(ids);
        return this;
    }

    /**
     * 传递的是一串网址
     *
     * @param images
     * @return
     */
    public PackViewBuild setImages(String... images) {
        cpBean.setImages(Arrays.asList(images));
        return this;
    }

    /**
     * 传递的是一串网址
     *
     * @param images
     * @return
     */
    public PackViewBuild setImages(List<String> images) {
        cpBean.setImages(images);
        return this;
    }

    /**
     * 如果是把数据源扔进来需要把具体获取图片路径的方法名传递进来(不推荐使用，因为涉及到反射。影响性能)
     *
     * @param imageName
     * @return
     */
    public PackViewBuild setImageName(String imageName) {
        cpBean.setImageName(imageName);
        return this;
    }

    /**
     * 可以扔一个数据源进来
     *
     * @param datas
     * @return
     */
    public PackViewBuild setDatas(List<Object> datas) {
        cpBean.setDatas(datas);
        return this;
    }

    public PackViewBuild setDefaultImage(int defaultImage) {
        cpBean.setDefaultImage(defaultImage);
        return this;
    }

    public PackViewBuild setGrivate(int grivate) {
        cpBean.setGrivate(grivate);
        return this;
    }

    public PackViewBuild setPaddLeft(int paddLeft) {
        cpBean.setPaddLeft(paddLeft);
        return this;
    }

    public PackViewBuild setPaddTop(int paddTop) {
        cpBean.setPaddTop(paddTop);
        return this;
    }

    public PackViewBuild setPaddRight(int paddRight) {
        cpBean.setPaddRight(paddRight);
        return this;
    }

    public PackViewBuild setPaddBottom(int paddBottom) {
        cpBean.setPaddBottom(paddBottom);
        return this;
    }

    public PackViewBuild setPadd(int paddLeft, int paddTop, int paddRight, int paddBottom) {
        cpBean.setPaddLeft(paddLeft);
        cpBean.setPaddTop(paddTop);
        cpBean.setPaddRight(paddRight);
        cpBean.setPaddBottom(paddBottom);
        return this;
    }

    public PackViewBuild setMarginLeft(int marginLeft) {
        cpBean.setMarginLeft(marginLeft);
        return this;
    }

    public PackViewBuild setMarginTop(int marginTop) {
        cpBean.setMarginTop(marginTop);
        return this;
    }

    public PackViewBuild setMarginRight(int marginRight) {
        cpBean.setMarginRight(marginRight);
        return this;
    }

    public PackViewBuild setMarginBottom(int marginBottom) {
        cpBean.setMarginBottom(marginBottom);
        return this;
    }

    public PackViewBuild setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        cpBean.setMarginLeft(marginLeft);
        cpBean.setMarginTop(marginTop);
        cpBean.setMarginRight(marginRight);
        cpBean.setMarginBottom(marginBottom);
        return this;
    }

    public PackViewBuild setDefaultTextBg(int defaultTextBg) {
        cpBean.setDefaultTextBg(defaultTextBg);
        return this;
    }

    public PackViewBuild setDefaultTextIndex(Object defaultTextIndex) {
        cpBean.setDefaultTextIndex(defaultTextIndex);
        return this;
    }

    public PackViewBuild setDefaultTextColor(int defaultTextColor) {
        cpBean.setDefaultTextColor(defaultTextColor);
        return this;
    }

    public PackViewBuild setDefaultTextSize(int defaultTextSize) {
        cpBean.setDefaultTextSize(defaultTextSize);
        return this;
    }

    public PackViewBuild setDefaultText(int defaultTextColor, int defaultTextSize) {
        cpBean.setDefaultTextColor(defaultTextColor);
        cpBean.setDefaultTextSize(defaultTextSize);
        return this;
    }

    public PackViewBuild setDefaultText(int defaultTextColor, int defaultTextSize, int defaultTextBg) {
        cpBean.setDefaultTextColor(defaultTextColor);
        cpBean.setDefaultTextSize(defaultTextSize);
        cpBean.setDefaultTextBg(defaultTextBg);
        return this;
    }

    public PackViewBuild setDefaultText(Object defaultTextIndex, int defaultTextColor, int defaultTextSize) {
        cpBean.setDefaultTextIndex(defaultTextIndex);
        cpBean.setDefaultTextColor(defaultTextColor);
        cpBean.setDefaultTextSize(defaultTextSize);
        return this;
    }

    public PackViewBuild setDefaultText(Object defaultTextIndex, int defaultTextColor, int defaultTextSize, int defaultTextBg) {
        cpBean.setDefaultTextIndex(defaultTextIndex);
        cpBean.setDefaultTextColor(defaultTextColor);
        cpBean.setDefaultTextSize(defaultTextSize);
        cpBean.setDefaultTextBg(defaultTextBg);
        return this;
    }

    public PackViewBuild setScaleType(AppCompatImageView.ScaleType scaleType) {
        cpBean.setScaleType(scaleType);
        return this;
    }

    public PackViewBuild setStartBg(int startBg) {
        cpBean.setStartBg(startBg);
        return this;
    }

    public PackViewBuild setStartBtn(Object startBtn) {
        cpBean.setStartBtn(startBtn);
        return this;
    }

    public PackViewBuild setStartBtnSize(int startBtnSize) {
        cpBean.setStartBtnSize(startBtnSize);
        return this;
    }

    public PackViewBuild setStartBtnColor(int startBtnColor) {
        cpBean.setStartBtnColor(startBtnColor);
        return this;
    }

    public PackViewBuild setStartBtn(Object startBtn, int startBtnSize, int startBtnColor) {
        cpBean.setStartBtn(startBtn);
        cpBean.setStartBtnSize(startBtnSize);
        cpBean.setStartBtnColor(startBtnColor);
        return this;
    }

    public PackViewBuild setStartBtn(Object startBtn, int startBtnSize, int startBtnColor, int startBg) {
        cpBean.setStartBtn(startBtn);
        cpBean.setStartBtnSize(startBtnSize);
        cpBean.setStartBtnColor(startBtnColor);
        cpBean.setStartBg(startBg);
        return this;
    }

    public PackViewBuild setStartBtnMgBottom(int startBtnMgBottom) {
        cpBean.setStartBtnMgBottom(startBtnMgBottom);
        return this;
    }

    public PackViewBuild setStartBtnPaddLeft(int startBtnPaddLeft) {
        cpBean.setStartBtnPaddLeft(startBtnPaddLeft);
        return this;
    }

    public PackViewBuild setStartBtnPaddTop(int startBtnPaddTop) {
        cpBean.setStartBtnPaddTop(startBtnPaddTop);
        return this;
    }

    public PackViewBuild setStartBtnPaddRight(int startBtnPaddRight) {
        cpBean.setStartBtnPaddRight(startBtnPaddRight);
        return this;
    }

    public PackViewBuild setStartBtnPadd(int startBtnPaddLeft, int startBtnPaddTop, int startBtnPaddRight, int startBtnMgBottom) {
        cpBean.setStartBtnPaddLeft(startBtnPaddLeft);
        cpBean.setStartBtnPaddTop(startBtnPaddTop);
        cpBean.setStartBtnPaddRight(startBtnPaddRight);
        cpBean.setStartBtnMgBottom(startBtnMgBottom);
        return this;
    }

    public PackViewBuild setStartBtnPaddBottom(int startBtnPaddBottom) {
        cpBean.setStartBtnPaddBottom(startBtnPaddBottom);
        return this;
    }

    public PackViewBuild setiVpClick(IVpClick iVpClick) {
        cpBean.setiVpClick(iVpClick);
        return this;
    }

    public PackViewBuild setChild(int child) {
        cpBean.setChild(child);
        return this;
    }

    public PackViewBuild setChild(int child, int grivate) {
        cpBean.setChild(child, grivate);
        return this;
    }

    public PackViewBuild setChildGrivate(int child) {
        cpBean.setChildGrivate(child);
        return this;
    }

    public PackViewBuild setChilds(List<Integer> childs) {
        cpBean.setChilds(childs);
        return this;
    }

    public void create(PackViewPager view) {
        this.view = view;
        view.setDatas(cpBean);
    }

    public void update() {
        view.update(cpBean);
    }
}
