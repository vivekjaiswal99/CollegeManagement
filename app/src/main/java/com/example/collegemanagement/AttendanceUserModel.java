package com.example.collegemanagement;

public class AttendanceUserModel {
    int id;
    String  name,father,phone,present,absent;

    public AttendanceUserModel(int id, String name, String father, String phone, String present, String absent) {
        this.id = id;
        this.name = name;
        this.father = father;
        this.phone = phone;
        this.present = present;
        this.absent = absent;
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

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }
}
