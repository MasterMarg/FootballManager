package com.company.BackEnd;

import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;

public interface LeagueManagerInterface {
    void addPlayer(SoccerPlayer player);

    void removePlayer(SoccerPlayer player);

    SoccerPlayer getPlayer(String name);

    SoccerPlayer[] getAllPlayers();

    SoccerPlayer[] getPlayers(League league);

    SoccerPlayer[] getPlayers(Country county);

    void addPoints(String name, int points);
}
