package com.example.ecommerceapp.feature.main.home.foodDetails;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;

import org.greenrobot.eventbus.EventBus;

public class ItemViewModel extends BaseViewModel {
    public Order order;
    int s;
    public int positions;
    public MutableLiveData<String> price = new MutableLiveData<>();
    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> type = new MutableLiveData<>();
    public MutableLiveData<String> num = new MutableLiveData<>();
    public MutableLiveData<String> image = new MutableLiveData<>();
    public ItemViewModel(Order order, int position) {
        this.order = order;
        this.positions = position;
    }

    public void onStart() {
        image.setValue(order.getImage());
        title.setValue(order.getTitle());
        type.setValue(order.getTypeFood());
        price.setValue(order.getPrice());
//        num.setValue(order.getNum());
    }
    public void addClick() {
//        s = Integer.decode(order.getNum());
//        s++;
//        order.setNum(String.valueOf(s));
//        num.setValue(order.getNum());
//        EventBus.getDefault().post(new ActionEvent(AppAction.ACTION_SELECT_SINGLE_CITY));


    }

    public void minusClick() {
//        if ((Integer.decode(order.getNum()) <= 0)) {
//            num.setValue(order.getNum());
//
//        } else {
//            s = Integer.decode(order.getNum());
//            s--;
//            order.setNum(String.valueOf(s));
//            num.setValue(order.getNum());
//            EventBus.getDefault().post(new ActionEvent(AppAction.ACTION_SELECT_SINGLE_CITY));


        }



    public void addCartClick() {
        EventBus.getDefault().post(new ActionEvent(AppAction.ADD_CART,order,positions));

    }
}
