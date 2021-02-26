package com.example.ecommerceapp.feature.onBourding;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.base.BaseViewModel;

public class FragmentViewModel extends BaseViewModel {
    public MutableLiveData<Integer> image = new MutableLiveData<>();
    public MutableLiveData<Integer> title = new MutableLiveData<>();
    public void onStart(OnBoarding onBoarding) {
        image.setValue(onBoarding.getImage());
        title.setValue(onBoarding.getTitle());
    }
}
