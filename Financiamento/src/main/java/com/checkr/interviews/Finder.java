package com.checkr.interviews;

import java.util.List;
import java.util.Map;

public class Finder {

    interface Filter {
        boolean match(String[] row, String value);
    }

    static class ColumnFilter implements Filter {
        private final int columnIndex;

        public ColumnFilter(int columnIndex) {
            this.columnIndex = columnIndex;
        }

        @Override
        public boolean match(String[] row, String value) {
            return row[columnIndex].equals(value);
        }
    }

    public static Map<String, String> findFirst(List<String[]> csvData,Map<String, String> options
    ) throws NoSuchEntryException {

        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);

            if (options.get("company_name") != null) {
                Filter filter = new ColumnFilter(1);
                if (!filter.match(row, options.get("company_name"))) {
                    continue;
                }
            }

            if (options.get("city") != null) {
                Filter filter = new ColumnFilter(4);
                if (!filter.match(row, options.get("city"))) {
                    continue;
                }
            }

            if (options.get("state") != null) {
                Filter filter = new ColumnFilter(5);
                if (!filter.match(row, options.get("state"))) {
                    continue;
                }
            }

            if (options.get("round") != null) {
                Filter filter = new ColumnFilter(9);
                if (!filter.match(row, options.get("round"))) {
                    continue;
                }
            }

            return RowMapper.map(row);
        }
        throw new NoSuchEntryException();
    }
}
