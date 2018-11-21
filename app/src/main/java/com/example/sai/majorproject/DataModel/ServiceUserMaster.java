package com.example.sai.majorproject.DataModel;

public class ServiceUserMaster {
    public int service_user_id,user_id,service_id,service_coast;

    public ServiceUserMaster(int service_user_id, int user_id, int service_id, int service_coast) {
        this.service_user_id = service_user_id;
        this.user_id = user_id;
        this.service_id = service_id;
        this.service_coast = service_coast;
    }

    public int getService_user_id() {
        return service_user_id;
    }

    public void setService_user_id(int service_user_id) {
        this.service_user_id = service_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getService_coast() {
        return service_coast;
    }

    public void setService_coast(int service_coast) {
        this.service_coast = service_coast;
    }
}
