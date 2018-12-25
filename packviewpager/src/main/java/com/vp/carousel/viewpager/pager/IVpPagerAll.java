package com.vp.carousel.viewpager.pager;

/**
 * Created by zdd
 * on 2018/12/25
 * at 16:55
 * summary:
 */
public interface IVpPagerAll extends IVpPager {
    void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
    void onPageSelected(int position);
    void onPageScrollStateChanged(int position);
}
