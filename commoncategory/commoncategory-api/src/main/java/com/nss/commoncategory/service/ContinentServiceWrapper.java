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
 * Provides a wrapper for {@link ContinentService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContinentService
 * @generated
 */
@ProviderType
public class ContinentServiceWrapper
	implements ContinentService, ServiceWrapper<ContinentService> {

	public ContinentServiceWrapper(ContinentService continentService) {
		_continentService = continentService;
	}

	@Override
	public com.nss.commoncategory.model.Continent addContinent(
			long userId, String name, String internationalName, String code,
			String description, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _continentService.addContinent(
			userId, name, internationalName, code, description, priority,
			countCode, serContext);
	}

	@Override
	public com.liferay.portal.kernel.security.permission.PermissionChecker
			getMyPermissionChecker()
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _continentService.getMyPermissionChecker();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _continentService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _continentService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _continentService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _continentService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.commoncategory.model.Continent update(
			long continentId, String name, String internationalName,
			String code, String description, int priority, int countCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _continentService.update(
			continentId, name, internationalName, code, description, priority,
			countCode);
	}

	@Override
	public ContinentService getWrappedService() {
		return _continentService;
	}

	@Override
	public void setWrappedService(ContinentService continentService) {
		_continentService = continentService;
	}

	private ContinentService _continentService;

}