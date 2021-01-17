package com.company;

public interface LeagueManagerInterface {
    void addPlayer(SoccerPlayer player);

    void removePlayer(SoccerPlayer player);

    SoccerPlayer getPlayer(String name);

    SoccerPlayer[] getAllPlayers();

    SoccerPlayer[] getPlayers(League league);

    SoccerPlayer[] getPlayers(Country county);

    void addPoints(String name, int points);
}
