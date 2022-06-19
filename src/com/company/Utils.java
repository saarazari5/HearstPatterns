package com.company;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Utils functions.
 */
public class Utils {
    /**
     * gets a hyponym and a database and prints the hyponym's hypernyms and the number of Appearances in each of them.
     * @param hyponym - the hyponym we want to get it's hypernyms.
     */
    public static void findAppearances(String hyponym) {
        HypernymRepository database = HypernymRepository.getInstance();
        if (!database.doesHyponymExist(hyponym)) {
            System.out.println("The lemma doesn't appear in the corpus.");
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        database.getDatabase().forEach((key, value) -> {
            if (value.containsKey(hyponym)) {
                map.put(key, value.get(hyponym));
            }
        });
        printAppearancesByOrder(map);
    }

    /**
     * Prints the map in descending order by values.
     * @param map - the map we want to print.
     */
    public static void printAppearancesByOrder(TreeMap<String, Integer> map) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(new HypernymComparator())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        sortedMap.forEach((key, value) -> System.out.println(key + ": (" + value + ")"));
    }
}

