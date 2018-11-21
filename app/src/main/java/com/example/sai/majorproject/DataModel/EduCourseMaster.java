package com.example.sai.majorproject.DataModel;

public class EduCourseMaster {
    public int course_id,org_id;
    public String course_name;

    public EduCourseMaster(int course_id, int org_id, String course_name) {
        this.course_id = course_id;
        this.org_id = org_id;
        this.course_name = course_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
