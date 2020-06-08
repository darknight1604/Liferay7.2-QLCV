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

package com.nss.taskcategory.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.model.Currency;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the currency service. This utility wraps <code>com.nss.taskcategory.service.persistence.impl.CurrencyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrencyPersistence
 * @generated
 */
@ProviderType
public class CurrencyUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Currency currency) {
		getPersistence().clearCache(currency);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Currency> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Currency> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Currency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Currency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Currency> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Currency update(Currency currency) {
		return getPersistence().update(currency);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Currency update(
		Currency currency, ServiceContext serviceContext) {

		return getPersistence().update(currency, serviceContext);
	}

	/**
	 * Returns all the currencies where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching currencies
	 */
	public static List<Currency> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the currencies where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of matching currencies
	 */
	public static List<Currency> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the currencies where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching currencies
	 */
	@Deprecated
	public static List<Currency> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the currencies where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching currencies
	 */
	public static List<Currency> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Currency> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByCompanyId_First(
			long companyId, OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByCompanyId_First(
		long companyId, OrderByComparator<Currency> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByCompanyId_Last(
			long companyId, OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByCompanyId_Last(
		long companyId, OrderByComparator<Currency> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the currencies before and after the current currency in the ordered set where companyId = &#63;.
	 *
	 * @param currencyId the primary key of the current currency
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public static Currency[] findByCompanyId_PrevAndNext(
			long currencyId, long companyId,
			OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCompanyId_PrevAndNext(
			currencyId, companyId, orderByComparator);
	}

	/**
	 * Removes all the currencies where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of currencies where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching currencies
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the currencies where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching currencies
	 */
	public static List<Currency> findByCompanyId_Active(
		long companyId, boolean active) {

		return getPersistence().findByCompanyId_Active(companyId, active);
	}

	/**
	 * Returns a range of all the currencies where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of matching currencies
	 */
	public static List<Currency> findByCompanyId_Active(
		long companyId, boolean active, int start, int end) {

		return getPersistence().findByCompanyId_Active(
			companyId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the currencies where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching currencies
	 */
	@Deprecated
	public static List<Currency> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId_Active(
			companyId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the currencies where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching currencies
	 */
	public static List<Currency> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator) {

		return getPersistence().findByCompanyId_Active(
			companyId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCompanyId_Active_First(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the first currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<Currency> orderByComparator) {

		return getPersistence().fetchByCompanyId_Active_First(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the last currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCompanyId_Active_Last(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the last currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<Currency> orderByComparator) {

		return getPersistence().fetchByCompanyId_Active_Last(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the currencies before and after the current currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param currencyId the primary key of the current currency
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public static Currency[] findByCompanyId_Active_PrevAndNext(
			long currencyId, long companyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCompanyId_Active_PrevAndNext(
			currencyId, companyId, active, orderByComparator);
	}

	/**
	 * Removes all the currencies where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	public static void removeByCompanyId_Active(
		long companyId, boolean active) {

		getPersistence().removeByCompanyId_Active(companyId, active);
	}

	/**
	 * Returns the number of currencies where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching currencies
	 */
	public static int countByCompanyId_Active(long companyId, boolean active) {
		return getPersistence().countByCompanyId_Active(companyId, active);
	}

	/**
	 * Returns all the currencies where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching currencies
	 */
	public static List<Currency> findByActive(boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the currencies where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of matching currencies
	 */
	public static List<Currency> findByActive(
		boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the currencies where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching currencies
	 */
	@Deprecated
	public static List<Currency> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the currencies where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching currencies
	 */
	public static List<Currency> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns the first currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByActive_First(
			boolean active, OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByActive_First(
		boolean active, OrderByComparator<Currency> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByActive_Last(
			boolean active, OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByActive_Last(
		boolean active, OrderByComparator<Currency> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the currencies before and after the current currency in the ordered set where active = &#63;.
	 *
	 * @param currencyId the primary key of the current currency
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public static Currency[] findByActive_PrevAndNext(
			long currencyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByActive_PrevAndNext(
			currencyId, active, orderByComparator);
	}

	/**
	 * Removes all the currencies where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of currencies where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching currencies
	 */
	public static int countByActive(boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Returns the currency where code = &#63; or throws a <code>NoSuchCurrencyException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public static Currency findByCode(String code)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the currency where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching currency, or <code>null</code> if a matching currency could not be found
	 */
	@Deprecated
	public static Currency fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Returns the currency where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public static Currency fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Removes the currency where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the currency that was removed
	 */
	public static Currency removeByCode(String code)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of currencies where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching currencies
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the currency in the entity cache if it is enabled.
	 *
	 * @param currency the currency
	 */
	public static void cacheResult(Currency currency) {
		getPersistence().cacheResult(currency);
	}

	/**
	 * Caches the currencies in the entity cache if it is enabled.
	 *
	 * @param currencies the currencies
	 */
	public static void cacheResult(List<Currency> currencies) {
		getPersistence().cacheResult(currencies);
	}

	/**
	 * Creates a new currency with the primary key. Does not add the currency to the database.
	 *
	 * @param currencyId the primary key for the new currency
	 * @return the new currency
	 */
	public static Currency create(long currencyId) {
		return getPersistence().create(currencyId);
	}

	/**
	 * Removes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency that was removed
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public static Currency remove(long currencyId)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().remove(currencyId);
	}

	public static Currency updateImpl(Currency currency) {
		return getPersistence().updateImpl(currency);
	}

	/**
	 * Returns the currency with the primary key or throws a <code>NoSuchCurrencyException</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public static Currency findByPrimaryKey(long currencyId)
		throws com.nss.taskcategory.exception.NoSuchCurrencyException {

		return getPersistence().findByPrimaryKey(currencyId);
	}

	/**
	 * Returns the currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency, or <code>null</code> if a currency with the primary key could not be found
	 */
	public static Currency fetchByPrimaryKey(long currencyId) {
		return getPersistence().fetchByPrimaryKey(currencyId);
	}

	/**
	 * Returns all the currencies.
	 *
	 * @return the currencies
	 */
	public static List<Currency> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of currencies
	 */
	public static List<Currency> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of currencies
	 */
	@Deprecated
	public static List<Currency> findAll(
		int start, int end, OrderByComparator<Currency> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of currencies
	 */
	public static List<Currency> findAll(
		int start, int end, OrderByComparator<Currency> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the currencies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of currencies.
	 *
	 * @return the number of currencies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CurrencyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CurrencyPersistence, CurrencyPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CurrencyPersistence.class);

		ServiceTracker<CurrencyPersistence, CurrencyPersistence>
			serviceTracker =
				new ServiceTracker<CurrencyPersistence, CurrencyPersistence>(
					bundle.getBundleContext(), CurrencyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}