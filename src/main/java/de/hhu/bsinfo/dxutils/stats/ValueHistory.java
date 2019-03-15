package de.hhu.bsinfo.dxutils.stats;

import java.util.ArrayList;

public class ValueHistory extends AbstractOperation  {
    private static final int SLOT_SIZE = 100000;

    private ArrayList<Data[]> m_slots = new ArrayList<>();
    private int m_index;

    private static class Data {
        public Data(long p_timestamp, long p_value) {
            m_timestamp = p_timestamp;
            m_value = p_value;
        }

        long m_timestamp;
        long m_value;
    }

    /**
     * Constructor
     *
     * @param p_class
     *         Class that contains the operation
     * @param p_name
     *         Name for the operation
     */
    public ValueHistory(final Class<?> p_class, final String p_name) {
        super(p_class, p_name);

        m_index = 0;
    }

    /**
     * Record a single value
     *
     * @param p_value
     *         Value to record
     */
    public synchronized void record(final long p_timestamp, final long p_value) {
        Data[] arr;

        if (m_index % SLOT_SIZE == 0) {
            arr = new Data[SLOT_SIZE];
            m_slots.add(arr);
            m_index = 0;
        } else {
            arr = m_slots.get(m_slots.size() - 1);
        }

        arr[m_index++] = new Data(p_timestamp, p_value);
    }

    @Override
    public String dataToString(String p_indent, boolean p_extended) {
        return "recorded values " + (m_slots.isEmpty() ? 0 : m_slots.size() + m_index - 1);
    }

    @Override
    public String generateCSVHeader(char p_delim) {
        return "timestamp" + p_delim + "value";
    }

    @Override
    public String toCSV(char p_delim) {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        for (Data[] arr : m_slots) {
            if (arr == m_slots.get(m_slots.size() - 1)) {
                for (int j = 0; j < m_index; j++) {
                    builder.append(arr[j].m_timestamp);
                    builder.append(p_delim);
                    builder.append(arr[j].m_value);
                    builder.append('\n');
                }
            } else {
                for (int j = 0; j < arr.length; j++) {
                    builder.append(arr[j].m_timestamp);
                    builder.append(p_delim);
                    builder.append(arr[j].m_value);
                    builder.append('\n');
                }
            }
        }

        return builder.toString();
    }
}
