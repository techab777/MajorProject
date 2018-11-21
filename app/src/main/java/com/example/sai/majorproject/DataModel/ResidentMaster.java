package com.example.sai.majorproject.DataModel;

public class ResidentMaster {
    public int resident_id,user_id;
    public String resident_name,resident_type,resident_address,resident_number,isbathroomattach;

    public ResidentMaster(int resident_id, int user_id, String resident_name, String resident_type,
                          String resident_address, String resident_number, String isbathroomattach) {
        this.resident_id = resident_id;
        this.user_id = user_id;
        this.resident_name = resident_name;
        this.resident_type = resident_type;
        this.resident_address = resident_address;
        this.resident_number = resident_number;
        this.isbathroomattach = isbathroomattach;
    }

    public int getResident_id() {
        return resident_id;
    }

    public void setResident_id(int resident_id) {
        this.resident_id = resident_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getResident_name() {
        return resident_name;
    }

    public void setResident_name(String resident_name) {
        this.resident_name = resident_name;
    }

    public String getResident_type() {
        return resident_type;
    }

    public void setResident_type(String resident_type) {
        this.resident_type = resident_type;
    }

    public String getResident_address() {
        return resident_address;
    }

    public void setResident_address(String resident_address) {
        this.resident_address = resident_address;
    }

    public String getResident_number() {
        return resident_number;
    }

    public void setResident_number(String resident_number) {
        this.resident_number = resident_number;
    }

    public String getIsbathroomattach() {
        return isbathroomattach;
    }

    public void setIsbathroomattach(String isbathroomattach) {
        this.isbathroomattach = isbathroomattach;
    }
}
