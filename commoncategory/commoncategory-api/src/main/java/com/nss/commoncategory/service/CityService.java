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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.nss.commoncategory.model.City;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for City. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CityServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CityService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityServiceUtil} to access the city remote service. Add custom service methods to <code>com.nss.commoncategory.service.impl.CityServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public City addCity(
			long userId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			ServiceContext serContext)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAddPermission(long groupId) throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasUpdatePermission(long groupId) throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasViewPermission(long groupId) throws PrincipalException;

	public City updateCity(
			long cityId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			ServiceContext serContext)
		throws PortalException;

}