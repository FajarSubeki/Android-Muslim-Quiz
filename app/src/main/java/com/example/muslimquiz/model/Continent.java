package com.example.muslimquiz.model;

import java.util.ArrayList;

public class Continent {

    String name;
    ArrayList<Score> scoreList = new ArrayList<Score>();

    public Continent(String name, ArrayList<Score> scoreList) {
        this.name = name;
        this.scoreList = scoreList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
