package com.example.ecommerceapp.feature.main.home.division;


import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.feature.main.nav.Menu;
import com.example.ecommerceapp.feature.main.nav.MenuAdapter;
import com.example.ecommerceapp.util.AppAction;

import java.util.ArrayList;
import java.util.Objects;

public class DivisionViewModel extends BaseViewModel {
    public MutableLiveData<AdapterFood> menuAdapter = new MutableLiveData<>();
    private ArrayList<Food> item;
//    public DivisionViewModel() {
//        menuAdapter.setValue(new AdapterFood());
//    }
//    public void onStart() {
//        setData();
//    }
//    public void setData() {
//        item = new ArrayList<>();
//        item.add(new Food(R.drawable.ic_hhouse,"المشروبات"));
//        item.add(new Food(R.drawable.ic_hhouse,"بقوليات"));
//        item.add(new Food(R.drawable.ic_hhouse,"معلبات"));
//        item.add(new Food(R.drawable.ic_hhouse,"شوكلاتة"));
//        item.add(new Food(R.drawable.ic_hhouse,"توابل"));
//        item.add(new Food(R.drawable.ic_hhouse,"أجبان ومشتقاتها"));
//
//        Objects.requireNonNull(menuAdapter.getValue()).setData(item);
//    }
}
