package com.example.ecommerceapp.feature.main.purchases;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.databinding.ItemDetailsBinding;
import com.example.ecommerceapp.databinding.ItemPerchesBinding;
import com.example.ecommerceapp.feature.main.home.foodDetails.AdapterFoodDetails;
import com.example.ecommerceapp.feature.main.home.foodDetails.ItemViewModel;
import com.example.ecommerceapp.feature.main.home.foodDetails.Order;

import java.util.ArrayList;

public class AdapterPerches extends RecyclerView.Adapter<AdapterPerches.ViewHolder>{
    private ArrayList<Perches> items = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPerchesBinding itemBinding = ItemPerchesBinding.inflate(layoutInflater, parent, false);
        return new AdapterPerches.ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setData(ArrayList<Perches> data) {
        items.clear();
        items.addAll(data);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemPerchesBinding itemBinding;

        public ViewHolder(@NonNull ItemPerchesBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Perches order) {
            PerchesAdapterViewModels vm = new PerchesAdapterViewModels(order, getAdapterPosition());
            vm.onStart();
            itemBinding.setViewModel(vm);
            itemBinding.executePendingBindings();
        }
    }
}
