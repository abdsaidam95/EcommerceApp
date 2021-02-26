package com.example.ecommerceapp.feature.rigester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseActivity;
import com.example.ecommerceapp.databinding.ActivityRegisterBinding;
import com.example.ecommerceapp.feature.login.LoginActivity;
import com.example.ecommerceapp.feature.login.LoginViewModel;
import com.example.ecommerceapp.util.AppAction;

public class RegisterActivity extends BaseActivity {
    private RegisterViewModel registerViewModel;
    private ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        registerViewModel = new ViewModelProvider(this, factory).get(RegisterViewModel.class);
        activityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        activityRegisterBinding.setViewModel(registerViewModel);
        activityRegisterBinding.setLifecycleOwner(this);
        registerViewModel.doAction.observe(this, action -> {
            if (action == AppAction.ACTION_GO_LOGIN) {
                startNewActivity(LoginActivity.class);
            }
        });
    }
}