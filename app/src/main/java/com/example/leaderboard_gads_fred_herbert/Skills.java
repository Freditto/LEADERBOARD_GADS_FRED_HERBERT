package com.example.leaderboard_gads_fred_herbert;

public class Skills {


    public String name, score, hours, badgeUrl;

    public Skills(String name, String score, String hours, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.hours = hours;
        this.badgeUrl = badgeUrl;
    }

    public Skills() {
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
