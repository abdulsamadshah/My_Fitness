package com.example.myfitness.Activity.Models;

public class Users {
    private String name;
    private String lastname;
    private String dob;
    private String gender;
    private String userimg;
    private String useremail;


    public Users(String name, String lastname, String dob, String gender, String userimg, String useremail) {
        this.name = name;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.userimg = userimg;
        this.useremail = useremail;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
