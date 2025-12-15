import com.hemebiotech.analytics.data.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.data.interfaces.ISymptomReader;
import com.hemebiotech.analytics.repository.WriteSymptomDataToFile;
import com.hemebiotech.analytics.repository.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.utils.AnalyticsCounter;
import com.hemebiotech.analytics.utils.interfaces.IAnalyticsCounter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    /**
     *
     * @param args
     * Lance un programme afin de lire dans le fichier symptoms.txt ,
     * ligne par ligne afin de compter le nombre de symptome identique et de sortir dans un fichier result.out
     */
    public static void main(String[] args) {
        final ISymptomReader readerSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
        final ISymptomWriter writeSymptoms = new WriteSymptomDataToFile("result.out");
        final IAnalyticsCounter analyticsCounter = new AnalyticsCounter(readerSymptoms,  writeSymptoms);

        List<String> listSymptoms = readerSymptoms.getSymptoms();
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(listSymptoms);
        analyticsCounter.writeSymptoms(countSymptoms);
    }
}
