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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.exception.EmptyCodeException;
import com.nss.commoncategory.model.Ward;
import com.nss.commoncategory.service.base.WardLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ward local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.WardLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WardLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.Ward",
	service = AopService.class
)
public class WardLocalServiceImpl extends WardLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.WardLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.WardLocalServiceUtil</code>.
	 */
	public Ward addWard(long userId, long countryId, long cityId, long districtId, String name, 
			String code, String description, boolean active, int priority, int countCode, ServiceContext serContext) throws PortalException {
		long wardId = counterLocalService.increment(Ward.class.getName());
		_validateWardByCode(0, code);
		Ward ward = createWard(wardId);
		User user = userLocalService.fetchUser(userId);
		String userName = StringPool.BLANK;
		if(user != null) {
			userName = user.getFullName();
		}
		Date now = new Date();
		ward.setUserId(userId);
		ward.setUserName(userName);
		ward.setCompanyId(serContext.getCompanyId());
		ward.setGroupId(serContext.getScopeGroupId());
		ward.setCreateDate(now);
		ward.setModifiedDate(now);
		
		ward.setCountryId(countryId);
		ward.setCityId(cityId);
		ward.setDistrictId(districtId);
		ward.setName(name);
		ward.setCode(code);
		ward.setDescription(description);
		ward.setPriority(priority);
		ward.setCountCode(countCode);
		ward.setActive(active);
		ward.setExpandoBridgeAttributes(serContext);
		
		addWard(ward);
		
		return ward;
	}
	
	public Ward updateWard(long wardId, long countryId, long cityId, long districtId, String name, 
			String code, String description, boolean active, int priority, int countCode, ServiceContext serContext) throws PortalException {
		Ward ward = fetchWard(wardId);
		_validateWardByCode(wardId, code);
		ward.setModifiedDate(new Date());
		
		ward.setCountryId(countryId);
		ward.setCityId(cityId);
		ward.setDistrictId(districtId);
		ward.setName(name);
		ward.setCode(code);
		ward.setDescription(description);
		ward.setPriority(priority);
		ward.setCountCode(countCode);
		ward.setActive(active);
		ward.setExpandoBridgeAttributes(serContext);
		
		updateWard(ward);
		return ward;
	}
	
	public void _validateWardByCode(long wardId, String code) throws EmptyCodeException, DuplicateCodeException {
		if(Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		Ward ward = fetchByCode(code);
		if(ward != null && ward.getWardId() != wardId) {
			throw new DuplicateCodeException();
		}
	}
	
	public Ward fetchByCode(String code) {
		return wardPersistence.fetchByCode(code);
	}
	
	public List<Ward> findByDistrictId_Active(long districtId, boolean active){
		return wardPersistence.findByDistrictId_Active(districtId, active);
	}
	
	public Ward fetchByDistrictId_Name(long districtId, String name) {
		return wardPersistence.fetchByDistrictId_Name(districtId, name);
	}
	
	public int countByBaseSearch(long companyId, long groupId, long countryId, long cityId, long districtId, int active, 
			String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return wardFinder.countByBaseSearch(companyId, groupId, countryId, cityId, districtId, active, 
				name, code, 
				description, andOperator);
	}
	
	public List<Ward> findByBaseSearch(long companyId, long groupId, long countryId, 
			long cityId, long districtId, int active, String name, 
			String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return wardFinder.findByBaseSearch(companyId, groupId, countryId, 
				cityId, districtId, active, name, 
				code, description, andOperator, start,
				end, obc);
	}
}