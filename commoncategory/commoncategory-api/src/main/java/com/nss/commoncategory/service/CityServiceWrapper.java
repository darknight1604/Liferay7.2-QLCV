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

package com.nss.commoncategory.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CityService}.
 *
 * @author Brian Wing Shun Chan
 * @see CityService
 * @generated
 */
@ProviderType
public class CityServiceWrapper
	implements CityService, ServiceWrapper<CityService> {

	public CityServiceWrapper(CityService cityService) {
		_cityService = cityService;
	}

	@Override
	public com.nss.commoncategory.model.City addCity(
			long userId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityService.addCity(
			userId, countryId, name, code, description, priority, countCode,
			active, serContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cityService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _cityService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _cityService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _cityService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.commoncategory.model.City updateCity(
			long cityId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityService.updateCity(
			cityId, countryId, name, code, description, priority, countCode,
			active, serContext);
	}

	@Override
	public CityService getWrappedService() {
		return _cityService;
	}

	@Override
	public void setWrappedService(CityService cityService) {
		_cityService = cityService;
	}

	private CityService _cityService;

}