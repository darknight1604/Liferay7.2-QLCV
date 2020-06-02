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
import com.nss.commoncategory.model.Continent;
import com.nss.commoncategory.service.ContinentLocalServiceUtil;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the Country service. Represents a row in the &quot;nss_platform_country&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.model.Country</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class CountryImpl extends CountryBaseImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a country model instance should use the {@link com.nss.commoncategory.model.Country} interface instead.
	 */
	private Continent continent;
	
	private Log _log = LogFactoryUtil.getLog(getClass());
	
	public CountryImpl() {
	}

	public Continent getContinent() {
		if(continent == null && getContinentId() > 0) {
			try {
				continent = ContinentLocalServiceUtil.fetchContinent(getContinentId());
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		return continent;
	}

}