package com.example.sai.majorproject.DataModel;

public class ServiceMaster {
    public int service_id,service_icon;
    public String service_type,service_ic_bg_color;

    public ServiceMaster(int service_id, int service_icon, String service_type, String service_ic_bg_color) {
        this.service_id = service_id;
        this.service_icon = service_icon;
        this.service_type = service_type;
        this.service_ic_bg_color = service_ic_bg_color;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getService_icon() {
        return service_icon;
    }

    public void setService_icon(int service_icon) {
        this.service_icon = service_icon;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_ic_bg_color() {
        return service_ic_bg_color;
    }

    public void setService_ic_bg_color(String service_ic_bg_color) {
        this.service_ic_bg_color = service_ic_bg_color;
    }
}
