package com.example.sai.majorproject.DataModel;

public class OrganizationMaster {
    public int org_id,owner_id;
    public String org_name,org_address,org_type,org_info,org_website,org_rating,org_contactinfo,org_logo;

    public OrganizationMaster(int org_id, int owner_id, String org_name, String org_address, String org_type, String org_info, String org_website, String org_rating, String org_contactinfo, String org_logo) {
        this.org_id = org_id;
        this.owner_id = owner_id;
        this.org_name = org_name;
        this.org_address = org_address;
        this.org_type = org_type;
        this.org_info = org_info;
        this.org_website = org_website;
        this.org_rating = org_rating;
        this.org_contactinfo = org_contactinfo;
        this.org_logo = org_logo;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_address() {
        return org_address;
    }

    public void setOrg_address(String org_address) {
        this.org_address = org_address;
    }

    public String getOrg_type() {
        return org_type;
    }

    public void setOrg_type(String org_type) {
        this.org_type = org_type;
    }

    public String getOrg_info() {
        return org_info;
    }

    public void setOrg_info(String org_info) {
        this.org_info = org_info;
    }

    public String getOrg_website() {
        return org_website;
    }

    public void setOrg_website(String org_website) {
        this.org_website = org_website;
    }

    public String getOrg_rating() {
        return org_rating;
    }

    public void setOrg_rating(String org_rating) {
        this.org_rating = org_rating;
    }

    public String getOrg_contactinfo() {
        return org_contactinfo;
    }

    public void setOrg_contactinfo(String org_contactinfo) {
        this.org_contactinfo = org_contactinfo;
    }

    public String getOrg_logo() {
        return org_logo;
    }

    public void setOrg_logo(String org_logo) {
        this.org_logo = org_logo;
    }
}
