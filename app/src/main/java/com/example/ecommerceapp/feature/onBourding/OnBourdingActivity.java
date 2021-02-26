package com.example.ecommerceapp.feature.onBourding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseActivity;
import com.example.ecommerceapp.databinding.ActivityInBourdingBinding;
import com.example.ecommerceapp.feature.login.LoginActivity;
import com.example.ecommerceapp.util.AppAction;

public class OnBourdingActivity extends BaseActivity {
    private OnBourdingViewModel onBourdingViewModel;
    private ActivityInBourdingBinding activityInBourdingBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_bourding);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        onBourdingViewModel = new ViewModelProvider(this, factory).get(OnBourdingViewModel.class);

        activityInBourdingBinding = DataBindingUtil.setContentView(this, R.layout.activity_in_bourding);
        activityInBourdingBinding.setViewModel(onBourdingViewModel);
        activityInBourdingBinding.setFragmentManager(getSupportFragmentManager());
        activityInBourdingBinding.setLifecycleOwner(this);
        initializeView();
    }
    private void initializeView() {


        onBourdingViewModel.doAction.observe(this, action -> {
            if (action == AppAction.ACTION_LANGUAGE_DIALOG) {
               startNewActivity(LoginActivity.class);

            }
        });
    }


}