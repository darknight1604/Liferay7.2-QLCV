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
 * Provides a wrapper for {@link DistrictService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictService
 * @generated
 */
@ProviderType
public class DistrictServiceWrapper
	implements DistrictService, ServiceWrapper<DistrictService> {

	public DistrictServiceWrapper(DistrictService districtService) {
		_districtService = districtService;
	}

	@Override
	public com.nss.commoncategory.model.District addDistrict(
			long userId, long countryId, long cityId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtService.addDistrict(
			userId, countryId, cityId, name, code, description, priority,
			countCode, active, serContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _districtService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _districtService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _districtService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _districtService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.commoncategory.model.District updateDistrict(
			long districtId, long countryId, long cityId, String name,
			String code, String description, int priority, int countCode,
			boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtService.updateDistrict(
			districtId, countryId, cityId, name, code, description, priority,
			countCode, active, serContext);
	}

	@Override
	public DistrictService getWrappedService() {
		return _districtService;
	}

	@Override
	public void setWrappedService(DistrictService districtService) {
		_districtService = districtService;
	}

	private DistrictService _districtService;

}