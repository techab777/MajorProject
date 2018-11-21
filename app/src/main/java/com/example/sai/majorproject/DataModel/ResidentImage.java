package com.example.sai.majorproject.DataModel;

public class ResidentImage {
    public int resident_image_id,resident_id;
    public String resident_image;

    public ResidentImage(int resident_image_id, int resident_id, String resident_image) {
        this.resident_image_id = resident_image_id;
        this.resident_id = resident_id;
        this.resident_image = resident_image;
    }

    public int getResident_image_id() {
        return resident_image_id;
    }

    public void setResident_image_id(int resident_image_id) {
        this.resident_image_id = resident_image_id;
    }

    public int getResident_id() {
        return resident_id;
    }

    public void setResident_id(int resident_id) {
        this.resident_id = resident_id;
    }

    public String getResident_image() {
        return resident_image;
    }

    public void setResident_image(String resident_image) {
        this.resident_image = resident_image;
    }
}
