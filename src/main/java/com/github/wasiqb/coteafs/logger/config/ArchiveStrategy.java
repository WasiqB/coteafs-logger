package com.github.wasiqb.coteafs.logger.config;

import com.github.wasiqb.coteafs.config.util.BasePojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
@Getter
@Setter
public class ArchiveStrategy extends BasePojo {
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
}