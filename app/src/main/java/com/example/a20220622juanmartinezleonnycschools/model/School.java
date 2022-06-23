package com.example.a20220622juanmartinezleonnycschools.model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class School implements Serializable{
    @SerializedName("dbn") public String dbn;
    @SerializedName("school_name") public String schoolName;
    @SerializedName("school_email") public String schoolEmail;
    @SerializedName("location") public String location;
    @SerializedName("phone_number") public String phoneNumber;
    @SerializedName("overview_paragraph") public String overviewParagraph;

    public String getOverviewParagraph() { return overviewParagraph;}

    public void setOverviewParagraph(String overviewParagraph) { this.overviewParagraph = overviewParagraph;}

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
