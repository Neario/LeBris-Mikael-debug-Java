package com.hemebiotech.analytics.utils.interfaces;

import java.util.List;
import java.util.Map;

public interface IAnalyticsCounter {
    public List<String> getSymptoms();
    public Map<String, Integer> countSymptoms(List<String> symptoms);
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms);
    public void writeSymptoms(Map<String, Integer> symptoms);
}
