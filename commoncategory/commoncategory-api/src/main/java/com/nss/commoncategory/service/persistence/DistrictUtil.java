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

import com.nss.commoncategory.model.District;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the district service. This utility wraps <code>com.nss.commoncategory.service.persistence.impl.DistrictPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictPersistence
 * @generated
 */
@ProviderType
public class DistrictUtil {

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
	public static void clearCache(District district) {
		getPersistence().clearCache(district);
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
	public static Map<Serializable, District> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static District update(District district) {
		return getPersistence().update(district);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static District update(
		District district, ServiceContext serviceContext) {

		return getPersistence().update(district, serviceContext);
	}

	/**
	 * Returns all the districts where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching districts
	 */
	public static List<District> findByActive(boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the districts where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByActive(
		boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	@Deprecated
	public static List<District> findByActive(
		boolean active, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the districts where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByActive(
		boolean active, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByActive_First(
			boolean active, OrderByComparator<District> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByActive_First(
		boolean active, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByActive_Last(
			boolean active, OrderByComparator<District> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByActive_Last(
		boolean active, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where active = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByActive_PrevAndNext(
			long districtId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByActive_PrevAndNext(
			districtId, active, orderByComparator);
	}

	/**
	 * Removes all the districts where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of districts where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching districts
	 */
	public static int countByActive(boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Returns all the districts where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the matching districts
	 */
	public static List<District> findByCityId_Active(
		long cityId, boolean active) {

		return getPersistence().findByCityId_Active(cityId, active);
	}

	/**
	 * Returns a range of all the districts where cityId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end) {

		return getPersistence().findByCityId_Active(cityId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where cityId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCityId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param cityId the city ID
	 * @param active the active
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	@Deprecated
	public static List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCityId_Active(
			cityId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the districts where cityId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByCityId_Active(
			cityId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByCityId_Active_First(
			long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByCityId_Active_First(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByCityId_Active_First(
		long cityId, boolean active,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByCityId_Active_First(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByCityId_Active_Last(
			long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByCityId_Active_Last(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByCityId_Active_Last(
		long cityId, boolean active,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByCityId_Active_Last(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByCityId_Active_PrevAndNext(
			long districtId, long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByCityId_Active_PrevAndNext(
			districtId, cityId, active, orderByComparator);
	}

	/**
	 * Removes all the districts where cityId = &#63; and active = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 */
	public static void removeByCityId_Active(long cityId, boolean active) {
		getPersistence().removeByCityId_Active(cityId, active);
	}

	/**
	 * Returns the number of districts where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the number of matching districts
	 */
	public static int countByCityId_Active(long cityId, boolean active) {
		return getPersistence().countByCityId_Active(cityId, active);
	}

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByCityId_Name(long cityId, String name)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByCityId_Name(cityId, name);
	}

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCityId_Name(long,String)}
	 * @param cityId the city ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	@Deprecated
	public static District fetchByCityId_Name(
		long cityId, String name, boolean useFinderCache) {

		return getPersistence().fetchByCityId_Name(
			cityId, name, useFinderCache);
	}

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByCityId_Name(long cityId, String name) {
		return getPersistence().fetchByCityId_Name(cityId, name);
	}

	/**
	 * Removes the district where cityId = &#63; and name = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the district that was removed
	 */
	public static District removeByCityId_Name(long cityId, String name)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().removeByCityId_Name(cityId, name);
	}

	/**
	 * Returns the number of districts where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the number of matching districts
	 */
	public static int countByCityId_Name(long cityId, String name) {
		return getPersistence().countByCityId_Name(cityId, name);
	}

	/**
	 * Returns the district where code = &#63; or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the district where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	@Deprecated
	public static District fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Returns the district where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Removes the district where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the district that was removed
	 */
	public static District removeByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching districts
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	public static void cacheResult(District district) {
		getPersistence().cacheResult(district);
	}

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	public static void cacheResult(List<District> districts) {
		getPersistence().cacheResult(districts);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public static District create(long districtId) {
		return getPersistence().create(districtId);
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District remove(long districtId)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().remove(districtId);
	}

	public static District updateImpl(District district) {
		return getPersistence().updateImpl(district);
	}

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District findByPrimaryKey(long districtId)
		throws com.nss.commoncategory.exception.NoSuchDistrictException {

		return getPersistence().findByPrimaryKey(districtId);
	}

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	public static District fetchByPrimaryKey(long districtId) {
		return getPersistence().fetchByPrimaryKey(districtId);
	}

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	public static List<District> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	public static List<District> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of districts
	 */
	@Deprecated
	public static List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of districts
	 */
	public static List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the districts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DistrictPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DistrictPersistence, DistrictPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DistrictPersistence.class);

		ServiceTracker<DistrictPersistence, DistrictPersistence>
			serviceTracker =
				new ServiceTracker<DistrictPersistence, DistrictPersistence>(
					bundle.getBundleContext(), DistrictPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}