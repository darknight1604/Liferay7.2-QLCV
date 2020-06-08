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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.exception.NoSuchCurrencyException;
import com.nss.taskcategory.model.Currency;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrencyUtil
 * @generated
 */
@ProviderType
public interface CurrencyPersistence extends BasePersistence<Currency> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CurrencyUtil} to access the currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the currencies where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching currencies
	 */
	public java.util.List<Currency> findByCompanyId(long companyId);

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
	public java.util.List<Currency> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<Currency> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Currency> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the first currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByCompanyId_First(
			long companyId, OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Returns the first currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByCompanyId_First(
		long companyId, OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the last currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByCompanyId_Last(
			long companyId, OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Returns the last currency in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByCompanyId_Last(
		long companyId, OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the currencies before and after the current currency in the ordered set where companyId = &#63;.
	 *
	 * @param currencyId the primary key of the current currency
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public Currency[] findByCompanyId_PrevAndNext(
			long currencyId, long companyId,
			OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Removes all the currencies where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of currencies where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching currencies
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the currencies where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching currencies
	 */
	public java.util.List<Currency> findByCompanyId_Active(
		long companyId, boolean active);

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
	public java.util.List<Currency> findByCompanyId_Active(
		long companyId, boolean active, int start, int end);

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
	public java.util.List<Currency> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Currency> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the first currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Returns the first currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the last currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Returns the last currency in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<Currency> orderByComparator);

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
	public Currency[] findByCompanyId_Active_PrevAndNext(
			long currencyId, long companyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Removes all the currencies where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	public void removeByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns the number of currencies where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching currencies
	 */
	public int countByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns all the currencies where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching currencies
	 */
	public java.util.List<Currency> findByActive(boolean active);

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
	public java.util.List<Currency> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<Currency> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Currency> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the first currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByActive_First(
			boolean active, OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Returns the first currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByActive_First(
		boolean active, OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the last currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByActive_Last(
			boolean active, OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Returns the last currency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByActive_Last(
		boolean active, OrderByComparator<Currency> orderByComparator);

	/**
	 * Returns the currencies before and after the current currency in the ordered set where active = &#63;.
	 *
	 * @param currencyId the primary key of the current currency
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public Currency[] findByActive_PrevAndNext(
			long currencyId, boolean active,
			OrderByComparator<Currency> orderByComparator)
		throws NoSuchCurrencyException;

	/**
	 * Removes all the currencies where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of currencies where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching currencies
	 */
	public int countByActive(boolean active);

	/**
	 * Returns the currency where code = &#63; or throws a <code>NoSuchCurrencyException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	public Currency findByCode(String code) throws NoSuchCurrencyException;

	/**
	 * Returns the currency where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching currency, or <code>null</code> if a matching currency could not be found
	 */
	@Deprecated
	public Currency fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the currency where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching currency, or <code>null</code> if a matching currency could not be found
	 */
	public Currency fetchByCode(String code);

	/**
	 * Removes the currency where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the currency that was removed
	 */
	public Currency removeByCode(String code) throws NoSuchCurrencyException;

	/**
	 * Returns the number of currencies where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching currencies
	 */
	public int countByCode(String code);

	/**
	 * Caches the currency in the entity cache if it is enabled.
	 *
	 * @param currency the currency
	 */
	public void cacheResult(Currency currency);

	/**
	 * Caches the currencies in the entity cache if it is enabled.
	 *
	 * @param currencies the currencies
	 */
	public void cacheResult(java.util.List<Currency> currencies);

	/**
	 * Creates a new currency with the primary key. Does not add the currency to the database.
	 *
	 * @param currencyId the primary key for the new currency
	 * @return the new currency
	 */
	public Currency create(long currencyId);

	/**
	 * Removes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency that was removed
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public Currency remove(long currencyId) throws NoSuchCurrencyException;

	public Currency updateImpl(Currency currency);

	/**
	 * Returns the currency with the primary key or throws a <code>NoSuchCurrencyException</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	public Currency findByPrimaryKey(long currencyId)
		throws NoSuchCurrencyException;

	/**
	 * Returns the currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency, or <code>null</code> if a currency with the primary key could not be found
	 */
	public Currency fetchByPrimaryKey(long currencyId);

	/**
	 * Returns all the currencies.
	 *
	 * @return the currencies
	 */
	public java.util.List<Currency> findAll();

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
	public java.util.List<Currency> findAll(int start, int end);

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
	public java.util.List<Currency> findAll(
		int start, int end, OrderByComparator<Currency> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Currency> findAll(
		int start, int end, OrderByComparator<Currency> orderByComparator);

	/**
	 * Removes all the currencies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of currencies.
	 *
	 * @return the number of currencies
	 */
	public int countAll();

}