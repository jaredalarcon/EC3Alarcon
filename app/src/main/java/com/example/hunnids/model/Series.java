package com.example.hunnids.model;

public class Series extends ShowModel{
    private int season;

    public Series(String name, String imgUrl, int season) {
        super(name, imgUrl);
        this.season = season;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
