package com.company.UI;

import com.company.BackEnd.LeagueManager;
import com.company.BackEnd.SoccerPlayer;
import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;
import com.company.Service.Service;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD_RED = "\u001B[31;1m";
    public static final String ANSI_BOLD_BLUE = "\u001B[34;1m";

    public static void main(String[] args) {
        System.out.println();
        LeagueManager leagueManager = Service.createLeagueManager();
        getPrintedByLeague(leagueManager);
        getPrintedByCounty(leagueManager);
    }

    public static void getPrintedByLeague(LeagueManager leagueManager) {
        System.out.println(ANSI_BOLD_BLUE + "РЕЙТИНГ ИГРОКОВ ПО ЛИГАМ" + ANSI_RESET);
        for (League league : League.values()) {
            System.out.print(ANSI_BOLD_BLUE + league.name + ANSI_RESET + "\n");
            for (SoccerPlayer player : Service.sortArray(leagueManager.getPlayers(league))) {
                System.out.print(player.getFullName());
                for (int index = 0; index < (15 - player.getFullName().length()); index++)
                    System.out.print(" ");
                System.out.println(player.getPoints());
            }
            System.out.println();
        }
    }

    public static void getPrintedByCounty(LeagueManager leagueManager) {
        System.out.println(ANSI_BOLD_RED + "РЕЙТИНГ ИГРОКОВ ПО СТРАНАМ" + ANSI_RESET);
        for (Country country : Country.values()) {
            System.out.print(ANSI_BOLD_RED + country.name + ANSI_RESET + "\n");
            for (SoccerPlayer player : Service.sortArray(leagueManager.getPlayers(country))) {
                System.out.print(player.getFullName());
                for (int index = 0; index < (15 - player.getFullName().length()); index++)
                    System.out.print(" ");
                System.out.println(player.getPoints());
            }
            System.out.println();
        }
    }
}