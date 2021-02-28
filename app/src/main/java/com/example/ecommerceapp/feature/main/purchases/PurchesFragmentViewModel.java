package com.example.ecommerceapp.feature.main.purchases;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.feature.main.home.foodDetails.AdapterFoodDetails;
import com.example.ecommerceapp.feature.main.home.foodDetails.Order;

import java.util.ArrayList;
import java.util.Objects;

public class PurchesFragmentViewModel extends BaseViewModel {
    private ArrayList<Perches> items = new ArrayList<>();
    public MutableLiveData<AdapterPerches> adapter = new MutableLiveData<>();
    public MutableLiveData<Integer> count = new MutableLiveData<>();
    public PurchesFragmentViewModel() {
        adapter.setValue(new AdapterPerches());
    }
    public void  onStart(){
        setCities();
    }

    public void setCities() {
        items.clear();
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "aaaaaa", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "bbbbb", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "ccccc", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "fffff", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "wefwe", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "sdsdsd", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, ",iiiii", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "yyyy", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "nnnnnnn", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "ttttt", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "rrrrrr", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Perches("24₪", R.drawable.ic_cleaning, "qqqqqq", "er;mgelrknhltrhnlrtn", String.valueOf(0)));


        Objects.requireNonNull(adapter.getValue()).setData(items);
    }
}
