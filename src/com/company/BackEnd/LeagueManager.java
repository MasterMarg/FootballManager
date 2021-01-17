package com.company.BackEnd;

import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;
import com.company.Service.PlayerNameAlreadyTakenException;

import java.util.ArrayList;

public class LeagueManager implements LeagueManagerInterface {
    private final ArrayList<SoccerPlayer> playerList;

    public LeagueManager() {
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(SoccerPlayer player) {
        boolean isNameDefined = false;
        while (!isNameDefined) {
            try {
                for (SoccerPlayer soccerPlayer : this.playerList) {
                    if (soccerPlayer.getFullName().equals(player.getFullName()))
                        throw new PlayerNameAlreadyTakenException();
                }
                isNameDefined = true;
                this.playerList.add(player);
            } catch (PlayerNameAlreadyTakenException exception) {
                player.renamePlayer();
            }
        }
    }

    public void removePlayer(SoccerPlayer player) {
        this.playerList.removeIf(soccerPlayer -> player == soccerPlayer);
    }

    public SoccerPlayer getPlayer(String name) {
        for (SoccerPlayer player : this.playerList) {
            if (player.getFullName().equals(name)) return player;
        }
        return null;
    }

    public SoccerPlayer[] getAllPlayers() {
        return this.playerList.toArray(SoccerPlayer[]::new);
    }

    public SoccerPlayer[] getPlayers(League league) {
        ArrayList<SoccerPlayer> leagueList = new ArrayList<>();
        for (SoccerPlayer player : this.playerList) {
            if (player.getLeague() == league) leagueList.add(player);
        }
        return leagueList.toArray(SoccerPlayer[]::new);
    }

    public SoccerPlayer[] getPlayers(Country country) {
        ArrayList<SoccerPlayer> countryList = new ArrayList<>();
        for (SoccerPlayer player : this.playerList) {
            if (player.getCountry() == country) countryList.add(player);
        }
        return countryList.toArray(SoccerPlayer[]::new);
    }

    public void addPoints(String name, int points) {
        for (SoccerPlayer player : this.playerList) {
            if (player.getFullName().equals(name)) player.addPoints(points);
        }
    }

}
