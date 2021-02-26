package com.example.ecommerceapp.feature.onBourding;


import com.example.ecommerceapp.R;

import java.io.Serializable;

public class OnBoarding implements Serializable {

    private int image = R.drawable.ic_bord1;
    private int title = R.string.app_name;

    public OnBoarding() {
    }

    public OnBoarding(int image, int title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
