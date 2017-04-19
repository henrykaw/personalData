package com.student.sjh.datacog.model;



public class Items {

    private String name, score, score1;

    public Items() {
    }

    public Items(String name, String score, String score1) {

        this.name = name;
        this.score = score;
        this.score1= score1;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }
}