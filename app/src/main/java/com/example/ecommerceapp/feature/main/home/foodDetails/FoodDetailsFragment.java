package com.example.ecommerceapp.feature.main.home.foodDetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.databinding.FragmentFoodDetailsBinding;
import com.example.ecommerceapp.databinding.FragmentHomeBinding;
import com.example.ecommerceapp.feature.main.home.HomeViewModel;
import com.example.ecommerceapp.util.eventBusModel.ActionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class FoodDetailsFragment extends Fragment {
    FragmentFoodDetailsBinding binding;
    FoodDetailsViewModel viewModelFragment;


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