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
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.service.base.CityLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the city local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.CityLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.City",
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.CityLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.CityLocalServiceUtil</code>.
	 */
	
	public City addCity(long userId, long countryId, String name, 
			String code, String description, int priority, int countCode, boolean active, ServiceContext serContext) throws PortalException {
		_validateCityByCode(0, code);
		long cityId = counterLocalService.increment(City.class.getName());
		City city = createCity(cityId);
		User user = userLocalService.fetchUser(userId);
		String userName = StringPool.BLANK;
		if(user != null) {
			userName = user.getFullName();
		}
		Date now = new Date();
		city.setUserId(userId);
		city.setUserName(userName);
		city.setCompanyId(serContext.getCompanyId());
		city.setGroupId(serContext.getScopeGroupId());
		city.setCreateDate(now);
		city.setModifiedDate(now);
		
		city.setCountryId(countryId);
		city.setName(name);
		city.setCode(code);
		city.setDescription(description);
		city.setPriority(priority);
		city.setCountCode(countCode);
		city.setActive(active);
		city.setExpandoBridgeAttributes(serContext);
		
		addCity(city);
		
		return city;
	}
	
	public City updateCity(long cityId, long countryId, String name, 
			String code, String description, int priority, int countCode, boolean active, ServiceContext serContext) throws PortalException {
		_validateCityByCode(cityId, code);
		City city = fetchCity(cityId);
		
		city.setModifiedDate(new Date());
		city.setName(name);
		city.setCode(code);
		city.setDescription(description);
		city.setPriority(priority);
		city.setCountCode(countCode);
		city.setExpandoBridgeAttributes(serContext);
		city.setActive(active);
		city.setCountryId(countryId);
		
		updateCity(city);
		
		return city;
	}
	
	public City fetchByCode(String code) {
		return cityPersistence.fetchByCode(code);
	}
	
	private void _validateCityByCode(long cityId, String code) throws DuplicateCodeException, EmptyCodeException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		City city = fetchByCode(code);
		if(city != null && city.getCityId() != cityId) {
			throw new DuplicateCodeException();
		}
	}
	
	public List<City> findByActive(boolean active){
		return cityPersistence.findByActive(active);
	}
	
	public List<City> findByCountryId_Active(long countryId, boolean active){
		return cityPersistence.findByCountryId_Active(countryId, active);
	}
	
	public City fetchByCountryId_Name(long countryId, String name) {
		return cityPersistence.fetchByCountryId_Name(countryId, name);
	}
	
	public int countByBaseSearch(long companyId, long groupId, long countryId, int active, 
			String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return cityFinder.countByBaseSearch(companyId, groupId, countryId, active, 
				name, code, 
				description, andOperator);
	}
	
	public List<City> findByBaseSearch(long companyId, long groupId, long countryId, int active, String name, 
			String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return cityFinder.findByBaseSearch(companyId, groupId, countryId, active, name, 
				code, description, andOperator, start,
				end, obc);
	}
}