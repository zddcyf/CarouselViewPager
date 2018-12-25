package com.vp.carousel.viewpager.adaper;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.vp.carousel.viewpager.bean.CustomPagerBean;
import com.vp.carousel.viewpager.config.ViewPagerEnum;

import java.util.List;

/**
 * Created by zdd
 * on 2018/11/29
 * at 16:17
 * summary:
 */
public abstract class BaseAdapter extends PagerAdapter {
    private boolean defaultItem;
    protected CustomPagerBean bean;
    private int idOrImgMode;
    private int mode;

    private int mChildCount = 0;

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (mChildCount > 0) {
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        if (null == bean) {
            return 1;
        }
        if (idOrImgMode == ViewPagerEnum.ids.getCode()) {
            return getCount(bean.getIds());
        } else if (idOrImgMode == ViewPagerEnum.images.getCode()) {
            return getCount(bean.getImages());
        } else if (idOrImgMode == ViewPagerEnum.datas.getCode()) {
            return getCount(bean.getDatas());
        } else {
            return 1;
        }
    }

    public <T> int getCount(List<T> datas) {
        if (null == datas) {
            defaultItem = true;
            return 1;
        }
        if (datas.size() == 0) {
            defaultItem = true;
            return 1;
        }
        if (mode == ViewPagerEnum.wireBanner.getCode()) {
            defaultItem = false;
            return datas.size() * 10;
        } else {
            defaultItem = false;
            return datas.size();
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        if (!defaultItem && idOrImgMode == ViewPagerEnum.ids.getCode()) {
            return instantIds(container, position);
        } else if (!defaultItem && idOrImgMode == ViewPagerEnum.images.getCode()) {
            return instantImages(container, position);
        } else if (!defaultItem && idOrImgMode == ViewPagerEnum.datas.getCode()) {
            return instantDatas(container, position);
        } else {
            return instantDefault(container, position);
        }
    }

    public abstract Object instantIds(ViewGroup container, int position);

    public abstract Object instantImages(ViewGroup container, int position);

    public abstract Object instantDatas(ViewGroup container, int position);

    public abstract Object instantDefault(ViewGroup container, int position);

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setDatas(CustomPagerBean bean) {
        this.bean = bean;
        idOrImgMode = bean.getIdOrImgMode();
        mode = bean.getMode();
        notifyDataSetChanged();
    }
}
