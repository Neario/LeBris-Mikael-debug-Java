package com.hemebiotech.analytics.utils;

import com.hemebiotech.analytics.data.interfaces.ISymptomReader;
import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.utils.interfaces.IAnalyticsCounter;

import java.util.*;

public final class AnalyticsCounter implements IAnalyticsCounter {
    private final ISymptomReader symptomReader;
    private final ISymptomWriter symptomWriter;

    public AnalyticsCounter(ISymptomReader symptomReader,
                            ISymptomWriter symptomWriter) {
        this.symptomReader = symptomReader;
        this.symptomWriter = symptomWriter;
    }

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
        Map<String, Integer> countSymptoms = new HashMap<>();
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
