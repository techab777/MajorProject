package com.example.sai.majorproject.DataModel;

public class HotelImage {
    public int hotel_image_id,hotel_id;
    public String hotel_image;

    public HotelImage(int hotel_image_id, int hotel_id, String hotel_image) {
        this.hotel_image_id = hotel_image_id;
        this.hotel_id = hotel_id;
        this.hotel_image = hotel_image;
    }

    public int getHotel_image_id() {
        return hotel_image_id;
    }

    public void setHotel_image_id(int hotel_image_id) {
        this.hotel_image_id = hotel_image_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_image() {
        return hotel_image;
    }

    public void setHotel_image(String hotel_image) {
        this.hotel_image = hotel_image;
    }
}
