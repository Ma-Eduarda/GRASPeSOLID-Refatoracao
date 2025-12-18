package com.checkr.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filters {
    
    interface Filter {
        List<String[]> apply(List<String[]> csvData, String value);
    }

    static class ColumnFilter implements Filter {
        private final int columnIndex;
        
        public ColumnFilter(int columnIndex) {
            this.columnIndex = columnIndex;
        }
        
        @Override
        public List<String[]> apply(List<String[]> csvData, String value) {
            List<String[]> results = new ArrayList<String[]>();
            
            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[columnIndex].equals(value)) {
                    results.add(csvData.get(i));
                }
            }
            
            return results;
        }
    }

    public static List<String[]> apply(List<String[]> csvData, Map<String, String> options) {
        
        if(options.get("company_name") != null) {
            Filter filter = new ColumnFilter(1);
            csvData = filter.apply(csvData, options.get("company_name"));
        }

        if(options.get("city") != null) {
            Filter filter = new ColumnFilter(4);
            csvData = filter.apply(csvData, options.get("city"));
        }

        if(options.get("state") != null) {
            Filter filter = new ColumnFilter(5);
            csvData = filter.apply(csvData, options.get("state"));
        }

        if(options.get("round") != null) {
            Filter filter = new ColumnFilter(9);
            csvData = filter.apply(csvData, options.get("round"));
        }

        return csvData;
    }
}