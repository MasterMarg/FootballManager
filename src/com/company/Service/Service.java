package com.company.Service;

import com.company.BackEnd.LeagueManager;
import com.company.BackEnd.SoccerPlayer;
import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;

import java.util.ArrayList;

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

    public static String generatePlayerName(Country country) {
        String base = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> anotherList = new ArrayList<>();
        String anotherBase = "aeiou";
        String lastBase = "bcdfghjklmnpqrstvwxyz";
        for (Character character : anotherBase.toCharArray()) list.add(character);
        for (Character character : lastBase.toCharArray()) anotherList.add(character);
        StringBuilder name = new StringBuilder();
        int size = (int) (Math.random() * 6 + 5);
        for (int index = 0; index < size; index++) {
            if (index == 1) name = new StringBuilder(name.toString().toUpperCase());
            if (index > 1) {
                char o = name.toString().toCharArray()[index - 1];
                char o1 = name.toString().toCharArray()[index - 2];
                if (list.contains(Character.toLowerCase(o)) &&
                        list.contains(Character.toLowerCase(o1)))
                    name.append(anotherList.get((int) (Math.random() * anotherList.size())));
                else if (anotherList.contains(Character.toLowerCase(o)) &&
                        anotherList.contains(Character.toLowerCase(o1)))
                    name.append(list.get((int) (Math.random() * list.size())));
                else name.append(base.toCharArray()[(int) (Math.random() * base.length())]);
            } else name.append(base.toCharArray()[(int) (Math.random() * base.length())]);
        }
        if (country == Country.POLAND || country == Country.RUSSIA) {
            if (list.contains(name.toString().toCharArray()[name.length() - 3]) &&
                    list.contains(name.toString().toCharArray()[name.length() - 4]))
                name.replace(name.length() - 3, name.length() - 2,
                        Character.toString(lastBase.toCharArray()[(int) (Math.random() * lastBase.length())]));
        }
        if (country == Country.UKRAINE) {
            if (anotherList.contains(name.toString().toCharArray()[name.length() - 3]) &&
                    anotherList.contains(name.toString().toCharArray()[name.length() - 4]))
                name.replace(name.length() - 3, name.length() - 2,
                        Character.toString(anotherBase.toCharArray()[(int) (Math.random() * anotherBase.length())]));
        }
        if (country == Country.POLAND) name.replace(name.length() - 2, name.length(), "ic");
        if (country == Country.RUSSIA) name.replace(name.length() - 2, name.length(), "ov");
        if (country == Country.UKRAINE) name.replace(name.length() - 2, name.length(), "ko");
        return name.toString();
    }
}
