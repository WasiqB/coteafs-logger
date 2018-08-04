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
package com.github.wasiqb.coteafs.logger.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wasiq.bhamla
 * @since 26-Jun-2017 8:34:32 PM
 */
public class Log4jSetting {
	private List <AppenderSetting>	appenders;
	private RootLoggerSetting		loggers;
	private String					monitorInterval;
	private List <PropertySetting>	properties;
	private Status					status;

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:34:32 PM
	 */
	public Log4jSetting () {
		setAppenders (new ArrayList <> ());
		setProperties (new ArrayList <> ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:36:15 PM
	 * @return the appenders
	 */
	public List <AppenderSetting> getAppenders () {
		return this.appenders;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:45:44 PM
	 * @return the loggers
	 */
	public RootLoggerSetting getLoggers () {
		return this.loggers;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:36:21 PM
	 * @return the monitorInterval
	 */
	public String getMonitorInterval () {
		return this.monitorInterval;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:43:29 PM
	 * @return the properties
	 */
	public List <PropertySetting> getProperties () {
		return this.properties;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:36:21 PM
	 * @return the level
	 */
	public Status getStatus () {
		return this.status;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:36:15 PM
	 * @param appenders
	 *            the appenders to set
	 */
	public void setAppenders (final List <AppenderSetting> appenders) {
		this.appenders = appenders;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:45:44 PM
	 * @param loggers
	 *            the loggers to set
	 */
	public void setLoggers (final RootLoggerSetting loggers) {
		this.loggers = loggers;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:36:21 PM
	 * @param monitorInterval
	 *            the monitorInterval to set
	 */
	public void setMonitorInterval (final String monitorInterval) {
		this.monitorInterval = monitorInterval;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:43:29 PM
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties (final List <PropertySetting> properties) {
		this.properties = properties;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:36:21 PM
	 * @param status
	 *            the level to set
	 */
	public void setStatus (final Status status) {
		this.status = status;
	}
}