package com.github.wasiqb.coteafs.logger.config;

import java.util.ArrayList;
import java.util.List;

import com.github.wasiqb.coteafs.config.util.BasePojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
@Getter
@Setter
public class LoggerSetting extends BasePojo {
    private String       logDir;
    private List<Logger> loggers;
    private Status       status;

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     */
    public LoggerSetting () {
        this.logDir = "/logs";
        this.status = Status.WARN;
        this.loggers = new ArrayList<> ();
        this.loggers.add (new Logger ());
    }
}