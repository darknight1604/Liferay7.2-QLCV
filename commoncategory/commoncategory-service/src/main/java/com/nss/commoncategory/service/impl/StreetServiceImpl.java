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
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.service.base.StreetServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the street remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.StreetService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StreetServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=nss",
		"json.web.service.context.path=Street"
	},
	service = AopService.class
)
public class StreetServiceImpl extends StreetServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.nss.commoncategory.service.StreetServiceUtil</code> to access the street remote service.
	 */
	private static volatile PortletResourcePermission _portletResourcePermission = PortletResourcePermissionFactory.getInstance(StreetServiceImpl.class, "_portletResourcePermission", ResourceConstants.RESOURCE_NAME);
	
	public boolean hasAddPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.ADD_STREET);
	}
	
	public boolean hasUpdatePermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.UPDATE);
	}
	
	public boolean hasViewPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.VIEW);
	}
	
	public Street addStreet(long userId, long countryId, long cityId, long districtId, long wardId, String name, 
			String code, String description, boolean active, int priority, int countCode, ServiceContext serContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serContext.getScopeGroupId(),
		        MyActionKeys.ADD_STREET);
		return streetLocalService.addStreet(userId, countryId, cityId, districtId, wardId, name, 
				code, description, active, priority, countCode, serContext);
	}
	
	public Street updateStreet(long streetId, long countryId, long cityId, long districtId, long wardId, String name, 
			String code, String description, boolean active, int priority, int countCode, ServiceContext serContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serContext.getScopeGroupId(),
		        MyActionKeys.UPDATE);
		return streetLocalService.updateStreet(streetId, countryId, cityId, districtId, wardId, name, 
				code, description, active, priority, countCode, serContext);
	}
}