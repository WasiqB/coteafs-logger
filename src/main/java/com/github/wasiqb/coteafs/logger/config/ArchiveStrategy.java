package com.github.wasiqb.coteafs.logger.config;

import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
@Data
public class ArchiveStrategy {
    private int     afterDays;
    private int     afterSize;
    private boolean onEveryRun;
}