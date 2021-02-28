package com.example.ecommerceapp.feature.main.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.base.BaseFragment;
import com.example.ecommerceapp.databinding.FragmentHomeBinding;
import com.example.ecommerceapp.databinding.FragmentOnBourdingBinding;
import com.example.ecommerceapp.feature.login.LoginActivity;
import com.example.ecommerceapp.feature.onBourding.FragmentViewModel;
import com.example.ecommerceapp.util.AppAction;


public class HomeFragment extends BaseFragment {
    FragmentHomeBinding binding;
    HomeViewModel viewModelFragment;



    public HomeFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModelFragment = new ViewModelProvider(requireActivity(), factory).get(HomeViewModel.class);
        binding.setViewModel(viewModelFragment);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelFragment.doAction.observe((LifecycleOwner) getContext(), action -> {
            if (action == AppAction.ACTION_GO_DIVISION) {
                Toast.makeText(getContext(), "ddssddsdsds", Toast.LENGTH_SHORT).show();

            }
        });
    }
}