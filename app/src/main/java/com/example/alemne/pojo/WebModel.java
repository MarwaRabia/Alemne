package com.example.alemne.pojo;

public class WebModel {
    private  int image;
    private int title;
    private int body;
    private String link;

    public WebModel(int image, int title, int body, String link) {
        this.image = image;
        this.title = title;
        this.body = body;
        this.link = link;
    }


    public int getImage() {
        return image;
    }

    public int getTitle() {
        return title;
    }

    public int getBody() {
        return body;
    }

    public String getLink() {
        return link;
    }
}
