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

package com.nss.commoncategory.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.nss.commoncategory.exception.NoSuchCityException;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.impl.CityImpl;
import com.nss.commoncategory.model.impl.CityModelImpl;
import com.nss.commoncategory.service.persistence.CityPersistence;
import com.nss.commoncategory.service.persistence.impl.constants.NSSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CityPersistence.class)
@ProviderType
public class CityPersistenceImpl
	extends BasePersistenceImpl<City> implements CityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CityUtil</code> to access the city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByActive;
	private FinderPath _finderPathWithoutPaginationFindByActive;
	private FinderPath _finderPathCountByActive;

	/**
	 * Returns all the cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching cities
	 */
	@Override
	public List<City> findByActive(boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<City> findByActive(boolean active, int start, int end) {
		return findByActive(active, start, end, null);
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
	@Override
	public List<City> findByActive(
		boolean active, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return findByActive(active, start, end, orderByComparator);
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
	@Override
	public List<City> findByActive(
		boolean active, int start, int end,
		OrderByComparator<City> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByActive;
			finderArgs = new Object[] {active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByActive;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<City> list = (List<City>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (City city : list) {
				if ((active != city.isActive())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CITY_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<City>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<City>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	@Override
	public City findByActive_First(
			boolean active, OrderByComparator<City> orderByComparator)
		throws NoSuchCityException {

		City city = fetchByActive_First(active, orderByComparator);

		if (city != null) {
			return city;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the first city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	@Override
	public City fetchByActive_First(
		boolean active, OrderByComparator<City> orderByComparator) {

		List<City> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	@Override
	public City findByActive_Last(
			boolean active, OrderByComparator<City> orderByComparator)
		throws NoSuchCityException {

		City city = fetchByActive_Last(active, orderByComparator);

		if (city != null) {
			return city;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the last city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	@Override
	public City fetchByActive_Last(
		boolean active, OrderByComparator<City> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<City> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public City[] findByActive_PrevAndNext(
			long cityId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException {

		City city = findByPrimaryKey(cityId);

		Session session = null;

		try {
			session = openSession();

			City[] array = new CityImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, city, active, orderByComparator, true);

			array[1] = city;

			array[2] = getByActive_PrevAndNext(
				session, city, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected City getByActive_PrevAndNext(
		Session session, City city, boolean active,
		OrderByComparator<City> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITY_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(city)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<City> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cities where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(boolean active) {
		for (City city :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(city);
		}
	}

	/**
	 * Returns the number of cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching cities
	 */
	@Override
	public int countByActive(boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITY_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 =
		"city.active = ?";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the city where code = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	@Override
	public City findByCode(String code) throws NoSuchCityException {
		City city = fetchByCode(code);

		if (city == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCityException(msg.toString());
		}

		return city;
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
	@Override
	public City fetchByCode(String code, boolean useFinderCache) {
		return fetchByCode(code);
	}

	/**
	 * Returns the city where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	@Override
	public City fetchByCode(String code) {
		code = Objects.toString(code, "");

		Object[] finderArgs = new Object[] {code};

		Object result = finderCache.getResult(
			_finderPathFetchByCode, finderArgs, this);

		if (result instanceof City) {
			City city = (City)result;

			if (!Objects.equals(code, city.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CITY_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<City> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCode, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CityPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					City city = list.get(0);

					result = city;

					cacheResult(city);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByCode, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (City)result;
		}
	}

	/**
	 * Removes the city where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the city that was removed
	 */
	@Override
	public City removeByCode(String code) throws NoSuchCityException {
		City city = findByCode(code);

		return remove(city);
	}

	/**
	 * Returns the number of cities where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching cities
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITY_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODE_CODE_2 = "city.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(city.code IS NULL OR city.code = '')";

	private FinderPath _finderPathWithPaginationFindByCountryId_Active;
	private FinderPath _finderPathWithoutPaginationFindByCountryId_Active;
	private FinderPath _finderPathCountByCountryId_Active;

	/**
	 * Returns all the cities where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @return the matching cities
	 */
	@Override
	public List<City> findByCountryId_Active(long countryId, boolean active) {
		return findByCountryId_Active(
			countryId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end) {

		return findByCountryId_Active(countryId, active, start, end, null);
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
	@Override
	public List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return findByCountryId_Active(
			countryId, active, start, end, orderByComparator);
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
	@Override
	public List<City> findByCountryId_Active(
		long countryId, boolean active, int start, int end,
		OrderByComparator<City> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCountryId_Active;
			finderArgs = new Object[] {countryId, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCountryId_Active;
			finderArgs = new Object[] {
				countryId, active, start, end, orderByComparator
			};
		}

		List<City> list = (List<City>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (City city : list) {
				if ((countryId != city.getCountryId()) ||
					(active != city.isActive())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CITY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_ACTIVE_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(active);

				if (!pagination) {
					list = (List<City>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<City>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public City findByCountryId_Active_First(
			long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException {

		City city = fetchByCountryId_Active_First(
			countryId, active, orderByComparator);

		if (city != null) {
			return city;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the first city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	@Override
	public City fetchByCountryId_Active_First(
		long countryId, boolean active,
		OrderByComparator<City> orderByComparator) {

		List<City> list = findByCountryId_Active(
			countryId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public City findByCountryId_Active_Last(
			long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException {

		City city = fetchByCountryId_Active_Last(
			countryId, active, orderByComparator);

		if (city != null) {
			return city;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCityException(msg.toString());
	}

	/**
	 * Returns the last city in the ordered set where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	@Override
	public City fetchByCountryId_Active_Last(
		long countryId, boolean active,
		OrderByComparator<City> orderByComparator) {

		int count = countByCountryId_Active(countryId, active);

		if (count == 0) {
			return null;
		}

		List<City> list = findByCountryId_Active(
			countryId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public City[] findByCountryId_Active_PrevAndNext(
			long cityId, long countryId, boolean active,
			OrderByComparator<City> orderByComparator)
		throws NoSuchCityException {

		City city = findByPrimaryKey(cityId);

		Session session = null;

		try {
			session = openSession();

			City[] array = new CityImpl[3];

			array[0] = getByCountryId_Active_PrevAndNext(
				session, city, countryId, active, orderByComparator, true);

			array[1] = city;

			array[2] = getByCountryId_Active_PrevAndNext(
				session, city, countryId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected City getByCountryId_Active_PrevAndNext(
		Session session, City city, long countryId, boolean active,
		OrderByComparator<City> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CITY_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYID_ACTIVE_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYID_ACTIVE_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(city)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<City> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cities where countryId = &#63; and active = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 */
	@Override
	public void removeByCountryId_Active(long countryId, boolean active) {
		for (City city :
				findByCountryId_Active(
					countryId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(city);
		}
	}

	/**
	 * Returns the number of cities where countryId = &#63; and active = &#63;.
	 *
	 * @param countryId the country ID
	 * @param active the active
	 * @return the number of matching cities
	 */
	@Override
	public int countByCountryId_Active(long countryId, boolean active) {
		FinderPath finderPath = _finderPathCountByCountryId_Active;

		Object[] finderArgs = new Object[] {countryId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CITY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_ACTIVE_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYID_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNTRYID_ACTIVE_COUNTRYID_2 =
		"city.countryId = ? AND ";

	private static final String _FINDER_COLUMN_COUNTRYID_ACTIVE_ACTIVE_2 =
		"city.active = ?";

	private FinderPath _finderPathFetchByCountryId_Name;
	private FinderPath _finderPathCountByCountryId_Name;

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	@Override
	public City findByCountryId_Name(long countryId, String name)
		throws NoSuchCityException {

		City city = fetchByCountryId_Name(countryId, name);

		if (city == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("countryId=");
			msg.append(countryId);

			msg.append(", name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCityException(msg.toString());
		}

		return city;
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
	@Override
	public City fetchByCountryId_Name(
		long countryId, String name, boolean useFinderCache) {

		return fetchByCountryId_Name(countryId, name);
	}

	/**
	 * Returns the city where countryId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	@Override
	public City fetchByCountryId_Name(long countryId, String name) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {countryId, name};

		Object result = finderCache.getResult(
			_finderPathFetchByCountryId_Name, finderArgs, this);

		if (result instanceof City) {
			City city = (City)result;

			if ((countryId != city.getCountryId()) ||
				!Objects.equals(name, city.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CITY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_NAME_COUNTRYID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_COUNTRYID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_COUNTRYID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				if (bindName) {
					qPos.add(name);
				}

				List<City> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCountryId_Name, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CityPersistenceImpl.fetchByCountryId_Name(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					City city = list.get(0);

					result = city;

					cacheResult(city);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByCountryId_Name, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (City)result;
		}
	}

	/**
	 * Removes the city where countryId = &#63; and name = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the city that was removed
	 */
	@Override
	public City removeByCountryId_Name(long countryId, String name)
		throws NoSuchCityException {

		City city = findByCountryId_Name(countryId, name);

		return remove(city);
	}

	/**
	 * Returns the number of cities where countryId = &#63; and name = &#63;.
	 *
	 * @param countryId the country ID
	 * @param name the name
	 * @return the number of matching cities
	 */
	@Override
	public int countByCountryId_Name(long countryId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByCountryId_Name;

		Object[] finderArgs = new Object[] {countryId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CITY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_NAME_COUNTRYID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_COUNTRYID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_COUNTRYID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNTRYID_NAME_COUNTRYID_2 =
		"city.countryId = ? AND ";

	private static final String _FINDER_COLUMN_COUNTRYID_NAME_NAME_2 =
		"city.name = ?";

	private static final String _FINDER_COLUMN_COUNTRYID_NAME_NAME_3 =
		"(city.name IS NULL OR city.name = '')";

	public CityPersistenceImpl() {
		setModelClass(City.class);

		setModelImplClass(CityImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the city in the entity cache if it is enabled.
	 *
	 * @param city the city
	 */
	@Override
	public void cacheResult(City city) {
		entityCache.putResult(
			entityCacheEnabled, CityImpl.class, city.getPrimaryKey(), city);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {city.getCode()}, city);

		finderCache.putResult(
			_finderPathFetchByCountryId_Name,
			new Object[] {city.getCountryId(), city.getName()}, city);

		city.resetOriginalValues();
	}

	/**
	 * Caches the cities in the entity cache if it is enabled.
	 *
	 * @param cities the cities
	 */
	@Override
	public void cacheResult(List<City> cities) {
		for (City city : cities) {
			if (entityCache.getResult(
					entityCacheEnabled, CityImpl.class, city.getPrimaryKey()) ==
						null) {

				cacheResult(city);
			}
			else {
				city.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the city.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(City city) {
		entityCache.removeResult(
			entityCacheEnabled, CityImpl.class, city.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CityModelImpl)city, true);
	}

	@Override
	public void clearCache(List<City> cities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (City city : cities) {
			entityCache.removeResult(
				entityCacheEnabled, CityImpl.class, city.getPrimaryKey());

			clearUniqueFindersCache((CityModelImpl)city, true);
		}
	}

	protected void cacheUniqueFindersCache(CityModelImpl cityModelImpl) {
		Object[] args = new Object[] {cityModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, cityModelImpl, false);

		args = new Object[] {
			cityModelImpl.getCountryId(), cityModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByCountryId_Name, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCountryId_Name, args, cityModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CityModelImpl cityModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {cityModelImpl.getCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}

		if ((cityModelImpl.getColumnBitmask() &
			 _finderPathFetchByCode.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {cityModelImpl.getOriginalCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				cityModelImpl.getCountryId(), cityModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByCountryId_Name, args);
			finderCache.removeResult(_finderPathFetchByCountryId_Name, args);
		}

		if ((cityModelImpl.getColumnBitmask() &
			 _finderPathFetchByCountryId_Name.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				cityModelImpl.getOriginalCountryId(),
				cityModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByCountryId_Name, args);
			finderCache.removeResult(_finderPathFetchByCountryId_Name, args);
		}
	}

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityId the primary key for the new city
	 * @return the new city
	 */
	@Override
	public City create(long cityId) {
		City city = new CityImpl();

		city.setNew(true);
		city.setPrimaryKey(cityId);

		city.setCompanyId(CompanyThreadLocal.getCompanyId());

		return city;
	}

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city
	 * @return the city that was removed
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	@Override
	public City remove(long cityId) throws NoSuchCityException {
		return remove((Serializable)cityId);
	}

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the city
	 * @return the city that was removed
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	@Override
	public City remove(Serializable primaryKey) throws NoSuchCityException {
		Session session = null;

		try {
			session = openSession();

			City city = (City)session.get(CityImpl.class, primaryKey);

			if (city == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(city);
		}
		catch (NoSuchCityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected City removeImpl(City city) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(city)) {
				city = (City)session.get(
					CityImpl.class, city.getPrimaryKeyObj());
			}

			if (city != null) {
				session.delete(city);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (city != null) {
			clearCache(city);
		}

		return city;
	}

	@Override
	public City updateImpl(City city) {
		boolean isNew = city.isNew();

		if (!(city instanceof CityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(city.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(city);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in city proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom City implementation " +
					city.getClass());
		}

		CityModelImpl cityModelImpl = (CityModelImpl)city;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (city.getCreateDate() == null)) {
			if (serviceContext == null) {
				city.setCreateDate(now);
			}
			else {
				city.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!cityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				city.setModifiedDate(now);
			}
			else {
				city.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (city.isNew()) {
				session.save(city);

				city.setNew(false);
			}
			else {
				city = (City)session.merge(city);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {cityModelImpl.isActive()};

			finderCache.removeResult(_finderPathCountByActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActive, args);

			args = new Object[] {
				cityModelImpl.getCountryId(), cityModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByCountryId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCountryId_Active, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((cityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActive.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					cityModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);

				args = new Object[] {cityModelImpl.isActive()};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);
			}

			if ((cityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCountryId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					cityModelImpl.getOriginalCountryId(),
					cityModelImpl.getOriginalActive()
				};

				finderCache.removeResult(
					_finderPathCountByCountryId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCountryId_Active, args);

				args = new Object[] {
					cityModelImpl.getCountryId(), cityModelImpl.isActive()
				};

				finderCache.removeResult(
					_finderPathCountByCountryId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCountryId_Active, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CityImpl.class, city.getPrimaryKey(), city,
			false);

		clearUniqueFindersCache(cityModelImpl, false);
		cacheUniqueFindersCache(cityModelImpl);

		city.resetOriginalValues();

		return city;
	}

	/**
	 * Returns the city with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the city
	 * @return the city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	@Override
	public City findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCityException {

		City city = fetchByPrimaryKey(primaryKey);

		if (city == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return city;
	}

	/**
	 * Returns the city with the primary key or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	@Override
	public City findByPrimaryKey(long cityId) throws NoSuchCityException {
		return findByPrimaryKey((Serializable)cityId);
	}

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 */
	@Override
	public City fetchByPrimaryKey(long cityId) {
		return fetchByPrimaryKey((Serializable)cityId);
	}

	/**
	 * Returns all the cities.
	 *
	 * @return the cities
	 */
	@Override
	public List<City> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<City> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<City> list = (List<City>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CITY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITY;

				if (pagination) {
					sql = sql.concat(CityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<City>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<City>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (City city : findAll()) {
			remove(city);
		}
	}

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CITY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "cityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the city persistence.
	 */
	@Activate
	public void activate() {
		CityModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CityModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName()},
			CityModelImpl.ACTIVE_COLUMN_BITMASK |
			CityModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName()});

		_finderPathFetchByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()},
			CityModelImpl.CODE_COLUMN_BITMASK);

		_finderPathCountByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByCountryId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountryId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCountryId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountryId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			CityModelImpl.COUNTRYID_COLUMN_BITMASK |
			CityModelImpl.ACTIVE_COLUMN_BITMASK |
			CityModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByCountryId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathFetchByCountryId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCountryId_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			CityModelImpl.COUNTRYID_COLUMN_BITMASK |
			CityModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByCountryId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryId_Name",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CityImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = NSSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.nss.commoncategory.model.City"),
			true);
	}

	@Override
	@Reference(
		target = NSSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NSSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CITY = "SELECT city FROM City city";

	private static final String _SQL_SELECT_CITY_WHERE =
		"SELECT city FROM City city WHERE ";

	private static final String _SQL_COUNT_CITY =
		"SELECT COUNT(city) FROM City city";

	private static final String _SQL_COUNT_CITY_WHERE =
		"SELECT COUNT(city) FROM City city WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "city.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No City exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No City exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

	static {
		try {
			Class.forName(NSSPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}