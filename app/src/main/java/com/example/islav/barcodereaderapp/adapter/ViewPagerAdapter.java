package com.example.islav.barcodereaderapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.islav.barcodereaderapp.fragments.MyCardsFragment;
import com.example.islav.barcodereaderapp.fragments.PublicCardsFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MyCardsFragment tab1 = new MyCardsFragment();
                return tab1;
            case 1:
                PublicCardsFragment tab2 = new PublicCardsFragment();
                return tab2;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}