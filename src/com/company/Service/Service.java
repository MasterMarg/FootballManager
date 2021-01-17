package com.company.Service;

import com.company.BackEnd.LeagueManager;
import com.company.BackEnd.SoccerPlayer;
import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;

public class Service {

    public static LeagueManager createLeagueManager() {
        LeagueManager leagueManager = new LeagueManager();
        while (leagueManager.getAllPlayers().length < (200 * League.values().length)
                || isNotEnoughPlayersInLeague(leagueManager)
                || isNotEnoughPlayersFromCountry(leagueManager)) {
            leagueManager.addPlayer(new SoccerPlayer());
        }
        return leagueManager;
    }

    public static SoccerPlayer[] sortArray(SoccerPlayer[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - 1 - i; j++) {
                if (players[j].getPoints() < players[j + 1].getPoints()) {
                    SoccerPlayer temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }
        return players;
    }

    public static boolean isNotEnoughPlayersInLeague(LeagueManager leagueManager) {
        for (League league : League.values()) {
            int playerCounter = 0;
            for (SoccerPlayer player : leagueManager.getAllPlayers()) {
                if (player.getLeague() == league) playerCounter++;
                if (playerCounter == 200) break;
            }
            if (playerCounter < 200) return true;
        }
        return false;
    }

    public static boolean isNotEnoughPlayersFromCountry(LeagueManager leagueManager) {
        for (Country country : Country.values()) {
            int playerCounter = 0;
            for (SoccerPlayer player : leagueManager.getAllPlayers()) {
                if (player.getCountry() == country) playerCounter++;
                if (playerCounter == 3) break;
            }
            if (playerCounter < 3) return true;
        }
        return false;
    }
}
