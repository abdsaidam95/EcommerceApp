package com.example.ecommerceapp.feature.rigester;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;

public class RegisterViewModel extends BaseViewModel {
    public void onClickButton(){
        doAction.setValue(AppAction.ACTION_GO_LOGIN);
    }

}
