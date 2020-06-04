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

import com.nss.commoncategory.exception.NoSuchDistrictException;
import com.nss.commoncategory.model.District;
import com.nss.commoncategory.model.impl.DistrictImpl;
import com.nss.commoncategory.model.impl.DistrictModelImpl;
import com.nss.commoncategory.service.persistence.DistrictPersistence;
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
 * The persistence implementation for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DistrictPersistence.class)
@ProviderType
public class DistrictPersistenceImpl
	extends BasePersistenceImpl<District> implements DistrictPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DistrictUtil</code> to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DistrictImpl.class.getName();

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
	 * Returns all the districts where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching districts
	 */
	@Override
	public List<District> findByActive(boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<District> findByActive(boolean active, int start, int end) {
		return findByActive(active, start, end, null);
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
	@Override
	public List<District> findByActive(
		boolean active, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return findByActive(active, start, end, orderByComparator);
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
	@Override
	public List<District> findByActive(
		boolean active, int start, int end,
		OrderByComparator<District> orderByComparator) {

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

		List<District> list = (List<District>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (District district : list) {
				if ((active != district.isActive())) {
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

			query.append(_SQL_SELECT_DISTRICT_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DistrictModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<District>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<District>)QueryUtil.list(
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
	 * Returns the first district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	@Override
	public District findByActive_First(
			boolean active, OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException {

		District district = fetchByActive_First(active, orderByComparator);

		if (district != null) {
			return district;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchDistrictException(msg.toString());
	}

	/**
	 * Returns the first district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public District fetchByActive_First(
		boolean active, OrderByComparator<District> orderByComparator) {

		List<District> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	@Override
	public District findByActive_Last(
			boolean active, OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException {

		District district = fetchByActive_Last(active, orderByComparator);

		if (district != null) {
			return district;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchDistrictException(msg.toString());
	}

	/**
	 * Returns the last district in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public District fetchByActive_Last(
		boolean active, OrderByComparator<District> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<District> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public District[] findByActive_PrevAndNext(
			long districtId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException {

		District district = findByPrimaryKey(districtId);

		Session session = null;

		try {
			session = openSession();

			District[] array = new DistrictImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, district, active, orderByComparator, true);

			array[1] = district;

			array[2] = getByActive_PrevAndNext(
				session, district, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected District getByActive_PrevAndNext(
		Session session, District district, boolean active,
		OrderByComparator<District> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRICT_WHERE);

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
			query.append(DistrictModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(district)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<District> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the districts where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(boolean active) {
		for (District district :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(district);
		}
	}

	/**
	 * Returns the number of districts where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching districts
	 */
	@Override
	public int countByActive(boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISTRICT_WHERE);

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
		"district.active = ?";

	private FinderPath _finderPathWithPaginationFindByCityId_Active;
	private FinderPath _finderPathWithoutPaginationFindByCityId_Active;
	private FinderPath _finderPathCountByCityId_Active;

	/**
	 * Returns all the districts where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the matching districts
	 */
	@Override
	public List<District> findByCityId_Active(long cityId, boolean active) {
		return findByCityId_Active(
			cityId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end) {

		return findByCityId_Active(cityId, active, start, end, null);
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
	@Override
	public List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return findByCityId_Active(
			cityId, active, start, end, orderByComparator);
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
	@Override
	public List<District> findByCityId_Active(
		long cityId, boolean active, int start, int end,
		OrderByComparator<District> orderByComparator) {

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

		List<District> list = (List<District>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (District district : list) {
				if ((cityId != district.getCityId()) ||
					(active != district.isActive())) {

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

			query.append(_SQL_SELECT_DISTRICT_WHERE);

			query.append(_FINDER_COLUMN_CITYID_ACTIVE_CITYID_2);

			query.append(_FINDER_COLUMN_CITYID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DistrictModelImpl.ORDER_BY_JPQL);
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
					list = (List<District>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<District>)QueryUtil.list(
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
	 * Returns the first district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	@Override
	public District findByCityId_Active_First(
			long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException {

		District district = fetchByCityId_Active_First(
			cityId, active, orderByComparator);

		if (district != null) {
			return district;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchDistrictException(msg.toString());
	}

	/**
	 * Returns the first district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public District fetchByCityId_Active_First(
		long cityId, boolean active,
		OrderByComparator<District> orderByComparator) {

		List<District> list = findByCityId_Active(
			cityId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public District findByCityId_Active_Last(
			long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException {

		District district = fetchByCityId_Active_Last(
			cityId, active, orderByComparator);

		if (district != null) {
			return district;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityId=");
		msg.append(cityId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchDistrictException(msg.toString());
	}

	/**
	 * Returns the last district in the ordered set where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public District fetchByCityId_Active_Last(
		long cityId, boolean active,
		OrderByComparator<District> orderByComparator) {

		int count = countByCityId_Active(cityId, active);

		if (count == 0) {
			return null;
		}

		List<District> list = findByCityId_Active(
			cityId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public District[] findByCityId_Active_PrevAndNext(
			long districtId, long cityId, boolean active,
			OrderByComparator<District> orderByComparator)
		throws NoSuchDistrictException {

		District district = findByPrimaryKey(districtId);

		Session session = null;

		try {
			session = openSession();

			District[] array = new DistrictImpl[3];

			array[0] = getByCityId_Active_PrevAndNext(
				session, district, cityId, active, orderByComparator, true);

			array[1] = district;

			array[2] = getByCityId_Active_PrevAndNext(
				session, district, cityId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected District getByCityId_Active_PrevAndNext(
		Session session, District district, long cityId, boolean active,
		OrderByComparator<District> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DISTRICT_WHERE);

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
			query.append(DistrictModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(district)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<District> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the districts where cityId = &#63; and active = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 */
	@Override
	public void removeByCityId_Active(long cityId, boolean active) {
		for (District district :
				findByCityId_Active(
					cityId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(district);
		}
	}

	/**
	 * Returns the number of districts where cityId = &#63; and active = &#63;.
	 *
	 * @param cityId the city ID
	 * @param active the active
	 * @return the number of matching districts
	 */
	@Override
	public int countByCityId_Active(long cityId, boolean active) {
		FinderPath finderPath = _finderPathCountByCityId_Active;

		Object[] finderArgs = new Object[] {cityId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISTRICT_WHERE);

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
		"district.cityId = ? AND ";

	private static final String _FINDER_COLUMN_CITYID_ACTIVE_ACTIVE_2 =
		"district.active = ?";

	private FinderPath _finderPathFetchByCityId_Name;
	private FinderPath _finderPathCountByCityId_Name;

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	@Override
	public District findByCityId_Name(long cityId, String name)
		throws NoSuchDistrictException {

		District district = fetchByCityId_Name(cityId, name);

		if (district == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cityId=");
			msg.append(cityId);

			msg.append(", name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDistrictException(msg.toString());
		}

		return district;
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
	@Override
	public District fetchByCityId_Name(
		long cityId, String name, boolean useFinderCache) {

		return fetchByCityId_Name(cityId, name);
	}

	/**
	 * Returns the district where cityId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public District fetchByCityId_Name(long cityId, String name) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {cityId, name};

		Object result = finderCache.getResult(
			_finderPathFetchByCityId_Name, finderArgs, this);

		if (result instanceof District) {
			District district = (District)result;

			if ((cityId != district.getCityId()) ||
				!Objects.equals(name, district.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DISTRICT_WHERE);

			query.append(_FINDER_COLUMN_CITYID_NAME_CITYID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_CITYID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CITYID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

				if (bindName) {
					qPos.add(name);
				}

				List<District> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCityId_Name, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DistrictPersistenceImpl.fetchByCityId_Name(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					District district = list.get(0);

					result = district;

					cacheResult(district);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByCityId_Name, finderArgs);

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
			return (District)result;
		}
	}

	/**
	 * Removes the district where cityId = &#63; and name = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the district that was removed
	 */
	@Override
	public District removeByCityId_Name(long cityId, String name)
		throws NoSuchDistrictException {

		District district = findByCityId_Name(cityId, name);

		return remove(district);
	}

	/**
	 * Returns the number of districts where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the number of matching districts
	 */
	@Override
	public int countByCityId_Name(long cityId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByCityId_Name;

		Object[] finderArgs = new Object[] {cityId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISTRICT_WHERE);

			query.append(_FINDER_COLUMN_CITYID_NAME_CITYID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_CITYID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CITYID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityId);

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

	private static final String _FINDER_COLUMN_CITYID_NAME_CITYID_2 =
		"district.cityId = ? AND ";

	private static final String _FINDER_COLUMN_CITYID_NAME_NAME_2 =
		"district.name = ?";

	private static final String _FINDER_COLUMN_CITYID_NAME_NAME_3 =
		"(district.name IS NULL OR district.name = '')";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the district where code = &#63; or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	@Override
	public District findByCode(String code) throws NoSuchDistrictException {
		District district = fetchByCode(code);

		if (district == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDistrictException(msg.toString());
		}

		return district;
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
	@Override
	public District fetchByCode(String code, boolean useFinderCache) {
		return fetchByCode(code);
	}

	/**
	 * Returns the district where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public District fetchByCode(String code) {
		code = Objects.toString(code, "");

		Object[] finderArgs = new Object[] {code};

		Object result = finderCache.getResult(
			_finderPathFetchByCode, finderArgs, this);

		if (result instanceof District) {
			District district = (District)result;

			if (!Objects.equals(code, district.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DISTRICT_WHERE);

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

				List<District> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCode, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DistrictPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					District district = list.get(0);

					result = district;

					cacheResult(district);
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
			return (District)result;
		}
	}

	/**
	 * Removes the district where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the district that was removed
	 */
	@Override
	public District removeByCode(String code) throws NoSuchDistrictException {
		District district = findByCode(code);

		return remove(district);
	}

	/**
	 * Returns the number of districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching districts
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISTRICT_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"district.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(district.code IS NULL OR district.code = '')";

	public DistrictPersistenceImpl() {
		setModelClass(District.class);

		setModelImplClass(DistrictImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	@Override
	public void cacheResult(District district) {
		entityCache.putResult(
			entityCacheEnabled, DistrictImpl.class, district.getPrimaryKey(),
			district);

		finderCache.putResult(
			_finderPathFetchByCityId_Name,
			new Object[] {district.getCityId(), district.getName()}, district);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {district.getCode()},
			district);

		district.resetOriginalValues();
	}

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	@Override
	public void cacheResult(List<District> districts) {
		for (District district : districts) {
			if (entityCache.getResult(
					entityCacheEnabled, DistrictImpl.class,
					district.getPrimaryKey()) == null) {

				cacheResult(district);
			}
			else {
				district.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all districts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DistrictImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the district.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(District district) {
		entityCache.removeResult(
			entityCacheEnabled, DistrictImpl.class, district.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DistrictModelImpl)district, true);
	}

	@Override
	public void clearCache(List<District> districts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (District district : districts) {
			entityCache.removeResult(
				entityCacheEnabled, DistrictImpl.class,
				district.getPrimaryKey());

			clearUniqueFindersCache((DistrictModelImpl)district, true);
		}
	}

	protected void cacheUniqueFindersCache(
		DistrictModelImpl districtModelImpl) {

		Object[] args = new Object[] {
			districtModelImpl.getCityId(), districtModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByCityId_Name, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCityId_Name, args, districtModelImpl, false);

		args = new Object[] {districtModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, districtModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DistrictModelImpl districtModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				districtModelImpl.getCityId(), districtModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByCityId_Name, args);
			finderCache.removeResult(_finderPathFetchByCityId_Name, args);
		}

		if ((districtModelImpl.getColumnBitmask() &
			 _finderPathFetchByCityId_Name.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				districtModelImpl.getOriginalCityId(),
				districtModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByCityId_Name, args);
			finderCache.removeResult(_finderPathFetchByCityId_Name, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {districtModelImpl.getCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}

		if ((districtModelImpl.getColumnBitmask() &
			 _finderPathFetchByCode.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {districtModelImpl.getOriginalCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	@Override
	public District create(long districtId) {
		District district = new DistrictImpl();

		district.setNew(true);
		district.setPrimaryKey(districtId);

		district.setCompanyId(CompanyThreadLocal.getCompanyId());

		return district;
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	@Override
	public District remove(long districtId) throws NoSuchDistrictException {
		return remove((Serializable)districtId);
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	@Override
	public District remove(Serializable primaryKey)
		throws NoSuchDistrictException {

		Session session = null;

		try {
			session = openSession();

			District district = (District)session.get(
				DistrictImpl.class, primaryKey);

			if (district == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDistrictException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(district);
		}
		catch (NoSuchDistrictException nsee) {
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
	protected District removeImpl(District district) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(district)) {
				district = (District)session.get(
					DistrictImpl.class, district.getPrimaryKeyObj());
			}

			if (district != null) {
				session.delete(district);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (district != null) {
			clearCache(district);
		}

		return district;
	}

	@Override
	public District updateImpl(District district) {
		boolean isNew = district.isNew();

		if (!(district instanceof DistrictModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(district.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(district);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in district proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom District implementation " +
					district.getClass());
		}

		DistrictModelImpl districtModelImpl = (DistrictModelImpl)district;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (district.getCreateDate() == null)) {
			if (serviceContext == null) {
				district.setCreateDate(now);
			}
			else {
				district.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!districtModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				district.setModifiedDate(now);
			}
			else {
				district.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (district.isNew()) {
				session.save(district);

				district.setNew(false);
			}
			else {
				district = (District)session.merge(district);
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
			Object[] args = new Object[] {districtModelImpl.isActive()};

			finderCache.removeResult(_finderPathCountByActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActive, args);

			args = new Object[] {
				districtModelImpl.getCityId(), districtModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByCityId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCityId_Active, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((districtModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActive.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					districtModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);

				args = new Object[] {districtModelImpl.isActive()};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);
			}

			if ((districtModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCityId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					districtModelImpl.getOriginalCityId(),
					districtModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByCityId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCityId_Active, args);

				args = new Object[] {
					districtModelImpl.getCityId(), districtModelImpl.isActive()
				};

				finderCache.removeResult(_finderPathCountByCityId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCityId_Active, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DistrictImpl.class, district.getPrimaryKey(),
			district, false);

		clearUniqueFindersCache(districtModelImpl, false);
		cacheUniqueFindersCache(districtModelImpl);

		district.resetOriginalValues();

		return district;
	}

	/**
	 * Returns the district with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	@Override
	public District findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDistrictException {

		District district = fetchByPrimaryKey(primaryKey);

		if (district == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDistrictException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return district;
	}

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	@Override
	public District findByPrimaryKey(long districtId)
		throws NoSuchDistrictException {

		return findByPrimaryKey((Serializable)districtId);
	}

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	@Override
	public District fetchByPrimaryKey(long districtId) {
		return fetchByPrimaryKey((Serializable)districtId);
	}

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	@Override
	public List<District> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<District> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator) {

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

		List<District> list = (List<District>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DISTRICT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISTRICT;

				if (pagination) {
					sql = sql.concat(DistrictModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<District>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<District>)QueryUtil.list(
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
	 * Removes all the districts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (District district : findAll()) {
			remove(district);
		}
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DISTRICT);

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
		return "districtId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DISTRICT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DistrictModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the district persistence.
	 */
	@Activate
	public void activate() {
		DistrictModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DistrictModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName()},
			DistrictModelImpl.ACTIVE_COLUMN_BITMASK |
			DistrictModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByCityId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCityId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			DistrictModelImpl.CITYID_COLUMN_BITMASK |
			DistrictModelImpl.ACTIVE_COLUMN_BITMASK |
			DistrictModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByCityId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathFetchByCityId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCityId_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			DistrictModelImpl.CITYID_COLUMN_BITMASK |
			DistrictModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByCityId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId_Name",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DistrictImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()},
			DistrictModelImpl.CODE_COLUMN_BITMASK);

		_finderPathCountByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DistrictImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.nss.commoncategory.model.District"),
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

	private static final String _SQL_SELECT_DISTRICT =
		"SELECT district FROM District district";

	private static final String _SQL_SELECT_DISTRICT_WHERE =
		"SELECT district FROM District district WHERE ";

	private static final String _SQL_COUNT_DISTRICT =
		"SELECT COUNT(district) FROM District district";

	private static final String _SQL_COUNT_DISTRICT_WHERE =
		"SELECT COUNT(district) FROM District district WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "district.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No District exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No District exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DistrictPersistenceImpl.class);

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