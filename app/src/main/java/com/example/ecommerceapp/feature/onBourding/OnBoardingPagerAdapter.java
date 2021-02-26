package com.example.ecommerceapp.feature.onBourding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class OnBoardingPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<OnBoarding> onBoardingList;
    public OnBoardingPagerAdapter(@NonNull FragmentManager fm, ArrayList<OnBoarding> onBoardingList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.onBoardingList = onBoardingList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return OnBourdingFragment.newInstance(onBoardingList.get(position));
    }

    @Override
    public int getCount() {
        return onBoardingList.size();
    }

}
