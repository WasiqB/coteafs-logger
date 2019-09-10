package com.github.wasiqb.coteafs.logger.config;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
public class ArchiveStrategy {
    private int     afterDays;
    private int     afterSize;
    private boolean onEveryRun;

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     */
    public ArchiveStrategy () {
        this.afterDays = 0;
        this.afterSize = 0;
        this.onEveryRun = false;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return after days
     */
    public int getAfterDays () {
        return this.afterDays;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return after size
     */
    public int getAfterSize () {
        return this.afterSize;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return on every run
     */
    public boolean isOnEveryRun () {
        return this.onEveryRun;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param afterDays
     */
    public void setAfterDays (final int afterDays) {
        this.afterDays = afterDays;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param afterSize
     */
    public void setAfterSize (final int afterSize) {
        this.afterSize = afterSize;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param onEveryRun
     */
    public void setOnEveryRun (final boolean onEveryRun) {
        this.onEveryRun = onEveryRun;
    }
}
