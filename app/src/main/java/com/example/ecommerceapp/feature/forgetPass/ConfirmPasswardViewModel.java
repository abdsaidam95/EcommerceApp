package com.example.ecommerceapp.feature.forgetPass;

/**
 * @author by EngAbdSaidam
 * project commerce that support dataBinging and MvvMDesignPattern
 */


import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.ecommerceapp.base.BaseViewModel;
import com.example.ecommerceapp.util.AppAction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConfirmPasswardViewModel extends BaseViewModel {
    public MutableLiveData<String> oldPassword = new MutableLiveData<>();
    public MutableLiveData<String> newPassword = new MutableLiveData<>();
    public MutableLiveData<String> confirmPassword = new MutableLiveData<>();
    public MutableLiveData<Integer> isShowing = new MutableLiveData<>();
    private FirebaseFirestore mDb;


    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ConfirmPasswardViewModel() {
        mDb = FirebaseFirestore.getInstance();
        isShowing.setValue(View.GONE);
    }

    public void onClickButton(){
        changePassword();

    }
    public static boolean doStringsMatch(String s1, String s2){
        return s1.equals(s2);
    }
    public void changePassword(){
        if (doStringsMatch(newPassword.getValue(), confirmPassword.getValue())) {
            isShowing.setValue(View.VISIBLE);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
            AuthCredential credential = EmailAuthProvider
                    .getCredential(user.getEmail(), oldPassword.getValue());

// Prompt the user to re-provide their sign-in credentials
            user.reauthenticate(credential)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                isShowing.setValue(View.GONE);
                                user.updatePassword(newPassword.getValue()).addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful()) {
                                        Toast.makeText(context, "Password updated", Toast.LENGTH_SHORT).show();
                                        mDb.collection("Users").document(FirebaseAuth.getInstance().getUid()).update("password", newPassword);
                                        doAction.setValue(AppAction.ACTION_GO_LOGIN);
                                    } else {
                                        Toast.makeText(context, "error change password ", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                isShowing.setValue(View.GONE);
                                Toast.makeText(context, "error change password ", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }
}
