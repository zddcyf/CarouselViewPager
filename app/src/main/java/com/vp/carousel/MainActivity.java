package com.vp.carousel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vp.carousel.bean.Banners;
import com.vp.carousel.viewpager.build.PackViewBuild;
import com.vp.carousel.viewpager.click.IVpItemClick;
import com.vp.carousel.viewpager.config.ViewPagerEnum;
import com.vp.carousel.viewpager.pager.IVpPagerSelect;
import com.vp.carousel.viewpager.view.PackViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private PackViewPager packViewPager;
    PackViewBuild packViewBuild;
    private AppCompatTextView update;
    List<Banners> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packViewPager = findViewById(R.id.packViewPager);
        update = findViewById(R.id.update);
        setDatas();

        packViewBuild = new PackViewBuild<Banners>().setDefaultImage(R.mipmap.ic_launcher)
                .setMode(ViewPagerEnum.noBanner.getCode())
                .setScaleType(ImageView.ScaleType.FIT_XY)
                .setPadd(5, 1, 5, 1)
                .setMargin(10, 10, 10, 10)
                .setGrivate(ViewPagerEnum.bottomOrRight.getCode())
                .setBookMarkMode(ViewPagerEnum.number.getCode())
                .setDatas(list)
//                .addOnPageChangeListener(new IVpPagerSelect() {
//                    @Override
//                    public void onPageSelected(int position) {
//                        Toast.makeText(MainActivity.this, position + "个", Toast.LENGTH_LONG).show();
//                    }
//                })
                .setiVpClick(new IVpItemClick() {
                    @Override
                    public void itemClick(View v, int position) {
                        Banners banners = (Banners) v.getTag();

                    }
                });
        packViewBuild.create(packViewPager);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        packViewBuild.setDefaultTextIndex(1).update();
    }

    public void setDatas() {
        list.add(new Banners("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=a4b3d7085dee3d6d2293d48b252b5910/0e2442a7d933c89524cd5cd4d51373f0830200ea.jpg?qq-pf-to=pcqq.c2c", "image"));
        list.add(new Banners("http://c.hiphotos.baidu.com/image/w%3D400/sign=c2318ff84334970a4773112fa5c8d1c0/b7fd5266d0160924c1fae5ccd60735fae7cd340d.jpg?qq-pf-to=pcqq.c2c", "image"));
        list.add(new Banners("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=a41eb338dd33c895a62bcb3bb72e47c2/5fdf8db1cb134954a2192ccb524e9258d1094a1e.jpg?qq-pf-to=pcqq.c2c", "image"));
        list.add(new Banners("", "image"));
    }
}
