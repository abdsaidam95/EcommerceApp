package com.example.ecommerceapp.feature.onBourding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.databinding.FragmentOnBourdingBinding;

import java.util.Objects;


public class OnBourdingFragment extends Fragment {
    FragmentOnBourdingBinding binding;
    FragmentViewModel viewModelFragment;
    public static OnBourdingFragment newInstance(OnBoarding onBoarding) {
        OnBourdingFragment onBoardingFragment = new OnBourdingFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("onBoarding", onBoarding);

        onBoardingFragment.setArguments(bundle);
        return onBoardingFragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBourdingBinding.inflate(inflater, container, false);

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModelFragment = new ViewModelProvider(requireActivity(), factory).get(FragmentViewModel.class);


        binding.setViewModel(viewModelFragment);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModelFragment.onStart((OnBoarding) Objects.requireNonNull(requireArguments().getSerializable("onBoarding")));

    }
}