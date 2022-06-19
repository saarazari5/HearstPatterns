package com.company.HearstPatterns;


import java.util.regex.Pattern;

/**
 * Including is a relation - Np including Np....
 */
public class Including extends HearstBasePattern {
    @Override
    public String getString() {
        return "including";
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
