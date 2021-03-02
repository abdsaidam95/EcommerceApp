package com.example.ecommerceapp.feature.login;

/**
 * @author by EngAbdSaidam
 * project commerce that support dataBinging and MvvMDesignPattern
 */


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.example.ecommerceapp.util.dataBinding.TextChange;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.text.TextUtils.isEmpty;

public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Integer> isShowing = new MutableLiveData<>();
    public MutableLiveData<Integer> emailError = new MutableLiveData<>();
    public MutableLiveData<Integer> passwordError = new MutableLiveData<>();
    public TextChange emailTextChange = value -> emailError.setValue(0);
    public TextChange passwordTextChange = value -> passwordError.setValue(0);
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LoginViewModel() {
        isShowing.setValue(View.GONE);
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
    private void signIn() {
        isShowing.setValue(View.VISIBLE);
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getValue(),
                password.getValue())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        isShowing.setValue(View.GONE);
                        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show();
                        doAction.setValue(AppAction.ACTION_LOGIN);


                    }


                }).addOnFailureListener(e -> {
                    isShowing.setValue(View.GONE);
                    Toast.makeText(context, "Login Faild", Toast.LENGTH_SHORT).show();
                });
        }





    public void onClickButton(){
        boolean v1 = validationEmail();
        boolean v2 = validationPassword();
        if (v1 && v2){
            signIn();
        }

    }
    public void onClickRegister(){
        doAction.setValue(AppAction.ACTION_REGISTER);
    }
    public void onClickChangePassword(){
        doAction.setValue(AppAction.ACTION_CHANGE_PASSWORD);
    }
}
