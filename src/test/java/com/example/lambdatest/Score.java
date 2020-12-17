package com.example.lambdatest;

public class Score {

    private String sId;

    private String cId;

    private int sScore;


    public Score() {
    }

    public Score(String sId, String cId, int sScore) {
        this.sId = sId;
        this.cId = cId;
        this.sScore = sScore;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public int getsScore() {
        return sScore;
    }

    public void setsScore(int sScore) {
        this.sScore = sScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sId='" + sId + '\'' +
                ", cId='" + cId + '\'' +
                ", sScore=" + sScore +
                '}';
    }
}
