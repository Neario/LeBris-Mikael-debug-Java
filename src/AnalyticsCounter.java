import com.hemebiotech.analytics.data.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.data.interfaces.ISymptomReader;
import com.hemebiotech.analytics.repository.WriteSymptomDataToFile;
import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private final ISymptomReader symptomReader;
    private ISymptomWriter symptomWriter;

    public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
        this.symptomReader = symptomReader;
        this.symptomWriter = symptomWriter;
    }

    /**
     *
     * @param args
     * @throws Exception
     * Lance un programme afin de lire dans le fichier symptoms ,
     * ligne par ligne afin de compter le nombre de symptome identique et de sortir dans un fichier result.out
     */
	public static void main(String[] args) throws Exception {

        ISymptomReader symptomReader= new ReadSymptomDataFromFile("symptoms.txt");
        Map<String, Integer> symptoms = new TreeMap<>();
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        for (String symptom : symptomReader.getSymptoms()) {
            int number = symptoms.getOrDefault(symptom, 0) + 1;
            symptoms.put(symptom, number);
        }
        writer.symptomsWriterFile(symptoms);
	}

    public List<String> getSymptoms() {
        return symptomReader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> countSymptoms = new TreeMap<>();
        for (String symptom : symptoms) {
            int number = countSymptoms.getOrDefault(symptom, 0) + 1;
            countSymptoms.put(symptom, number);
        }
        return countSymptoms;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return symptoms;
    }
}
