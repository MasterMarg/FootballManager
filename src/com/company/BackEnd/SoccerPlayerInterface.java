package com.company.BackEnd;

import com.company.Enums.Country;
import com.company.Enums.League;

public interface SoccerPlayerInterface {
    String getFullName();

    Integer getPoints();

    League getLeague();

    Country getCountry();
}
