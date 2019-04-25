package com.example.muslimquiz.model;

public class Category {

    private int bg_card;
    private String name_category;

    public Category(int bg_card, String name_category) {
        this.bg_card = bg_card;
        this.name_category = name_category;
    }

    public int getBg_card() {
        return bg_card;
    }

    public void setBg_card(int bg_card) {
        this.bg_card = bg_card;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }
}
