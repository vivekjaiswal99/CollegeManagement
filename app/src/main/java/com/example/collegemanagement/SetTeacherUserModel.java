package com.example.collegemanagement;

public class SetTeacherUserModel {
    int id;
    String name,email,qualification,department,experience,phone;

    public SetTeacherUserModel(int id, String name, String email, String qualification, String department, String experience, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.department = department;
        this.experience = experience;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
