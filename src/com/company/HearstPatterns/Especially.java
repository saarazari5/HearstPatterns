package com.company.HearstPatterns;
import java.util.regex.Pattern;

/**
 * Especially is a relation - Np especially Np....
 */
public class Especially extends HearstBasePattern {
    @Override
    public String getString() {
        return "especially";
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
