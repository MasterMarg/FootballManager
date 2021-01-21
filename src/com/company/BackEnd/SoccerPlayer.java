package com.company.BackEnd;

import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;
import com.company.Service.Service;

public class SoccerPlayer implements SoccerPlayerInterface {
    private String name;
    private final Country country;
    private final League league;
    private int points;

    public SoccerPlayer() {
        this.country = Country.values()[(int) (Math.random() * Country.values().length)];
        this.name = Service.generatePlayerName(this.country);
        this.league = League.values()[(int) (Math.random() * League.values().length)];
        this.points = (int) (Math.random() * 40) + 60;
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
        this.name = Service.generatePlayerName(this.country);
    }
}
