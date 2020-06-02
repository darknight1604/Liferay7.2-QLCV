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

import com.nss.commoncategory.exception.NoSuchContinentException;
import com.nss.commoncategory.model.Continent;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the continent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContinentUtil
 * @generated
 */
@ProviderType
public interface ContinentPersistence extends BasePersistence<Continent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContinentUtil} to access the continent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the continent where code = &#63; or throws a <code>NoSuchContinentException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching continent
	 * @throws NoSuchContinentException if a matching continent could not be found
	 */
	public Continent findByCode(String code) throws NoSuchContinentException;

	/**
	 * Returns the continent where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching continent, or <code>null</code> if a matching continent could not be found
	 */
	@Deprecated
	public Continent fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the continent where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching continent, or <code>null</code> if a matching continent could not be found
	 */
	public Continent fetchByCode(String code);

	/**
	 * Removes the continent where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the continent that was removed
	 */
	public Continent removeByCode(String code) throws NoSuchContinentException;

	/**
	 * Returns the number of continents where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching continents
	 */
	public int countByCode(String code);

	/**
	 * Returns the continent where name = &#63; or throws a <code>NoSuchContinentException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching continent
	 * @throws NoSuchContinentException if a matching continent could not be found
	 */
	public Continent findByName(String name) throws NoSuchContinentException;

	/**
	 * Returns the continent where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByName(String)}
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching continent, or <code>null</code> if a matching continent could not be found
	 */
	@Deprecated
	public Continent fetchByName(String name, boolean useFinderCache);

	/**
	 * Returns the continent where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching continent, or <code>null</code> if a matching continent could not be found
	 */
	public Continent fetchByName(String name);

	/**
	 * Removes the continent where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the continent that was removed
	 */
	public Continent removeByName(String name) throws NoSuchContinentException;

	/**
	 * Returns the number of continents where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching continents
	 */
	public int countByName(String name);

	/**
	 * Returns all the continents where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching continents
	 */
	public java.util.List<Continent> findByActive(boolean active);

	/**
	 * Returns a range of all the continents where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @return the range of matching continents
	 */
	public java.util.List<Continent> findByActive(
		boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the continents where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching continents
	 */
	@Deprecated
	public java.util.List<Continent> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Continent> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the continents where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching continents
	 */
	public java.util.List<Continent> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Continent> orderByComparator);

	/**
	 * Returns the first continent in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching continent
	 * @throws NoSuchContinentException if a matching continent could not be found
	 */
	public Continent findByActive_First(
			boolean active, OrderByComparator<Continent> orderByComparator)
		throws NoSuchContinentException;

	/**
	 * Returns the first continent in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching continent, or <code>null</code> if a matching continent could not be found
	 */
	public Continent fetchByActive_First(
		boolean active, OrderByComparator<Continent> orderByComparator);

	/**
	 * Returns the last continent in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching continent
	 * @throws NoSuchContinentException if a matching continent could not be found
	 */
	public Continent findByActive_Last(
			boolean active, OrderByComparator<Continent> orderByComparator)
		throws NoSuchContinentException;

	/**
	 * Returns the last continent in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching continent, or <code>null</code> if a matching continent could not be found
	 */
	public Continent fetchByActive_Last(
		boolean active, OrderByComparator<Continent> orderByComparator);

	/**
	 * Returns the continents before and after the current continent in the ordered set where active = &#63;.
	 *
	 * @param continentId the primary key of the current continent
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next continent
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public Continent[] findByActive_PrevAndNext(
			long continentId, boolean active,
			OrderByComparator<Continent> orderByComparator)
		throws NoSuchContinentException;

	/**
	 * Removes all the continents where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of continents where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching continents
	 */
	public int countByActive(boolean active);

	/**
	 * Caches the continent in the entity cache if it is enabled.
	 *
	 * @param continent the continent
	 */
	public void cacheResult(Continent continent);

	/**
	 * Caches the continents in the entity cache if it is enabled.
	 *
	 * @param continents the continents
	 */
	public void cacheResult(java.util.List<Continent> continents);

	/**
	 * Creates a new continent with the primary key. Does not add the continent to the database.
	 *
	 * @param continentId the primary key for the new continent
	 * @return the new continent
	 */
	public Continent create(long continentId);

	/**
	 * Removes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent that was removed
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public Continent remove(long continentId) throws NoSuchContinentException;

	public Continent updateImpl(Continent continent);

	/**
	 * Returns the continent with the primary key or throws a <code>NoSuchContinentException</code> if it could not be found.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public Continent findByPrimaryKey(long continentId)
		throws NoSuchContinentException;

	/**
	 * Returns the continent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent, or <code>null</code> if a continent with the primary key could not be found
	 */
	public Continent fetchByPrimaryKey(long continentId);

	/**
	 * Returns all the continents.
	 *
	 * @return the continents
	 */
	public java.util.List<Continent> findAll();

	/**
	 * Returns a range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @return the range of continents
	 */
	public java.util.List<Continent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of continents
	 */
	@Deprecated
	public java.util.List<Continent> findAll(
		int start, int end, OrderByComparator<Continent> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of continents
	 */
	public java.util.List<Continent> findAll(
		int start, int end, OrderByComparator<Continent> orderByComparator);

	/**
	 * Removes all the continents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of continents.
	 *
	 * @return the number of continents
	 */
	public int countAll();

}