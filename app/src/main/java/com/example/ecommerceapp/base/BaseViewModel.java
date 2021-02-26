package com.example.ecommerceapp.base;

import androidx.lifecycle.ViewModel;

import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.dataBinding.SingleLiveEvent;

public class BaseViewModel extends ViewModel {
    public SingleLiveEvent<AppAction> doAction = new SingleLiveEvent<>();

}
