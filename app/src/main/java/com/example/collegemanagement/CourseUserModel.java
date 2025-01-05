package com.example.collegemanagement;

public class CourseUserModel {
    int id;
    String name,eligibility,duration,fess,percentage;

    public CourseUserModel(int id, String name, String eligibility, String duration, String fess, String percentage) {
        this.id = id;
        this.name = name;
        this.eligibility = eligibility;
        this.duration = duration;
        this.fess = fess;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFess() {
        return fess;
    }

    public void setFess(String fess) {
        this.fess = fess;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
