package com.vp.carousel.viewpager.click;

import android.view.View;

/**
 * Created by zdd
 * on 2018/11/30
 * at 17:22
 * summary:
 */
public interface IVpItemClick extends IVpClick {
    void itemClick(View v, int position);
}
