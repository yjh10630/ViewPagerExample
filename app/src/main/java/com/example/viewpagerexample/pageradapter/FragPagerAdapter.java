package com.example.viewpagerexample.pageradapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.viewpagerexample.fragment.IndexFragment;

public class FragPagerAdapter extends FragmentPagerAdapter {

    FragmentManager mFragMan;

    public FragPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mFragMan = fm;
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

    /*@Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        IndexFragment cf = (IndexFragment) object;
        mFragMan.beginTransaction().remove(cf).commit();
    }*/
}
