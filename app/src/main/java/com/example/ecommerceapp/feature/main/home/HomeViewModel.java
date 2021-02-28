package com.example.ecommerceapp.feature.main.home;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;

import org.greenrobot.eventbus.EventBus;

public class HomeViewModel extends BaseViewModel {
    public void onClickfood(){
        EventBus.getDefault().post(new ActionEvent(AppAction.ACTION_GO_DIVISION));

    }
    public void onClickCleaing(){

    }
    public void onClickHouseMaterials(){

    }
}
