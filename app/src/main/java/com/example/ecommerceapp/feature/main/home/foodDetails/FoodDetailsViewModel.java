package com.example.ecommerceapp.feature.main.home.foodDetails;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.feature.main.home.division.AdapterFood;
import com.example.ecommerceapp.feature.main.home.division.Food;
import com.example.ecommerceapp.feature.rigester.User;
import com.example.ecommerceapp.util.AppAction;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class FoodDetailsViewModel extends ViewModel {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //  private CollectionReference notebookRef = db.collection("Beans");
    private CollectionReference notebookRef = db.collection("FillOrderBeans");
    public MutableLiveData<Integer> count = new MutableLiveData<>();
    public MutableLiveData<AdapterFoodDetails> adapter = new MutableLiveData<>();
    public ArrayList<Order>yy=new ArrayList<>();
    private FirebaseFirestore mDb;


    public MutableLiveData<Integer> getCount() {
        return count;
    }
    public FoodDetailsViewModel() {
        mDb = FirebaseFirestore.getInstance();
        mDb = FirebaseFirestore.getInstance();
        adapter.setValue(new AdapterFoodDetails());

    }
    public void  onStart(){
      setUpRecyclerView();

    }
    private void setUpRecyclerView() {
        notebookRef.get().addOnSuccessListener(queryDocumentSnapshots -> {
            if (queryDocumentSnapshots.isEmpty()) {
                Log.d(TAG, "onSuccess: LIST EMPTY");
                return;
            } else {
                // Convert the whole Query Snapshot to a list
                // of objects directly! No need to fetch each
                // document.
                List<Order> types = queryDocumentSnapshots.toObjects(Order.class);

                Objects.requireNonNull(adapter.getValue()).setData((ArrayList<Order>) types);

                // Add all to your list

            }

        }).addOnFailureListener(e -> {

        });

    }


    }





