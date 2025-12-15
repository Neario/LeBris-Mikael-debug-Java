package com.hemebiotech.analytics.repository;

import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public record WriteSymptomDataToFile(String filepath) implements ISymptomWriter {

    @Override
    public void symptomsWriterFile(Map<String, Integer> symptoms) {
        System.out.println(this.filepath);
        try (FileWriter writer = new FileWriter(this.filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
