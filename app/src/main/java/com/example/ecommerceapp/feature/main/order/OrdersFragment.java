package com.example.ecommerceapp.feature.main.order;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class OrdersFragment extends Fragment {
    public View view;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    List<SliderImage> list;
    public SliderAdapter sliderAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_orders, container, false);
        viewPager2=view.findViewById(R.id.pager);
        tabLayout=view.findViewById(R.id.tab);
        list=new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sliderAdapter=new SliderAdapter(list);
        list.add(new SliderImage(R.drawable.ic_cleaning,"name","notella","50$","50%"));
        list.add(new SliderImage(R.drawable.ic_cleaning,"name","notella","50$","50%"));
        list.add(new SliderImage(R.drawable.ic_cleaning,"name","notella","50$","50%"));
        list.add(new SliderImage(R.drawable.ic_cleaning,"name","notella","50$","50%"));
        list.add(new SliderImage(R.drawable.ic_cleaning,"name","notella","50$","50%"));
        list.add(new SliderImage(R.drawable.ic_cleaning,"name","notella","50$","50%"));
        viewPager2.setAdapter(sliderAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                if (tab.getPosition()==list.size()){}
                else {
                    tab.setText(" " + (position + 1));
                    viewPager2.setCurrentItem(tab.getPosition(), true);
                }

            }
        }).attach();
    }
}