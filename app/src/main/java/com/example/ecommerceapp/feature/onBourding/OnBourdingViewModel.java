package com.example.ecommerceapp.feature.onBourding;

import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;

import java.util.ArrayList;

public class OnBourdingViewModel extends BaseViewModel {
    private int position = 0;

    public MutableLiveData<Integer> currentPage = new MutableLiveData<>();
    public MutableLiveData<Integer> textButton = new MutableLiveData<>();
    public MutableLiveData<ArrayList<OnBoarding>> onBoardingArrayList = new MutableLiveData<>();
    public ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int p) {
            position = p;
        }
    };
    public OnBourdingViewModel() {
        currentPage.setValue(0);
        ArrayList<OnBoarding> list = new ArrayList<>();

        list.add(new OnBoarding(R.drawable.ic_bord1, R.string.on_boarding_1));
        list.add(new OnBoarding(R.drawable.ic_bord2, R.string.on_boarding_1));
        list.add(new OnBoarding(R.drawable.ic_bord3, R.string.on_boarding_1));

        onBoardingArrayList.setValue(list);
    }
    public void onClickButton() {
        switch (position) {
            case 0:
                currentPage.setValue(1);
                break;
            case 1:
                currentPage.setValue(2);
                break;
            case 2:
                doAction.setValue(AppAction.ACTION_LANGUAGE_DIALOG);
                break;
        }

    }

}
