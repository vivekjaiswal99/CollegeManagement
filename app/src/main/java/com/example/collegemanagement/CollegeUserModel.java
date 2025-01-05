package com.example.collegemanagement;

public class CollegeUserModel {
    int id;
    String name,established,ranking,pass,placement,location,number;

    public CollegeUserModel(int id, String name, String established, String ranking, String pass, String placement, String location, String number) {
        this.id = id;
        this.name = name;
        this.established = established;
        this.ranking = ranking;
        this.pass = pass;
        this.placement = placement;
        this.location = location;
        this.number = number;
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

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
