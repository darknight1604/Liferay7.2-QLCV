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

import com.nss.commoncategory.model.Street;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the street service. This utility wraps <code>com.nss.commoncategory.service.persistence.impl.StreetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StreetPersistence
 * @generated
 */
@ProviderType
public class StreetUtil {

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
	public static void clearCache(Street street) {
		getPersistence().clearCache(street);
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
	public static Map<Serializable, Street> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Street> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Street> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Street> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Street update(Street street) {
		return getPersistence().update(street);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Street update(Street street, ServiceContext serviceContext) {
		return getPersistence().update(street, serviceContext);
	}

	/**
	 * Returns all the streets where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching streets
	 */
	public static List<Street> findByActive(boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the streets where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of matching streets
	 */
	public static List<Street> findByActive(
		boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the streets where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching streets
	 */
	@Deprecated
	public static List<Street> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the streets where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streets
	 */
	public static List<Street> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByActive_First(
			boolean active, OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByActive_First(
		boolean active, OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByActive_Last(
			boolean active, OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByActive_Last(
		boolean active, OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the streets before and after the current street in the ordered set where active = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public static Street[] findByActive_PrevAndNext(
			long streetId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByActive_PrevAndNext(
			streetId, active, orderByComparator);
	}

	/**
	 * Removes all the streets where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of streets where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching streets
	 */
	public static int countByActive(boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Returns all the streets where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the matching streets
	 */
	public static List<Street> findByCityId_Active(
		long cityId, boolean active) {

		return getPersistence().findByCityId_Active(cityId, active);
	}

	/**
	 * Returns a range of all the streets where cityId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of matching streets
	 */
	public static List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end) {

		return getPersistence().findByCityId_Active(cityId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the streets where cityId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCityId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param cityId the city ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching streets
	 */
	@Deprecated
	public static List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCityId_Active(
			cityId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the streets where cityId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streets
	 */
	public static List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().findByCityId_Active(
			cityId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByCityId_Active_First(
			long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByCityId_Active_First(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByCityId_Active_First(
		long cityId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByCityId_Active_First(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByCityId_Active_Last(
			long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByCityId_Active_Last(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByCityId_Active_Last(
		long cityId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByCityId_Active_Last(
			cityId, active, orderByComparator);
	}

	/**
	 * Returns the streets before and after the current street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public static Street[] findByCityId_Active_PrevAndNext(
			long streetId, long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByCityId_Active_PrevAndNext(
			streetId, cityId, active, orderByComparator);
	}

	/**
	 * Removes all the streets where cityId = &#63; and active = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 */
	public static void removeByCityId_Active(long cityId, boolean active) {
		getPersistence().removeByCityId_Active(cityId, active);
	}

	/**
	 * Returns the number of streets where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	public static int countByCityId_Active(long cityId, boolean active) {
		return getPersistence().countByCityId_Active(cityId, active);
	}

	/**
	 * Returns all the streets where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the matching streets
	 */
	public static List<Street> findByDistrictId_Active(
		long districtId, boolean active) {

		return getPersistence().findByDistrictId_Active(districtId, active);
	}

	/**
	 * Returns a range of all the streets where districtId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of matching streets
	 */
	public static List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end) {

		return getPersistence().findByDistrictId_Active(
			districtId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the streets where districtId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDistrictId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param districtId the district ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching streets
	 */
	@Deprecated
	public static List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDistrictId_Active(
			districtId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the streets where districtId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streets
	 */
	public static List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().findByDistrictId_Active(
			districtId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByDistrictId_Active_First(
			long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByDistrictId_Active_First(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByDistrictId_Active_First(
		long districtId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByDistrictId_Active_First(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByDistrictId_Active_Last(
			long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByDistrictId_Active_Last(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByDistrictId_Active_Last(
		long districtId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByDistrictId_Active_Last(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the streets before and after the current street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public static Street[] findByDistrictId_Active_PrevAndNext(
			long streetId, long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByDistrictId_Active_PrevAndNext(
			streetId, districtId, active, orderByComparator);
	}

	/**
	 * Removes all the streets where districtId = &#63; and active = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 */
	public static void removeByDistrictId_Active(
		long districtId, boolean active) {

		getPersistence().removeByDistrictId_Active(districtId, active);
	}

	/**
	 * Returns the number of streets where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	public static int countByDistrictId_Active(
		long districtId, boolean active) {

		return getPersistence().countByDistrictId_Active(districtId, active);
	}

	/**
	 * Returns all the streets where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @return the matching streets
	 */
	public static List<Street> findByWardId_Active(
		long wardId, boolean active) {

		return getPersistence().findByWardId_Active(wardId, active);
	}

	/**
	 * Returns a range of all the streets where wardId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of matching streets
	 */
	public static List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end) {

		return getPersistence().findByWardId_Active(wardId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the streets where wardId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByWardId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param wardId the ward ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching streets
	 */
	@Deprecated
	public static List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByWardId_Active(
			wardId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the streets where wardId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streets
	 */
	public static List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().findByWardId_Active(
			wardId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByWardId_Active_First(
			long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByWardId_Active_First(
			wardId, active, orderByComparator);
	}

	/**
	 * Returns the first street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByWardId_Active_First(
		long wardId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByWardId_Active_First(
			wardId, active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByWardId_Active_Last(
			long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByWardId_Active_Last(
			wardId, active, orderByComparator);
	}

	/**
	 * Returns the last street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByWardId_Active_Last(
		long wardId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		return getPersistence().fetchByWardId_Active_Last(
			wardId, active, orderByComparator);
	}

	/**
	 * Returns the streets before and after the current street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public static Street[] findByWardId_Active_PrevAndNext(
			long streetId, long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByWardId_Active_PrevAndNext(
			streetId, wardId, active, orderByComparator);
	}

	/**
	 * Removes all the streets where wardId = &#63; and active = &#63; from the database.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 */
	public static void removeByWardId_Active(long wardId, boolean active) {
		getPersistence().removeByWardId_Active(wardId, active);
	}

	/**
	 * Returns the number of streets where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	public static int countByWardId_Active(long wardId, boolean active) {
		return getPersistence().countByWardId_Active(wardId, active);
	}

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByWardId_Name(long wardId, String name)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByWardId_Name(wardId, name);
	}

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByWardId_Name(long,String)}
	 * @param wardId the ward ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Deprecated
	public static Street fetchByWardId_Name(
		long wardId, String name, boolean useFinderCache) {

		return getPersistence().fetchByWardId_Name(
			wardId, name, useFinderCache);
	}

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByWardId_Name(long wardId, String name) {
		return getPersistence().fetchByWardId_Name(wardId, name);
	}

	/**
	 * Removes the street where wardId = &#63; and name = &#63; from the database.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the street that was removed
	 */
	public static Street removeByWardId_Name(long wardId, String name)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().removeByWardId_Name(wardId, name);
	}

	/**
	 * Returns the number of streets where wardId = &#63; and name = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the number of matching streets
	 */
	public static int countByWardId_Name(long wardId, String name) {
		return getPersistence().countByWardId_Name(wardId, name);
	}

	/**
	 * Returns the street where code = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public static Street findByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the street where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Deprecated
	public static Street fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Returns the street where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	public static Street fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Removes the street where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the street that was removed
	 */
	public static Street removeByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of streets where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching streets
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the street in the entity cache if it is enabled.
	 *
	 * @param street the street
	 */
	public static void cacheResult(Street street) {
		getPersistence().cacheResult(street);
	}

	/**
	 * Caches the streets in the entity cache if it is enabled.
	 *
	 * @param streets the streets
	 */
	public static void cacheResult(List<Street> streets) {
		getPersistence().cacheResult(streets);
	}

	/**
	 * Creates a new street with the primary key. Does not add the street to the database.
	 *
	 * @param streetId the primary key for the new street
	 * @return the new street
	 */
	public static Street create(long streetId) {
		return getPersistence().create(streetId);
	}

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streetId the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public static Street remove(long streetId)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().remove(streetId);
	}

	public static Street updateImpl(Street street) {
		return getPersistence().updateImpl(street);
	}

	/**
	 * Returns the street with the primary key or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public static Street findByPrimaryKey(long streetId)
		throws com.nss.commoncategory.exception.NoSuchStreetException {

		return getPersistence().findByPrimaryKey(streetId);
	}

	/**
	 * Returns the street with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street, or <code>null</code> if a street with the primary key could not be found
	 */
	public static Street fetchByPrimaryKey(long streetId) {
		return getPersistence().fetchByPrimaryKey(streetId);
	}

	/**
	 * Returns all the streets.
	 *
	 * @return the streets
	 */
	public static List<Street> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of streets
	 */
	public static List<Street> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of streets
	 */
	@Deprecated
	public static List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of streets
	 */
	public static List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the streets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of streets.
	 *
	 * @return the number of streets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StreetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StreetPersistence, StreetPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StreetPersistence.class);

		ServiceTracker<StreetPersistence, StreetPersistence> serviceTracker =
			new ServiceTracker<StreetPersistence, StreetPersistence>(
				bundle.getBundleContext(), StreetPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}