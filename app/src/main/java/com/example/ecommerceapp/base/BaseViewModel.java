package com.example.ecommerceapp.base;

/**
 * @author by EngAbdSaidam
 * project commerce that support dataBinging and MvvMDesignPattern
 */


import androidx.lifecycle.ViewModel;

import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.dataBinding.SingleLiveEvent;

public class BaseViewModel extends ViewModel {
    public SingleLiveEvent<AppAction> doAction = new SingleLiveEvent<>();

}
