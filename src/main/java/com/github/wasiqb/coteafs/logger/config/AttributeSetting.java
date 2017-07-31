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

import java.util.HashMap;
import java.util.Map;

/**
 * @author wasiq.bhamla
 * @since 26-Jun-2017 8:22:32 PM
 */
public class AttributeSetting {
	protected Map <String, Object> attributes;

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:22:32 PM
	 */
	public AttributeSetting () {
		setAttributes (new HashMap <> ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:22:57 PM
	 * @return the attributes
	 */
	public Map <String, Object> getAttributes () {
		return this.attributes;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Jun-2017 8:22:57 PM
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes (final Map <String, Object> attributes) {
		this.attributes = attributes;
	}
}