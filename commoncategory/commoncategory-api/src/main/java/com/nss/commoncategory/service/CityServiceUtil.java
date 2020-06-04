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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for City. This utility wraps
 * <code>com.nss.commoncategory.service.impl.CityServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CityService
 * @generated
 */
@ProviderType
public class CityServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.commoncategory.service.impl.CityServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.nss.commoncategory.model.City addCity(
			long userId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCity(
			userId, countryId, name, code, description, priority, countCode,
			active, serContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().hasAddPermission(groupId);
	}

	public static boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().hasUpdatePermission(groupId);
	}

	public static boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().hasViewPermission(groupId);
	}

	public static com.nss.commoncategory.model.City updateCity(
			long cityId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCity(
			cityId, countryId, name, code, description, priority, countCode,
			active, serContext);
	}

	public static CityService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CityService, CityService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CityService.class);

		ServiceTracker<CityService, CityService> serviceTracker =
			new ServiceTracker<CityService, CityService>(
				bundle.getBundleContext(), CityService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}