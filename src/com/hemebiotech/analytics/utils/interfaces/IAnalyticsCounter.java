package com.hemebiotech.analytics.utils.interfaces;

import java.util.List;
import java.util.Map;

public interface IAnalyticsCounter {

    /**
     *
     * @return List of all symptoms who can contains duplicate symptom
     */
    List<String> getSymptoms();

    /**
     * Counts how many times each symptom appears in the list.
     * @param symptoms list of symptom names who can contains duplicate symptom
     * @return Sorted Map where keys are symptom names and values are their occurrence counts
     */
    Map<String, Integer> countSymptoms(List<String> symptoms);

    /**
     * Waiting Map and give new Map sorted by their names in alphabetical order.
     * @param symptoms Map contains symptoms and occurrence counts
     * @return Sorted Map by their names in alphabetical order
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms);

    /**
     * Writes the given symptoms and their occurrence counts to an output file.
     * @param symptoms Map contains symptoms and occurrence value
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
