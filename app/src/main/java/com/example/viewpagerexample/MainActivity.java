package com.example.viewpagerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.viewpagerexample.auto_scroll.AutoScrollActivity;
import com.example.viewpagerexample.pageradapter.PagerAdapterActivity;
import com.example.viewpagerexample.stateadapter.StatePagerAdapterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.vp_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PagerAdapterActivity.class));
            }
        });

        findViewById(R.id.vp_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StatePagerAdapterActivity.class));
            }
        });

        findViewById(R.id.vp_auto_paging).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AutoScrollActivity.class));
            }
        });

    }
}
