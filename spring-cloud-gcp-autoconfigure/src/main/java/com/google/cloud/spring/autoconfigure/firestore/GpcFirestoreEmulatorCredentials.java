/*
 * Copyright 2017-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spring.autoconfigure.firestore;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.auth.Credentials;

class GpcFirestoreEmulatorCredentials extends Credentials {

	private final Map<String, List<String>> headerMap = new HashMap<>();

	GpcFirestoreEmulatorCredentials(final String resourcePrefix) {
		headerMap.put("Authorization", Collections.singletonList("Bearer owner"));
		headerMap.put("google-cloud-resource-prefix", Collections.singletonList(resourcePrefix));
	}

	@Override
	public String getAuthenticationType() {
		return null;
	}

	@Override
	public Map<String, List<String>> getRequestMetadata(URI uri) {
		return headerMap;
	}

	@Override
	public boolean hasRequestMetadata() {
		return true;
	}

	@Override
	public boolean hasRequestMetadataOnly() {
		return true;
	}

	@Override
	public void refresh() {
		// no-op
	}
}
