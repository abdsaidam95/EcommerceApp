package com.example.ecommerceapp.feature.forgetPass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseActivity;
import com.example.ecommerceapp.databinding.ActivityConfirmPasswerdBinding;
import com.example.ecommerceapp.feature.login.LoginActivity;
import com.example.ecommerceapp.feature.rigester.RegisterViewModel;
import com.example.ecommerceapp.util.AppAction;

public class ConfirmPasswerdActivity extends BaseActivity {
    private ConfirmPasswardViewModel confirmPasswardViewModel;
    private ActivityConfirmPasswerdBinding activityConfirmPasswerdBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        confirmPasswardViewModel = new ViewModelProvider(this, factory).get(ConfirmPasswardViewModel.class);
        activityConfirmPasswerdBinding = DataBindingUtil.setContentView(this, R.layout.activity_confirm_passwerd);
        activityConfirmPasswerdBinding.setViewModel(confirmPasswardViewModel);
        activityConfirmPasswerdBinding.setLifecycleOwner(this);
        setSupportActionBar(activityConfirmPasswerdBinding.appBar.toolbar);
        initializeToolbar("تغيير كلمة المرور");
        confirmPasswardViewModel.doAction.observe(this, action -> {
            if (action == AppAction.ACTION_GO_LOGIN) {
                startNewActivity(LoginActivity.class);
            }
        });
    }
}