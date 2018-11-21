package com.example.sai.majorproject.DataModel;

public class HealthcareDrMaster {
    public int dr_id,org_id;
    public String dr_name,dr_education,dr_specialization,dr_contactno,dr_pofilepic;

    public HealthcareDrMaster(int dr_id, int org_id, String dr_name, String dr_education, String dr_specialization,
                              String dr_contactno, String dr_pofilepic) {
        this.dr_id = dr_id;
        this.org_id = org_id;
        this.dr_name = dr_name;
        this.dr_education = dr_education;
        this.dr_specialization = dr_specialization;
        this.dr_contactno = dr_contactno;
        this.dr_pofilepic = dr_pofilepic;
    }

    public int getDr_id() {
        return dr_id;
    }

    public void setDr_id(int dr_id) {
        this.dr_id = dr_id;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getDr_education() {
        return dr_education;
    }

    public void setDr_education(String dr_education) {
        this.dr_education = dr_education;
    }

    public String getDr_specialization() {
        return dr_specialization;
    }

    public void setDr_specialization(String dr_specialization) {
        this.dr_specialization = dr_specialization;
    }

    public String getDr_contactno() {
        return dr_contactno;
    }

    public void setDr_contactno(String dr_contactno) {
        this.dr_contactno = dr_contactno;
    }

    public String getDr_pofilepic() {
        return dr_pofilepic;
    }

    public void setDr_pofilepic(String dr_pofilepic) {
        this.dr_pofilepic = dr_pofilepic;
    }
}
