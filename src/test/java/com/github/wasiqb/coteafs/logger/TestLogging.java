/**
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
package com.github.wasiqb.coteafs.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author wasiq.bhamla
 * @since 17-Jun-2017 6:14:59 PM
 */
public class TestLogging {
    /**
     * @author wasiq.bhamla
     * @since 17-Jun-2017 6:18:03 PM
     */
    @Test
    public void testLogs () {
        final Logger log = LogManager.getLogger (TestLogging.class);
        log.info ("Testing info...");
        log.warn ("Testing warn...");
        log.error ("Testing error...");
        log.debug ("Testing debug...");
        log.trace ("Testing trace...");
        log.fatal ("Testing fatal...");
    }
}