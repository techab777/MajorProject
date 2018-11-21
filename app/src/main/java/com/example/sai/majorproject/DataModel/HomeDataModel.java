package com.example.sai.majorproject.DataModel;

public class HomeDataModel {
    public int home_id;
    public String home_categorie,home_categorie_image;

    public HomeDataModel(int home_id, String home_categorie, String home_categorie_image) {
        this.home_id = home_id;
        this.home_categorie = home_categorie;
        this.home_categorie_image = home_categorie_image;
    }

    public int getHome_id() {
        return home_id;
    }

    public void setHome_id(int home_id) {
        this.home_id = home_id;
    }

    public String getHome_categorie() {
        return home_categorie;
    }

    public void setHome_categorie(String home_categorie) {
        this.home_categorie = home_categorie;
    }

    public String getHome_categorie_image() {
        return home_categorie_image;
    }

    public void setHome_categorie_image(String home_categorie_image) {
        this.home_categorie_image = home_categorie_image;
    }
}
