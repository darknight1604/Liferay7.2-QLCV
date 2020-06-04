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

package com.nss.commoncategory.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.commoncategory.model.City;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the city service. This utility wraps <code>com.nss.commoncategory.service.persistence.impl.CityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityPersistence
 * @generated
 */
@ProviderType
public class CityUtil {

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
	public static void clearCache(City city) {
		getPersistence().clearCache(city);
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
	public static Map<Serializable, City> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<City> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<City> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static City update(City city) {
		return getPersistence().update(city);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static City update(City city, ServiceContext serviceContext) {
		return getPersistence().update(city, serviceContext);
	}

	/**
	 * Returns all the cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching cities
	 */
	public static List<City> findByActive(boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 */
	public static List<City> findByActive(boolean active, int start, int end) {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cities
	 */
	@Deprecated
	public static List<City> findByActive(
		boolean active, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 */
	public static List<City> findByActive(
		boolean active, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByActive_First(
			boolean active, OrderByComparator<City> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByActive_First(
		boolean active, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByActive_Last(
			boolean active, OrderByComparator<City> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByActive_Last(
		boolean active, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the cities before and after the current city in the ordered set where active = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City[] findByActive_PrevAndNext(
			long cityId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByActive_PrevAndNext(
			cityId, active, orderByComparator);
	}

	/**
	 * Removes all the cities where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching cities
	 */
	public static int countByActive(boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Returns the city where code = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the city where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	@Deprecated
	public static City fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Returns the city where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Removes the city where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the city that was removed
	 */
	public static City removeByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of cities where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching cities
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the cities where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @return the matching cities
	 */
	public static List<City> findByCountryId_Active(
		long countryId, boolean active) {

		return getPersistence().findByCountryId_Active(countryId, active);
	}

	/**
	 * Returns a range of all the cities where countryId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 */
	public static List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end) {

		return getPersistence().findByCountryId_Active(
			countryId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the cities where countryId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCountryId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param countryId the country ID
	 * @param active the active
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cities
	 */
	@Deprecated
	public static List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCountryId_Active(
			countryId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cities where countryId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 */
	public static List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findByCountryId_Active(
			countryId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByCountryId_Active_First(
			long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByCountryId_Active_First(
			countryId, active, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByCountryId_Active_First(
		long countryId, boolean active,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByCountryId_Active_First(
			countryId, active, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByCountryId_Active_Last(
			long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByCountryId_Active_Last(
			countryId, active, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByCountryId_Active_Last(
		long countryId, boolean active,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByCountryId_Active_Last(
			countryId, active, orderByComparator);
	}

	/**
	 * Returns the cities before and after the current city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City[] findByCountryId_Active_PrevAndNext(
			long cityId, long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByCountryId_Active_PrevAndNext(
			cityId, countryId, active, orderByComparator);
	}

	/**
	 * Removes all the cities where countryId = &#63; and active = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 */
	public static void removeByCountryId_Active(
		long countryId, boolean active) {

		getPersistence().removeByCountryId_Active(countryId, active);
	}

	/**
	 * Returns the number of cities where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @return the number of matching cities
	 */
	public static int countByCountryId_Active(long countryId, boolean active) {
		return getPersistence().countByCountryId_Active(countryId, active);
	}

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByCountryId_Name(long countryId, String name)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByCountryId_Name(countryId, name);
	}

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCountryId_Name(long,String)}
	 * @param countryId the country ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	@Deprecated
	public static City fetchByCountryId_Name(
		long countryId, String name, boolean useFinderCache) {

		return getPersistence().fetchByCountryId_Name(
			countryId, name, useFinderCache);
	}

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByCountryId_Name(long countryId, String name) {
		return getPersistence().fetchByCountryId_Name(countryId, name);
	}

	/**
	 * Removes the city where countryId = &#63; and name = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the city that was removed
	 */
	public static City removeByCountryId_Name(long countryId, String name)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().removeByCountryId_Name(countryId, name);
	}

	/**
	 * Returns the number of cities where countryId = &#63; and name = &#63;.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the number of matching cities
	 */
	public static int countByCountryId_Name(long countryId, String name) {
		return getPersistence().countByCountryId_Name(countryId, name);
	}

	/**
	 * Caches the city in the entity cache if it is enabled.
	 *
	 * @param city the city
	 */
	public static void cacheResult(City city) {
		getPersistence().cacheResult(city);
	}

	/**
	 * Caches the cities in the entity cache if it is enabled.
	 *
	 * @param cities the cities
	 */
	public static void cacheResult(List<City> cities) {
		getPersistence().cacheResult(cities);
	}

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityId the primary key for the new city
	 * @return the new city
	 */
	public static City create(long cityId) {
		return getPersistence().create(cityId);
	}

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city
	 * @return the city that was removed
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City remove(long cityId)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().remove(cityId);
	}

	public static City updateImpl(City city) {
		return getPersistence().updateImpl(city);
	}

	/**
	 * Returns the city with the primary key or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City findByPrimaryKey(long cityId)
		throws com.nss.commoncategory.exception.NoSuchCityException {

		return getPersistence().findByPrimaryKey(cityId);
	}

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 */
	public static City fetchByPrimaryKey(long cityId) {
		return getPersistence().fetchByPrimaryKey(cityId);
	}

	/**
	 * Returns all the cities.
	 *
	 * @return the cities
	 */
	public static List<City> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of cities
	 */
	public static List<City> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cities
	 */
	@Deprecated
	public static List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cities
	 */
	public static List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CityPersistence, CityPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CityPersistence.class);

		ServiceTracker<CityPersistence, CityPersistence> serviceTracker =
			new ServiceTracker<CityPersistence, CityPersistence>(
				bundle.getBundleContext(), CityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}