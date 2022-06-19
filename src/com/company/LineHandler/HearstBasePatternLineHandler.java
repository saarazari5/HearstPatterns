package com.company.LineHandler;
import com.company.HearstPatterns.HearstBasePattern;
import java.util.regex.Matcher;

/**
 * LineHandler for Hearst Patterns.
 */
public class HearstBasePatternLineHandler implements  LineHandler {

    private final HearstBasePattern hearstBasePattern;

    /**
     * @param hearstBasePattern the pattern to provide the regex from.
     */
    public HearstBasePatternLineHandler(HearstBasePattern hearstBasePattern) {
        this.hearstBasePattern = hearstBasePattern;
    }

    /**
     * @return the pattern.
     */
    public HearstBasePattern getHearstBasePattern() {
        return hearstBasePattern;
    }

    @Override
    public boolean process(String line) {
        if (!line.contains(this.hearstBasePattern.getString())) {
            return false;
        }
        Matcher matcher = hearstBasePattern.getRegex().matcher(line);
        int counter = 0;
        while (matcher.find()) {
            counter++;
            hearstBasePattern.addToDataBase(matcher.group());
        }
        return counter > 0;
    }
}
