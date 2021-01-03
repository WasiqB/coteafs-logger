package com.github.wasiqb.coteafs.logger.config;

import java.util.ArrayList;
import java.util.List;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
@Data
@DataFile
public class LoggerConfig {
    private String       logDir;
    private List<Logger> loggers;
    private Status       status;

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     */
    public LoggerConfig () {
        this.logDir = "/logs";
        this.status = Status.WARN;
        this.loggers = new ArrayList<> ();
        this.loggers.add (new Logger ());
    }
}