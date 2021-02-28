package com.example.ecommerceapp.feature.main.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ecommerceapp.R;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>  {
    public List<SliderImage> list;
    private ViewPager2 viewPager2;
    public int position;

    public SliderAdapter(List<SliderImage> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slider_image,parent
                ,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class SliderViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView percent,type,name,price;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            percent=itemView.findViewById(R.id.percent);
            type=itemView.findViewById(R.id.text2);
            name=itemView.findViewById(R.id.text1);
            price=itemView.findViewById(R.id.price);
        }
        public void setImage(SliderImage sliderImage){
            imageView.setImageResource(sliderImage.getImage());
            percent.setText(sliderImage.getPercent());
            type.setText(sliderImage.getType());
            name.setText(sliderImage.getName());
            price.setText(sliderImage.getPrice());

        }

    }
}
