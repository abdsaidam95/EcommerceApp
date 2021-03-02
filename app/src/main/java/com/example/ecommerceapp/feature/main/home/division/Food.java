package com.example.ecommerceapp.feature.main.home.division;

public class Food {
    private String image;
    private String title;

    public Food(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public Food() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
