package com.example.collegemanagement;

public class ReviewUserModel {
    int id;
    String name,course,semester,review;

    public ReviewUserModel(int id, String name, String course, String semester, String review) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = semester;
        this.review = review;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
