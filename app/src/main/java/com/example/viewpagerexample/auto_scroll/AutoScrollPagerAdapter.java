package com.example.viewpagerexample.auto_scroll;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.viewpagerexample.R;

import java.util.ArrayList;

public class AutoScrollPagerAdapter extends PagerAdapter {

    private ArrayList<String> colorList;
    public int LOOPS_COUNT = 100;

    public AutoScrollPagerAdapter(ArrayList<String> colorList) {
        this.colorList = colorList;
    }

    @Override
    public int getCount() {
        if (colorList == null) {
            return 0;
        } else {
            if (colorList.size() > 1) {
                return LOOPS_COUNT * colorList.size();
            } else {
                return colorList.size();
            }
        }
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { return view == object; }
    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object); }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_image, container, false);

        int index = position % colorList.size();
        TextView tv_realCount = (TextView)view.findViewById(R.id.tv_real_count);
        TextView tv_innerCount = (TextView)view.findViewById(R.id.tv_inner_count);
        if (colorList.size() > 1) {
            tv_realCount.setText(String.valueOf(position));
            tv_innerCount.setText(String.valueOf(index));
        } else {
            tv_realCount.setText("딸랑 하나 ? ");
            tv_innerCount.setText("딸랑 하나 ? ");
        }

        view.setBackgroundColor(Color.parseColor(colorList.get(index)));

        container.addView(view);
        return view;
    }
}
