package com.zp.design_pattern.proxy.statics;

public class CurrentMovie implements Movie {
    private String movieName;

    CurrentMovie(String name) {
        this.movieName = name;
    }

    public void play() {
        System.out.println("正在播放" + this.movieName + "...");
    }
}