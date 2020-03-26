package com.example.viewpagerexample.auto_scroll;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.viewpagerexample.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class AutoScrollActivity extends AppCompatActivity {

    private CustomScrollWrapViewPager rxjava_viewpager;

    private Subscription mSubscription;
    private boolean isAutoScroll;

    private ArrayList<String> colorList = new ArrayList<>(
            Arrays.asList(
                    "#F44336", "#009688", "#FF9800", "#673AB7", "#FFEB3B", "#FF9E80", "#B388FF", "#CCFF90", "#8C9EFF", "#3D5AFE"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoscroll);
        setRxjavaScrollViewPager();
    }

    private void setRxjavaScrollViewPager() {
        rxjava_viewpager = findViewById(R.id.vp_rxjava_autoscroll);
        Switch sw_rxjava = findViewById(R.id.sw_rxjava);
        Switch sw_slow_rxjava = findViewById(R.id.sw_slow_rxjava);
        rxjava_viewpager.setAdapter(new AutoScrollPagerAdapter(colorList));
        rxjava_viewpager.setPageMargin(20);
        rxjava_viewpager.setCurrentItem(100 * 10 / 2);  // 전역변수로 설정 하여 계산해 줘야 하지만.. 귀찮아서 걍 하드코딩..

        // 오토 스크롤 스위치
        sw_rxjava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isAutoScroll = true;
                    autoScrollStart(isAutoScroll);
                } else {
                    isAutoScroll = false;
                    autoScrollStop();
                }
            }
        });

        // 스크롤 스피드 변경 스위치
        sw_slow_rxjava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rxjava_viewpager.setScrollDurationFactor(1000);
                } else {
                    rxjava_viewpager.setScrollDurationFactor(0);
                }
            }
        });

        rxjava_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE: {
                        autoScrollStart(isAutoScroll);  // 스크롤이 끝났다거나, 아니면 현재 멈춰져 있을 경우 오토 스크롤 시작.
                        break;
                    }
                    case ViewPager.SCROLL_STATE_DRAGGING: { // 사용자가 손으로 스크롤 시 오토 스크롤 잠깐 정지.
                        autoScrollStop();
                        break;
                    }
                }
            }
        });
    }


    private void autoScrollStart(boolean isAutoScroll) {
        if (isAutoScroll) {
            if (mSubscription != null) mSubscription.unsubscribe();
            mSubscription = Observable.timer(500, TimeUnit.MILLISECONDS)    // 0.5초 뒤에 스크롤 시작.
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Long>() {
                                   @Override
                                   public void call(Long aLong) {
                                       rxjava_viewpager.setCurrentItem(rxjava_viewpager.getCurrentItem() + 1);
                                   }
                               }
                    );
        }
    }

    private void autoScrollStop() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }
}
