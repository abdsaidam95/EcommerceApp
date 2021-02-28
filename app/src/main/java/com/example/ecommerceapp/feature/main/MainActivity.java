package com.example.ecommerceapp.feature.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseActivity;
import com.example.ecommerceapp.databinding.ActivityMainBinding;
import com.example.ecommerceapp.feature.main.home.HomeFragment;
import com.example.ecommerceapp.feature.main.home.division.DivisionFragment;
import com.example.ecommerceapp.feature.main.home.foodDetails.FoodDetailsFragment;
import com.example.ecommerceapp.feature.main.nav.Menu;
import com.example.ecommerceapp.feature.main.order.OrdersFragment;
import com.example.ecommerceapp.feature.main.purchases.PurchasesFragment;
import com.example.ecommerceapp.feature.main.settings.SettingsFragment;
import com.example.ecommerceapp.feature.main.support.SupportFragment;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;
import com.google.android.material.navigation.NavigationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;

import static com.example.ecommerceapp.util.AppAction.ACTION_GO_DETAIL;
import static com.example.ecommerceapp.util.AppAction.ACTION_GO_DIVISION;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawer;
    private NavigationView navigationView;
     MenuItem menuItemNotifications;
    Toolbar toolbar;

    private TextView textViewNotification;
    private TextView textViewMessages;
    private int count = 10;
    private boolean iconCkeaked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.onStart();
        initializeView();

    }
    private void initializeView() {
        initializeDrawer();
    }
    private void initializeDrawer() {
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.main_drawer_open, R.string.main_drawer_close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        viewModel.doAction.observe(this, appAction -> {
            switch (appAction) {
                case ACTION_NAV_HOME:
                    iconCkeaked=true;
                    count=10;
                    setupBadge();
                    if (menuItemNotifications!=null){
                        menuItemNotifications.setVisible(true);
                    }
                    getSupportActionBar().setTitle(getString(R.string.nav_home));
                    replaceFragment(new HomeFragment(), "Home Fragment");
                    break;
                case ACTION_NAV_ORDERS:
                    iconCkeaked=true;
                    menuItemNotifications.setVisible(true);
                    count=10;
                    setupBadge();
                    getSupportActionBar().setTitle(getString(R.string.nav_offer));
                    replaceFragment(new OrdersFragment(), "Orders Fragment");
                    break;
                case ACTION_NAV_SETTING:
                    iconCkeaked=true;
                    menuItemNotifications.setVisible(true);
                    count=10;
                    setupBadge();
                    getSupportActionBar().setTitle(getString(R.string.nav_account_settings));
                    replaceFragment(new SettingsFragment(), "Settings Fragment ");
                    break;
                case ACTION_NAV_PERCHES:
                    menuItemNotifications.setVisible(false);
                    getSupportActionBar().setTitle(getString(R.string.nav_purchases));
                    count=0;
                    setupBadge();
                    replaceFragment(new PurchasesFragment(), "Purchases Fragment ");
                    break;
                case ACTION_NAV_SUPPORT:
                    iconCkeaked=true;
                    menuItemNotifications.setVisible(true);
                    count=10;
                    setupBadge();
                    getSupportActionBar().setTitle(getString(R.string.technical_support));
                    replaceFragment(new SupportFragment(), "Support Fragment ");
                    break;

                case ACTION_QUIT:
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    } else {
                        super.onBackPressed();
                    }
                    break;
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onActionEvent(ActionEvent actionEvent) {
        if (actionEvent.getActions() == AppAction.ACTION_NAV_ITEM) {
            Object data = actionEvent.getData();
            if (data != null ) {
                viewModel.handleItemNavSelection((Menu) actionEvent.getData());
                drawer.closeDrawer(GravityCompat.START);
            }
        }else if (actionEvent.getActions()==ACTION_GO_DIVISION){
            replaceFragment(new DivisionFragment(), "Division Fragment ");

        }else if (actionEvent.getActions()==ACTION_GO_DETAIL){
            getSupportActionBar().setTitle(getString(R.string.food_details));
            replaceFragment(new FoodDetailsFragment(), "Division Fragment ");

        }
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.cart, menu);

         menuItemNotifications = menu.findItem(R.id.action_notifications);
        menuItemNotifications.setVisible(true);
        if (iconCkeaked){
            menuItemNotifications.setIcon(R.drawable.ic_cart);
        }else {

        }
        View actionViewNotifications = menuItemNotifications.getActionView();
        textViewNotification = (TextView) actionViewNotifications.findViewById(R.id.textViewNotification);

        setupBadge();

        actionViewNotifications.setOnClickListener(v -> onOptionsItemSelected(menuItemNotifications));
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
            return true;
        } else if (item.getItemId() == R.id.action_notifications) {
            if (iconCkeaked==true){
                Toast.makeText(this, "cart", Toast.LENGTH_SHORT).show();
            }
            else {
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }
    private void setupBadge() {
        if (textViewNotification != null) {
            if (count == 0) {
                if (textViewNotification.getVisibility() != View.GONE) {
                    textViewNotification.setVisibility(View.GONE);
                }
            } else {
                textViewNotification.setText(String.valueOf(Math.min(count, 99)));
                if (textViewNotification.getVisibility() != View.VISIBLE) {
                    textViewNotification.setVisibility(View.VISIBLE);
                }
            }
        }
        if (textViewMessages != null) {
            if (count == 0) {
                if (textViewMessages.getVisibility() != View.GONE) {
                    textViewMessages.setVisibility(View.GONE);
                }
            } else {
                textViewMessages.setText(String.valueOf(Math.min(count, 99)));
                if (textViewMessages.getVisibility() != View.VISIBLE) {
                    textViewMessages.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    @Override
    public void onBackPressed() {
        viewModel.onBackPressed();
    }
}