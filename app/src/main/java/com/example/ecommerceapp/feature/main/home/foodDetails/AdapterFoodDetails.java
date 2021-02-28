package com.example.ecommerceapp.feature.main.home.foodDetails;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.databinding.ItemDetailsBinding;

import java.util.ArrayList;

public class AdapterFoodDetails extends RecyclerView.Adapter<AdapterFoodDetails.ViewHolder> {
    private ArrayList<Order> items = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemDetailsBinding itemBinding = ItemDetailsBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setData(ArrayList<Order> data) {
        items.clear();
        items.addAll(data);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemDetailsBinding itemBinding;

        public ViewHolder(@NonNull ItemDetailsBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Order order) {
            ItemViewModel vm = new ItemViewModel(order, getAdapterPosition());
            vm.onStart();
            itemBinding.setViewModel(vm);
            itemBinding.executePendingBindings();
        }
    }
}
