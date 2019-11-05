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

import static com.github.wasiqb.coteafs.logger.config.LoggerType.CONSOLE;
import static com.github.wasiqb.coteafs.logger.config.LoggerType.FILE;
import static com.github.wasiqb.coteafs.logger.config.Status.ALL;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;
import static java.util.Objects.requireNonNull;
import static org.apache.logging.log4j.core.appender.ConsoleAppender.Target.valueOf;

import java.util.List;

import com.github.wasiqb.coteafs.config.loader.ConfigLoader;
import com.github.wasiqb.coteafs.logger.config.ArchiveStrategy;
import com.github.wasiqb.coteafs.logger.config.Logger;
import com.github.wasiqb.coteafs.logger.config.LoggerSetting;
import com.github.wasiqb.coteafs.logger.config.LoggerType;

import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.AppenderRefComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

/**
 * @author wasiq.bhamla
 * @since 26-Jun-2017 8:50:32 PM
 */
class ConfigBuilder {
    private static final String DIR = getProperty ("user.dir");

    private static void addComponent (final AppenderComponentBuilder component, final Logger logSetting,
        final ConfigurationBuilder<BuiltConfiguration> build) {
        if (logSetting.getType () == CONSOLE) {
            return;
        }
        final ComponentBuilder<?> comp = build.newComponent ("Policies");
        final ArchiveStrategy archive = logSetting.getArchive ();
        if (archive != null) {
            if (archive.getAfterDays () > 0) {
                final ComponentBuilder<?> newComp = build.newComponent ("TimeBasedTriggeringPolicy");
                newComp.addAttribute ("interval", archive.getAfterDays ());
                newComp.addAttribute ("modulate", true);
                comp.addComponent (newComp);
            }
            if (archive.getAfterSize () > 0) {
                final ComponentBuilder<?> newComp = build.newComponent ("SizeBasedTriggeringPolicy");
                newComp.addAttribute ("size", format ("{0} MB", archive.getAfterSize ()));
                comp.addComponent (newComp);
            }
            if (archive.isOnEveryRun ()) {
                final ComponentBuilder<?> newComp = build.newComponent ("OnStartupTriggeringPolicy");
                comp.addComponent (newComp);
            }
        }
        component.addComponent (comp);
    }

    private static void addLayout (final AppenderComponentBuilder appenderCom,
        final ConfigurationBuilder<BuiltConfiguration> build, final Logger logSetting) {
        final LayoutComponentBuilder layoutCom = build.newLayout ("PatternLayout");
        layoutCom.addAttribute ("pattern", check (logSetting.getMessagePattern (), "Message Pattern"));
        appenderCom.add (layoutCom);
    }

    private static <T> T check (final T value, final String field) {
        return requireNonNull (value, format ("{0} is required.", field));
    }

    private static String getAppenderPlugin (final LoggerType loggerType) {
        String result;
        switch (loggerType) {
            case CONSOLE:
                result = "Console";
                break;
            case FILE:
                result = "RollingFile";
                break;
            case REPORT_PORTAL:
            default:
                result = "ReportPortalLog4j2Appender";
                break;
        }
        return result;
    }

    private final LoggerSetting setting;

    ConfigBuilder () {
        super ();
        this.setting = ConfigLoader.settings ()
            .withKey ("coteafs.logger.config")
            .withDefault ("logger-config.yml")
            .load (LoggerSetting.class);
    }

    Configuration build (final String name, final ConfigurationBuilder<BuiltConfiguration> build) {
        if (this.setting == null) {
            return null;
        }
        build.setConfigurationName (name);
        build.setStatusLevel (check (this.setting.getStatus ()
            .getStatus (), "Log Level"));
        build.setMonitorInterval ("30");
        addAppenders (build);
        addRootLogger (build);
        return build.build ();
    }

    private void addAppenders (final ConfigurationBuilder<BuiltConfiguration> build) {
        final List<Logger> loggers = this.setting.getLoggers ();
        for (final Logger logger : loggers) {
            final String plugin = getAppenderPlugin (logger.getType ());
            final AppenderComponentBuilder appenderCom = build.newAppender (check (logger.getName (), "Log Name"),
                plugin);
            addAttributes (appenderCom, logger);
            addLayout (appenderCom, build, logger);
            addComponent (appenderCom, logger, build);
            build.add (appenderCom);
        }
    }

    private void addAttributes (final AppenderComponentBuilder appenderCom, final Logger logSetting) {
        if (logSetting.getType () == CONSOLE) {
            appenderCom.addAttribute ("target", valueOf ("SYSTEM_OUT"));
        } else if (logSetting.getType () == FILE) {
            final String dir = check (this.setting.getLogDir (), "Log Directory");
            appenderCom.addAttribute ("fileName",
                format ("{0}/{1}/{2}.log", DIR, dir, check (logSetting.getFileName (), "File Name")));
            appenderCom.addAttribute ("filePattern",
                format ("{0}/{1}/{2}.log", DIR, dir, check (logSetting.getPathPattern (), "Path Pattern")));
            appenderCom.addAttribute ("append", false);
            appenderCom.addAttribute ("immediateFlush", true);
        }
    }

    private void addRootLogger (final ConfigurationBuilder<BuiltConfiguration> build) {
        final RootLoggerComponentBuilder root = build.newRootLogger (ALL.toString ());
        final List<Logger> loggers = this.setting.getLoggers ();
        for (final Logger logger : loggers) {
            final AppenderRefComponentBuilder ref = build.newAppenderRef (logger.getName ());
            ref.addAttribute ("level", check (logger.getLevel ()
                .toString (), "Log Level"));
            root.add (ref);
        }
        build.add (root);
    }
}