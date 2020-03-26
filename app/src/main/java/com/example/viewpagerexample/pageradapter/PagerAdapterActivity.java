package com.example.viewpagerexample.pageradapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpagerexample.R;

public class PagerAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageradapter);

        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(new FragPagerAdapter(getSupportFragmentManager()));

    }
}
