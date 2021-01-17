package com.company;

public class SoccerPlayer implements SoccerPlayerInterface {
    private String name;
    private final Country country;
    private final League league;
    private int points;

    public SoccerPlayer() {
        this.name = generateName();
        this.country = Country.values()[(int) (Math.random() * Country.values().length)];
        this.league = League.values()[(int) (Math.random() * League.values().length)];
        this.points = (int) (Math.random() * 40) + 60;
    }

    private String generateName() {
        String base = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder name = new StringBuilder();
        int size = (int) (Math.random() * 6 + 5);
        for (int index = 0; index < size; index++) {
            if (index==1) name = new StringBuilder(name.toString().toUpperCase());
            name.append(base.toCharArray()[(int) (Math.random() * base.length())]);
        }
        return name.toString();
    }

    public String getFullName() {
        return this.name;
    }

    public Integer getPoints() {
        return this.points;
    }

    public League getLeague() {
        return this.league;
    }

    public Country getCountry() {
        return this.country;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public void renamePlayer() {
        this.name = generateName();
    }
}
