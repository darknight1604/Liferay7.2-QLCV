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

package com.nss.taskcategory.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.model.AddressDTO;
import com.nss.taskcategory.constants.TaskCategoryActionKeys;
import com.nss.taskcategory.constants.TaskCategoryResourceConstants;
import com.nss.taskcategory.model.Investor;
import com.nss.taskcategory.service.base.InvestorServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the investor remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.InvestorService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvestorServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=task_category",
		"json.web.service.context.path=Investor"
	},
	service = AopService.class
)
public class InvestorServiceImpl extends InvestorServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.nss.taskcategory.service.InvestorServiceUtil</code> to access the investor remote service.
	 */
	private static volatile PortletResourcePermission _portletResourcePermission = PortletResourcePermissionFactory.getInstance(InvestorServiceImpl.class, "_portletResourcePermission", TaskCategoryResourceConstants.RESOURCE_NAME);
	
	public Investor addInvestor(long userId, String name, 
			String phoneNumber, String email, boolean active, AddressDTO addressDTO, ServiceContext serviceContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), TaskCategoryActionKeys.ADD_INVESTOR);
		return investorLocalService.addInvestor(userId, name, phoneNumber, email, active, addressDTO, serviceContext);
	}
	
	public Investor updateInvestor(long investorId, String name, 
			String phoneNumber, String email, boolean active, AddressDTO addressDTO, ServiceContext serviceContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), TaskCategoryActionKeys.UPDATE);
		return investorLocalService.updateInvestor(investorId, name, phoneNumber, email, active, addressDTO, serviceContext);
	}
	
	public boolean hasAddPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, TaskCategoryActionKeys.ADD_INVESTOR);
	}
	
	public boolean hasUpdatePermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, TaskCategoryActionKeys.UPDATE);
	}
	
	public boolean hasViewPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, TaskCategoryActionKeys.VIEW);
	}
}