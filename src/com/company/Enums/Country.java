package com.company.Enums;

public enum Country {
    RUSSIA("Россия"),
    USA("США"),
    HUNGARY("Венгрия"),
    NETHERLANDS("Нидерланды"),
    GERMANY("Германия"),
    POLAND("Польша"),
    UKRAINE("Украина"),
    AUSTRIA("Австрия"),
    PORTUGAL("Португалия"),
    SPAIN("Испания"),
    FRANCE("Франция"),
    BRAZIL("Бразилия"),
    ARGENTINA("Аргентина"),
    DENMARK("Дания"),
    SWEDEN("Швеция"),
    ENGLAND("Англия"),
    ITALY("Италия"),
    SWITZERLAND("Швейцария");

    public final String name;

    Country(String name) {
        this.name = name;
    }
}
