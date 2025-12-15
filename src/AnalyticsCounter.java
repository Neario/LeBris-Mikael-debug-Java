import com.hemebiotech.analytics.data.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.data.interfaces.ISymptomReader;
import com.hemebiotech.analytics.repository.WriteSymptomDataToFile;
import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;

import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    /**
     *
     * @param args
     * @throws Exception
     * Lance un programme afin de lire dans le fichier symptoms ,
     * ligne par ligne afin de compter le nombre de symptome identique et de sortir dans un fichier result.out
     */
	public static void main(String[] args) throws Exception {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        Map<String, Integer> symptoms = new TreeMap<>();
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        for (String symptom : reader.getSymptoms()) {
            int number = symptoms.getOrDefault(symptom, 0) + 1;
            symptoms.put(symptom, number);
        }
        writer.symptomsWriterFile(symptoms);
	}
}
