package com.company;

import java.rmi.UnexpectedException;

/**
 * Discover hypernym class.
 */
public class DiscoverHypernym {
    /**
     * Main 2 to ass7 - gets a corpus path and a lemma and prints the lemma's hypernyms in the corpus and the
     * number of relation between them for each hypernym.
     * @param args - command line arguments - corpus path and destination path.
     */
    public static void main(String[] args) throws UnexpectedException {

        if (args.length < 2) {
            throw new UnexpectedException("Must get two args!");
        }
        new CreateHypernymDatabase().initDataBase(args[0], null);

        StringBuilder lemma = new StringBuilder(args[1]);

        if (args.length > 2) {
            for (int i = 2; i < args.length; i++) {
                lemma.append(" ").append(args[i]);
            }
        }

        Utils.findAppearances(lemma.toString());
    }
}
