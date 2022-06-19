package com.company.HearstPatterns;

import java.util.regex.Pattern;

/**
 * As is a relation - Such Np as Np....
 */
public class As extends HearstBasePattern {
    @Override
    public String getString() {
        return "as";
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile("such " + Np.Regex + "(( )(,)( ))? " + this.getString() + " (" + Np.Regex
                + "(( )(,)( ))?)+( ?or | ?and )?(" + Np.Regex + ")?");

    }

    @Override
    public void addToDataBase(String string) {
        super.addToDataBase(string);
    }
}
