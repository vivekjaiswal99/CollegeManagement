package com.example.collegemanagement;

public class StudentCallNumberUserModel {
    String name,phone,course;
    public StudentCallNumberUserModel(String name, String phone, String course) {
        this.name = name;
        this.phone = phone;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
