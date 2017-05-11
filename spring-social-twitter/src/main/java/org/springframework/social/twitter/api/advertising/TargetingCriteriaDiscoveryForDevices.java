/*
 * Copyright 2014 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api.advertising;

import org.springframework.social.twitter.api.TwitterObject;


/**
 * Data discovery for targeting criterias based in devices.
 * 
 * @author Hudson Mendes
 */
public class TargetingCriteriaDiscoveryForDevices extends TwitterObject {
	private static final long serialVersionUID = 1L;
    private final String targetingValue;
    private final String targetingType;
    private final String platform;
    private final String manufacturer;
    private final String name;
    
    public TargetingCriteriaDiscoveryForDevices(
    	    String targetingValue,
    	    String targetingType,
    	    String platform,
    	    String manufacturer,
    	    String name) {

        this.targetingValue = targetingValue;
        this.targetingType = targetingType;
        this.platform = platform;
        this.manufacturer = manufacturer;
        this.name = name;
    }

	public String getTargetingValue() {
		return targetingValue;
	}

	public String getTargetingType() {
		return targetingType;
	}

	public String getPlatform() {
		return platform;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

    
}
