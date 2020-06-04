/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nss.commoncategory.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.service.CityLocalServiceUtil;
import com.nss.commoncategory.service.CountryLocalServiceUtil;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the District service. Represents a row in the &quot;nss_platform_district&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.model.District</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class DistrictImpl extends DistrictBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a district model instance should use the {@link com.nss.commoncategory.model.District} interface instead.
	 */
	private City city;
	
	private Country country;
	
	private Log _log = LogFactoryUtil.getLog(getClass());
	
	public DistrictImpl() {
	}

	public Country getCountry() {
		if((country == null && getCountryId() > 0) || (country != null && country.getCountryId() != getCountryId())) {
			try {
				country = CountryLocalServiceUtil.fetchCountry(getCountryId());
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		return country;
	}

	public City getCity() {
		if((city == null && getCityId() > 0) || (city != null && city.getCityId() != getCityId())) {
			try {
				city = CityLocalServiceUtil.fetchCity(getCityId());
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		return city;
	}

}