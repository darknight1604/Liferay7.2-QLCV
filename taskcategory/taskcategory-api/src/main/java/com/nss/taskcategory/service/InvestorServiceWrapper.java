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

package com.nss.taskcategory.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link InvestorService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvestorService
 * @generated
 */
@ProviderType
public class InvestorServiceWrapper
	implements InvestorService, ServiceWrapper<InvestorService> {

	public InvestorServiceWrapper(InvestorService investorService) {
		_investorService = investorService;
	}

	@Override
	public com.nss.taskcategory.model.Investor addInvestor(
			long userId, String name, String phoneNumber, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorService.addInvestor(
			userId, name, phoneNumber, email, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _investorService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _investorService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _investorService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _investorService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.taskcategory.model.Investor updateInvestor(
			long investorId, String name, String phoneNumber, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorService.updateInvestor(
			investorId, name, phoneNumber, email, serviceContext);
	}

	@Override
	public InvestorService getWrappedService() {
		return _investorService;
	}

	@Override
	public void setWrappedService(InvestorService investorService) {
		_investorService = investorService;
	}

	private InvestorService _investorService;

}