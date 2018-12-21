package com.vp.carousel.click;

import android.view.View;

/**
 * Created by zdd
 * on 2018/11/30
 * at 17:31
 * summary:
 */
public interface IVpAllClick extends IVpClick {
    void itemClick(View v, int position);
    void startClick(View v);
}
