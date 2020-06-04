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
import com.nss.commoncategory.model.District;
import com.nss.commoncategory.service.base.DistrictLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the district local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.DistrictLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.District",
	service = AopService.class
)
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.DistrictLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.DistrictLocalServiceUtil</code>.
	 */
	public District addDistrict(long userId, long countryId, long cityId, String name, 
			String code, String description, int priority, int countCode, boolean active, ServiceContext serContext) throws PortalException {
		_validateDistrictByCode(0, code);
		long districtId = counterLocalService.increment(District.class.getName());
		District district = createDistrict(districtId);
		User user = userLocalService.fetchUser(userId);
		String userName = StringPool.BLANK;
		if(user != null) {
			userName = user.getFullName();
		}
		Date now = new Date();
		district.setUserId(userId);
		district.setUserName(userName);
		district.setCompanyId(serContext.getCompanyId());
		district.setGroupId(serContext.getScopeGroupId());
		district.setCreateDate(now);
		district.setModifiedDate(now);
		
		district.setCountryId(countryId);
		district.setCityId(cityId);
		district.setName(name);
		district.setCode(code);
		district.setDescription(description);
		district.setPriority(priority);
		district.setCountCode(countCode);
		district.setActive(active);
		district.setExpandoBridgeAttributes(serContext);
		
		addDistrict(district);
		
		return district;
	}
	
	public District updateDistrict(long districtId, long countryId, long cityId, String name, 
			String code, String description, int priority, int countCode, boolean active, ServiceContext serContext) throws PortalException {
		_validateDistrictByCode(districtId, code);
		District district = fetchDistrict(districtId);
		
		district.setModifiedDate(new Date());
		
		district.setCountryId(countryId);
		district.setName(name);
		district.setCode(code);
		district.setDescription(description);
		district.setPriority(priority);
		district.setCountCode(countCode);
		district.setActive(active);
		district.setExpandoBridgeAttributes(serContext);
		district.setCityId(cityId);
		
		updateDistrict(district);
		
		return district;
	}
	
	public void _validateDistrictByCode(long districtId, String code) throws EmptyCodeException, DuplicateCodeException {
		if(Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		District district = fetchByCode(code);
		if(district != null && district.getDistrictId() != districtId) {
			throw new DuplicateCodeException();
		}
	}
	
	public District fetchByCode(String code) {
		return districtPersistence.fetchByCode(code);
	}
	
	public List<District> findByActive(boolean active){
		return districtPersistence.findByActive(active);
	}
	
	public List<District> findByCityId_Active(long cityId, boolean active){
		return districtPersistence.findByCityId_Active(cityId, active);
	}
	
	public District fetchByCityId_Name(long cityId, String name) {
		return districtPersistence.fetchByCityId_Name(cityId, name);
	}
	
	public int countByBaseSearch(long companyId, long groupId, long countryId, long cityId, int active, 
			String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return districtFinder.countByBaseSearch(companyId, groupId, countryId, cityId, active, 
				name, code, 
				description, andOperator);
	}
	
	public List<District> findByBaseSearch(long companyId, long groupId, long countryId, long cityId, int active, String name, 
			String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return districtFinder.findByBaseSearch(companyId, groupId, countryId, cityId, active, name, 
				code, description, andOperator, start,
				end, obc);
	}
}