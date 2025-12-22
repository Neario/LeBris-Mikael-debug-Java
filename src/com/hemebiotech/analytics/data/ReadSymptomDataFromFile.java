package com.hemebiotech.analytics.data;

import com.hemebiotech.analytics.data.interfaces.ISymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    final String filepath;

    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("The filepath argument cannot be null or empty.");
        }
        this.filepath = filepath;
    }

    /**
     * Read input file line by line and return a list
     *
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     */
    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();

            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
