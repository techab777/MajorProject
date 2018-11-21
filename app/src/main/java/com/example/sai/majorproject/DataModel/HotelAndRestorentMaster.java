package com.example.sai.majorproject.DataModel;

public class HotelAndRestorentMaster{
    public int hotel_id,user_id;
    public  String hotel_name,hotel_contactno,hotel_address,hotel_roomdetail,hotel_rating,hotel_info,hotel_website;

    public HotelAndRestorentMaster(int hotel_id, int user_id, String hotel_name, String hotel_contactno, String hotel_address, String hotel_roomdetail, String hotel_rating, String hotel_info, String hotel_website) {
        this.hotel_id = hotel_id;
        this.user_id = user_id;
        this.hotel_name = hotel_name;
        this.hotel_contactno = hotel_contactno;
        this.hotel_address = hotel_address;
        this.hotel_roomdetail = hotel_roomdetail;
        this.hotel_rating = hotel_rating;
        this.hotel_info = hotel_info;
        this.hotel_website = hotel_website;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_contactno() {
        return hotel_contactno;
    }

    public void setHotel_contactno(String hotel_contactno) {
        this.hotel_contactno = hotel_contactno;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_roomdetail() {
        return hotel_roomdetail;
    }

    public void setHotel_roomdetail(String hotel_roomdetail) {
        this.hotel_roomdetail = hotel_roomdetail;
    }

    public String getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(String hotel_rating) {
        this.hotel_rating = hotel_rating;
    }

    public String getHotel_info() {
        return hotel_info;
    }

    public void setHotel_info(String hotel_info) {
        this.hotel_info = hotel_info;
    }

    public String getHotel_website() {
        return hotel_website;
    }

    public void setHotel_website(String hotel_website) {
        this.hotel_website = hotel_website;
    }



}
