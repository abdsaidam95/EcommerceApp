package com.example.ecommerceapp.feature.forgetPass;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;

public class ConfirmPasswardViewModel extends BaseViewModel {
    public void onClickButton(){
        doAction.setValue(AppAction.ACTION_GO_LOGIN);
    }
}
