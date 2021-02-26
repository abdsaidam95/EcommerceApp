package com.example.ecommerceapp.feature.login;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.dataBinding.TextChange;

public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Integer> emailError = new MutableLiveData<>();
    public MutableLiveData<Integer> passwordError = new MutableLiveData<>();
    public TextChange emailTextChange = value -> emailError.setValue(0);
    public TextChange passwordTextChange = value -> passwordError.setValue(0);

    public LoginViewModel() {
        emailError.setValue(0);
        passwordError.setValue(0);
    }
    private boolean validationEmail() {
        if (TextUtils.isEmpty(email.getValue())) {
            emailError.setValue((R.string.please_enter_email));
            return false;
        } else {
            emailError.setValue(0);
            return true;
        }
    }
    private boolean validationPassword() {
        if (TextUtils.isEmpty(password.getValue())) {
            passwordError.setValue((R.string.please_enter_password));
            return false;
        } else {
            passwordError.setValue(0);
            return true;
        }
    }

    public void onClickButton(){
        boolean v1 = validationEmail();
        boolean v2 = validationPassword();
        if (v1 && v2){
            doAction.setValue(AppAction.ACTION_LOGIN);
        }

    }
    public void onClickRegister(){
        doAction.setValue(AppAction.ACTION_REGISTER);
    }
    public void onClickChangePassword(){
        doAction.setValue(AppAction.ACTION_CHANGE_PASSWORD);
    }
}
