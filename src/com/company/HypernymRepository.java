package com.company;
import java.util.TreeMap;

/**
 * singleton repository.
 */
public final class HypernymRepository {
     private static final HypernymRepository INSTANCE;
     private final TreeMap<String, TreeMap<String, Integer>> database = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    static {
        INSTANCE = new HypernymRepository();
    }

    private HypernymRepository() {
    }

    /**
     * @return shared instance.
     */
    public static HypernymRepository getInstance() {
        return INSTANCE;
    }

    /**
     * @param hypernym key.
     * @param hyponym value.
     */
    public void addRelations(String hypernym, String hyponym) {
        if (!this.database.containsKey(hypernym)) {
            this.database.put(hypernym, new TreeMap<>());
            this.database.get(hypernym).put(hyponym, 1);
            return;
        }
        if (this.database.get(hypernym).containsKey(hyponym)) {
            int current = this.database.get(hypernym).get(hyponym);
            this.database.get(hypernym).put(hyponym, current + 1);
            return;
        }
        this.database.get(hypernym).put(hyponym, 1);
    }

    /**
     * Return the map of the database.
     * @return the map of the database.
     */
    public TreeMap<String, TreeMap<String, Integer>> getDatabase() {
        return this.database;
    }

    /**
     * Returns the number of hyponyms the received hypernym has.
     * @param hypernym - the hypernym we want to know how much hyponyms he has.
     * @return the number of hyponyms the received hypernym has. if it dosent exist in the database,
     * returns -1.
     */
    public int numOfHypernyms(String hypernym) {
        if (this.database.containsKey(hypernym)) {
            return this.database.get(hypernym).size();
        }
        return -1;
    }
    /**
     * Returns true if the received hyponym exist in the database.
     * @param hyponym - the hyponym to be know if exist.
     * @return true if it is exist in the database and false otherwise.
     */
    public boolean doesHyponymExist(String hyponym) {
        for (String hyper:this.database.keySet()) {
            for (String currentHyponym:this.database.get(hyper).keySet()) {
                if (currentHyponym.equals(hyponym)) {
                    return true;
                }
            }
        }
        return false;
    }
}
