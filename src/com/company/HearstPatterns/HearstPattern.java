package com.company.HearstPatterns;
import java.util.regex.Pattern;

/**
 * Relation between hypernym and hyponym.
 */
public interface HearstPattern {

    /**
     * Return the string of the relation.
     * @return the string of the relation.
     */
    String getString();

    /**
     * Return the regex of the relation.
     * @return the regex of the relation.
     */
    Pattern getRegex();

    /**
     * Receives a string of sentence that contain the relation.
     * Extract the relation from the sentence and add it ot he data base.
     * @param string - sentence that contain the relation.
     */
    void addToDataBase(String string);
}
