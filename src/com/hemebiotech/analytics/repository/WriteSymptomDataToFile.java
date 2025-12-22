package com.hemebiotech.analytics.repository;

import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public final class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filepath;

    public WriteSymptomDataToFile(String filepath) {
        if (filepath == null || filepath.isEmpty()) {
            throw new IllegalArgumentException("The filepath argument cannot be null or empty.");
        }
        this.filepath = filepath;
    }


    /**
     * Write symptoms and occurrence in output file
     *
     * @param symptoms Map contains symptoms and occurrence value
     */
    @Override
    public void symptomsWriterFile(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(this.filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
