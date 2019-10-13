package com.github.wasiqb.coteafs.logger;

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.handleError;
import static org.apache.logging.log4j.LogManager.getLogger;

import org.apache.logging.log4j.Logger;

/**
 * @author Wasiq Bhamla
 * @since 12-Sep-2019
 */
public final class Loggy {
    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @return instance
     */
    public static Loggy init () {
        return new Loggy ();
    }

    private final Logger log;

    private Loggy () {
        final Throwable caller = new Throwable ();
        final StackTraceElement callingStack = caller.getStackTrace () [2];
        this.log = getLogger (callingStack.getClassName ());
    }

    /**
     * @author Wasiq Bhamla
     * @since 13-Oct-2019
     * @param cause
     */
    public void c (final Throwable cause) {
        this.log.catching (cause);
        handleError (cause).forEach (this::e);
    }

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @param message
     * @param args
     */
    public void d (final String message, final Object... args) {
        this.log.debug (message, args);
    }

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @param message
     * @param args
     */
    public void e (final String message, final Object... args) {
        this.log.error (message, args);
    }

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @param message
     * @param args
     */
    public void f (final String message, final Object... args) {
        this.log.fatal (message, args);
    }

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @param message
     * @param args
     */
    public void i (final String message, final Object... args) {
        this.log.info (message, args);
    }

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @param message
     * @param args
     */
    public void t (final String message, final Object... args) {
        this.log.trace (message, args);
    }

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @param message
     * @param args
     */
    public void w (final String message, final Object... args) {
        this.log.warn (message, args);
    }
}