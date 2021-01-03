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
package com.github.wasiqb.coteafs.logger;

import static com.github.wasiqb.coteafs.logger.Loggy.init;
import static java.text.MessageFormat.format;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

/**
 * @author wasiq.bhamla
 * @since 17-Jun-2017 6:14:59 PM
 */
public class TestLogging {
    /**
     * @throws IOException IO exception
     * @author wasiq.bhamla
     * @since 17-Jun-2017 6:18:03 PM
     */
    @Test (expectedExceptions = IOException.class)
    public void testLogs () throws IOException {
        final Loggy log = init ();
        final String attachByteMessage = "Testing {0} attach bytes...";
        final String attachMessage = "Testing {0} attach...";
        final String attach = "./attach-sample.txt";
        final File attachFile = new File (attach);
        try (final FileInputStream in = new FileInputStream (attachFile)) {
            final byte[] data = new byte[(int) attachFile.length ()];
            in.read (data);
            log.enter ("Entered method");
            log.i ("Testing info...");
            log.i (attachFile, format (attachMessage, "Info"));
            log.i (data, format (attachByteMessage, "Info"));
            log.w ("Testing warn...");
            log.w (attachFile, format (attachMessage, "Warn"));
            log.w (data, format (attachByteMessage, "Warn"));
            log.c (new FileNotFoundException ("File Not found"));
            log.e ("Testing error...");
            log.e (attachFile, format (attachMessage, "Error"));
            log.e (data, format (attachByteMessage, "Error"));
            log.d ("Testing debug...");
            log.d (attachFile, format (attachMessage, "Debug"));
            log.d (data, format (attachByteMessage, "Debug"));
            log.t ("Testing trace...");
            log.t (attachFile, format (attachMessage, "Trace"));
            log.t (data, format (attachByteMessage, "Trace"));
            log.f ("Testing fatal...");
            log.f (attachFile, format (attachMessage, "Fatal"));
            log.f (data, format (attachByteMessage, "Fatal"));
        }
        log.exit ("Exit method");
        throw log.th (new IOException ("IO exception"));
    }
}