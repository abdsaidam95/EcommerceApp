package com.example.ecommerceapp.feature.main.home.division;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.feature.main.nav.Menu;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;

import org.greenrobot.eventbus.EventBus;

public class FoodItemViewModel extends BaseViewModel {
    private Food food;
    private int position;

    public MutableLiveData<String> foodTitle = new MutableLiveData<>();
    public MutableLiveData<Integer> icon = new MutableLiveData<>();
    public FoodItemViewModel(Food menu) {
        this.food = menu;
    }

    public void onStart() {
        foodTitle.setValue(food.getTitle());
        icon.setValue(food.getImage());
    }
    public void onClickItem() {
        EventBus.getDefault().post(new ActionEvent(AppAction.ACTION_GO_DETAIL, food, position));
    }
}
