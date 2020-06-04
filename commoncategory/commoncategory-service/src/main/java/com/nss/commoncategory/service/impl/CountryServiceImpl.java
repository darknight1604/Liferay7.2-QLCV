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

package com.nss.commoncategory.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.constants.MyActionKeys;
import com.nss.commoncategory.constants.ResourceConstants;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.service.base.CountryServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the country remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.CountryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=nss",
		"json.web.service.context.path=Country"
	},
	service = AopService.class
)
public class CountryServiceImpl extends CountryServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.nss.commoncategory.service.CountryServiceUtil</code> to access the country remote service.
	 */
	private static volatile PortletResourcePermission _portletResourcePermission = PortletResourcePermissionFactory.getInstance(CountryServiceImpl.class, "_portletResourcePermission", ResourceConstants.RESOURCE_NAME);
	
	public boolean hasAddPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.ADD_COUNTRY);
	}
	
	public boolean hasUpdatePermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.UPDATE);
	}
	
	public boolean hasViewPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.VIEW);
	}
	
	public Country addCountry(long userId, long continentId, String name, String internationalName, 
			String nationality, String code, String description, int priority, int countCode, boolean active, ServiceContext serContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serContext.getScopeGroupId(),
		        MyActionKeys.ADD_COUNTRY);
		return countryLocalService.addCountry(userId, continentId, name, internationalName, nationality, 
				code, description, priority, countCode, active, serContext);
	}
	
	public Country updateCountry(long countryId, long continentId, String name, String internationalName, 
			String nationality, String code, String description, int priority, int countCode, boolean active) throws PortalException {
		Country country = countryLocalService.fetchCountry(countryId);
		_portletResourcePermission.check(getPermissionChecker(), country.getGroupId(),
		        MyActionKeys.UPDATE);
		return countryLocalService.updateCountry(countryId, continentId, name, internationalName, 
				nationality, code, description, priority, countCode, active);
	}
}