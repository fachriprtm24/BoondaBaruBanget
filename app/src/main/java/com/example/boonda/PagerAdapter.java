package com.example.boonda;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int tab_number;

    public PagerAdapter(FragmentManager fm, int tab_number){
        super(fm);
        this.tab_number = tab_number;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new WeightFragment();
            case 1:
                return new HeightFragment();
            case 2:
                return new HeadFragment();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tab_number;
    }
}
