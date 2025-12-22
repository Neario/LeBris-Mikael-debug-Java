import com.hemebiotech.analytics.data.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.data.interfaces.ISymptomReader;
import com.hemebiotech.analytics.repository.WriteSymptomDataToFile;
import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.utils.AnalyticsCounter;

import java.util.List;
import java.util.Map;

public class Main {

    public static final String SYMPTOMS_IN = "symptoms.txt";
    public static final String RESULT_OUT = "result.out";

    /**
     *
     * @param args
     * Lance un programme afin de lire dans le fichier symptoms.txt ,
     * ligne par ligne afin de compter le nombre de symptome identique et de sortir dans un fichier result.out
     */
    public static void main(String[] args) {
        final ISymptomReader readerSymptoms = new ReadSymptomDataFromFile(SYMPTOMS_IN);
        final ISymptomWriter writeSymptoms = new WriteSymptomDataToFile(RESULT_OUT);
        final AnalyticsCounter analyticsCounter = new AnalyticsCounter(readerSymptoms,  writeSymptoms);


        List<String> listSymptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(listSymptoms);
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countSymptoms);
        writeSymptoms.symptomsWriterFile(sortedSymptoms);
    }
}
