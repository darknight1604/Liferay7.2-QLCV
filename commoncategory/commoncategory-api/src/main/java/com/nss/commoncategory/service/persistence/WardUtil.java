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

import com.nss.commoncategory.model.Ward;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ward service. This utility wraps <code>com.nss.commoncategory.service.persistence.impl.WardPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WardPersistence
 * @generated
 */
@ProviderType
public class WardUtil {

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
	public static void clearCache(Ward ward) {
		getPersistence().clearCache(ward);
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
	public static Map<Serializable, Ward> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ward> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ward> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ward> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ward> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ward update(Ward ward) {
		return getPersistence().update(ward);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ward update(Ward ward, ServiceContext serviceContext) {
		return getPersistence().update(ward, serviceContext);
	}

	/**
	 * Returns all the wards where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching wards
	 */
	public static List<Ward> findByActive(boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the wards where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @return the range of matching wards
	 */
	public static List<Ward> findByActive(boolean active, int start, int end) {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the wards where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching wards
	 */
	@Deprecated
	public static List<Ward> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the wards where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wards
	 */
	public static List<Ward> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns the first ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public static Ward findByActive_First(
			boolean active, OrderByComparator<Ward> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public static Ward fetchByActive_First(
		boolean active, OrderByComparator<Ward> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public static Ward findByActive_Last(
			boolean active, OrderByComparator<Ward> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public static Ward fetchByActive_Last(
		boolean active, OrderByComparator<Ward> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the wards before and after the current ward in the ordered set where active = &#63;.
	 *
	 * @param wardId the primary key of the current ward
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public static Ward[] findByActive_PrevAndNext(
			long wardId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByActive_PrevAndNext(
			wardId, active, orderByComparator);
	}

	/**
	 * Removes all the wards where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of wards where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching wards
	 */
	public static int countByActive(boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Returns all the wards where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the matching wards
	 */
	public static List<Ward> findByDistrictId_Active(
		long districtId, boolean active) {

		return getPersistence().findByDistrictId_Active(districtId, active);
	}

	/**
	 * Returns a range of all the wards where districtId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @return the range of matching wards
	 */
	public static List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end) {

		return getPersistence().findByDistrictId_Active(
			districtId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the wards where districtId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDistrictId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param districtId the district ID
	 * @param active the active
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching wards
	 */
	@Deprecated
	public static List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDistrictId_Active(
			districtId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the wards where districtId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wards
	 */
	public static List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator) {

		return getPersistence().findByDistrictId_Active(
			districtId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public static Ward findByDistrictId_Active_First(
			long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByDistrictId_Active_First(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the first ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public static Ward fetchByDistrictId_Active_First(
		long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator) {

		return getPersistence().fetchByDistrictId_Active_First(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the last ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public static Ward findByDistrictId_Active_Last(
			long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByDistrictId_Active_Last(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the last ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public static Ward fetchByDistrictId_Active_Last(
		long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator) {

		return getPersistence().fetchByDistrictId_Active_Last(
			districtId, active, orderByComparator);
	}

	/**
	 * Returns the wards before and after the current ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param wardId the primary key of the current ward
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public static Ward[] findByDistrictId_Active_PrevAndNext(
			long wardId, long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByDistrictId_Active_PrevAndNext(
			wardId, districtId, active, orderByComparator);
	}

	/**
	 * Removes all the wards where districtId = &#63; and active = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 */
	public static void removeByDistrictId_Active(
		long districtId, boolean active) {

		getPersistence().removeByDistrictId_Active(districtId, active);
	}

	/**
	 * Returns the number of wards where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the number of matching wards
	 */
	public static int countByDistrictId_Active(
		long districtId, boolean active) {

		return getPersistence().countByDistrictId_Active(districtId, active);
	}

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public static Ward findByDistrictId_Name(long districtId, String name)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByDistrictId_Name(districtId, name);
	}

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByDistrictId_Name(long,String)}
	 * @param districtId the district ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Deprecated
	public static Ward fetchByDistrictId_Name(
		long districtId, String name, boolean useFinderCache) {

		return getPersistence().fetchByDistrictId_Name(
			districtId, name, useFinderCache);
	}

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public static Ward fetchByDistrictId_Name(long districtId, String name) {
		return getPersistence().fetchByDistrictId_Name(districtId, name);
	}

	/**
	 * Removes the ward where districtId = &#63; and name = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the ward that was removed
	 */
	public static Ward removeByDistrictId_Name(long districtId, String name)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().removeByDistrictId_Name(districtId, name);
	}

	/**
	 * Returns the number of wards where districtId = &#63; and name = &#63;.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the number of matching wards
	 */
	public static int countByDistrictId_Name(long districtId, String name) {
		return getPersistence().countByDistrictId_Name(districtId, name);
	}

	/**
	 * Returns the ward where code = &#63; or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public static Ward findByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the ward where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Deprecated
	public static Ward fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Returns the ward where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public static Ward fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Removes the ward where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the ward that was removed
	 */
	public static Ward removeByCode(String code)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of wards where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching wards
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the ward in the entity cache if it is enabled.
	 *
	 * @param ward the ward
	 */
	public static void cacheResult(Ward ward) {
		getPersistence().cacheResult(ward);
	}

	/**
	 * Caches the wards in the entity cache if it is enabled.
	 *
	 * @param wards the wards
	 */
	public static void cacheResult(List<Ward> wards) {
		getPersistence().cacheResult(wards);
	}

	/**
	 * Creates a new ward with the primary key. Does not add the ward to the database.
	 *
	 * @param wardId the primary key for the new ward
	 * @return the new ward
	 */
	public static Ward create(long wardId) {
		return getPersistence().create(wardId);
	}

	/**
	 * Removes the ward with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward that was removed
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public static Ward remove(long wardId)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().remove(wardId);
	}

	public static Ward updateImpl(Ward ward) {
		return getPersistence().updateImpl(ward);
	}

	/**
	 * Returns the ward with the primary key or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public static Ward findByPrimaryKey(long wardId)
		throws com.nss.commoncategory.exception.NoSuchWardException {

		return getPersistence().findByPrimaryKey(wardId);
	}

	/**
	 * Returns the ward with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward, or <code>null</code> if a ward with the primary key could not be found
	 */
	public static Ward fetchByPrimaryKey(long wardId) {
		return getPersistence().fetchByPrimaryKey(wardId);
	}

	/**
	 * Returns all the wards.
	 *
	 * @return the wards
	 */
	public static List<Ward> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the wards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @return the range of wards
	 */
	public static List<Ward> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the wards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of wards
	 */
	@Deprecated
	public static List<Ward> findAll(
		int start, int end, OrderByComparator<Ward> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the wards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wards
	 */
	public static List<Ward> findAll(
		int start, int end, OrderByComparator<Ward> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the wards from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of wards.
	 *
	 * @return the number of wards
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WardPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WardPersistence, WardPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WardPersistence.class);

		ServiceTracker<WardPersistence, WardPersistence> serviceTracker =
			new ServiceTracker<WardPersistence, WardPersistence>(
				bundle.getBundleContext(), WardPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}