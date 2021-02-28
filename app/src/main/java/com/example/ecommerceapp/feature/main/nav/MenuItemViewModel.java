package com.example.ecommerceapp.feature.main.nav;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;

import org.greenrobot.eventbus.EventBus;

public class MenuItemViewModel extends BaseViewModel {
    private Menu menu;
    private int position;

    public MutableLiveData<Integer> menuTitle = new MutableLiveData<>();
    public MutableLiveData<Integer> icon = new MutableLiveData<>();
    public MenuItemViewModel(Menu menu) {
        this.menu = menu;
    }

    public void onStart() {
        menuTitle.setValue(menu.getMenuTitle());
        icon.setValue(menu.getMenuIcon());
    }
    public void onClickItem() {
        EventBus.getDefault().post(new ActionEvent(AppAction.ACTION_NAV_ITEM, menu, position));
    }
}
