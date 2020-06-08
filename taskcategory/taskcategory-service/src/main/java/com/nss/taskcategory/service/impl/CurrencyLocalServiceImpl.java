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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.exception.EmptyCodeException;
import com.nss.taskcategory.model.Currency;
import com.nss.taskcategory.service.base.CurrencyLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the currency local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.CurrencyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrencyLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.taskcategory.model.Currency",
	service = AopService.class
)
public class CurrencyLocalServiceImpl extends CurrencyLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.taskcategory.service.CurrencyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.CurrencyLocalServiceUtil</code>.
	 */
	public Currency addCurrency(long userId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateCurrencyByCode(0, code);
		
		long currencyId = counterLocalService.increment(Currency.class.getName());
		Currency currency = createCurrency(currencyId);
		User user = UserLocalServiceUtil.fetchUser(userId);
		Date now = new Date();
		
		if(user != null) {
			currency.setUserId(userId);
			currency.setUserName(user.getFullName());
		}
		
		currency.setModifiedDate(now);
		currency.setCreateDate(now);
		currency.setCompanyId(serviceContext.getCompanyId());
		currency.setGroupId(serviceContext.getScopeGroupId());
		
		currency.setName(name);
		currency.setCode(code);
		currency.setPriority(priority);
		currency.setActive(active);
		currency.setDescription(description);
		currency.setExpandoBridgeAttributes(serviceContext);
		
		addCurrency(currency);
		
		return currency;
	}
	
	public Currency updateCurrency(long currencyId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateCurrencyByCode(currencyId, code);
		Currency currency = fetchCurrency(currencyId);
		Date now = new Date();
		currency.setModifiedDate(now);
		
		currency.setName(name);
		currency.setCode(code);
		currency.setPriority(priority);
		currency.setActive(active);
		currency.setDescription(description);
		currency.setExpandoBridgeAttributes(serviceContext);
		
		updateCurrency(currency);
		
		return currency;
	}
	
	public Currency fetchByCode(String code) {
		return currencyPersistence.fetchByCode(code);
	}
	
	private void _validateCurrencyByCode(long currencyId, String code) throws PortalException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		if (Validator.isNotNull(code)) {
			Currency currency = fetchByCode(code);
			if (currency != null && currency.getCurrencyId() != currencyId) {
				throw new DuplicateCodeException();
			}
		}
	}
	
	public int countByCompanyId(long companyId) {
		return currencyPersistence.countByCompanyId(companyId);
	}
	
	public List<Currency> findByCompanyId(long companyId){
		return currencyPersistence.findByCompanyId(companyId);
	}
	
	public int countByCompanyId_Active(long companyId, boolean active) {
		return currencyPersistence.countByCompanyId_Active(companyId, active);
	}
	
	public List<Currency> findByCompanyId_Active(long companyId, boolean active){
		return currencyPersistence.findByCompanyId_Active(companyId, active);
	}
	
	public int countByActive(boolean active) {
		return currencyPersistence.countByActive(active);
	}
	
	public List<Currency> findByActive(boolean active) {
		return currencyPersistence.findByActive(active);
	}
	
	public int countByBaseSearch(long companyId, long groupId, int active, String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return currencyFinder.countByBaseSearch(companyId, groupId, active, name, code, description, andOperator);
	}
	
	public List<Currency> findByBaseSearch(long companyId, long groupId, int active, 
			String name, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return currencyFinder.findByBaseSearch(companyId, groupId, active, name, code, description, andOperator, start, end, obc);
	}
}