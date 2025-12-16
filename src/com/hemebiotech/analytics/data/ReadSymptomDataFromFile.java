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
public record ReadSymptomDataFromFile(String filepath) implements ISymptomReader {

    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile {
    }

    /**
     * Read input file line by line and return a list
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     */
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filepath != null) {
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
        }
        return result;
    }

}
