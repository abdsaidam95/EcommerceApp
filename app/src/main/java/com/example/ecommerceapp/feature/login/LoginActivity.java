package com.example.ecommerceapp.feature.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseActivity;
import com.example.ecommerceapp.databinding.ActivityLoginBinding;
import com.example.ecommerceapp.feature.forgetPass.ConfirmPasswerdActivity;
import com.example.ecommerceapp.feature.onBourding.OnBourdingActivity;
import com.example.ecommerceapp.feature.rigester.RegisterActivity;
import com.example.ecommerceapp.feature.splash.SplashViewModel;
import com.example.ecommerceapp.util.AppAction;

import static com.example.ecommerceapp.util.AppAction.ACTION_CHANGE_PASSWORD;

public class LoginActivity extends BaseActivity {
    private LoginViewModel loginViewModel;
    private ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        loginViewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewModel(loginViewModel);
        activityLoginBinding.setLifecycleOwner(this);

        loginViewModel.doAction.observe(this, action -> {
            if (action == AppAction.ACTION_LOGIN) {
                Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
            }else if (action==AppAction.ACTION_REGISTER){
                startNewActivity(RegisterActivity.class);
            }else if (action==ACTION_CHANGE_PASSWORD){
                startNewActivity(ConfirmPasswerdActivity.class);
            }
        });
    }
}