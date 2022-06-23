package com.example.a20220622juanmartinezleonnycschools.validation;

public class Validator {
    public static Boolean validateCityName(String cityName) {
        return (cityName.length() > 0);
    }
}
