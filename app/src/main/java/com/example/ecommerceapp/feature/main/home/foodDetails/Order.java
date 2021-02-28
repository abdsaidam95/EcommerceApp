package com.example.ecommerceapp.feature.main.home.foodDetails;

public class Order {
    private String price;
    private int image;
    private String typeFood;
    private String title;
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Order(String price, int image, String typeFood, String title, String num) {
        this.price = price;
        this.image = image;
        this.typeFood = typeFood;
        this.title = title;
        this.num = num;
    }

    public Order() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
