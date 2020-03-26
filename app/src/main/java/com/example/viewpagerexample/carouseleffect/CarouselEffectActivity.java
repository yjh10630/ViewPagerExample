package com.example.viewpagerexample.carouseleffect;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpagerexample.R;
import com.example.viewpagerexample.auto_scroll.AutoScrollPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class CarouselEffectActivity extends AppCompatActivity {

    private ArrayList<String> colorList = new ArrayList<>(
            Arrays.asList(
                    "#F44336", "#009688", "#FF9800", "#673AB7", "#FFEB3B", "#FF9E80", "#B388FF", "#CCFF90", "#8C9EFF", "#3D5AFE"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carouseleffect);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new AutoScrollPagerAdapter(colorList));    // AutoScrollPaagerAdapter 빌려 옴.. 똑같은 PagerAdapter 로 동작 할 수 있으니까 ..
        viewPager.setCurrentItem(100 * 10 / 2); // 무한 스크롤 초기 세팅 값

        // 고정된 width 값 ( 280dp ) 를 세팅 하고 안드로이드 특성상 가로 비율이 다르기 때문에 이미지를 고정 하고 양쪽 패딩을 해상도 비율에 맞게 조절.
        viewPager.setClipToPadding(false);  // viewpager 가 아닌 viewpager 의 child view 에게 padding 을 주게 하는 것,
        float diff = pxToDp(width) - 280;   // 280 이란? width 를 나타냄. 수식을 보면 280은 dp 라는것을 알 수 있음.
        int padding = dpToPx((int) (diff / 2)); // 양쪽 padding 값이 계산됨.

        viewPager.setPadding(padding, 0, padding, 0); // ViewPager Child Item 기준으로 양쪽 패딩을 줌으로써 양쪽 이미지가 padding 에 따라 보여진다.
        viewPager.setPageMargin((int) dpToPx(20));  // ViewPager Child Item 간의 Margin 값.
        viewPager.setPageTransformer(false, new CarouselEffectTransformer(this)); // Set pageTransformer
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private float pxToDp(float px) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
