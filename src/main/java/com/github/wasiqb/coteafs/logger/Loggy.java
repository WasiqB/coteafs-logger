package com.github.wasiqb.coteafs.logger;

import static java.text.MessageFormat.format;
import static org.apache.logging.log4j.LogManager.getLogger;
import static rp.com.google.common.io.BaseEncoding.base64;

import java.io.File;

import org.apache.logging.log4j.Logger;

/**
 * @author Wasiq Bhamla
 * @since 12-Sep-2019
 */
public final class Loggy {
    private static final String ATTACH_BASE64_PATTERN = "RP_MESSAGE#BASE64#{}#{}";
    private static final String ATTACH_FILE_PATTERN   = "RP_MESSAGE#FILE#{}#{}";

    /**
     * @return instance
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public static Loggy init () {
        return new Loggy ();
    }

    private final Logger log;

    private Loggy () {
        final Throwable caller = new Throwable ();
        final StackTraceElement callingStack = caller.getStackTrace ()[2];
        this.log = getLogger (callingStack.getClassName ());
    }

    /**
     * @param <T> Exception type
     * @param cause Exception
     *
     * @author Wasiq Bhamla
     * @since 13-Oct-2019
     */
    public <T extends Throwable> void c (final T cause) {
        this.log.catching (cause);
    }

    /**
     * @param data ReportPortal attachment data
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void d (final byte[] data, final String message, final Object... args) {
        d (ATTACH_BASE64_PATTERN, base64 ().encode (data), format (message, args));
    }

    /**
     * @param file ReportPortal attachment file
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 01-Nov-2019
     */
    public void d (final File file, final String message, final Object... args) {
        d (ATTACH_FILE_PATTERN, file.getPath (), format (message, args));
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public void d (final String message, final Object... args) {
        this.log.debug (message, args);
    }

    /**
     * @param data ReportPortal attachment data
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void e (final byte[] data, final String message, final Object... args) {
        e (ATTACH_BASE64_PATTERN, base64 ().encode (data), format (message, args));
    }

    /**
     * @param file ReportPortal attachment file
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void e (final File file, final String message, final Object... args) {
        e (ATTACH_FILE_PATTERN, file.getPath (), format (message, args));
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public void e (final String message, final Object... args) {
        this.log.error (message, args);
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void enter (final String message, final Object... args) {
        this.log.traceEntry (message, args);
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void exit (final String message, final Object... args) {
        this.log.traceExit (message, args);
    }

    /**
     * @param data ReportPortal attachment data
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void f (final byte[] data, final String message, final Object... args) {
        f (ATTACH_BASE64_PATTERN, base64 ().encode (data), format (message, args));
    }

    /**
     * @param file ReportPortal attachment file
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void f (final File file, final String message, final Object... args) {
        f (ATTACH_FILE_PATTERN, file.getPath (), format (message, args));
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public void f (final String message, final Object... args) {
        this.log.fatal (message, args);
    }

    /**
     * @param data ReportPortal attachment data
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void i (final byte[] data, final String message, final Object... args) {
        i (ATTACH_BASE64_PATTERN, base64 ().encode (data), format (message, args));
    }

    /**
     * @param file ReportPortal attachment file
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void i (final File file, final String message, final Object... args) {
        i (ATTACH_FILE_PATTERN, file.getPath (), format (message, args));
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public void i (final String message, final Object... args) {
        this.log.info (message, args);
    }

    /**
     * @param data ReportPortal attachment data
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void t (final byte[] data, final String message, final Object... args) {
        t (ATTACH_BASE64_PATTERN, base64 ().encode (data), format (message, args));
    }

    /**
     * @param file ReportPortal attachment file
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void t (final File file, final String message, final Object... args) {
        t (ATTACH_FILE_PATTERN, file.getPath (), format (message, args));
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public void t (final String message, final Object... args) {
        this.log.trace (message, args);
    }

    /**
     * @param <T> Exception type
     * @param cause Exception
     *
     * @return exception
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public <T extends Throwable> T th (final T cause) {
        return this.log.throwing (cause);
    }

    /**
     * @param data ReportPortal attachment data
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void w (final byte[] data, final String message, final Object... args) {
        w (ATTACH_BASE64_PATTERN, base64 ().encode (data), format (message, args));
    }

    /**
     * @param file ReportPortal attachment file
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 02-Nov-2019
     */
    public void w (final File file, final String message, final Object... args) {
        w (ATTACH_FILE_PATTERN, file.getPath (), format (message, args));
    }

    /**
     * @param message Log message
     * @param args Message args
     *
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     */
    public void w (final String message, final Object... args) {
        this.log.warn (message, args);
    }
}