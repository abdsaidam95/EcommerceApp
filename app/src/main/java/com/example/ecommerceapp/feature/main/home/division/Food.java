package com.example.ecommerceapp.feature.main.home.division;

public class Food {
    private int image;
    private String title;

    public Food(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public Food() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
