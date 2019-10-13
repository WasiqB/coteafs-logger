package com.github.wasiqb.coteafs.logger.config;

import com.github.wasiqb.coteafs.config.util.BasePojo;

/**
 * @author Wasiq Bhamla
 * @since 10-Sep-2019
 */
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
    public Logger () {
        this.name = "console-log";
        this.type = LoggerType.CONSOLE;
        this.messagePattern = "[%d{HH:mm:ss.SSS}] [%-5level] - %msg (%logger{1}:%L) %throwable{short.message}%n";
        this.level = Status.DEBUG;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return archive strategy
     */
    public ArchiveStrategy getArchive () {
        return this.archive;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return file name
     */
    public String getFileName () {
        return this.fileName;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return log level
     */
    public Status getLevel () {
        return this.level;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return message pattern
     */
    public String getMessagePattern () {
        return this.messagePattern;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return name
     */
    public String getName () {
        return this.name;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return path pattern
     */
    public String getPathPattern () {
        return this.pathPattern;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @return type
     */
    public LoggerType getType () {
        return this.type;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param archive
     */
    public void setArchive (final ArchiveStrategy archive) {
        this.archive = archive;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param fileName
     */
    public void setFileName (final String fileName) {
        this.fileName = fileName;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param level
     */
    public void setLevel (final Status level) {
        this.level = level;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param messagePattern
     */
    public void setMessagePattern (final String messagePattern) {
        this.messagePattern = messagePattern;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param name
     */
    public void setName (final String name) {
        this.name = name;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param pathPattern
     */
    public void setPathPattern (final String pathPattern) {
        this.pathPattern = pathPattern;
    }

    /**
     * @author Wasiq Bhamla
     * @since 10-Sep-2019
     * @param type
     */
    public void setType (final LoggerType type) {
        this.type = type;
    }
}