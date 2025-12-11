package com.checkr.interviews;

import java.util.*;

public class Filters {
    
    public static List<String[]> apply(List<String[]> csvData, Map<String, String> options) {
        
        if(options.containsKey("company_name")) {
            List<String[]> results = new ArrayList<String[]>();

            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[1].equals(options.get("company_name"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if(options.containsKey("city")) {
            List<String[]> results = new ArrayList<String[]>();

            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[4].equals(options.get("city"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if(options.containsKey("state")) {
            List<String[]> results = new ArrayList<String[]>();

            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[5].equals(options.get("state"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if(options.containsKey("round")) {
            List<String[]> results = new ArrayList<String[]>();

            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[9].equals(options.get("round"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        return csvData;
    }
}
