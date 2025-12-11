package com.checkr.interviews;

import java.util.*;
import java.io.IOException;

public class FundingRaised {
    
    public static List<Map<String, String>> where(Map<String, String> options) 
            throws IOException {
        
        List<String[]> csvData = CsvLoader.loadCSV("startup_funding.csv");
        csvData = Filters.apply(csvData, options);

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        for(int i = 0; i < csvData.size(); i++) {
            output.add(RowMapper.map(csvData.get(i)));
        }

        return output;
    }

    public static Map<String, String> findBy(Map<String, String> options) 
            throws IOException, NoSuchEntryException {
        
        List<String[]> csvData = CsvLoader.loadCSV("startup_funding.csv");
        return Finder.findFirst(csvData, options);
    }

    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<String, String>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print(FundingRaised.where(options).size());
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}
