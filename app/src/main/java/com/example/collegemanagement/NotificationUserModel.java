package com.example.collegemanagement;

public class NotificationUserModel {
    int id;
    String name,course,phone,year;

    public NotificationUserModel(int id, String name, String course, String phone, String year) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.phone = phone;
        this.year = year;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
