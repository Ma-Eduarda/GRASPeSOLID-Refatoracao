package com.checkr.interviews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FundingRaised {

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = CsvLoader.load();

        if(options.get("company_name") != null) {
            List<String[]> results = new ArrayList<String[]>();
            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[1].equals(
                        options.get("company_name"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if(options.get("city") != null) {
            List<String[]> results = new ArrayList<String[]>();
            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[4].equals(
                        options.get("city"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if(options.get("state") != null) {
            List<String[]> results = new ArrayList<String[]>();
            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[5].equals(
                        options.get("state"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if(options.get("round") != null) {
            List<String[]> results = new ArrayList<String[]>();
            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[9].equals(
                        options.get("round"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        for(int i = 0; i < csvData.size(); i++) {
            output.add(RowMapper.map(csvData.get(i)));
        }
        return output;
    }

    public static Map<String, String> findBy(Map<String, String> options)throws IOException, NoSuchEntryException {
        List<String[]> csvData = CsvLoader.load();

        for(int i = 0; i < csvData.size(); i++) {
            
            if(options.get("company_name") != null) {
                if(!csvData.get(i)[1].equals(
                        options.get("company_name"))) {
                    continue;
                }
            }

            if(options.get("city") != null) {
                if(!csvData.get(i)[4].equals(
                        options.get("city"))) {
                    continue;
                }
            }

            if(options.get("state") != null) {
                if(!csvData.get(i)[5].equals(
                        options.get("state"))) {
                    continue;
                }
            }

            if(options.get("round") != null) {
                if(!csvData.get(i)[9].equals(
                        options.get("round"))) {
                    continue;
                }
            }
            return RowMapper.map(csvData.get(i));
        }
        
        throw new NoSuchEntryException();
    }
}
