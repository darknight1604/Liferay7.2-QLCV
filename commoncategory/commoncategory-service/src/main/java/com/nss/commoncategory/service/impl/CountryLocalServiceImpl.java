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
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.service.base.CountryLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the country local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.CountryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.Country",
	service = AopService.class
)
public class CountryLocalServiceImpl extends CountryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.CountryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.CountryLocalServiceUtil</code>.
	 */
	
	public Country addCountry(long userId, long continentId, String name, String internationalName, 
			String nationality, String code, String description, int priority, int countCode, ServiceContext serContext) throws PortalException {
		_validateCountryByCode(0, code);
		long countryId = counterLocalService.increment(Country.class.getName());
		Country country = createCountry(countryId);
		User user = userLocalService.fetchUser(userId);
		String userName = StringPool.BLANK;
		if(user != null) {
			userName = user.getFullName();
		}
		Date now = new Date();
		country.setUserId(userId);
		country.setUserName(userName);
		country.setCompanyId(serContext.getCompanyId());
		country.setGroupId(serContext.getScopeGroupId());
		country.setCreateDate(now);
		country.setModifiedDate(now);
		
		country.setName(name);
		country.setInternationalName(internationalName);
		country.setCode(code);
		country.setDescription(description);
		country.setPriority(priority);
		country.setActive(true);
		country.setCountCode(countCode);
		country.setNationality(nationality);
		country.setContinentId(continentId);
		
		addCountry(country);
		
		return country;
	}
	
	public Country updateCountry(long countryId, long continentId, String name, String internationalName, 
			String nationality, String code, String description, int priority, int countCode) throws PortalException {
		Country country = fetchCountry(countryId);
		
		_validateCountryByCode(countryId, code);
		
		country.setModifiedDate(new Date());
		country.setName(name);
		country.setInternationalName(internationalName);
		country.setCode(code);
		country.setDescription(description);
		country.setPriority(priority);
		country.setActive(true);
		country.setCountCode(countCode);
		country.setNationality(nationality);
		country.setContinentId(continentId);
		
		updateCountry(country);
		
		return country;
	}
	
	private void _validateCountryByCode(long countryId, String code) throws PortalException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		if (Validator.isNotNull(code)) {
			Country country = fetchByCode(code);
			if (country != null && country.getCountryId() != countryId) {
				throw new DuplicateCodeException();
			}
		}
	}
	
	public Country fetchByCode(String code) {
		return countryPersistence.fetchByCode(code);
	}
	
	public List<Country> findByActive(boolean active){
		return countryPersistence.findByActive(active);
	}
	
	public List<Country> findByActive(boolean active, int start, int end){
		return countryPersistence.findByActive(active, start, end);
	}
	
	public int countByBaseSearch(long companyId, long groupId, long continentId, int active, 
			String name, String internationalName, String code, 
			String description, boolean andOperator) throws SystemException {
		return countryFinder.countByBaseSearch(companyId, groupId, continentId, active, 
				name, internationalName, code, 
				description, andOperator);
	}
	
	public List<Country> findByBaseSearch(long companyId, long groupId, long continentId, int active, String name, String internationalName, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return countryFinder.findByBaseSearch(companyId, groupId, continentId, active, name, 
				internationalName, code, description, andOperator, start,
				end, obc);
	}
}