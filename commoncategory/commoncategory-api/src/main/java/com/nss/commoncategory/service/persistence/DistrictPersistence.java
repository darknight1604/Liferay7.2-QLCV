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

import com.nss.commoncategory.exception.NoSuchDistrictException;
import com.nss.commoncategory.model.District;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictUtil
 * @generated
 */
@ProviderType
public interface DistrictPersistence extends BasePersistence<District> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DistrictUtil} to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the districts where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching districts
	 */
	public java.util.List<District> findByActive(boolean active);

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
	public java.util.List<District> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<District> findByActive(
		boolean active, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache);

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
	public java.util.List<District> findByActive(
		boolean active, int start, int end,
		OrderByComparator<District> orderByComparator);

	/**
	 * Returns the first district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByActive_First(
			boolean active, OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByActive_First(
		boolean active, OrderByComparator<District> orderByComparator);

	/**
	 * Returns the last district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByActive_Last(
			boolean active, OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByActive_Last(
		boolean active, OrderByComparator<District> orderByComparator);

	/**
	 * Returns the districts before and after the current district in the ordered set where active = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District[] findByActive_PrevAndNext(
			long districtId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of districts where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching districts
	 */
	public int countByActive(boolean active);

	/**
	 * Returns all the districts where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the matching districts
	 */
	public java.util.List<District> findByCityId_Active(
		long cityId, boolean active);

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
	public java.util.List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end);

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
	public java.util.List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache);

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
	public java.util.List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<District> orderByComparator);

	/**
	 * Returns the first district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByCityId_Active_First(
			long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByCityId_Active_First(
		long cityId, boolean active,
		OrderByComparator<District> orderByComparator);

	/**
	 * Returns the last district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByCityId_Active_Last(
			long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByCityId_Active_Last(
		long cityId, boolean active,
		OrderByComparator<District> orderByComparator);

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
	public District[] findByCityId_Active_PrevAndNext(
			long districtId, long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where cityId = &#63; and active = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 */
	public void removeByCityId_Active(long cityId, boolean active);

	/**
	 * Returns the number of districts where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the number of matching districts
	 */
	public int countByCityId_Active(long cityId, boolean active);

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByCityId_Name(long cityId, String name)
		throws NoSuchDistrictException;

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
	public District fetchByCityId_Name(
		long cityId, String name, boolean useFinderCache);

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByCityId_Name(long cityId, String name);

	/**
	 * Removes the district where cityId = &#63; and name = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the district that was removed
	 */
	public District removeByCityId_Name(long cityId, String name)
		throws NoSuchDistrictException;

	/**
	 * Returns the number of districts where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the number of matching districts
	 */
	public int countByCityId_Name(long cityId, String name);

	/**
	 * Returns the district where code = &#63; or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByCode(String code) throws NoSuchDistrictException;

	/**
	 * Returns the district where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	@Deprecated
	public District fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the district where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByCode(String code);

	/**
	 * Removes the district where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the district that was removed
	 */
	public District removeByCode(String code) throws NoSuchDistrictException;

	/**
	 * Returns the number of districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching districts
	 */
	public int countByCode(String code);

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	public void cacheResult(District district);

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	public void cacheResult(java.util.List<District> districts);

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public District create(long districtId);

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District remove(long districtId) throws NoSuchDistrictException;

	public District updateImpl(District district);

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District findByPrimaryKey(long districtId)
		throws NoSuchDistrictException;

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	public District fetchByPrimaryKey(long districtId);

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	public java.util.List<District> findAll();

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
	public java.util.List<District> findAll(int start, int end);

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
	public java.util.List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator);

	/**
	 * Removes all the districts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public int countAll();

}