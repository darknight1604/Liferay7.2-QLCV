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
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.service.base.StreetLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the street local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.StreetLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StreetLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.Street",
	service = AopService.class
)
public class StreetLocalServiceImpl extends StreetLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.StreetLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.StreetLocalServiceUtil</code>.
	 */
	
	public Street addStreet(long userId, long countryId, long cityId, long districtId, long wardId, String name, 
			String code, String description, boolean active, int priority, int countCode, ServiceContext serContext) throws PortalException {
		long streetId = counterLocalService.increment(Street.class.getName());
		_validateStreetByCode(0, code);
		Street street = createStreet(streetId);
		User user = userLocalService.fetchUser(userId);
		String userName = StringPool.BLANK;
		if(user != null) {
			userName = user.getFullName();
		}
		Date now = new Date();
		street.setUserId(userId);
		street.setUserName(userName);
		street.setCompanyId(serContext.getCompanyId());
		street.setGroupId(serContext.getScopeGroupId());
		street.setCreateDate(now);
		street.setModifiedDate(now);
		
		street.setCountryId(countryId);
		street.setCityId(cityId);
		street.setDistrictId(districtId);
		street.setWardId(wardId);
		street.setName(name);
		street.setCode(code);
		street.setDescription(description);
		street.setPriority(priority);
		street.setCountCode(countCode);
		street.setActive(active);
		street.setExpandoBridgeAttributes(serContext);
		
		addStreet(street);
		
		return street;
	}
	
	public Street updateStreet(long streetId, long countryId, long cityId, long districtId, long wardId, String name, 
			String code, String description, boolean active, int priority, int countCode, ServiceContext serContext) throws PortalException {
		Street street = fetchStreet(streetId);
		_validateStreetByCode(streetId, code);
		street.setModifiedDate(new Date());
		
		street.setCountryId(countryId);
		street.setCityId(cityId);
		street.setDistrictId(districtId);
		street.setWardId(wardId);
		street.setName(name);
		street.setCode(code);
		street.setDescription(description);
		street.setPriority(priority);
		street.setCountCode(countCode);
		street.setActive(active);
		street.setExpandoBridgeAttributes(serContext);
		
		updateStreet(street);
		return street;
	}
	
	public Street fetchByCode(String code) {
		return streetPersistence.fetchByCode(code);
	}
	
	public void _validateStreetByCode(long streetId, String code) throws EmptyCodeException, DuplicateCodeException {
		if(Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		Street street = fetchByCode(code);
		if(street != null && street.getStreetId() != streetId) {
			throw new DuplicateCodeException();
		}
	}
	
	public List<Street> findByActive(boolean active){
		return streetPersistence.findByActive(active);
	}
	
	public List<Street> findByCityId_Active(long cityId, boolean active){
		return streetPersistence.findByCityId_Active(cityId, active);
	}
	
	public List<Street> findByDistrictId_Active(long districtId, boolean active){
		return streetPersistence.findByDistrictId_Active(districtId, active);
	}
	
	public List<Street> findByWardId_Active(long wardId, boolean active){
		return streetPersistence.findByWardId_Active(wardId, active);
	}
	
	public Street fetchByWardId_Name(long wardId, String name) {
		return streetPersistence.fetchByWardId_Name(wardId, name);
	}
	
	public int countByBaseSearch(long companyId, long groupId, long countryId, 
			long cityId, long districtId, long wardId, int active, 
			String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return streetFinder.countByBaseSearch(companyId, groupId, countryId, 
				cityId, districtId, wardId, active, 
				name, code, 
				description, andOperator);
	}
	
	public List<Street> findByBaseSearch(long companyId, long groupId, long countryId, 
			long cityId, long districtId, long wardId, int active, String name, 
			String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return streetFinder.findByBaseSearch(companyId, groupId, countryId, 
				cityId, districtId, wardId, active, name, 
				code, description, andOperator, start,
				end, obc);
	}
}