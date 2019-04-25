package com.example.muslimquiz.model;

public class VideoModel {

    private final String image_url;
    private String video_url;
    private final String name;
    private final String description;

    public VideoModel(String video_url, String image_url, String name, String description) {
        this.video_url = video_url;
        this.image_url = image_url;
        this.name = name;
        this.description = description;
    }

    public VideoModel(String image_url, String name, String description) {
        this.image_url = image_url;
        this.name = name;
        this.description = description;
    }

    public VideoModel(String name) {
        this.image_url= null;
        this.description = null;
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
