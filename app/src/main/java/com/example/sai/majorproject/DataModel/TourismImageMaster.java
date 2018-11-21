package com.example.sai.majorproject.DataModel;

public class TourismImageMaster {
    public int place_image_id,place_id;
    public String place_image;

    public TourismImageMaster(int place_image_id, int place_id, String place_image) {
        this.place_image_id = place_image_id;
        this.place_id = place_id;
        this.place_image = place_image;
    }

    public int getPlace_image_id() {
        return place_image_id;
    }

    public void setPlace_image_id(int place_image_id) {
        this.place_image_id = place_image_id;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getPlace_image() {
        return place_image;
    }

    public void setPlace_image(String place_image) {
        this.place_image = place_image;
    }
}
