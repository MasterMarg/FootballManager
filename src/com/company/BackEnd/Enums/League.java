package com.company.BackEnd.Enums;

public enum League {
    RUS_PREM_LEAGUE("Российская премьер-лига"),
    LIGA_PORTUGAL("Португальская лига"),
    LIGUE1("Французская лига"),
    CHAMPIONSHIP("Английская вторая лига"),
    BUNDESLIGA("Немецкая лига"),
    SERIE_A("Итальянская лига"),
    LALIGA("Испанская лига"),
    PREMIER_LEAGUE("Английская премьер-лига");

    public final String name;

    League(String name){
        this.name = name;
    }
}
