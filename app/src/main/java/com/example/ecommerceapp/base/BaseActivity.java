package com.example.ecommerceapp.base;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import static com.example.ecommerceapp.util.AppUtil.hideKeyboard;

public class BaseActivity extends AppCompatActivity {
    public void startNewActivity(Class<?> newActivity) {
        startNewActivity(newActivity, null, false);
    }

    public void startNewActivity(Class<?> newActivity, Intent extras) {
        startNewActivity(newActivity, extras, false);
    }

    public void startNewActivity(Class<?> newActivity, Intent extras, boolean clearStack) {
        Intent intent = new Intent(this, newActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (clearStack) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        if (extras != null) {
            intent.putExtras(extras);
        }
        hideKeyboard(this);
        startActivity(intent);
    }
    public void initializeToolbar(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
