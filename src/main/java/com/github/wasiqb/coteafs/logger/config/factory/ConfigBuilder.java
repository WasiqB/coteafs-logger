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
package com.github.wasiqb.coteafs.logger.config.factory;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.ConsoleAppender.Target;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.AppenderRefComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import com.github.wasiqb.coteafs.config.loader.ConfigLoader;
import com.github.wasiqb.coteafs.logger.config.AppenderRefSetting;
import com.github.wasiqb.coteafs.logger.config.AppenderSetting;
import com.github.wasiqb.coteafs.logger.config.ComponentSetting;
import com.github.wasiqb.coteafs.logger.config.LayoutSetting;
import com.github.wasiqb.coteafs.logger.config.Log4jSetting;
import com.github.wasiqb.coteafs.logger.config.PropertySetting;
import com.github.wasiqb.coteafs.logger.config.RootLoggerSetting;
import com.github.wasiqb.coteafs.logger.config.Status;

/**
 * @author wasiq.bhamla
 * @since 26-Jun-2017 8:50:32 PM
 */
public class ConfigBuilder {
	private static void addAppenderRef (final AppenderComponentBuilder appenderCom,
			final List <AppenderRefSetting> appenderRef, final ConfigurationBuilder <BuiltConfiguration> build) {
		for (final AppenderRefSetting setting : appenderRef) {
			final AppenderRefComponentBuilder ref = build.newAppenderRef (setting.getRef ());
			addAttributes (ref, setting.getAttributes ());
			appenderCom.addComponent (ref);
		}
	}

	private static <T, K extends ComponentBuilder <K>> void addAttributes (final ComponentBuilder <K> appender,
			final Map <String, T> attributes) {
		for (final Entry <String, T> entry : attributes.entrySet ()) {
			final String key = entry.getKey ();
			final T val = entry.getValue ();
			boolean isEnum = false;
			for (final Target target : ConsoleAppender.Target.values ())
				if (target	.name ()
							.equalsIgnoreCase (val.toString ())) {
					appender.addAttribute (key, Target.valueOf (val.toString ()));
					isEnum = true;
				}
			if (!isEnum) {
				if (val instanceof Status) {
					appender.addAttribute (key, ((Status) val).getStatus ());
				}
				else {
					appender.addAttribute (key, val);
				}
			}
		}
	}

	private static void addLayout (final AppenderComponentBuilder appenderCom, final LayoutSetting layout,
			final ConfigurationBuilder <BuiltConfiguration> build) {
		if (layout == null) return;
		final LayoutComponentBuilder layoutCom = build.newLayout (layout.getPlugin ());
		addAttributes (layoutCom, layout.getAttributes ());
		appenderCom.add (layoutCom);
	}

	private final List <AppenderSetting>	appenders;
	private final String					interval;
	private final Level						level;
	private final RootLoggerSetting			loggers;
	private final List <PropertySetting>	properties;

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:50:32 PM
	 */
	public ConfigBuilder () {
		final Log4jSetting config = ConfigLoader.settings ()
												.withKey ("coteafs.logger.config")
												.withDefault ("/coteafs-logger.yaml")
												.load (Log4jSetting.class);
		this.properties = config.getProperties ();
		this.appenders = config.getAppenders ();
		this.loggers = config.getLoggers ();
		this.level = config	.getStatus ()
							.getStatus ();
		this.interval = config.getMonitorInterval ();
	}

	/**
	 * @author wasiq.bhamla
	 * @param name
	 * @param build
	 * @return config
	 * @since 26-Jun-2017 8:55:37 PM
	 */
	public Configuration build (final String name, final ConfigurationBuilder <BuiltConfiguration> build) {
		build.setConfigurationName (name);
		build.setStatusLevel (this.level);
		build.setMonitorInterval (this.interval);
		addProperties (build);
		addAppenders (build);
		addRootLogger (build);
		return build.build ();
	}

	private void addAppenders (final ConfigurationBuilder <BuiltConfiguration> build) {
		for (final AppenderSetting appender : this.appenders) {
			final AppenderComponentBuilder appenderCom = build.newAppender (appender.getName (), appender.getPlugin ());
			addAttributes (appenderCom, appender.getAttributes ());
			addLayout (appenderCom, appender.getLayout (), build);
			addAppenderRef (appenderCom, appender.getAppenderRef (), build);
			addComponent (appenderCom, appender.getComponent (), build);
			build.add (appenderCom);
		}
	}

	private <K extends ComponentBuilder <K>> void addComponent (final ComponentBuilder <K> component,
			final ComponentSetting setting, final ConfigurationBuilder <BuiltConfiguration> build) {
		if (setting == null) return;
		final ComponentBuilder <?> comp = build.newComponent (setting.getPlugin ());
		for (final ComponentSetting c : setting.getComponents ()) {
			final ComponentBuilder <?> newComp = build.newComponent (c.getPlugin ());
			addAttributes (newComp, c.getAttributes ());
			if (!c	.getComponents ()
					.isEmpty ()) {
				addComponent (newComp, c, build);
			}
			comp.addComponent (newComp);
		}
		component.addComponent (comp);
	}

	private void addProperties (final ConfigurationBuilder <BuiltConfiguration> build) {
		for (final PropertySetting property : this.properties) {
			build.addProperty (property.getName (), property.getValue ());
		}
	}

	private void addRootLogger (final ConfigurationBuilder <BuiltConfiguration> build) {
		final RootLoggerComponentBuilder root = build.newRootLogger (this.loggers	.getLevel ()
																					.getStatus ());
		for (final AppenderRefSetting setting : this.loggers.getAppenderRef ()) {
			final AppenderRefComponentBuilder ref = build.newAppenderRef (setting.getRef ());
			addAttributes (ref, setting.getAttributes ());
			root.add (ref);
		}
		build.add (root);
	}
}