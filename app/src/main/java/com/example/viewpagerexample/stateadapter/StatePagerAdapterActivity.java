package com.example.viewpagerexample.stateadapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpagerexample.R;

public class StatePagerAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statepageradapter);

        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(new FragStatePagerAdapter(getSupportFragmentManager()));

    }
}
