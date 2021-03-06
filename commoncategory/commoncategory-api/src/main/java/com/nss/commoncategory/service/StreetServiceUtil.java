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
 * Provides the remote service utility for Street. This utility wraps
 * <code>com.nss.commoncategory.service.impl.StreetServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StreetService
 * @generated
 */
@ProviderType
public class StreetServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.commoncategory.service.impl.StreetServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.nss.commoncategory.model.Street addStreet(
			long userId, long countryId, long cityId, long districtId,
			long wardId, String name, String code, String description,
			boolean active, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addStreet(
			userId, countryId, cityId, districtId, wardId, name, code,
			description, active, priority, countCode, serContext);
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

	public static com.nss.commoncategory.model.Street updateStreet(
			long streetId, long countryId, long cityId, long districtId,
			long wardId, String name, String code, String description,
			boolean active, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStreet(
			streetId, countryId, cityId, districtId, wardId, name, code,
			description, active, priority, countCode, serContext);
	}

	public static StreetService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StreetService, StreetService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StreetService.class);

		ServiceTracker<StreetService, StreetService> serviceTracker =
			new ServiceTracker<StreetService, StreetService>(
				bundle.getBundleContext(), StreetService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}