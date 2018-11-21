package com.example.sai.majorproject.DataModel;

public class EduFeesMaster {
    public int fees_id,course_id;
    public String fees_amount;

    public EduFeesMaster(int fees_id, int course_id, String fees_amount) {
        this.fees_id = fees_id;
        this.course_id = course_id;
        this.fees_amount = fees_amount;
    }

    public int getFees_id() {
        return fees_id;
    }

    public void setFees_id(int fees_id) {
        this.fees_id = fees_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getFees_amount() {
        return fees_amount;
    }

    public void setFees_amount(String fees_amount) {
        this.fees_amount = fees_amount;
    }
}
