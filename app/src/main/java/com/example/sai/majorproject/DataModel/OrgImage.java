package com.example.sai.majorproject.DataModel;

public class OrgImage {
    public  int image_id,org_id;
    public  String image;

    public OrgImage(int image_id, int org_id, String image) {
        this.image_id = image_id;
        this.org_id = org_id;
        this.image = image;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
