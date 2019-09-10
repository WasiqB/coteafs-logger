package com.github.wasiqb.coteafs.logger.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
public class LoggerSetting {
    private String       logDir;
    private List<Logger> loggers;
    private Status       status;

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     */
    public LoggerSetting () {
        this.loggers = new ArrayList<> ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return log dir
     */
    public String getLogDir () {
        return this.logDir;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return loggers
     */
    public List<Logger> getLoggers () {
        return this.loggers;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return log status
     */
    public Status getStatus () {
        return this.status;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param logDir
     */
    public void setLogDir (final String logDir) {
        this.logDir = logDir;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param loggers
     */
    public void setLoggers (final List<Logger> loggers) {
        this.loggers = loggers;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param status
     */
    public void setStatus (final Status status) {
        this.status = status;
    }
}