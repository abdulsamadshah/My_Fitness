package com.example.myfitness.Activity.Models;

public class category {
    private String cimg;
    private String cname;
    private String cvideo;
    private String cdescription;
    private String subdescriptions;
    private String seconddescription;

    public category(String cimg, String cname, String cvideo, String cdescription, String subdescriptions, String seconddescription) {
        this.cimg = cimg;
        this.cname = cname;
        this.cvideo = cvideo;
        this.cdescription = cdescription;
        this.subdescriptions = subdescriptions;
        this.seconddescription = seconddescription;
    }

    public category() {
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCvideo() {
        return cvideo;
    }

    public void setCvideo(String cvideo) {
        this.cvideo = cvideo;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    public String getSubdescriptions() {
        return subdescriptions;
    }

    public void setSubdescriptions(String subdescriptions) {
        this.subdescriptions = subdescriptions;
    }

    public String getSeconddescription() {
        return seconddescription;
    }

    public void setSeconddescription(String seconddescription) {
        this.seconddescription = seconddescription;
    }
}


