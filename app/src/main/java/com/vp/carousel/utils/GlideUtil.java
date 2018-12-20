package com.vp.carousel.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by 盈东科技
 * on 2018/11/14
 * at 上午10:34
 * summary:
 */

public class GlideUtil {

    private static int placeholderImg = 0;
    private static int errorImg = 0;

    private static volatile RequestOptions options;

    private static RequestOptions getOptions() {
        if (options == null) {
            synchronized (GlideUtil.class) {
                if (options == null) {
                    options = new RequestOptions().placeholder(placeholderImg).error(errorImg)
                            .diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate();
                }
            }
        }
        return options;
    }

    public static void load(Context context, String url, ImageView imageView, int placeholderImg, int errorImg) {
        Glide.with(context).load(url).apply(new RequestOptions()
                .placeholder(placeholderImg)
                .error(errorImg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate())
                .into(imageView);
    }

    public static void load(Context context, String url, ImageView imageView, int placeholderImg) {
        Glide.with(context).load(url).apply(new RequestOptions()
                .placeholder(placeholderImg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate())
                .into(imageView);
    }

    public static void load(Context context, int url, ImageView imageView) {
        Glide.with(context).load(url).apply(new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate())
                .into(imageView);
    }

    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).apply(getOptions()).into(imageView);
    }
}
