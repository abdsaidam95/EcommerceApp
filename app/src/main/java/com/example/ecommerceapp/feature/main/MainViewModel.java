package com.example.ecommerceapp.feature.main;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.feature.main.nav.Menu;
import com.example.ecommerceapp.feature.main.nav.MenuAdapter;
import com.example.ecommerceapp.util.AppAction;

import java.util.ArrayList;
import java.util.Objects;

public class MainViewModel extends BaseViewModel {
    public MutableLiveData<MenuAdapter> menuAdapter = new MutableLiveData<>();
    public MutableLiveData<String> userName = new MutableLiveData<>();
    private ArrayList<Menu> menus;
    private Menu selectedMenu = null;
    public MainViewModel() {

        userName.setValue("رياض أحمد");
        menuAdapter.setValue(new MenuAdapter());
        setData();
    }
    public void onStart() {
        setData();
    }
    public void handleItemNavSelection(Menu menu) {
        selectedMenu = menu;
        doAction.setValue(menu.getAction());
    }   public void setData() {
        menus = new ArrayList<>();
        menus.add(new Menu((R.string.nav_home), R.drawable.ic_home, AppAction.ACTION_NAV_HOME));
        menus.add(new Menu((R.string.nav_offer), R.drawable.ic_offer, AppAction.ACTION_NAV_ORDERS));
        menus.add(new Menu((R.string.nav_purchases), R.drawable.ic_cart, AppAction.ACTION_NAV_PERCHES));
        menus.add(new Menu((R.string.nav_account_settings), R.drawable.ic_setting, AppAction.ACTION_NAV_SETTING));
        menus.add(new Menu((R.string.technical_support), R.drawable.ic_support, AppAction.ACTION_NAV_SUPPORT));

        handleItemNavSelection(menus.get(0));
        Objects.requireNonNull(menuAdapter.getValue()).setData(menus);
    }

    public void onBackPressed() {
        if (selectedMenu.getAction() != AppAction.ACTION_NAV_HOME) {
            handleItemNavSelection(menus.get(0));
        } else {
            doAction.setValue(AppAction.ACTION_QUIT);
        }
    }
}
