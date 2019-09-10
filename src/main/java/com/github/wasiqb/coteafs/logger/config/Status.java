/*
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.logger.config;

import org.apache.logging.log4j.Level;

/**
 * @author wasiq.bhamla
 * @since 27-Jun-2017 2:20:30 PM
 */
public enum Status {
    /**
     * Log all events.
     */
    ALL (Level.ALL),
    /**
     * Log debug events.
     */
    DEBUG (Level.DEBUG),
    /**
     * Log Error events.
     */
    ERROR (Level.ERROR),
    /**
     * Fatal Error.
     */
    FATAL (Level.FATAL),
    /**
     * Log info events.
     */
    INFO (Level.INFO),
    /**
     * Logging off.
     */
    OFF (Level.OFF),
    /**
     * Trace.
     */
    TRACE (Level.TRACE),
    /**
     * Warning.
     */
    WARN (Level.WARN);

    private final Level level;

    private Status (final Level level) {
        this.level = level;
    }

    /**
     * @author wasiq.bhamla
     * @since 27-Jun-2017 2:26:25 PM
     * @return the status
     */
    public Level getStatus () {
        return this.level;
    }
}