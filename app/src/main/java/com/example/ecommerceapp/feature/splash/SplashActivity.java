package com.example.ecommerceapp.feature.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseActivity;
import com.example.ecommerceapp.databinding.ActivitySplashBinding;
import com.example.ecommerceapp.feature.onBourding.OnBourdingActivity;
import com.example.ecommerceapp.util.AppAction;

public class SplashActivity extends BaseActivity {
    private SplashViewModel viewModel;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModel = new ViewModelProvider(this, factory).get(SplashViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.onStart();
        viewModel.doAction.observe(this, action -> {
            if (action == AppAction.ACTION_ON_BOARDING) {
                startNewActivity(OnBourdingActivity.class);
            }
        });

    }


    @Override
    protected void onDestroy() {
        viewModel.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}