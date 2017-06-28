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
 * @since 26-Jun-2017 8:01:10 PM
 */
public class RootLoggerSetting extends AttributeSetting {
	private List <AppenderRefSetting>	appenderRef;
	private ComponentSetting			component;
	private Status						level;

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:46:27 PM
	 */
	public RootLoggerSetting () {
		super ();
		setAppenderRef (new ArrayList <> ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:47:02 PM
	 * @return the appenderRef
	 */
	public List <AppenderRefSetting> getAppenderRef () {
		return this.appenderRef;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:47:41 PM
	 * @return the component
	 */
	public ComponentSetting getComponent () {
		return this.component;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:47:02 PM
	 * @return the level
	 */
	public Status getLevel () {
		return this.level;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:47:02 PM
	 * @param appenderRef
	 *            the appenderRef to set
	 */
	public void setAppenderRef (final List <AppenderRefSetting> appenderRef) {
		this.appenderRef = appenderRef;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:47:41 PM
	 * @param component
	 *            the component to set
	 */
	public void setComponent (final ComponentSetting component) {
		this.component = component;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:47:02 PM
	 * @param level
	 *            the level to set
	 */
	public void setLevel (final Status level) {
		this.level = level;
	}
}