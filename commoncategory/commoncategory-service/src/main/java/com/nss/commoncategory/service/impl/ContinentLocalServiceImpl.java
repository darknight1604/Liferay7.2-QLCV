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
import com.nss.commoncategory.model.Continent;
import com.nss.commoncategory.service.base.ContinentLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the continent local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.commoncategory.service.ContinentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContinentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.commoncategory.model.Continent",
	service = AopService.class
)
public class ContinentLocalServiceImpl extends ContinentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.commoncategory.service.ContinentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.ContinentLocalServiceUtil</code>.
	 */
	public Continent addContinent(long userId, String name, String internationalName, 
			String code, String description, int priority, int countCode, ServiceContext serContext) throws PortalException {
		_validateContinentByCode(0, code);
		long continentId = counterLocalService.increment(Continent.class.getName());
		Continent continent = createContinent(continentId);
		User user = userLocalService.fetchUser(userId);
		String userName = StringPool.BLANK;
		if(user != null) {
			userName = user.getFullName();
		}
		Date now = new Date();
		continent.setUserId(userId);
		continent.setUserName(userName);
		continent.setCompanyId(serContext.getCompanyId());
		continent.setGroupId(serContext.getScopeGroupId());
		continent.setCreateDate(now);
		continent.setModifiedDate(now);
		
		continent.setName(name);
		continent.setInternationalName(internationalName);
		continent.setCode(code);
		continent.setDescription(description);
		continent.setPriority(priority);
		continent.setActive(true);
		continent.setCountCode(countCode);
		
		addContinent(continent);
		
		return continent;
	}
	
	public Continent update(long continentId, String name, String internationalName, 
			String code, String description, int priority, int countCode) throws PortalException {
		Continent continent = fetchContinent(continentId);
		
		_validateContinentByCode(continentId, code);
		
		continent.setModifiedDate(new Date());
		continent.setName(name);
		continent.setInternationalName(internationalName);
		continent.setCode(code);
		continent.setDescription(description);
		continent.setPriority(priority);
		continent.setActive(true);
		continent.setCountCode(countCode);
		
		updateContinent(continent);
		
		return continent;
	}
	
	private void _validateContinentByCode(long continentId, String code) throws PortalException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		if (Validator.isNotNull(code)) {
			Continent continent = fetchByCode(code);
			if (continent != null && continent.getContinentId() != continentId) {
				throw new DuplicateCodeException();
			}
		}
	}
	
	public Continent fetchByCode(String code) {
		return continentPersistence.fetchByCode(code);
	}
	
	public List<Continent> findByActive(boolean active){
		return continentPersistence.findByActive(active);
	}
	
	public List<Continent> findByActive(boolean active, int start, int end){
		return continentPersistence.findByActive(active, start, end);
	}
	
	public int countByBaseSearch(int active, String name, String internationalName, String code, 
			String description, boolean andOperator) throws SystemException {
		return continentFinder.countByBaseSearch(active, name, internationalName, code, 
				description, andOperator);
	}
	
	public List<Continent> findByBaseSearch(int active, String name, String internationalName, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return continentFinder.findByBaseSearch(active, name, internationalName, code, description, andOperator, start,
				end, obc);
	}
}