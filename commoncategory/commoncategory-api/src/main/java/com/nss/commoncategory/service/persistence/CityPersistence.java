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

import com.nss.commoncategory.exception.NoSuchCityException;
import com.nss.commoncategory.model.City;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityUtil
 * @generated
 */
@ProviderType
public interface CityPersistence extends BasePersistence<City> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityUtil} to access the city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching cities
	 */
	public java.util.List<City> findByActive(boolean active);

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
	public java.util.List<City> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<City> findByActive(
		boolean active, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache);

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
	public java.util.List<City> findByActive(
		boolean active, int start, int end,
		OrderByComparator<City> orderByComparator);

	/**
	 * Returns the first city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByActive_First(
			boolean active, OrderByComparator<City> orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the first city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByActive_First(
		boolean active, OrderByComparator<City> orderByComparator);

	/**
	 * Returns the last city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByActive_Last(
			boolean active, OrderByComparator<City> orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the last city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByActive_Last(
		boolean active, OrderByComparator<City> orderByComparator);

	/**
	 * Returns the cities before and after the current city in the ordered set where active = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City[] findByActive_PrevAndNext(
			long cityId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException;

	/**
	 * Removes all the cities where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching cities
	 */
	public int countByActive(boolean active);

	/**
	 * Returns the city where code = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByCode(String code) throws NoSuchCityException;

	/**
	 * Returns the city where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	@Deprecated
	public City fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the city where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByCode(String code);

	/**
	 * Removes the city where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the city that was removed
	 */
	public City removeByCode(String code) throws NoSuchCityException;

	/**
	 * Returns the number of cities where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching cities
	 */
	public int countByCode(String code);

	/**
	 * Returns all the cities where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @return the matching cities
	 */
	public java.util.List<City> findByCountryId_Active(
		long countryId, boolean active);

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
	public java.util.List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end);

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
	public java.util.List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache);

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
	public java.util.List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end,
		OrderByComparator<City> orderByComparator);

	/**
	 * Returns the first city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByCountryId_Active_First(
			long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the first city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByCountryId_Active_First(
		long countryId, boolean active,
		OrderByComparator<City> orderByComparator);

	/**
	 * Returns the last city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByCountryId_Active_Last(
			long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the last city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByCountryId_Active_Last(
		long countryId, boolean active,
		OrderByComparator<City> orderByComparator);

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
	public City[] findByCountryId_Active_PrevAndNext(
			long cityId, long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException;

	/**
	 * Removes all the cities where countryId = &#63; and active = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 */
	public void removeByCountryId_Active(long countryId, boolean active);

	/**
	 * Returns the number of cities where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @return the number of matching cities
	 */
	public int countByCountryId_Active(long countryId, boolean active);

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByCountryId_Name(long countryId, String name)
		throws NoSuchCityException;

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
	public City fetchByCountryId_Name(
		long countryId, String name, boolean useFinderCache);

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByCountryId_Name(long countryId, String name);

	/**
	 * Removes the city where countryId = &#63; and name = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the city that was removed
	 */
	public City removeByCountryId_Name(long countryId, String name)
		throws NoSuchCityException;

	/**
	 * Returns the number of cities where countryId = &#63; and name = &#63;.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the number of matching cities
	 */
	public int countByCountryId_Name(long countryId, String name);

	/**
	 * Caches the city in the entity cache if it is enabled.
	 *
	 * @param city the city
	 */
	public void cacheResult(City city);

	/**
	 * Caches the cities in the entity cache if it is enabled.
	 *
	 * @param cities the cities
	 */
	public void cacheResult(java.util.List<City> cities);

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityId the primary key for the new city
	 * @return the new city
	 */
	public City create(long cityId);

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city
	 * @return the city that was removed
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City remove(long cityId) throws NoSuchCityException;

	public City updateImpl(City city);

	/**
	 * Returns the city with the primary key or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City findByPrimaryKey(long cityId) throws NoSuchCityException;

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 */
	public City fetchByPrimaryKey(long cityId);

	/**
	 * Returns all the cities.
	 *
	 * @return the cities
	 */
	public java.util.List<City> findAll();

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
	public java.util.List<City> findAll(int start, int end);

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
	public java.util.List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator);

	/**
	 * Removes all the cities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 */
	public int countAll();

}