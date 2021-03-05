package com.example.ecommerceapp.feature.main.home.foodDetails;

public class Order {
    private String image;
    private String price ;
    private String title ;
    private String typeFood;
//    private String num;

    //    public String getNum() {
//        return num;
//    }
//
//    public void setNum(String num) {
//        this.num = num;
//    }
    public Order() {
    }

    public Order(String price, String image, String typeFood, String title) {
        this.price = price;
        this.image = image;
        this.typeFood = typeFood;
        this.title = title;
//        this.num = num;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
