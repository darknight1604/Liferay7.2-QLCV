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

import com.nss.commoncategory.exception.NoSuchStreetException;
import com.nss.commoncategory.model.Street;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the street service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StreetUtil
 * @generated
 */
@ProviderType
public interface StreetPersistence extends BasePersistence<Street> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StreetUtil} to access the street persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the streets where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching streets
	 */
	public java.util.List<Street> findByActive(boolean active);

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
	public java.util.List<Street> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<Street> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Street> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the first street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByActive_First(
			boolean active, OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the first street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByActive_First(
		boolean active, OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the last street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByActive_Last(
			boolean active, OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the last street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByActive_Last(
		boolean active, OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the streets before and after the current street in the ordered set where active = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street[] findByActive_PrevAndNext(
			long streetId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Removes all the streets where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of streets where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching streets
	 */
	public int countByActive(boolean active);

	/**
	 * Returns all the streets where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the matching streets
	 */
	public java.util.List<Street> findByCityId_Active(
		long cityId, boolean active);

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
	public java.util.List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end);

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
	public java.util.List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCityId_Active_First(
			long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCityId_Active_First(
		long cityId, boolean active,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCityId_Active_Last(
			long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCityId_Active_Last(
		long cityId, boolean active,
		OrderByComparator<Street> orderByComparator);

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
	public Street[] findByCityId_Active_PrevAndNext(
			long streetId, long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Removes all the streets where cityId = &#63; and active = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 */
	public void removeByCityId_Active(long cityId, boolean active);

	/**
	 * Returns the number of streets where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	public int countByCityId_Active(long cityId, boolean active);

	/**
	 * Returns all the streets where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the matching streets
	 */
	public java.util.List<Street> findByDistrictId_Active(
		long districtId, boolean active);

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
	public java.util.List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end);

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
	public java.util.List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the first street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByDistrictId_Active_First(
			long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the first street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByDistrictId_Active_First(
		long districtId, boolean active,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the last street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByDistrictId_Active_Last(
			long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the last street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByDistrictId_Active_Last(
		long districtId, boolean active,
		OrderByComparator<Street> orderByComparator);

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
	public Street[] findByDistrictId_Active_PrevAndNext(
			long streetId, long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Removes all the streets where districtId = &#63; and active = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 */
	public void removeByDistrictId_Active(long districtId, boolean active);

	/**
	 * Returns the number of streets where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	public int countByDistrictId_Active(long districtId, boolean active);

	/**
	 * Returns all the streets where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @return the matching streets
	 */
	public java.util.List<Street> findByWardId_Active(
		long wardId, boolean active);

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
	public java.util.List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end);

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
	public java.util.List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the first street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByWardId_Active_First(
			long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the first street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByWardId_Active_First(
		long wardId, boolean active,
		OrderByComparator<Street> orderByComparator);

	/**
	 * Returns the last street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByWardId_Active_Last(
			long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the last street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByWardId_Active_Last(
		long wardId, boolean active,
		OrderByComparator<Street> orderByComparator);

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
	public Street[] findByWardId_Active_PrevAndNext(
			long streetId, long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Removes all the streets where wardId = &#63; and active = &#63; from the database.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 */
	public void removeByWardId_Active(long wardId, boolean active);

	/**
	 * Returns the number of streets where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	public int countByWardId_Active(long wardId, boolean active);

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByWardId_Name(long wardId, String name)
		throws NoSuchStreetException;

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
	public Street fetchByWardId_Name(
		long wardId, String name, boolean useFinderCache);

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByWardId_Name(long wardId, String name);

	/**
	 * Removes the street where wardId = &#63; and name = &#63; from the database.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the street that was removed
	 */
	public Street removeByWardId_Name(long wardId, String name)
		throws NoSuchStreetException;

	/**
	 * Returns the number of streets where wardId = &#63; and name = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the number of matching streets
	 */
	public int countByWardId_Name(long wardId, String name);

	/**
	 * Returns the street where code = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCode(String code) throws NoSuchStreetException;

	/**
	 * Returns the street where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Deprecated
	public Street fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the street where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCode(String code);

	/**
	 * Removes the street where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the street that was removed
	 */
	public Street removeByCode(String code) throws NoSuchStreetException;

	/**
	 * Returns the number of streets where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching streets
	 */
	public int countByCode(String code);

	/**
	 * Caches the street in the entity cache if it is enabled.
	 *
	 * @param street the street
	 */
	public void cacheResult(Street street);

	/**
	 * Caches the streets in the entity cache if it is enabled.
	 *
	 * @param streets the streets
	 */
	public void cacheResult(java.util.List<Street> streets);

	/**
	 * Creates a new street with the primary key. Does not add the street to the database.
	 *
	 * @param streetId the primary key for the new street
	 * @return the new street
	 */
	public Street create(long streetId);

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streetId the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street remove(long streetId) throws NoSuchStreetException;

	public Street updateImpl(Street street);

	/**
	 * Returns the street with the primary key or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street findByPrimaryKey(long streetId) throws NoSuchStreetException;

	/**
	 * Returns the street with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street, or <code>null</code> if a street with the primary key could not be found
	 */
	public Street fetchByPrimaryKey(long streetId);

	/**
	 * Returns all the streets.
	 *
	 * @return the streets
	 */
	public java.util.List<Street> findAll();

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
	public java.util.List<Street> findAll(int start, int end);

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
	public java.util.List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator);

	/**
	 * Removes all the streets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of streets.
	 *
	 * @return the number of streets
	 */
	public int countAll();

}