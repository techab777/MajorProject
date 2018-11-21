package com.example.sai.majorproject.DataModel;

public class ShopInfoModel {
    String shop_Name,shop_Address,shop_catogeies,shop_rating;
    int shop_icon;

    public ShopInfoModel(String shop_Name, String shop_Address, String shop_catogeies, String shop_rating, int shop_icon) {
        this.shop_Name = shop_Name;
        this.shop_Address = shop_Address;
        this.shop_catogeies = shop_catogeies;
        this.shop_rating = shop_rating;
        this.shop_icon = shop_icon;
    }

    public String getShop_Name() {
        return shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        this.shop_Name = shop_Name;
    }

    public String getShop_Address() {
        return shop_Address;
    }

    public void setShop_Address(String shop_Address) {
        this.shop_Address = shop_Address;
    }

    public String getShop_catogeies() {
        return shop_catogeies;
    }

    public void setShop_catogeies(String shop_catogeies) {
        this.shop_catogeies = shop_catogeies;
    }

    public String getShop_rating() {
        return shop_rating;
    }

    public void setShop_rating(String shop_rating) {
        this.shop_rating = shop_rating;
    }

    public int getShop_icon() {
        return shop_icon;
    }

    public void setShop_icon(int shop_icon) {
        this.shop_icon = shop_icon;
    }
}
