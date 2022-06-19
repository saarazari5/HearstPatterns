package com.company.HearstPatterns;

import java.util.regex.Pattern;

/**
 * SuchAs is a relation - Np such as Np....
 */
public class SuchAs extends HearstBasePattern {
    @Override
    public String getString() {
        return "such as";
    }

    @Override
    public Pattern getRegex() {
        return super.getRegex();
    }

    @Override
    public void addToDataBase(String string) {
        super.addToDataBase(string);
    }
}