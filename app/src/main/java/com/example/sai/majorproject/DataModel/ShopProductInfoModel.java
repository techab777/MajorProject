package com.example.sai.majorproject.DataModel;

public class ShopProductInfoModel {

    int img;
    String product_name,product_rating,product_offer;
    Float product_prize;

    public ShopProductInfoModel(int img, String product_name, String product_rating, String product_offer, Float product_prize) {
        this.img = img;
        this.product_name = product_name;
        this.product_rating = product_rating;
        this.product_offer = product_offer;
        this.product_prize = product_prize;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_rating() {
        return product_rating;
    }

    public void setProduct_rating(String product_rating) {
        this.product_rating = product_rating;
    }

    public String getProduct_offer() {
        return product_offer;
    }

    public void setProduct_offer(String product_offer) {
        this.product_offer = product_offer;
    }

    public Float getProduct_prize() {
        return product_prize;
    }

    public void setProduct_prize(Float product_prize) {
        this.product_prize = product_prize;
    }
}
