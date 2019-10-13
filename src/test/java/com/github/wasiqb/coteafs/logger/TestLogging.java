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

import static com.github.wasiqb.coteafs.logger.Loggy.init;

import java.io.FileNotFoundException;

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
        final Loggy log = init ();
        log.i ("Testing info...");
        log.w ("Testing warn...");
        log.c (new FileNotFoundException ("File Not found"));
        log.e ("Testing error...");
        log.d ("Testing debug...");
        log.t ("Testing trace...");
        log.f ("Testing fatal...");
    }

    /**
     * @author Wasiq Bhamla
     * @since 13-Sep-2019
     */
    @Test
    public void testLogsWithoutConfig () {
        final Loggy log = init ();
        log.i ("Testing info...");
        log.w ("Testing warn...");
        log.e ("Testing error...");
        log.c (new FileNotFoundException ("File Not found"));
        log.d ("Testing debug...");
        log.t ("Testing trace...");
        log.f ("Testing fatal...");
    }
}