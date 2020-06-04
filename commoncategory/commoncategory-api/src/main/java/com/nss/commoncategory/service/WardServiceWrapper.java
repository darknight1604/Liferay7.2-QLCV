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
 * Provides a wrapper for {@link WardService}.
 *
 * @author Brian Wing Shun Chan
 * @see WardService
 * @generated
 */
@ProviderType
public class WardServiceWrapper
	implements WardService, ServiceWrapper<WardService> {

	public WardServiceWrapper(WardService wardService) {
		_wardService = wardService;
	}

	@Override
	public com.nss.commoncategory.model.Ward addWard(
			long userId, long countryId, long cityId, long districtId,
			String name, String code, String description, boolean active,
			int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardService.addWard(
			userId, countryId, cityId, districtId, name, code, description,
			active, priority, countCode, serContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wardService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _wardService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _wardService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _wardService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.commoncategory.model.Ward updateWard(
			long wardId, long countryId, long cityId, long districtId,
			String name, String code, String description, boolean active,
			int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardService.updateWard(
			wardId, countryId, cityId, districtId, name, code, description,
			active, priority, countCode, serContext);
	}

	@Override
	public WardService getWrappedService() {
		return _wardService;
	}

	@Override
	public void setWrappedService(WardService wardService) {
		_wardService = wardService;
	}

	private WardService _wardService;

}