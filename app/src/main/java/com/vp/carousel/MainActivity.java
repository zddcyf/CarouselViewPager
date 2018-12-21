package com.vp.carousel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.vp.carousel.viewpager.build.PackViewBuild;
import com.vp.carousel.viewpager.config.ViewPagerEnum;
import com.vp.carousel.viewpager.view.PackViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PackViewPager packViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packViewPager = findViewById(R.id.packViewPager);
        List<String> list = new ArrayList<>();
        list.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=a4b3d7085dee3d6d2293d48b252b5910/0e2442a7d933c89524cd5cd4d51373f0830200ea.jpg?qq-pf-to=pcqq.c2c");
        list.add("http://c.hiphotos.baidu.com/image/w%3D400/sign=c2318ff84334970a4773112fa5c8d1c0/b7fd5266d0160924c1fae5ccd60735fae7cd340d.jpg?qq-pf-to=pcqq.c2c");
        list.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=a41eb338dd33c895a62bcb3bb72e47c2/5fdf8db1cb134954a2192ccb524e9258d1094a1e.jpg?qq-pf-to=pcqq.c2c");
        new PackViewBuild().setDefaultImage(R.mipmap.ic_launcher)
                .setMode(ViewPagerEnum.wireBanner.getCode())
                .setScaleType(ImageView.ScaleType.FIT_XY)
                .setPadd(5, 1, 5, 1)
                .setMargin(10, 10, 10, 10)
                .setGrivate(ViewPagerEnum.bottomOrRight.getCode())
                .setBookMarkMode(ViewPagerEnum.number.getCode())
                .setImages(list)
                .create(packViewPager);
    }
}
