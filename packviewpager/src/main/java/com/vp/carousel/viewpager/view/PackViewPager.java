package com.vp.carousel.viewpager.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

import com.vp.carousel.viewpager.R;
import com.vp.carousel.viewpager.adaper.PagerDefaultAdapter;
import com.vp.carousel.viewpager.bean.CustomPagerBean;
import com.vp.carousel.viewpager.click.IVpAllClick;
import com.vp.carousel.viewpager.click.IVpStartClick;
import com.vp.carousel.viewpager.config.ViewPagerEnum;

/**
 * Created by zdd
 * on 2018/11/29
 * at 15:03
 * summary:
 */
public class PackViewPager extends RelativeLayout implements ViewPager.OnPageChangeListener {

    private Context mContext;
    private CustomViewPager viewPager;
    private TextIndicator textIndicator;
    private PagerDefaultAdapter mAdapter;
    private CustomPagerBean bean;
    private AppCompatTextView startBtn;
    private View childAt;

    public PackViewPager(Context context) {
        this(context, null);
    }

    public PackViewPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PackViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public void init() {
        viewPager = new CustomViewPager(mContext);
        viewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        mAdapter = new PagerDefaultAdapter();
        viewPager.setAdapter(mAdapter);
        addView(viewPager);
        viewPager.addOnPageChangeListener(this);
    }

    public void setDatas(CustomPagerBean bean) {
        this.bean = bean;
        setIndicator();
        mAdapter.setDatas(bean);
        viewPager.setMode(bean);
    }

    private void setIndicator() {
        if (bean.getBookMarkMode() == ViewPagerEnum.point.getCode()) {
            setPointIndicator();
        } else if (bean.getBookMarkMode() == ViewPagerEnum.number.getCode()) {
            setNumberIndicator();
        }
        if (bean.getMode() == ViewPagerEnum.startBanner.getCode()
                && (bean.getStartBg() != -1 || !TextUtils.isEmpty(bean.getStartBtn()))) {
            setStartBtn();
        }
    }

    /**
     * 创建点的指示器
     */
    private void setPointIndicator() {

    }

    /**
     * 创建数字的指示器
     */
    private void setNumberIndicator() {
        textIndicator = new TextIndicator(bean, mContext);
        textIndicator.setId(R.id.textIndicator);
        addView(textIndicator);
        textIndicator.setPadding(px(bean.getPaddLeft()), px(bean.getPaddTop()), px(bean.getPaddRight()), px(bean.getPaddBottom()));
        RelativeLayout.LayoutParams layoutParams = (LayoutParams) textIndicator.getLayoutParams();
        layoutParams.setMargins(px(bean.getMarginLeft()), px(bean.getMarginTop()), px(bean.getMarginRight()), px(bean.getMarginBottom()));
        setNumberIndicatorGrivate(layoutParams);
        textIndicator.setLayoutParams(layoutParams);
        if (bean.getChild() != -1) {
            childAt = findViewById(bean.getChild());
            RelativeLayout.LayoutParams layoutParams1 = (LayoutParams) childAt.getLayoutParams();
            if (bean.getChildGrivate() == ViewPagerEnum.childLeft.getCode()) {
                layoutParams1.addRule(RelativeLayout.LEFT_OF, R.id.textIndicator);
                layoutParams1.addRule(RelativeLayout.ALIGN_TOP, R.id.textIndicator);
            } else if (bean.getChildGrivate() == ViewPagerEnum.childRight.getCode()) {
                layoutParams1.addRule(RelativeLayout.RIGHT_OF, R.id.textIndicator);
                layoutParams1.addRule(RelativeLayout.ALIGN_TOP, R.id.textIndicator);
            } else {
                layoutParams1.addRule(RelativeLayout.LEFT_OF, R.id.textIndicator);
                layoutParams1.addRule(RelativeLayout.ALIGN_TOP, R.id.textIndicator);
            }
            childAt.setLayoutParams(layoutParams1);
        }
    }

    private void setNumberIndicatorGrivate(LayoutParams layoutParams) {
        if (bean.getGrivate() == ViewPagerEnum.bottomOrLeft.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        } else if (bean.getGrivate() == ViewPagerEnum.bottomOrCenter.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        } else if (bean.getGrivate() == ViewPagerEnum.bottomOrRight.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        } else if (bean.getGrivate() == ViewPagerEnum.topOrLeft.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        } else if (bean.getGrivate() == ViewPagerEnum.topOrCenter.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        } else if (bean.getGrivate() == ViewPagerEnum.topOrRight.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        }
    }

    private void setStartBtn() {
        startBtn = new AppCompatTextView(mContext);
        addView(startBtn);
        startBtn.setVisibility(GONE);
        startBtn.setPadding(px(bean.getStartBtnPaddLeft()), px(bean.getStartBtnPaddTop()), px(bean.getStartBtnPaddRight()), px(bean.getStartBtnPaddBottom()));
        RelativeLayout.LayoutParams layoutParams = (LayoutParams) startBtn.getLayoutParams();
        layoutParams.bottomMargin = px(bean.getStartBtnMgBottom());
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        startBtn.setLayoutParams(layoutParams);
        startBtn.setText(bean.getStartBtn());
        startBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, bean.getStartBtnSize() == -1 ? 12 : bean.getStartBtnSize());
        startBtn.setTextColor(mContext.getResources().getColor(bean.getStartBtnColor() == -1 ? android.R.color.black : bean.getStartBtnColor()));
        if (bean.getStartBg() != -1) {
            String resourceTypeName = mContext.getResources().getResourceTypeName(bean.getStartBg());
            if (resourceTypeName.contains("drawable")) {
                setBackground(mContext.getResources().getDrawable(bean.getStartBg()));
            } else if (resourceTypeName.contains("color")) {
                setBackgroundColor(mContext.getResources().getColor(bean.getStartBg()));
            }
        } else {
            setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
        }
        if (null != bean.getiVpClick()) {
            startBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bean.getiVpClick() instanceof IVpStartClick) {
                        ((IVpStartClick) bean.getiVpClick()).startClick(v);
                    } else if (bean.getiVpClick() instanceof IVpAllClick) {
                        ((IVpAllClick) bean.getiVpClick()).startClick(v);
                    }
                }
            });
        }
    }

    public static int px(float dipValue) {
        Resources r = Resources.getSystem();
        final float scale = r.getDisplayMetrics().scaledDensity;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (null != textIndicator) {
            textIndicator.setText((position % bean.getTotalSize() + 1) + "/" + bean.getTotalSize());
        }
        if (bean.getMode() == ViewPagerEnum.firstBanner.getCode() && (position % bean.getTotalSize() + 1) == bean.getTotalSize()) {
            viewPager.stopHandler(true);
        }
        if (bean.getMode() == ViewPagerEnum.startBanner.getCode()
                && (bean.getStartBg() != -1 || !TextUtils.isEmpty(bean.getStartBtn()))
                && (position % bean.getTotalSize() + 1) == bean.getTotalSize()) {
            if (null != textIndicator)
                textIndicator.setVisibility(GONE);
            startBtn.setVisibility(VISIBLE);
        } else {
            if (null != textIndicator)
                textIndicator.setVisibility(VISIBLE);
            if (null != startBtn)
                startBtn.setVisibility(GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void update(CustomPagerBean bean) {
        if (null != textIndicator) {
            textIndicator.setText(String.format("%s/%s", TextUtils.isEmpty(bean.getDefaultTextIndex()) ? 1 : bean.getDefaultTextIndex(), bean.getTotalSize()));
        }
        mAdapter.setDatas(bean);
    }
}
