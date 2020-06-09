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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.commoncategory.model.Address;
import com.nss.commoncategory.model.AddressDTO;
import com.nss.commoncategory.service.AddressLocalServiceUtil;
import com.nss.taskcategory.model.Investor;
import com.nss.taskcategory.service.base.InvestorLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the investor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.InvestorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvestorLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.taskcategory.model.Investor",
	service = AopService.class
)
public class InvestorLocalServiceImpl extends InvestorLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.taskcategory.service.InvestorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.InvestorLocalServiceUtil</code>.
	 */
	public Investor addInvestor(long userId, String name, 
			String phoneNumber, String email, boolean active, AddressDTO addressDTO, ServiceContext serviceContext) throws PortalException {
		long investorId = counterLocalService.increment(Investor.class.getName());
		Investor investor = createInvestor(investorId);
		User user = UserLocalServiceUtil.fetchUser(userId);
		Date now = new Date();
		
		if(user != null) {
			investor.setUserId(userId);
			investor.setUserName(user.getFullName());
		}
		
		investor.setModifiedDate(now);
		investor.setCreateDate(now);
		investor.setCompanyId(serviceContext.getCompanyId());
		investor.setGroupId(serviceContext.getScopeGroupId());
		
		investor.setName(name);
		investor.setPhoneNumber(phoneNumber);
		investor.setEmail(email);
		investor.setExpandoBridgeAttributes(serviceContext);
		investor.setActive(active);
		
		if(addressDTO != null) {
			ClassName cnInvestor = ClassNameLocalServiceUtil.getClassName(Investor.class.getName());
			AddressLocalServiceUtil.addAddress(userId, cnInvestor != null ? cnInvestor.getClassNameId() : 0, investorId, 
					addressDTO.getCountryId(), addressDTO.getCityId(), addressDTO.getDistrictId(), 
					addressDTO.getWardId(), addressDTO.getStreetId(), addressDTO.getStreetOther(), addressDTO.getQuarter(), 
					addressDTO.getHouseNumber(), addressDTO.getBuilding(), addressDTO.getFloor(), addressDTO.getRoom(), addressDTO.getType(), serviceContext);
		}
		
		addInvestor(investor);
		
		return investor;
	}
	
	public Investor updateInvestor(long investorId, String name, 
			String phoneNumber, String email, boolean active, AddressDTO addressDTO, ServiceContext serviceContext) throws PortalException {
		Investor investor = fetchInvestor(investorId);
		Date now = new Date();
		investor.setModifiedDate(now);
		
		investor.setName(name);
		investor.setPhoneNumber(phoneNumber);
		investor.setEmail(email);
		investor.setExpandoBridgeAttributes(serviceContext);
		investor.setActive(active);
		
		if(addressDTO != null) {
			ClassName cnInvestor = ClassNameLocalServiceUtil.getClassName(Investor.class.getName());
			int count = AddressLocalServiceUtil.countByC_C_T(cnInvestor.getClassNameId(), investorId, addressDTO.getType());
			if(count > 0) {
				List<Address> list = AddressLocalServiceUtil.findByC_C_T(cnInvestor.getClassNameId(), investorId, addressDTO.getType());
				AddressLocalServiceUtil.updateAddress(list.get(0).getAddressId(), cnInvestor.getClassNameId(), investorId, addressDTO.getCountryId(), addressDTO.getCityId(), addressDTO.getDistrictId(), 
						addressDTO.getWardId(), addressDTO.getStreetId(), addressDTO.getStreetOther(), addressDTO.getQuarter(), 
						addressDTO.getHouseNumber(), addressDTO.getBuilding(), addressDTO.getFloor(), addressDTO.getRoom(), addressDTO.getType(), serviceContext);
			}else {
				AddressLocalServiceUtil.addAddress(serviceContext.getUserId(), cnInvestor != null ? cnInvestor.getClassNameId() : 0, investorId, 
						addressDTO.getCountryId(), addressDTO.getCityId(), addressDTO.getDistrictId(), 
						addressDTO.getWardId(), addressDTO.getStreetId(), addressDTO.getStreetOther(), addressDTO.getQuarter(), 
						addressDTO.getHouseNumber(), addressDTO.getBuilding(), addressDTO.getFloor(), addressDTO.getRoom(), addressDTO.getType(), serviceContext);
			}
		}
		
		updateInvestor(investor);
		
		return investor;
	}
	
	public int countByCompanyId(long companyId) {
		return investorPersistence.countByCompanyId(companyId);
	}
	
	public List<Investor> findByCompanyId(long companyId){
		return investorPersistence.findByCompanyId(companyId);
	}
	
	public int countByBaseSearch(long companyId, long groupId, int active, String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return investorFinder.countByBaseSearch(companyId, groupId, active, name, code, description, andOperator);
	}
	
	public List<Investor> findByBaseSearch(long companyId, long groupId, int active, 
			String name, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return investorFinder.findByBaseSearch(companyId, groupId, active, name, code, description, andOperator, start, end, obc);
	}
}