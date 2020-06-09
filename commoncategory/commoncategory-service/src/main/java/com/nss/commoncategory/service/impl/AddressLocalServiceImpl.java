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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.model.Address;
import com.nss.commoncategory.service.base.AddressLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the address local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.AddressLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.Address",
	service = AopService.class
)
public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.AddressLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.AddressLocalServiceUtil</code>.
	 */
	public Address addAddress(long userId, long classNameId, long classPK, long countryId, long cityId, long districtId,
			long wardId, long streetId, String streetOther, String quarter, String houseNumber, String building,
			String floor, String room, int type, ServiceContext serviceContext)
			throws PortalException {
		Date now = new Date();
		User user = null;
		long groupId = 0;
		if (userId > 0) {
			user = userLocalService.fetchUser(userId);
			groupId = serviceContext.getScopeGroupId();
		}

		long addressId = counterLocalService.increment(Address.class.getName());
		Address address = addressPersistence.create(addressId);

		address.setGroupId(groupId);
		if (user != null) {
			address.setCompanyId(user.getCompanyId());
			address.setUserId(user.getUserId());
			address.setUserName(user.getFullName());
			address.setCreateDate(now);
			address.setModifiedDate(now);
		} else {
			address.setCreateDate(now);
			address.setModifiedDate(now);
		}

		address.setClassNameId(classNameId);
		address.setClassPK(classPK);
		address.setCountryId(countryId);
		address.setCityId(cityId);
		address.setDistrictId(districtId);
		address.setWardId(wardId);
		address.setStreetId(streetId);
		address.setStreetOther(streetOther);
		address.setQuarter(quarter);
		address.setHouseNumber(houseNumber);
		address.setBuilding(building);
		address.setFloor(floor);
		address.setRoom(room);
		address.setType(type);
		address.setExpandoBridgeAttributes(serviceContext);

		addAddress(address);

		return address;
	}

	public Address updateAddress(long addressId, long classNameId, long classPK, long countryId, long cityId,
			long districtId, long wardId, long streetId, String streetOther, String quarter, String houseNumber,
			String building, String floor, String room, int type,
			ServiceContext serviceContext) throws PortalException {
		Address address = addressPersistence.fetchByPrimaryKey(addressId);
		address.setModifiedDate(serviceContext.getModifiedDate(null));

		address.setClassNameId(classNameId);
		address.setClassPK(classPK);
		address.setCountryId(countryId);
		address.setCityId(cityId);
		address.setDistrictId(districtId);
		address.setWardId(wardId);
		address.setStreetId(streetId);
		address.setStreetOther(streetOther);
		address.setQuarter(quarter);
		address.setHouseNumber(houseNumber);
		address.setBuilding(building);
		address.setFloor(floor);
		address.setRoom(room);
		address.setType(type);
		address.setExpandoBridgeAttributes(serviceContext);

		updateAddress(address);

		return address;
	}
	
	public int countByCompanyId(long companyId) {
		return addressPersistence.countByCompanyId(companyId);
	}

	public List<Address> findByCompanyId(long companyId) {
		return addressPersistence.findByCompanyId(companyId);
	}

	public List<Address> findByCompanyId(long companyId, int start, int end) {
		return addressPersistence.findByCompanyId(companyId, start, end);
	}
	
	public void removeByCompanyId(long companyId) {
		addressPersistence.removeByCompanyId(companyId);
	}

	public int countByClassNameId_ClassPK(long classNameId, long classPK) {
		return addressPersistence.countByClassNameId_ClassPK(classNameId, classPK);
	}

	public List<Address> findByClassNameId_ClassPK(long classNameId, long classPK) {
		return addressPersistence.findByClassNameId_ClassPK(classNameId, classPK);
	}

	public List<Address> findByClassNameId_ClassPK(long classNameId, long classPK, int start, int end) {
		return addressPersistence.findByClassNameId_ClassPK(classNameId, classPK, start, end);
	}
	
	public void removeByClassNameId_ClassPK(long classNameId, long classPK) {
		addressPersistence.removeByClassNameId_ClassPK(classNameId, classPK);
	}
	
	public int countByC_C_T(long classNameId, long classPK, int type) {
		return addressPersistence.countByC_C_T(classNameId, classPK, type);
	}

	public List<Address> findByC_C_T(long classNameId, long classPK, int type) {
		return addressPersistence.findByC_C_T(classNameId, classPK, type);
	}
	
	public void removeByC_C_T(long classNameId, long classPK, int type) {
		addressPersistence.removeByC_C_T(classNameId, classPK, type);
	}
}