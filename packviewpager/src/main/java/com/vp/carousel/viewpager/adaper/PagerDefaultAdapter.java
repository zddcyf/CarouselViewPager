package com.vp.carousel.viewpager.adaper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vp.carousel.viewpager.bean.ConfigBean;
import com.vp.carousel.viewpager.click.IVpAllClick;
import com.vp.carousel.viewpager.click.IVpItemClick;
import com.vp.carousel.viewpager.utils.GlideUtil;

/**
 * Created by zdd
 * on 2018/11/29
 * at 16:32
 * summary:
 */
public class PagerDefaultAdapter extends BaseAdapter {

    /**
     * 传入的是一堆id的时候调用
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantIds(ViewGroup container, int position) {
        Context context = container.getContext();
        PagerHolder holder = null;
        if (null == holder) {
            holder = new PagerHolder();
            holder.imageView = new AppCompatImageView(context);
            holder.imageView.setTag(holder);
        } else {
            holder = (PagerHolder) holder.imageView.getTag();
        }
        if (null != bean) {
            int integer = (int) bean.getIds().get(position % bean.getIds().size());
            setImageBg(context, holder.imageView, integer);
            setImageAttr(holder.imageView);
            setClick(holder.imageView, position);
        }
        container.addView(holder.imageView);
        return holder.imageView;
    }

    /**
     * 传入的是网络路径的时候调用
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantImages(ViewGroup container, int position) {
        Context context = container.getContext();
        AppCompatImageView imageView = new AppCompatImageView(context);
        String url = (String) bean.getImages().get(position % bean.getImages().size());
        GlideUtil.load(context, bean.getImageHeadUrl() + url, imageView, bean.getDefaultImage());
        setImageAttr(imageView);
        setClick(imageView, position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public Object instantDatas(ViewGroup container, int position) {
        Context context = container.getContext();
        AppCompatImageView imageView = new AppCompatImageView(context);
        Object data = bean.getDatas().get(position % bean.getDatas().size());
        if (data instanceof ConfigBean) {
            Object pictures = ((ConfigBean) data).getPictures();
            if (pictures instanceof String && null != pictures && !"".equals(pictures)) {
                GlideUtil.load(context, bean.getImageHeadUrl() + pictures, imageView, bean.getDefaultImage());
            } else if (pictures instanceof Integer) {
                setImageBg(context, imageView, (Integer) pictures);
            } else {
                setImageBg(context, imageView, -1);
            }
        }
        imageView.setTag(data);
        setImageAttr(imageView);
        setClick(imageView, position);
        container.addView(imageView);
        return imageView;
    }

    /**
     * 传入的是默认图的时候调用
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantDefault(ViewGroup container, int position) {
        Context context = container.getContext();
        AppCompatImageView imageView = new AppCompatImageView(context);
        setImageAttr(imageView);
        setImageBg(context, imageView, bean.getDefaultImage());
        setClick(imageView, position);
        container.addView(imageView);
        return imageView;
    }

    private void setClick(AppCompatImageView imageView, final int position) {
        if (null != bean.getiVpClick()) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bean.getiVpClick() instanceof IVpItemClick) {
                        ((IVpItemClick) bean.getiVpClick()).itemClick(v, position);
                    } else if (bean.getiVpClick() instanceof IVpAllClick) {
                        ((IVpAllClick) bean.getiVpClick()).itemClick(v, position);
                    }
                }
            });
        }
    }

    private void setImageAttr(AppCompatImageView imageView) {
        ImageView.ScaleType scaleType = bean.getScaleType();
        if (null != scaleType) {
            imageView.setScaleType(scaleType);
        }
    }

    private void setImageBg(Context context, AppCompatImageView imageView, int backgroundBg) {
        if (backgroundBg != -1) {
            String resourceTypeName = context.getResources().getResourceTypeName(backgroundBg);
            if (resourceTypeName.contains("drawable")) {
                imageView.setBackground(context.getResources().getDrawable(backgroundBg));
            } else if (resourceTypeName.contains("color")) {
                imageView.setBackgroundColor(context.getResources().getColor(backgroundBg));
            }
        } else {
            if (bean.getDefaultImage() != -1) {
                imageView.setBackgroundResource(bean.getDefaultImage());
            } else {
                imageView.setBackgroundColor(Color.parseColor("000000"));
            }
        }
    }

    public class PagerHolder {
        private AppCompatImageView imageView;
    }
}
