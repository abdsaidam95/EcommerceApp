package com.example.ecommerceapp.feature.main.home.division;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.databinding.FragmentDivisionBinding;
import com.example.ecommerceapp.databinding.FragmentHomeBinding;
import com.example.ecommerceapp.feature.main.home.HomeViewModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.greenrobot.eventbus.EventBus;


public class DivisionFragment extends Fragment {
    FragmentDivisionBinding binding;
    DivisionViewModel viewModelFragment;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Category");
    private AdapterFood adapter;



    public DivisionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        binding = FragmentDivisionBinding.inflate(inflater, container, false);

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModelFragment = new ViewModelProvider(requireActivity(), factory).get(DivisionViewModel.class);
        binding.setViewModel(viewModelFragment);
        binding.setLifecycleOwner(this);
        setUpRecyclerView();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // setUpRecyclerView();
    }
    private void setUpRecyclerView() {
        Query query = notebookRef.orderBy("title", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Food> options = new FirestoreRecyclerOptions.Builder<Food>()
                .setQuery(query, Food.class)
                .build();
        adapter = new AdapterFood(options);
        RecyclerView recyclerView = binding.rec;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}