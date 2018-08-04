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

/**
 * @author wasiq.bhamla
 * @since 26-Jun-2017 7:17:16 PM
 */
public class PluginSetting extends AttributeSetting {
	protected String plugin;

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 7:15:43 PM
	 */
	public PluginSetting () {
		super ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 7:16:29 PM
	 * @return the plugin
	 */
	public String getPlugin () {
		return this.plugin;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 7:16:29 PM
	 * @param plugin
	 *            the plugin to set
	 */
	public void setPlugin (final String plugin) {
		this.plugin = plugin;
	}
}