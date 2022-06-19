package com.company;
import java.util.Comparator;
import java.util.Map;

/**
 * Hypernym Comparator for sorting.
 */
public class HypernymComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> hypernym1, Map.Entry<String, Integer> hypernym2) {
        int valueCompare = Integer.compare(hypernym1.getValue(), hypernym2.getValue());
        if (valueCompare != 0) {
            return  -valueCompare;
        }
        return  String.CASE_INSENSITIVE_ORDER.compare(hypernym1.getKey(),  hypernym2.getKey());
    }
}