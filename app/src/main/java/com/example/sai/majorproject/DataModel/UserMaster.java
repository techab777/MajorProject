package com.example.sai.majorproject.DataModel;

public class UserMaster {
    public int user_id;
    public String user_name,user_mobileno,user_email,user_password,user_googleid,user_profilepic,fcm_token;

    public UserMaster(int user_id, String user_name, String user_mobileno, String user_email, String user_password, String user_googleid, String user_profilepic, String fcm_token) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_mobileno = user_mobileno;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_googleid = user_googleid;
        this.user_profilepic = user_profilepic;
        this.fcm_token = fcm_token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mobileno() {
        return user_mobileno;
    }

    public void setUser_mobileno(String user_mobileno) {
        this.user_mobileno = user_mobileno;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_googleid() {
        return user_googleid;
    }

    public void setUser_googleid(String user_googleid) {
        this.user_googleid = user_googleid;
    }

    public String getUser_profilepic() {
        return user_profilepic;
    }

    public void setUser_profilepic(String user_profilepic) {
        this.user_profilepic = user_profilepic;
    }
    public void setFcm_token(String fcm_token) {
        this.fcm_token = fcm_token;
    }
    public String getFcm_token() {
        return fcm_token;
    }


}
