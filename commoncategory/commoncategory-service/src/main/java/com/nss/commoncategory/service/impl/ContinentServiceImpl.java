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
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.constants.MyActionKeys;
import com.nss.commoncategory.constants.ResourceConstants;
import com.nss.commoncategory.model.Continent;
import com.nss.commoncategory.service.base.ContinentServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the continent remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.ContinentService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContinentServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=nss",
		"json.web.service.context.path=Continent"
	},
	service = AopService.class
)
public class ContinentServiceImpl extends ContinentServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.nss.commoncategory.service.ContinentServiceUtil</code> to access the continent remote service.
	 */
	public PermissionChecker getMyPermissionChecker() throws PrincipalException {
		return getPermissionChecker();
	}
	
	private static volatile ModelResourcePermission<Continent> _continentModelResourcePermission = ModelResourcePermissionFactory.getInstance(ContinentServiceImpl.class, "_continentModelResourcePermission", Continent.class);
	private static volatile PortletResourcePermission _portletResourcePermission = PortletResourcePermissionFactory.getInstance(ContinentServiceImpl.class, "_portletResourcePermission", ResourceConstants.RESOURCE_NAME);
	
	public boolean hasAddPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.ADD_CONTINENT);
	}
	
	public boolean hasUpdatePermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.UPDATE);
	}
	
	public boolean hasViewPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, MyActionKeys.VIEW);
	}
	
	public Continent addContinent(long userId, String name, String internationalName, 
			String code, String description, int priority, int countCode, boolean active, ServiceContext serContext) throws PortalException {
		
		_portletResourcePermission.check(getPermissionChecker(), serContext.getScopeGroupId(),
		        MyActionKeys.ADD_CONTINENT);
		
		return continentLocalService.addContinent(userId, name, internationalName, code, description, 
				priority, countCode, active, serContext);
	}
	
	public Continent update(long continentId, String name, String internationalName, 
			String code, String description, int priority, int countCode, boolean active) throws PortalException {
		Continent continent = continentLocalService.fetchContinent(continentId);
		_portletResourcePermission.check(getPermissionChecker(), continent.getGroupId(),
		        MyActionKeys.UPDATE);
		
		return continentLocalService.update(continentId, name, internationalName, code, 
				description, priority, countCode, active);
	}
	
}