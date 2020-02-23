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
public class Logger extends BasePojo {
    private ArchiveStrategy archive;
    private String          fileName;
    private Status          level;
    private String          messagePattern;
    private String          name;
    private String          pathPattern;
    private LoggerType      type;

    /**
     * @author Wasiq Bhamla
     * @since 13-Oct-2019
     */
    public Logger() {
        this.name = "console-log";
        this.type = LoggerType.CONSOLE;
        this.messagePattern = "[%d{HH:mm:ss.SSS}] [%-5level] - %msg (%logger{1}:%L) %throwable{short.message}%n";
        this.level = Status.DEBUG;
    }
}