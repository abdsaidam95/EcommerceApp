package com.example.ecommerceapp.feature.main.home.division;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.databinding.ItemFoodBinding;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class AdapterFood  extends FirestoreRecyclerAdapter<Food, AdapterFood.ViewHolder> {
    private ArrayList<Food> items = new ArrayList<>();

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterFood(@NonNull FirestoreRecyclerOptions<Food> options) {
        super(options);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFoodBinding itemBinding = ItemFoodBinding.inflate(layoutInflater, parent, false);
        return new AdapterFood.ViewHolder(itemBinding);
    }



    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Food model) {
        Log.d("rrrrr","ffdg");
        holder.bind(model);


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
