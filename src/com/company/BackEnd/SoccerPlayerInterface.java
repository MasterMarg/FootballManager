package com.company.BackEnd;

import com.company.BackEnd.Enums.Country;
import com.company.BackEnd.Enums.League;

public interface SoccerPlayerInterface {
    String getFullName();

    Integer getPoints();

    League getLeague();

    Country getCountry();
}
