package com.example.gs_server.retrofitpost.Demo3;

import retrofit2.http.Url;

public class Heroes {

    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl;
    private String bio;

    public Heroes() {
    }

    public Heroes(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realname;
    }

    public void setRealName(String realName) {
        this.realname = realName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstAppearence() {
        return firstappearance;
    }

    public void setFirstAppearence(String firstAppearence) {
        this.firstappearance = firstAppearence;
    }

    public String getCreatedBy() {
        return createdby;
    }

    public void setCreatedBy(String createdBy) {
        this.createdby = createdBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return imageurl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageurl = imageUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
