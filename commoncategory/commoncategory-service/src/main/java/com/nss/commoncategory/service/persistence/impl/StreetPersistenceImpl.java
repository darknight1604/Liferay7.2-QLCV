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

import com.nss.commoncategory.exception.NoSuchStreetException;
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.model.impl.StreetImpl;
import com.nss.commoncategory.model.impl.StreetModelImpl;
import com.nss.commoncategory.service.persistence.StreetPersistence;
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
 * The persistence implementation for the street service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StreetPersistence.class)
@ProviderType
public class StreetPersistenceImpl
	extends BasePersistenceImpl<Street> implements StreetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StreetUtil</code> to access the street persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StreetImpl.class.getName();

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
	 * Returns all the streets where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching streets
	 */
	@Override
	public List<Street> findByActive(boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Street> findByActive(boolean active, int start, int end) {
		return findByActive(active, start, end, null);
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
	@Override
	public List<Street> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return findByActive(active, start, end, orderByComparator);
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
	@Override
	public List<Street> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

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

		List<Street> list = (List<Street>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Street street : list) {
				if ((active != street.isActive())) {
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

			query.append(_SQL_SELECT_STREET_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StreetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Street>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Street>)QueryUtil.list(
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
	 * Returns the first street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByActive_First(
			boolean active, OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByActive_First(active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the first street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByActive_First(
		boolean active, OrderByComparator<Street> orderByComparator) {

		List<Street> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByActive_Last(
			boolean active, OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByActive_Last(active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the last street in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByActive_Last(
		boolean active, OrderByComparator<Street> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<Street> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street[] findByActive_PrevAndNext(
			long streetId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = findByPrimaryKey(streetId);

		Session session = null;

		try {
			session = openSession();

			Street[] array = new StreetImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, street, active, orderByComparator, true);

			array[1] = street;

			array[2] = getByActive_PrevAndNext(
				session, street, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Street getByActive_PrevAndNext(
		Session session, Street street, boolean active,
		OrderByComparator<Street> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STREET_WHERE);

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
			query.append(StreetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(street)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Street> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streets where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(boolean active) {
		for (Street street :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(street);
		}
	}

	/**
	 * Returns the number of streets where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching streets
	 */
	@Override
	public int countByActive(boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STREET_WHERE);

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
		"street.active = ?";

	private FinderPath _finderPathWithPaginationFindByCityId_Active;
	private FinderPath _finderPathWithoutPaginationFindByCityId_Active;
	private FinderPath _finderPathCountByCityId_Active;

	/**
	 * Returns all the streets where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the matching streets
	 */
	@Override
	public List<Street> findByCityId_Active(long cityId, boolean active) {
		return findByCityId_Active(
			cityId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end) {

		return findByCityId_Active(cityId, active, start, end, null);
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
	@Override
	public List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return findByCityId_Active(
			cityId, active, start, end, orderByComparator);
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
	@Override
	public List<Street> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCityId_Active;
			finderArgs = new Object[] {cityId, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCityId_Active;
			finderArgs = new Object[] {
				cityId, active, start, end, orderByComparator
			};
		}

		List<Street> list = (List<Street>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Street street : list) {
				if ((cityId != street.getCityId()) ||
					(active != street.isActive())) {

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

			query.append(_SQL_SELECT_STREET_WHERE);

			query.append(_FINDER_COLUMN_CITYID_ACTIVE_CITYID_2);

			query.append(_FINDER_COLUMN_CITYID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StreetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				qPos.add(active);

				if (!pagination) {
					list = (List<Street>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Street>)QueryUtil.list(
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
	 * Returns the first street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByCityId_Active_First(
			long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByCityId_Active_First(
			cityId, active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCityId_Active_First(
		long cityId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		List<Street> list = findByCityId_Active(
			cityId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street findByCityId_Active_Last(
			long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByCityId_Active_Last(
			cityId, active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCityId_Active_Last(
		long cityId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		int count = countByCityId_Active(cityId, active);

		if (count == 0) {
			return null;
		}

		List<Street> list = findByCityId_Active(
			cityId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street[] findByCityId_Active_PrevAndNext(
			long streetId, long cityId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = findByPrimaryKey(streetId);

		Session session = null;

		try {
			session = openSession();

			Street[] array = new StreetImpl[3];

			array[0] = getByCityId_Active_PrevAndNext(
				session, street, cityId, active, orderByComparator, true);

			array[1] = street;

			array[2] = getByCityId_Active_PrevAndNext(
				session, street, cityId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Street getByCityId_Active_PrevAndNext(
		Session session, Street street, long cityId, boolean active,
		OrderByComparator<Street> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STREET_WHERE);

		query.append(_FINDER_COLUMN_CITYID_ACTIVE_CITYID_2);

		query.append(_FINDER_COLUMN_CITYID_ACTIVE_ACTIVE_2);

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
			query.append(StreetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cityId);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(street)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Street> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streets where cityId = &#63; and active = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 */
	@Override
	public void removeByCityId_Active(long cityId, boolean active) {
		for (Street street :
				findByCityId_Active(
					cityId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(street);
		}
	}

	/**
	 * Returns the number of streets where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	@Override
	public int countByCityId_Active(long cityId, boolean active) {
		FinderPath finderPath = _finderPathCountByCityId_Active;

		Object[] finderArgs = new Object[] {cityId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STREET_WHERE);

			query.append(_FINDER_COLUMN_CITYID_ACTIVE_CITYID_2);

			query.append(_FINDER_COLUMN_CITYID_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

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

	private static final String _FINDER_COLUMN_CITYID_ACTIVE_CITYID_2 =
		"street.cityId = ? AND ";

	private static final String _FINDER_COLUMN_CITYID_ACTIVE_ACTIVE_2 =
		"street.active = ?";

	private FinderPath _finderPathWithPaginationFindByDistrictId_Active;
	private FinderPath _finderPathWithoutPaginationFindByDistrictId_Active;
	private FinderPath _finderPathCountByDistrictId_Active;

	/**
	 * Returns all the streets where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the matching streets
	 */
	@Override
	public List<Street> findByDistrictId_Active(
		long districtId, boolean active) {

		return findByDistrictId_Active(
			districtId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end) {

		return findByDistrictId_Active(districtId, active, start, end, null);
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
	@Override
	public List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return findByDistrictId_Active(
			districtId, active, start, end, orderByComparator);
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
	@Override
	public List<Street> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDistrictId_Active;
			finderArgs = new Object[] {districtId, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDistrictId_Active;
			finderArgs = new Object[] {
				districtId, active, start, end, orderByComparator
			};
		}

		List<Street> list = (List<Street>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Street street : list) {
				if ((districtId != street.getDistrictId()) ||
					(active != street.isActive())) {

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

			query.append(_SQL_SELECT_STREET_WHERE);

			query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_DISTRICTID_2);

			query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StreetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(districtId);

				qPos.add(active);

				if (!pagination) {
					list = (List<Street>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Street>)QueryUtil.list(
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
	 * Returns the first street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByDistrictId_Active_First(
			long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByDistrictId_Active_First(
			districtId, active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("districtId=");
		msg.append(districtId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the first street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByDistrictId_Active_First(
		long districtId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		List<Street> list = findByDistrictId_Active(
			districtId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street findByDistrictId_Active_Last(
			long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByDistrictId_Active_Last(
			districtId, active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("districtId=");
		msg.append(districtId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the last street in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByDistrictId_Active_Last(
		long districtId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		int count = countByDistrictId_Active(districtId, active);

		if (count == 0) {
			return null;
		}

		List<Street> list = findByDistrictId_Active(
			districtId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street[] findByDistrictId_Active_PrevAndNext(
			long streetId, long districtId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = findByPrimaryKey(streetId);

		Session session = null;

		try {
			session = openSession();

			Street[] array = new StreetImpl[3];

			array[0] = getByDistrictId_Active_PrevAndNext(
				session, street, districtId, active, orderByComparator, true);

			array[1] = street;

			array[2] = getByDistrictId_Active_PrevAndNext(
				session, street, districtId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Street getByDistrictId_Active_PrevAndNext(
		Session session, Street street, long districtId, boolean active,
		OrderByComparator<Street> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STREET_WHERE);

		query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_DISTRICTID_2);

		query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_ACTIVE_2);

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
			query.append(StreetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(districtId);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(street)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Street> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streets where districtId = &#63; and active = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 */
	@Override
	public void removeByDistrictId_Active(long districtId, boolean active) {
		for (Street street :
				findByDistrictId_Active(
					districtId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(street);
		}
	}

	/**
	 * Returns the number of streets where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	@Override
	public int countByDistrictId_Active(long districtId, boolean active) {
		FinderPath finderPath = _finderPathCountByDistrictId_Active;

		Object[] finderArgs = new Object[] {districtId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STREET_WHERE);

			query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_DISTRICTID_2);

			query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(districtId);

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

	private static final String _FINDER_COLUMN_DISTRICTID_ACTIVE_DISTRICTID_2 =
		"street.districtId = ? AND ";

	private static final String _FINDER_COLUMN_DISTRICTID_ACTIVE_ACTIVE_2 =
		"street.active = ?";

	private FinderPath _finderPathWithPaginationFindByWardId_Active;
	private FinderPath _finderPathWithoutPaginationFindByWardId_Active;
	private FinderPath _finderPathCountByWardId_Active;

	/**
	 * Returns all the streets where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @return the matching streets
	 */
	@Override
	public List<Street> findByWardId_Active(long wardId, boolean active) {
		return findByWardId_Active(
			wardId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end) {

		return findByWardId_Active(wardId, active, start, end, null);
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
	@Override
	public List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		return findByWardId_Active(
			wardId, active, start, end, orderByComparator);
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
	@Override
	public List<Street> findByWardId_Active(
		long wardId, boolean active, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByWardId_Active;
			finderArgs = new Object[] {wardId, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByWardId_Active;
			finderArgs = new Object[] {
				wardId, active, start, end, orderByComparator
			};
		}

		List<Street> list = (List<Street>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Street street : list) {
				if ((wardId != street.getWardId()) ||
					(active != street.isActive())) {

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

			query.append(_SQL_SELECT_STREET_WHERE);

			query.append(_FINDER_COLUMN_WARDID_ACTIVE_WARDID_2);

			query.append(_FINDER_COLUMN_WARDID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StreetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wardId);

				qPos.add(active);

				if (!pagination) {
					list = (List<Street>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Street>)QueryUtil.list(
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
	 * Returns the first street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByWardId_Active_First(
			long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByWardId_Active_First(
			wardId, active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wardId=");
		msg.append(wardId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the first street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByWardId_Active_First(
		long wardId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		List<Street> list = findByWardId_Active(
			wardId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street findByWardId_Active_Last(
			long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByWardId_Active_Last(
			wardId, active, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wardId=");
		msg.append(wardId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchStreetException(msg.toString());
	}

	/**
	 * Returns the last street in the ordered set where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByWardId_Active_Last(
		long wardId, boolean active,
		OrderByComparator<Street> orderByComparator) {

		int count = countByWardId_Active(wardId, active);

		if (count == 0) {
			return null;
		}

		List<Street> list = findByWardId_Active(
			wardId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Street[] findByWardId_Active_PrevAndNext(
			long streetId, long wardId, boolean active,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = findByPrimaryKey(streetId);

		Session session = null;

		try {
			session = openSession();

			Street[] array = new StreetImpl[3];

			array[0] = getByWardId_Active_PrevAndNext(
				session, street, wardId, active, orderByComparator, true);

			array[1] = street;

			array[2] = getByWardId_Active_PrevAndNext(
				session, street, wardId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Street getByWardId_Active_PrevAndNext(
		Session session, Street street, long wardId, boolean active,
		OrderByComparator<Street> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STREET_WHERE);

		query.append(_FINDER_COLUMN_WARDID_ACTIVE_WARDID_2);

		query.append(_FINDER_COLUMN_WARDID_ACTIVE_ACTIVE_2);

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
			query.append(StreetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(wardId);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(street)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Street> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streets where wardId = &#63; and active = &#63; from the database.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 */
	@Override
	public void removeByWardId_Active(long wardId, boolean active) {
		for (Street street :
				findByWardId_Active(
					wardId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(street);
		}
	}

	/**
	 * Returns the number of streets where wardId = &#63; and active = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param active the active
	 * @return the number of matching streets
	 */
	@Override
	public int countByWardId_Active(long wardId, boolean active) {
		FinderPath finderPath = _finderPathCountByWardId_Active;

		Object[] finderArgs = new Object[] {wardId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STREET_WHERE);

			query.append(_FINDER_COLUMN_WARDID_ACTIVE_WARDID_2);

			query.append(_FINDER_COLUMN_WARDID_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wardId);

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

	private static final String _FINDER_COLUMN_WARDID_ACTIVE_WARDID_2 =
		"street.wardId = ? AND ";

	private static final String _FINDER_COLUMN_WARDID_ACTIVE_ACTIVE_2 =
		"street.active = ?";

	private FinderPath _finderPathFetchByWardId_Name;
	private FinderPath _finderPathCountByWardId_Name;

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByWardId_Name(long wardId, String name)
		throws NoSuchStreetException {

		Street street = fetchByWardId_Name(wardId, name);

		if (street == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("wardId=");
			msg.append(wardId);

			msg.append(", name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStreetException(msg.toString());
		}

		return street;
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
	@Override
	public Street fetchByWardId_Name(
		long wardId, String name, boolean useFinderCache) {

		return fetchByWardId_Name(wardId, name);
	}

	/**
	 * Returns the street where wardId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByWardId_Name(long wardId, String name) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {wardId, name};

		Object result = finderCache.getResult(
			_finderPathFetchByWardId_Name, finderArgs, this);

		if (result instanceof Street) {
			Street street = (Street)result;

			if ((wardId != street.getWardId()) ||
				!Objects.equals(name, street.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STREET_WHERE);

			query.append(_FINDER_COLUMN_WARDID_NAME_WARDID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_WARDID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_WARDID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wardId);

				if (bindName) {
					qPos.add(name);
				}

				List<Street> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByWardId_Name, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StreetPersistenceImpl.fetchByWardId_Name(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Street street = list.get(0);

					result = street;

					cacheResult(street);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByWardId_Name, finderArgs);

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
			return (Street)result;
		}
	}

	/**
	 * Removes the street where wardId = &#63; and name = &#63; from the database.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the street that was removed
	 */
	@Override
	public Street removeByWardId_Name(long wardId, String name)
		throws NoSuchStreetException {

		Street street = findByWardId_Name(wardId, name);

		return remove(street);
	}

	/**
	 * Returns the number of streets where wardId = &#63; and name = &#63;.
	 *
	 * @param wardId the ward ID
	 * @param name the name
	 * @return the number of matching streets
	 */
	@Override
	public int countByWardId_Name(long wardId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByWardId_Name;

		Object[] finderArgs = new Object[] {wardId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STREET_WHERE);

			query.append(_FINDER_COLUMN_WARDID_NAME_WARDID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_WARDID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_WARDID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wardId);

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

	private static final String _FINDER_COLUMN_WARDID_NAME_WARDID_2 =
		"street.wardId = ? AND ";

	private static final String _FINDER_COLUMN_WARDID_NAME_NAME_2 =
		"street.name = ?";

	private static final String _FINDER_COLUMN_WARDID_NAME_NAME_3 =
		"(street.name IS NULL OR street.name = '')";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the street where code = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByCode(String code) throws NoSuchStreetException {
		Street street = fetchByCode(code);

		if (street == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStreetException(msg.toString());
		}

		return street;
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
	@Override
	public Street fetchByCode(String code, boolean useFinderCache) {
		return fetchByCode(code);
	}

	/**
	 * Returns the street where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCode(String code) {
		code = Objects.toString(code, "");

		Object[] finderArgs = new Object[] {code};

		Object result = finderCache.getResult(
			_finderPathFetchByCode, finderArgs, this);

		if (result instanceof Street) {
			Street street = (Street)result;

			if (!Objects.equals(code, street.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STREET_WHERE);

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

				List<Street> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCode, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StreetPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Street street = list.get(0);

					result = street;

					cacheResult(street);
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
			return (Street)result;
		}
	}

	/**
	 * Removes the street where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the street that was removed
	 */
	@Override
	public Street removeByCode(String code) throws NoSuchStreetException {
		Street street = findByCode(code);

		return remove(street);
	}

	/**
	 * Returns the number of streets where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching streets
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STREET_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_2 = "street.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(street.code IS NULL OR street.code = '')";

	public StreetPersistenceImpl() {
		setModelClass(Street.class);

		setModelImplClass(StreetImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the street in the entity cache if it is enabled.
	 *
	 * @param street the street
	 */
	@Override
	public void cacheResult(Street street) {
		entityCache.putResult(
			entityCacheEnabled, StreetImpl.class, street.getPrimaryKey(),
			street);

		finderCache.putResult(
			_finderPathFetchByWardId_Name,
			new Object[] {street.getWardId(), street.getName()}, street);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {street.getCode()}, street);

		street.resetOriginalValues();
	}

	/**
	 * Caches the streets in the entity cache if it is enabled.
	 *
	 * @param streets the streets
	 */
	@Override
	public void cacheResult(List<Street> streets) {
		for (Street street : streets) {
			if (entityCache.getResult(
					entityCacheEnabled, StreetImpl.class,
					street.getPrimaryKey()) == null) {

				cacheResult(street);
			}
			else {
				street.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all streets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StreetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the street.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Street street) {
		entityCache.removeResult(
			entityCacheEnabled, StreetImpl.class, street.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StreetModelImpl)street, true);
	}

	@Override
	public void clearCache(List<Street> streets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Street street : streets) {
			entityCache.removeResult(
				entityCacheEnabled, StreetImpl.class, street.getPrimaryKey());

			clearUniqueFindersCache((StreetModelImpl)street, true);
		}
	}

	protected void cacheUniqueFindersCache(StreetModelImpl streetModelImpl) {
		Object[] args = new Object[] {
			streetModelImpl.getWardId(), streetModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByWardId_Name, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByWardId_Name, args, streetModelImpl, false);

		args = new Object[] {streetModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, streetModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StreetModelImpl streetModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				streetModelImpl.getWardId(), streetModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByWardId_Name, args);
			finderCache.removeResult(_finderPathFetchByWardId_Name, args);
		}

		if ((streetModelImpl.getColumnBitmask() &
			 _finderPathFetchByWardId_Name.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				streetModelImpl.getOriginalWardId(),
				streetModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByWardId_Name, args);
			finderCache.removeResult(_finderPathFetchByWardId_Name, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {streetModelImpl.getCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}

		if ((streetModelImpl.getColumnBitmask() &
			 _finderPathFetchByCode.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {streetModelImpl.getOriginalCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}
	}

	/**
	 * Creates a new street with the primary key. Does not add the street to the database.
	 *
	 * @param streetId the primary key for the new street
	 * @return the new street
	 */
	@Override
	public Street create(long streetId) {
		Street street = new StreetImpl();

		street.setNew(true);
		street.setPrimaryKey(streetId);

		street.setCompanyId(CompanyThreadLocal.getCompanyId());

		return street;
	}

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streetId the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street remove(long streetId) throws NoSuchStreetException {
		return remove((Serializable)streetId);
	}

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street remove(Serializable primaryKey) throws NoSuchStreetException {
		Session session = null;

		try {
			session = openSession();

			Street street = (Street)session.get(StreetImpl.class, primaryKey);

			if (street == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStreetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(street);
		}
		catch (NoSuchStreetException nsee) {
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
	protected Street removeImpl(Street street) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(street)) {
				street = (Street)session.get(
					StreetImpl.class, street.getPrimaryKeyObj());
			}

			if (street != null) {
				session.delete(street);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (street != null) {
			clearCache(street);
		}

		return street;
	}

	@Override
	public Street updateImpl(Street street) {
		boolean isNew = street.isNew();

		if (!(street instanceof StreetModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(street.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(street);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in street proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Street implementation " +
					street.getClass());
		}

		StreetModelImpl streetModelImpl = (StreetModelImpl)street;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (street.getCreateDate() == null)) {
			if (serviceContext == null) {
				street.setCreateDate(now);
			}
			else {
				street.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!streetModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				street.setModifiedDate(now);
			}
			else {
				street.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (street.isNew()) {
				session.save(street);

				street.setNew(false);
			}
			else {
				street = (Street)session.merge(street);
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
			Object[] args = new Object[] {streetModelImpl.isActive()};

			finderCache.removeResult(_finderPathCountByActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActive, args);

			args = new Object[] {
				streetModelImpl.getCityId(), streetModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByCityId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCityId_Active, args);

			args = new Object[] {
				streetModelImpl.getDistrictId(), streetModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByDistrictId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDistrictId_Active, args);

			args = new Object[] {
				streetModelImpl.getWardId(), streetModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByWardId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByWardId_Active, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((streetModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActive.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					streetModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);

				args = new Object[] {streetModelImpl.isActive()};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);
			}

			if ((streetModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCityId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					streetModelImpl.getOriginalCityId(),
					streetModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByCityId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCityId_Active, args);

				args = new Object[] {
					streetModelImpl.getCityId(), streetModelImpl.isActive()
				};

				finderCache.removeResult(_finderPathCountByCityId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCityId_Active, args);
			}

			if ((streetModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDistrictId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					streetModelImpl.getOriginalDistrictId(),
					streetModelImpl.getOriginalActive()
				};

				finderCache.removeResult(
					_finderPathCountByDistrictId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDistrictId_Active, args);

				args = new Object[] {
					streetModelImpl.getDistrictId(), streetModelImpl.isActive()
				};

				finderCache.removeResult(
					_finderPathCountByDistrictId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDistrictId_Active, args);
			}

			if ((streetModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByWardId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					streetModelImpl.getOriginalWardId(),
					streetModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByWardId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByWardId_Active, args);

				args = new Object[] {
					streetModelImpl.getWardId(), streetModelImpl.isActive()
				};

				finderCache.removeResult(_finderPathCountByWardId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByWardId_Active, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StreetImpl.class, street.getPrimaryKey(),
			street, false);

		clearUniqueFindersCache(streetModelImpl, false);
		cacheUniqueFindersCache(streetModelImpl);

		street.resetOriginalValues();

		return street;
	}

	/**
	 * Returns the street with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStreetException {

		Street street = fetchByPrimaryKey(primaryKey);

		if (street == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStreetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return street;
	}

	/**
	 * Returns the street with the primary key or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street findByPrimaryKey(long streetId) throws NoSuchStreetException {
		return findByPrimaryKey((Serializable)streetId);
	}

	/**
	 * Returns the street with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street, or <code>null</code> if a street with the primary key could not be found
	 */
	@Override
	public Street fetchByPrimaryKey(long streetId) {
		return fetchByPrimaryKey((Serializable)streetId);
	}

	/**
	 * Returns all the streets.
	 *
	 * @return the streets
	 */
	@Override
	public List<Street> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Street> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator) {

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

		List<Street> list = (List<Street>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STREET);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STREET;

				if (pagination) {
					sql = sql.concat(StreetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Street>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Street>)QueryUtil.list(
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
	 * Removes all the streets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Street street : findAll()) {
			remove(street);
		}
	}

	/**
	 * Returns the number of streets.
	 *
	 * @return the number of streets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STREET);

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
		return "streetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STREET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StreetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the street persistence.
	 */
	@Activate
	public void activate() {
		StreetModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StreetModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName()},
			StreetModelImpl.ACTIVE_COLUMN_BITMASK |
			StreetModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByCityId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCityId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			StreetModelImpl.CITYID_COLUMN_BITMASK |
			StreetModelImpl.ACTIVE_COLUMN_BITMASK |
			StreetModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByCityId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByDistrictId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistrictId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDistrictId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDistrictId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			StreetModelImpl.DISTRICTID_COLUMN_BITMASK |
			StreetModelImpl.ACTIVE_COLUMN_BITMASK |
			StreetModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByDistrictId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDistrictId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByWardId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWardId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByWardId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWardId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			StreetModelImpl.WARDID_COLUMN_BITMASK |
			StreetModelImpl.ACTIVE_COLUMN_BITMASK |
			StreetModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByWardId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWardId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathFetchByWardId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWardId_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			StreetModelImpl.WARDID_COLUMN_BITMASK |
			StreetModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByWardId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWardId_Name",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StreetImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()},
			StreetModelImpl.CODE_COLUMN_BITMASK);

		_finderPathCountByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StreetImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.nss.commoncategory.model.Street"),
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

	private static final String _SQL_SELECT_STREET =
		"SELECT street FROM Street street";

	private static final String _SQL_SELECT_STREET_WHERE =
		"SELECT street FROM Street street WHERE ";

	private static final String _SQL_COUNT_STREET =
		"SELECT COUNT(street) FROM Street street";

	private static final String _SQL_COUNT_STREET_WHERE =
		"SELECT COUNT(street) FROM Street street WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "street.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Street exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Street exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StreetPersistenceImpl.class);

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