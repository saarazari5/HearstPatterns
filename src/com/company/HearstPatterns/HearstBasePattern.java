package com.company.HearstPatterns;
import com.company.HypernymRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MultiNpsRelation is a sentence with more than one Np.
 */
public abstract class HearstBasePattern implements HearstPattern {

    @Override
    public Pattern getRegex() {
        return Pattern.compile(Np.Regex + "(( )(,)( ))? " + this.getString()
                + " (" + Np.Regex + "(( )(,)( ))?)+( ?or | ?and )?(" + Np.Regex + ")?");
    }

    @Override
    public void addToDataBase(String string) {
        Pattern npPattern = Pattern.compile("<np>(.*?)</np>");
        Matcher npMatcher = npPattern.matcher(string);
        try {
            String hyper = null;
            if (npMatcher.find()) {
                hyper = npMatcher.group(1);
            }

            while (npMatcher.find()) {
                String hyponym = npMatcher.group(1);
                HypernymRepository.getInstance().addRelations(hyper, hyponym);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
