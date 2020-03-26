package com.example.viewpagerexample.stateadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.viewpagerexample.fragment.IndexFragment;

public class FragStatePagerAdapter extends FragmentStatePagerAdapter {

    public FragStatePagerAdapter(@NonNull FragmentManager fm) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return IndexFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 10;
    }
}
