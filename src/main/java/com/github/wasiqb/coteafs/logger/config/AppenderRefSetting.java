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
 * @since 26-Jun-2017 8:21:40 PM
 */
public class AppenderRefSetting extends AttributeSetting {
	protected List <ComponentSetting>	components;
	protected Status					level;
	protected String					ref;

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:21:40 PM
	 */
	public AppenderRefSetting () {
		super ();
		setComponents (new ArrayList <> ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:27:08 PM
	 * @return the components
	 */
	public List <ComponentSetting> getComponents () {
		return this.components;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:27:08 PM
	 * @return the level
	 */
	public Status getLevel () {
		return this.level;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:27:08 PM
	 * @return the ref
	 */
	public String getRef () {
		return this.ref;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:27:08 PM
	 * @param components
	 *            the components to set
	 */
	public void setComponents (final List <ComponentSetting> components) {
		this.components = components;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:27:08 PM
	 * @param level
	 *            the level to set
	 */
	public void setLevel (final Status level) {
		this.level = level;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:27:08 PM
	 * @param ref
	 *            the ref to set
	 */
	public void setRef (final String ref) {
		this.ref = ref;
	}
}