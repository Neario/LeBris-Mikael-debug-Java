package com.hemebiotech.analytics.utils;

import com.hemebiotech.analytics.data.interfaces.ISymptomReader;
import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.utils.interfaces.IAnalyticsCounter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public record AnalyticsCounter(ISymptomReader symptomReader,
                               ISymptomWriter symptomWriter) implements IAnalyticsCounter {

    /**
     * {@inheritDoc}
     */
    public List<String> getSymptoms() {
        return symptomReader.getSymptoms();
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> countSymptoms = new TreeMap<>();
        for (String symptom : symptoms) {
            int number = countSymptoms.getOrDefault(symptom, 0) + 1;
            countSymptoms.put(symptom, number);
        }
        return countSymptoms;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * {@inheritDoc}
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        symptomWriter.symptomsWriterFile(symptoms);
    }
}
