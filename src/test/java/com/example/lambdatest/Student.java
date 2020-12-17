package com.example.lambdatest;

public class Student {

    private String sId;

    private String sName;

    private String sBirth;

    private String sSex;

    public Student() {
    }

    public Student(String sId, String sName, String sBirth, String sSex) {
        this.sId = sId;
        this.sName = sName;
        this.sBirth = sBirth;
        this.sSex = sSex;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsBirth() {
        return sBirth;
    }

    public void setsBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sBirth='" + sBirth + '\'' +
                ", sSex='" + sSex + '\'' +
                '}';
    }
}
