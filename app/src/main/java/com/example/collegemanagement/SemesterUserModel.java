package com.example.collegemanagement;

public class SemesterUserModel {
    int id;
    String CourseName, SubOne, TecOne, SubTwo, TecTwo, SubThree, TecThree, SubFour, TecFour, SubFive, TecFive, SubSix, TecSix;

    public SemesterUserModel(int id, String courseName, String subOne, String tecOne, String subTwo, String tecTwo, String subThree, String tecThree, String subFour, String tecFour, String subFive, String tecFive, String subSix, String tecSix) {
        this.id = id;
        CourseName = courseName;
        SubOne = subOne;
        TecOne = tecOne;
        SubTwo = subTwo;
        TecTwo = tecTwo;
        SubThree = subThree;
        TecThree = tecThree;
        SubFour = subFour;
        TecFour = tecFour;
        SubFive = subFive;
        TecFive = tecFive;
        SubSix = subSix;
        TecSix = tecSix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getSubOne() {
        return SubOne;
    }

    public void setSubOne(String subOne) {
        SubOne = subOne;
    }

    public String getTecOne() {
        return TecOne;
    }

    public void setTecOne(String tecOne) {
        TecOne = tecOne;
    }

    public String getSubTwo() {
        return SubTwo;
    }

    public void setSubTwo(String subTwo) {
        SubTwo = subTwo;
    }

    public String getTecTwo() {
        return TecTwo;
    }

    public void setTecTwo(String tecTwo) {
        TecTwo = tecTwo;
    }

    public String getSubThree() {
        return SubThree;
    }

    public void setSubThree(String subThree) {
        SubThree = subThree;
    }

    public String getTecThree() {
        return TecThree;
    }

    public void setTecThree(String tecThree) {
        TecThree = tecThree;
    }

    public String getSubFour() {
        return SubFour;
    }

    public void setSubFour(String subFour) {
        SubFour = subFour;
    }

    public String getTecFour() {
        return TecFour;
    }

    public void setTecFour(String tecFour) {
        TecFour = tecFour;
    }

    public String getSubFive() {
        return SubFive;
    }

    public void setSubFive(String subFive) {
        SubFive = subFive;
    }

    public String getTecFive() {
        return TecFive;
    }

    public void setTecFive(String tecFive) {
        TecFive = tecFive;
    }

    public String getSubSix() {
        return SubSix;
    }

    public void setSubSix(String subSix) {
        SubSix = subSix;
    }

    public String getTecSix() {
        return TecSix;
    }

    public void setTecSix(String tecSix) {
        TecSix = tecSix;
    }
}