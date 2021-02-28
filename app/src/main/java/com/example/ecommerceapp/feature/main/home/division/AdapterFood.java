package com.example.ecommerceapp.feature.main.home.division;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.databinding.ItemFoodBinding;

import java.util.ArrayList;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.ViewHolder>{
    private ArrayList<Food> items = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFoodBinding itemBinding = ItemFoodBinding.inflate(layoutInflater, parent, false);
        return new AdapterFood.ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setData(ArrayList<Food> data) {
        items.clear();
        items.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemFoodBinding itemBinding;

        public ViewHolder(@NonNull ItemFoodBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Food food) {
            FoodItemViewModel vm = new FoodItemViewModel(food);
            vm.onStart();
            itemBinding.setViewModel(vm);
            itemBinding.executePendingBindings();
        }
    }
}
