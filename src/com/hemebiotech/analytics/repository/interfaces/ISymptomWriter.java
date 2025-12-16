package com.hemebiotech.analytics.repository.interfaces;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Write symptoms and occurrence in output file
     * @param symptoms Map contains symptoms and occurrence value
     */
    public void symptomsWriterFile(Map<String, Integer> symptoms);
}
