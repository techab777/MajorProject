package com.example.sai.majorproject.DataModel;

public class ShoppingHomeModel {
    public int shopping_categorie_image,shopping_categorie_id;
    public String shopping_categorie;

    public ShoppingHomeModel(int shopping_categorie_image, int shopping_categorie_id, String shopping_categorie) {
        this.shopping_categorie_image = shopping_categorie_image;
        this.shopping_categorie_id = shopping_categorie_id;
        this.shopping_categorie = shopping_categorie;
    }

    public int getShopping_categorie_image() {
        return shopping_categorie_image;
    }

    public void setShopping_categorie_image(int shopping_categorie_image) {
        this.shopping_categorie_image = shopping_categorie_image;
    }

    public int getShopping_categorie_id() {
        return shopping_categorie_id;
    }

    public void setShopping_categorie_id(int shopping_categorie_id) {
        this.shopping_categorie_id = shopping_categorie_id;
    }

    public String getShopping_categorie() {
        return shopping_categorie;
    }

    public void setShopping_categorie(String shopping_categorie) {
        this.shopping_categorie = shopping_categorie;
    }
}
