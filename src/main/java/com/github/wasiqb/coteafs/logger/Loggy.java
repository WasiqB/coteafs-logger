package com.github.wasiqb.coteafs.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Wasiq Bhamla
 * @since 12-Sep-2019
 */
public final class Loggy {
    private static final Loggy INSTANCE = new Loggy ();

    /**
     * @author Wasiq Bhamla
     * @since 12-Sep-2019
     * @return instance
     */
    public static Loggy init () {
        return INSTANCE;
    }

    private final Logger log;

    private Loggy () {
        final Throwable caller = new Throwable ();
        final StackTraceElement callingStack = caller.getStackTrace () [2];
        this.log = LogManager.getLogger (callingStack.getClassName ());
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
