/*
 * Copyright (C) 2018 Heinrich-Heine-Universitaet Duesseldorf, Institute of Computer Science,
 * Department Operating Systems
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package de.hhu.bsinfo.dxutils.stats;

/**
 * (Thread safe) throughput operation using a pool with per thread local throughput operations
 *
 * @author Stefan Nothaas, stefan.nothaas@hhu.de, 05.03.2018
 */
public class ThroughputPool extends OperationPool {

    /**
     * Constructor
     *
     * @param p_class
     *         Class that contains the operation
     * @param p_name
     *         Name for the operation
     */
    public ThroughputPool(final Class<?> p_class, final String p_name) {
        super(Throughput.class, p_class, p_name);
    }

    /**
     * Start throughput measurement. Ensure a call to stop() is following
     */
    public void start() {
        ((Throughput) getThreadLocalValue()).start();
    }

    /**
     * Start throughput measurement. Ensure a call to stop() is following
     *
     * @param p_val
     *         Value to add (e.g. data processed)
     */
    public void start(final long p_val) {
        ((Throughput) getThreadLocalValue()).start(p_val);
    }

    /**
     * Add a value, e.g. data processed
     *
     * @param p_val
     *         Value to add
     */
    public void add(final long p_val) {
        ((Throughput) getThreadLocalValue()).add(p_val);
    }

    /**
     * Stop throughput measurement. Ensure a call to start is preceding
     */
    public void stop() {
        ((Throughput) getThreadLocalValue()).stop();
    }

    /**
     * Stop throughput measurement. Ensure a call to start is preceding
     *
     * @param p_val
     *         Value to add (e.g. data processed)
     */
    public void stop(final long p_val) {
        ((Throughput) getThreadLocalValue()).stop(p_val);
    }

    /**
     * Get the total throughput
     *
     * @return Total time
     */
    public double getTotalThroughput() {
        double val = 0;

        for (AbstractOperation[] opArr : m_pool) {
            for (AbstractOperation op : opArr) {
                if (op != null) {
                    val += ((Throughput) op).getThroughput();
                }
            }
        }

        return val;
    }

    /**
     * Get the total throughput
     *
     * @return Total time
     */
    public long getTotalCount() {
        long val = 0;

        for (AbstractOperation[] opArr : m_pool) {
            for (AbstractOperation op : opArr) {
                if (op != null) {
                    val += ((Throughput) op).getCounter();
                }
            }
        }

        return val;
    }
    /**
     * "Debug version". Identical to normal call but is removed on non-debug builds.
     */
    public void startDebug() {
        start();
    }

    /**
     * "Debug version". Identical to normal call but is removed on non-debug builds.
     */
    public void startDebug(final long p_val) {
        start(p_val);
    }

    /**
     * "Debug version". Identical to normal call but is removed on non-debug builds.
     */
    public void addDebug(final long p_val) {
        add(p_val);
    }

    /**
     * "Debug version". Identical to normal call but is removed on non-debug builds.
     */
    public void stopDebug() {
        stop();
    }

    /**
     * "Debug version". Identical to normal call but is removed on non-debug builds.
     */
    public void stopDebug(final long p_val) {
        stop(p_val);
    }

    @Override
    public String generateCSVHeader(final char p_delim) {
        return "name" + p_delim + "pool size" + p_delim + "counter" + p_delim + "throughput u/sec";
    }

    @Override
    public String toCSV(final char p_delim) {
        return getOperationName() + p_delim + getPoolSize() + p_delim + getTotalCount()
                + p_delim + getTotalThroughput();
    }
}
