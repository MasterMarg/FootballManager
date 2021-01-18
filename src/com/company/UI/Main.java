package com.company.UI;

import com.company.BackEnd.LeagueManager;
import com.company.BackEnd.SoccerPlayer;
import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;
import com.company.Service.Painter;
import com.company.Service.Service;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        LeagueManager leagueManager = Service.createLeagueManager();
        getPrintedByLeague(leagueManager);
        getPrintedByCounty(leagueManager);
    }

    public static void getPrintedByLeague(LeagueManager leagueManager) {
        System.out.println(Painter.getPainted("РЕЙТИНГ ИГРОКОВ ПО ЛИГАМ", Painter.Paint.ANSI_BOLD_BLUE));
        for (League league : League.values()) {
            System.out.println(Painter.getPainted(league.name, Painter.Paint.ANSI_BOLD_BLUE));
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
        System.out.println(Painter.getPainted("РЕЙТИНГ ИГРОКОВ ПО СТРАНАМ", Painter.Paint.ANSI_BOLD_RED));
        for (Country country : Country.values()) {
            System.out.println(Painter.getPainted(country.name, Painter.Paint.ANSI_BOLD_RED));
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