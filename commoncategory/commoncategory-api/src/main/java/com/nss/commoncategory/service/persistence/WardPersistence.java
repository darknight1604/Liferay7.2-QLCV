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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.commoncategory.exception.NoSuchWardException;
import com.nss.commoncategory.model.Ward;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ward service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WardUtil
 * @generated
 */
@ProviderType
public interface WardPersistence extends BasePersistence<Ward> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WardUtil} to access the ward persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the wards where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching wards
	 */
	public java.util.List<Ward> findByActive(boolean active);

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
	public java.util.List<Ward> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<Ward> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Ward> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator);

	/**
	 * Returns the first ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public Ward findByActive_First(
			boolean active, OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException;

	/**
	 * Returns the first ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public Ward fetchByActive_First(
		boolean active, OrderByComparator<Ward> orderByComparator);

	/**
	 * Returns the last ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public Ward findByActive_Last(
			boolean active, OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException;

	/**
	 * Returns the last ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public Ward fetchByActive_Last(
		boolean active, OrderByComparator<Ward> orderByComparator);

	/**
	 * Returns the wards before and after the current ward in the ordered set where active = &#63;.
	 *
	 * @param wardId the primary key of the current ward
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public Ward[] findByActive_PrevAndNext(
			long wardId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException;

	/**
	 * Removes all the wards where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of wards where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching wards
	 */
	public int countByActive(boolean active);

	/**
	 * Returns all the wards where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the matching wards
	 */
	public java.util.List<Ward> findByDistrictId_Active(
		long districtId, boolean active);

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
	public java.util.List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end);

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
	public java.util.List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator);

	/**
	 * Returns the first ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public Ward findByDistrictId_Active_First(
			long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException;

	/**
	 * Returns the first ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public Ward fetchByDistrictId_Active_First(
		long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator);

	/**
	 * Returns the last ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public Ward findByDistrictId_Active_Last(
			long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException;

	/**
	 * Returns the last ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public Ward fetchByDistrictId_Active_Last(
		long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator);

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
	public Ward[] findByDistrictId_Active_PrevAndNext(
			long wardId, long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException;

	/**
	 * Removes all the wards where districtId = &#63; and active = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 */
	public void removeByDistrictId_Active(long districtId, boolean active);

	/**
	 * Returns the number of wards where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the number of matching wards
	 */
	public int countByDistrictId_Active(long districtId, boolean active);

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public Ward findByDistrictId_Name(long districtId, String name)
		throws NoSuchWardException;

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
	public Ward fetchByDistrictId_Name(
		long districtId, String name, boolean useFinderCache);

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public Ward fetchByDistrictId_Name(long districtId, String name);

	/**
	 * Removes the ward where districtId = &#63; and name = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the ward that was removed
	 */
	public Ward removeByDistrictId_Name(long districtId, String name)
		throws NoSuchWardException;

	/**
	 * Returns the number of wards where districtId = &#63; and name = &#63;.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the number of matching wards
	 */
	public int countByDistrictId_Name(long districtId, String name);

	/**
	 * Returns the ward where code = &#63; or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	public Ward findByCode(String code) throws NoSuchWardException;

	/**
	 * Returns the ward where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Deprecated
	public Ward fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the ward where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	public Ward fetchByCode(String code);

	/**
	 * Removes the ward where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the ward that was removed
	 */
	public Ward removeByCode(String code) throws NoSuchWardException;

	/**
	 * Returns the number of wards where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching wards
	 */
	public int countByCode(String code);

	/**
	 * Caches the ward in the entity cache if it is enabled.
	 *
	 * @param ward the ward
	 */
	public void cacheResult(Ward ward);

	/**
	 * Caches the wards in the entity cache if it is enabled.
	 *
	 * @param wards the wards
	 */
	public void cacheResult(java.util.List<Ward> wards);

	/**
	 * Creates a new ward with the primary key. Does not add the ward to the database.
	 *
	 * @param wardId the primary key for the new ward
	 * @return the new ward
	 */
	public Ward create(long wardId);

	/**
	 * Removes the ward with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward that was removed
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public Ward remove(long wardId) throws NoSuchWardException;

	public Ward updateImpl(Ward ward);

	/**
	 * Returns the ward with the primary key or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	public Ward findByPrimaryKey(long wardId) throws NoSuchWardException;

	/**
	 * Returns the ward with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward, or <code>null</code> if a ward with the primary key could not be found
	 */
	public Ward fetchByPrimaryKey(long wardId);

	/**
	 * Returns all the wards.
	 *
	 * @return the wards
	 */
	public java.util.List<Ward> findAll();

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
	public java.util.List<Ward> findAll(int start, int end);

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
	public java.util.List<Ward> findAll(
		int start, int end, OrderByComparator<Ward> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Ward> findAll(
		int start, int end, OrderByComparator<Ward> orderByComparator);

	/**
	 * Removes all the wards from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of wards.
	 *
	 * @return the number of wards
	 */
	public int countAll();

}