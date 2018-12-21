package com.vp.carousel.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;

import com.vp.carousel.bean.CustomPagerBean;
import com.vp.carousel.config.ViewPagerEnum;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/**
 * Created by zdd
 * on 2018/11/29
 * at 14:29
 * summary:
 */
public class CustomViewPager extends ViewPager {
    // 是否自动滑动
    private boolean isAutoScroll = false;
    // 定义handler
    private Handler handler;
    // 初始位置左边和右边
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private int direction = RIGHT;

    // 是否循环
    private boolean isCycle = true;

    private boolean isBorderAnimation = true;


    private boolean stopScrollWhenTouch = true;

    private boolean isStopByTouch = false;

    public static final int SLIDE_BORDER_MODE_NONE = 0;
    private int slideBorderMode = SLIDE_BORDER_MODE_NONE;

    public static final int SLIDE_BORDER_MODE_TO_PARENT = 2;
    public static final int SLIDE_BORDER_MODE_CYCLE = 1;

    private float touchX = 0f, downX = 0f;
    /**
     * 自动滑动
     */
    private double autoScrollFactor = 1.0;
    /**
     * 手动滑动
     */
    private double swipeScrollFactor = 1.0;
    private CustomDurationScroller scroller = null;

    public static final int SCROLL_WHAT = 0;
    private CustomPagerBean bean;
    private boolean stopHandler = false;

    CustomViewPager(@NonNull Context context) {
        this(context, null);
    }

    private CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMode(CustomPagerBean bean) {
        this.bean = bean;
        setAdapter();
    }

    /**
     * 需要无限轮播的时候调用
     */
    public void setAdapter() {
        if (bean.getMode() == ViewPagerEnum.wireBanner.getCode()) {
            handler = new MyHandler(this);
            setViewPagerScroller();
            setCurrentItem(getAdapter().getCount() / 2 - (getAdapter().getCount() / 2 % bean.getTotalSize()));
            startAutoScroll();
        } else if (bean.getMode() == ViewPagerEnum.startBanner.getCode() || bean.getMode() == ViewPagerEnum.noBanner.getCode()) {
            setCurrentItem(0);
        } else if (bean.getMode() == ViewPagerEnum.firstBanner.getCode()) {
            handler = new MyHandler(this);
            setViewPagerScroller();
            setCurrentItem(0);
            if (getAdapter().getCount() > 1) {
                startAutoScroll();
            }
        } else if (bean.getMode() == ViewPagerEnum.selectBanner.getCode()) {
            setCurrentItem(TextUtils.isEmpty(bean.getDefaultTextIndex()) ? 0 : Integer.parseInt(bean.getDefaultTextIndex()));
        }
    }

    private static class MyHandler extends Handler {

        private final WeakReference<CustomViewPager> autoScrollViewPager;

        public MyHandler(CustomViewPager autoScrollViewPager) {
            this.autoScrollViewPager = new WeakReference<>(autoScrollViewPager);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case SCROLL_WHAT:
                    CustomViewPager pager = this.autoScrollViewPager.get();
                    if (pager != null) {
                        pager.scroller.setScrollDurationFactor(pager.autoScrollFactor);
                        pager.scrollOnce();
                        pager.scroller.setScrollDurationFactor(pager.swipeScrollFactor);
                        pager.sendScrollMessage(pager.bean.getInterval() + pager.scroller.getDuration());
                    }
                default:
                    break;
            }
        }
    }

    /**
     * 结束滑动
     */
    public void stopAutoScroll() {
        isAutoScroll = false;
        handler.removeMessages(SCROLL_WHAT);
    }

    /**
     * 是否停止handler
     */
    public void stopHandler(boolean stopHandler) {
        isAutoScroll = false;
        this.stopHandler = stopHandler;
    }

    /**
     * 开始滑动
     */
    public void startAutoScroll() {
        isAutoScroll = true;
        sendScrollMessage((long) (bean.getInterval() + scroller.getDuration() / autoScrollFactor * swipeScrollFactor));
    }

    private void sendScrollMessage(long delayTimeInMills) {
        handler.removeMessages(SCROLL_WHAT);
        if (!stopHandler) {
            handler.sendEmptyMessageDelayed(SCROLL_WHAT, delayTimeInMills);
        }
    }

    /**
     * scroll only once
     */
    public void scrollOnce() {
        PagerAdapter adapter = getAdapter();
        int currentItem = getCurrentItem();
        int totalCount;
        if (adapter == null || (totalCount = adapter.getCount()) <= 1) {
            return;
        }

        // 如何右边的标志位等于右边的标志位的时候就让标志位减去一，反之加一
        int nextItem = (direction == LEFT) ? --currentItem : ++currentItem;
        // 如果现在的位置小与0
        if (nextItem < 0) {
            // 如果无限循环的话则从结束位开始
            if (bean.getMode() == ViewPagerEnum.wireBanner.getCode()) {
                if (isCycle) {
                    setCurrentItem(totalCount - 1, isBorderAnimation);
                }
            }
            // 如果现在的位置等于总长度的时候
        } else if (nextItem == totalCount) {
            if (bean.getMode() == ViewPagerEnum.wireBanner.getCode()) {
                // 如果无限循环的话则从初始位开始
                if (isCycle) {
                    setCurrentItem(0, isBorderAnimation);
                }
            }
        } else {
            // 如果现在的位置大于0， 则正常显示
            setCurrentItem(nextItem, true);
        }
    }

    private void setViewPagerScroller() {
        try {
            // 获取到滚动对象
            Field scrollerField = ViewPager.class.getDeclaredField("mScroller");
            scrollerField.setAccessible(true);
            // 货到插入者对象
            Field interpolatorField = ViewPager.class.getDeclaredField("sInterpolator");
            interpolatorField.setAccessible(true);

            scroller = new CustomDurationScroller(getContext(), (Interpolator) interpolatorField.get(null));
            scrollerField.set(this, scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);

        if (stopScrollWhenTouch) {
            if ((action == MotionEvent.ACTION_DOWN) && isAutoScroll) {
                isStopByTouch = true;
                stopAutoScroll();
            } else if (ev.getAction() == MotionEvent.ACTION_UP && isStopByTouch) {
                startAutoScroll();
            }
        }

        if (slideBorderMode == SLIDE_BORDER_MODE_TO_PARENT || slideBorderMode == SLIDE_BORDER_MODE_CYCLE) {
            touchX = ev.getX();
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                downX = touchX;
            }
            if (ev.getAction() == MotionEvent.ACTION_MOVE) {
                int currentItem = getCurrentItem();
                PagerAdapter adapter = getAdapter();
                int pageCount = adapter == null ? 0 : adapter.getCount();
                if ((currentItem == 0 && downX <= touchX) || (currentItem == pageCount - 1 && downX >= touchX)) {
                    if (slideBorderMode == SLIDE_BORDER_MODE_TO_PARENT) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        if (pageCount > 1) {
                            setCurrentItem(pageCount - currentItem - 1, isBorderAnimation);
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return super.dispatchTouchEvent(ev);
                }
            }
        }

        return super.dispatchTouchEvent(ev);
    }
}
