package com.checkr.interviews;

import java.util.*;

public class Finder {
    
    public static Map<String, String> findFirst(List<String[]> csvData,Map<String, String> options) 
            throws NoSuchEntryException {
        
        Map<String, String> mapped = new HashMap<String, String>();

        for(int i = 0; i < csvData.size(); i++) {
            
            if(options.containsKey("company_name")) {
                if(csvData.get(i)[1].equals(options.get("company_name"))) {
                    mapped = RowMapper.map(csvData.get(i));
                } else {
                    continue;
                }
            }

            if(options.containsKey("city")) {
                if(csvData.get(i)[4].equals(options.get("city"))) {
                    mapped = RowMapper.map(csvData.get(i));
                } else {
                    continue;
                }
            }

            if(options.containsKey("state")) {
                if(csvData.get(i)[5].equals(options.get("state"))) {
                    mapped = RowMapper.map(csvData.get(i));
                } else {
                    continue;
                }
            }

            if(options.containsKey("round")) {
                if(csvData.get(i)[9].equals(options.get("round"))) {
                    mapped = RowMapper.map(csvData.get(i));
                } else {
                    continue;
                }
            }

            return mapped;
        }

        throw new NoSuchEntryException();
    }
}
