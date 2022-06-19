package com.company.HearstPatterns;
import com.company.HypernymRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SuchAs is a relation - Np which is Np....
 */
public class WhichIs extends HearstBasePattern {
    @Override
    public String getString() {
        return "which is";
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile(Np.Regex + "(( )(,)( ))?" + " " + getString() + " "
                + "((an example|a kind|a class)? of )?" + Np.Regex);
    }

    @Override
    public void addToDataBase(String string) {
        Pattern npPattern = Pattern.compile("<np>(.*?)</np>");
        Matcher npMatcher = npPattern.matcher(string);
        try {
            String hyponym = null;
            if (npMatcher.find()) {
                hyponym = npMatcher.group(1);
            }
            String hyper = null;
            if (npMatcher.find()) {
                hyper = npMatcher.group(1);
            }
            HypernymRepository.getInstance().addRelations(hyper, hyponym);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
