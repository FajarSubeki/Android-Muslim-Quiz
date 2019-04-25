package com.example.muslimquiz.model;

public class VideoCategory {

    String name, coin;

    public VideoCategory(String name, String coin) {
        this.name = name;
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }
}
