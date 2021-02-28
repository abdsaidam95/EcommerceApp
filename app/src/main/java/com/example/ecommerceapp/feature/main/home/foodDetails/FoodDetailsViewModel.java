package com.example.ecommerceapp.feature.main.home.foodDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecommerceapp.R;

import java.util.ArrayList;
import java.util.Objects;

public class FoodDetailsViewModel extends ViewModel {
    private ArrayList<Order> items = new ArrayList<>();
    public MutableLiveData<AdapterFoodDetails> adapter = new MutableLiveData<>();
    public MutableLiveData<Integer> count = new MutableLiveData<>();

    public MutableLiveData<Integer> getCount() {
        return count;
    }
    public FoodDetailsViewModel() {
        adapter.setValue(new AdapterFoodDetails());
    }
    public void  onStart(){
        setCities();
    }

    public void setCities() {
        items.clear();
        items.add(new Order("24₪", R.drawable.ic_cleaning, "aaaaaa", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "bbbbb", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "ccccc", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "fffff", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "wefwe", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "sdsdsd", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, ",iiiii", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "yyyy", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "nnnnnnn", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "ttttt", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "rrrrrr", "er;mgelrknhltrhnlrtn", String.valueOf(0)));
        items.add(new Order("24₪", R.drawable.ic_cleaning, "qqqqqq", "er;mgelrknhltrhnlrtn", String.valueOf(0)));


        Objects.requireNonNull(adapter.getValue()).setData(items);
    }
}
