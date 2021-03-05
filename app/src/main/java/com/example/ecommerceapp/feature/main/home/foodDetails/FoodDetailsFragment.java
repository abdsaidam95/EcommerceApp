package com.example.ecommerceapp.feature.main.home.foodDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.databinding.FragmentFoodDetailsBinding;
import com.example.ecommerceapp.databinding.FragmentHomeBinding;
import com.example.ecommerceapp.feature.main.home.HomeViewModel;
import com.example.ecommerceapp.feature.main.home.division.AdapterFood;
import com.example.ecommerceapp.feature.main.home.division.Food;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;


public class FoodDetailsFragment extends Fragment {
    FragmentFoodDetailsBinding binding;
    FoodDetailsViewModel viewModelFragment;
    private AdapterFoodDetails adapter;




    public FoodDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailsBinding.inflate(inflater, container, false);

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModelFragment = new ViewModelProvider(requireActivity(), factory).get(FoodDetailsViewModel.class);
        binding.setViewModel(viewModelFragment);
        binding.setLifecycleOwner(this);
        viewModelFragment.onStart();
        return binding.getRoot();
    }



    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);

    }

    @Subscribe
    public void onActionEvent(ActionEvent actionEvent) {

    }
}