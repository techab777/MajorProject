package com.example.sai.majorproject.DataModel;

import java.io.Serializable;

public class TourismPlaceMaster implements Serializable {
    public int place_id;
    public String place_name,place_address,place_info,place_history,place_header_image;

    public TourismPlaceMaster(int place_id, String place_name, String place_address, String place_info, String place_history,String place_header_image) {
        this.place_id = place_id;
        this.place_name = place_name;
        this.place_address = place_address;
        this.place_info = place_info;
        this.place_history = place_history;
        this.place_header_image= place_header_image;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_address() {
        return place_address;
    }

    public void setPlace_address(String place_address) {
        this.place_address = place_address;
    }

    public String getPlace_info() {
        return place_info;
    }

    public void setPlace_info(String place_info) {
        this.place_info = place_info;
    }

    public String getPlace_history() {
        return place_history;
    }

    public void setPlace_history(String place_history) {
        this.place_history = place_history;
    }

    public String getPlace_header_image() {
        return place_header_image;
    }

    public void setPlace_header_image(String place_header_image) {
        this.place_header_image = place_header_image;
    }
}
