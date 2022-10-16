package com.example.myfitness.Activity.Models;

public class plan {
    private String pname;
    private String pdesc;
    private String sgoal;
    private String dweek;
    private String postId;

    public plan(String pname, String pdesc, String sgoal, String dweek, String postId) {
        this.pname = pname;
        this.pdesc = pdesc;
        this.sgoal = sgoal;
        this.dweek = dweek;
        this.postId = postId;
    }


    public plan() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getSgoal() {
        return sgoal;
    }

    public void setSgoal(String sgoal) {
        this.sgoal = sgoal;
    }

    public String getDweek() {
        return dweek;
    }

    public void setDweek(String dweek) {
        this.dweek = dweek;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
