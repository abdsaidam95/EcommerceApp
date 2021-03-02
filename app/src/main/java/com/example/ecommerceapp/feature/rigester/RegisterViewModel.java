package com.example.ecommerceapp.feature.rigester;

/**
 * @author by EngAbdSaidam
 * project commerce that support dataBinging and MvvMDesignPattern
 */


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import static android.text.TextUtils.isEmpty;

public class RegisterViewModel extends BaseViewModel {
    public MutableLiveData<String> userName = new MutableLiveData<>();
    public MutableLiveData<String> phoneNumber = new MutableLiveData<>();
    public MutableLiveData<String> TelephoneNumber = new MutableLiveData<>();
    public MutableLiveData<String> address = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Integer> isShowing = new MutableLiveData<>();
    private FirebaseFirestore mDb;
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RegisterViewModel() {
        mDb = FirebaseFirestore.getInstance();
        userName.setValue("");
        phoneNumber.setValue("");
        TelephoneNumber.setValue("");
        address.setValue("");
        email.setValue("");
        password.setValue("");
        isShowing.setValue(View.GONE);
    }

    public void onClickButton() {
        if (!isEmpty(userName.getValue())
                && !isEmpty(phoneNumber.getValue())
                && !isEmpty(TelephoneNumber.getValue())
                && !isEmpty(address.getValue()) && !isEmpty(email.getValue()) && !isEmpty(password.getValue())) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getValue(), password.getValue())
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {

                            //insert some default data
                            User user = new User();
                            user.setEmail(email.getValue());
                            user.setId(FirebaseAuth.getInstance().getUid());
                            user.setAddress(address.getValue());
                            user.setPhone(phoneNumber.getValue());
                            user.setUsername(userName.getValue());
                            user.setPassword(password.getValue());
                            user.setTelefone(TelephoneNumber.getValue());
                            isShowing.setValue(View.VISIBLE);

                            FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                                    .build();
                            mDb.setFirestoreSettings(settings);

                            DocumentReference newUserRef = mDb
                                    .collection("Users")
                                    .document(FirebaseAuth.getInstance().getUid());

                            newUserRef.set(user).addOnCompleteListener(task1 -> {

                                if (task1.isSuccessful()) {
                                    Log.d("jy5j5yj", "y6uk6uk6");
                                    doAction.setValue(AppAction.ACTION_GO_LOGIN);
                                    isShowing.setValue(View.GONE);
                                } else {
                                    isShowing.setValue(View.GONE);
                                    Toast.makeText(context, "this account exists", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        // ...
                    });
        }


    }






    }



