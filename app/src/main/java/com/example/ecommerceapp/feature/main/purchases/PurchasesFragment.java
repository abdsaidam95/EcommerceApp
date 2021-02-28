package com.example.ecommerceapp.feature.main.purchases;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.databinding.FragmentHomeBinding;
import com.example.ecommerceapp.databinding.FragmentPerchesBinding;
import com.example.ecommerceapp.databinding.FragmentPurchasesBinding;
import com.example.ecommerceapp.feature.main.home.HomeViewModel;


public class PurchasesFragment extends Fragment {
  public FragmentPurchasesBinding binding;
  public   PurchesFragmentViewModel viewModelFragment;



    public PurchasesFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPurchasesBinding.inflate(inflater, container, false);

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModelFragment = new ViewModelProvider(requireActivity(), factory).get(PurchesFragmentViewModel.class);
        binding.setViewModel(viewModelFragment);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelFragment.onStart();
    }
}