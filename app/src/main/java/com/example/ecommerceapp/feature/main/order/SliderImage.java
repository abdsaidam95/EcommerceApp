package com.example.ecommerceapp.feature.main.order;

/**
 * @author by EngAbdSaidam
 * project commerce that support dataBinging and MvvMDesignPattern
 */


public class SliderImage {
    public SliderImage(int image, String name, String type, String price, String percent) {
        this.image = image;
        this.name = name;
        this.type = type;
        this.price = price;
        this.percent = percent;
    }

    private int image;
    private String name,type,price,percent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public SliderImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
