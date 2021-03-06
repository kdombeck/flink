/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.clusterframework.messages;

import org.apache.flink.runtime.clusterframework.types.ResourceID;
import org.apache.flink.runtime.messages.RequiresLeaderSessionID;

import java.io.Serializable;

import static java.util.Objects.requireNonNull;

/**
 * Message sent to the JobManager by the Resource Manager to inform
 * about the removal of a resource.
 */
public class ResourceRemoved implements RequiresLeaderSessionID, Serializable {
	private static final long serialVersionUID = 1L;

	/** The ID under which the resource is registered (for example container ID) */
	private final ResourceID resourceId;

	/** Optional message with details, for logging and debugging */
	private final String message;

	/**
	 * Constructor for a shutdown of a registered resource.
	 * @param resourceId The ID under which the resource is registered (for example container ID).
	 * @param message Optional message with details, for logging and debugging.
	 */
	public ResourceRemoved(ResourceID resourceId, String message) {
		this.resourceId = requireNonNull(resourceId);
		this.message = message;
	}

	// ------------------------------------------------------------------------

	/**
	 * Gets the ID under which the resource is registered (for example container ID).
	 * @return The resource ID
	 */
	public ResourceID resourceId() {
		return resourceId;
	}

	/**
	 * Gets the optional message with details, for logging and debugging.
	 * @return Optional message, may be null
	 */
	public String message() {
		return message;
	}

	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "ResourceRemoved{" +
			"resourceId=" + resourceId +
			", message='" + message + '\'' +
			'}';
	}
}
