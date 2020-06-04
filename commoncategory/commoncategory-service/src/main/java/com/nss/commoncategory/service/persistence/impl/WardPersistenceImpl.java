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

import com.nss.commoncategory.exception.NoSuchWardException;
import com.nss.commoncategory.model.Ward;
import com.nss.commoncategory.model.impl.WardImpl;
import com.nss.commoncategory.model.impl.WardModelImpl;
import com.nss.commoncategory.service.persistence.WardPersistence;
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
 * The persistence implementation for the ward service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WardPersistence.class)
@ProviderType
public class WardPersistenceImpl
	extends BasePersistenceImpl<Ward> implements WardPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WardUtil</code> to access the ward persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WardImpl.class.getName();

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
	 * Returns all the wards where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching wards
	 */
	@Override
	public List<Ward> findByActive(boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ward> findByActive(boolean active, int start, int end) {
		return findByActive(active, start, end, null);
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
	@Override
	public List<Ward> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator, boolean useFinderCache) {

		return findByActive(active, start, end, orderByComparator);
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
	@Override
	public List<Ward> findByActive(
		boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator) {

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

		List<Ward> list = (List<Ward>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ward ward : list) {
				if ((active != ward.isActive())) {
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

			query.append(_SQL_SELECT_WARD_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(WardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Ward>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Ward>)QueryUtil.list(
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
	 * Returns the first ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	@Override
	public Ward findByActive_First(
			boolean active, OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException {

		Ward ward = fetchByActive_First(active, orderByComparator);

		if (ward != null) {
			return ward;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchWardException(msg.toString());
	}

	/**
	 * Returns the first ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Override
	public Ward fetchByActive_First(
		boolean active, OrderByComparator<Ward> orderByComparator) {

		List<Ward> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	@Override
	public Ward findByActive_Last(
			boolean active, OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException {

		Ward ward = fetchByActive_Last(active, orderByComparator);

		if (ward != null) {
			return ward;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchWardException(msg.toString());
	}

	/**
	 * Returns the last ward in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Override
	public Ward fetchByActive_Last(
		boolean active, OrderByComparator<Ward> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<Ward> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ward[] findByActive_PrevAndNext(
			long wardId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException {

		Ward ward = findByPrimaryKey(wardId);

		Session session = null;

		try {
			session = openSession();

			Ward[] array = new WardImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, ward, active, orderByComparator, true);

			array[1] = ward;

			array[2] = getByActive_PrevAndNext(
				session, ward, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ward getByActive_PrevAndNext(
		Session session, Ward ward, boolean active,
		OrderByComparator<Ward> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WARD_WHERE);

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
			query.append(WardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ward)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Ward> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wards where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(boolean active) {
		for (Ward ward :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ward);
		}
	}

	/**
	 * Returns the number of wards where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching wards
	 */
	@Override
	public int countByActive(boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARD_WHERE);

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
		"ward.active = ?";

	private FinderPath _finderPathWithPaginationFindByDistrictId_Active;
	private FinderPath _finderPathWithoutPaginationFindByDistrictId_Active;
	private FinderPath _finderPathCountByDistrictId_Active;

	/**
	 * Returns all the wards where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the matching wards
	 */
	@Override
	public List<Ward> findByDistrictId_Active(long districtId, boolean active) {
		return findByDistrictId_Active(
			districtId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end) {

		return findByDistrictId_Active(districtId, active, start, end, null);
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
	@Override
	public List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator, boolean useFinderCache) {

		return findByDistrictId_Active(
			districtId, active, start, end, orderByComparator);
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
	@Override
	public List<Ward> findByDistrictId_Active(
		long districtId, boolean active, int start, int end,
		OrderByComparator<Ward> orderByComparator) {

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

		List<Ward> list = (List<Ward>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ward ward : list) {
				if ((districtId != ward.getDistrictId()) ||
					(active != ward.isActive())) {

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

			query.append(_SQL_SELECT_WARD_WHERE);

			query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_DISTRICTID_2);

			query.append(_FINDER_COLUMN_DISTRICTID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(WardModelImpl.ORDER_BY_JPQL);
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
					list = (List<Ward>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Ward>)QueryUtil.list(
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
	 * Returns the first ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	@Override
	public Ward findByDistrictId_Active_First(
			long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException {

		Ward ward = fetchByDistrictId_Active_First(
			districtId, active, orderByComparator);

		if (ward != null) {
			return ward;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("districtId=");
		msg.append(districtId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchWardException(msg.toString());
	}

	/**
	 * Returns the first ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Override
	public Ward fetchByDistrictId_Active_First(
		long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator) {

		List<Ward> list = findByDistrictId_Active(
			districtId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ward findByDistrictId_Active_Last(
			long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException {

		Ward ward = fetchByDistrictId_Active_Last(
			districtId, active, orderByComparator);

		if (ward != null) {
			return ward;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("districtId=");
		msg.append(districtId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchWardException(msg.toString());
	}

	/**
	 * Returns the last ward in the ordered set where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Override
	public Ward fetchByDistrictId_Active_Last(
		long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator) {

		int count = countByDistrictId_Active(districtId, active);

		if (count == 0) {
			return null;
		}

		List<Ward> list = findByDistrictId_Active(
			districtId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ward[] findByDistrictId_Active_PrevAndNext(
			long wardId, long districtId, boolean active,
			OrderByComparator<Ward> orderByComparator)
		throws NoSuchWardException {

		Ward ward = findByPrimaryKey(wardId);

		Session session = null;

		try {
			session = openSession();

			Ward[] array = new WardImpl[3];

			array[0] = getByDistrictId_Active_PrevAndNext(
				session, ward, districtId, active, orderByComparator, true);

			array[1] = ward;

			array[2] = getByDistrictId_Active_PrevAndNext(
				session, ward, districtId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ward getByDistrictId_Active_PrevAndNext(
		Session session, Ward ward, long districtId, boolean active,
		OrderByComparator<Ward> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WARD_WHERE);

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
			query.append(WardModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ward)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Ward> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wards where districtId = &#63; and active = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 */
	@Override
	public void removeByDistrictId_Active(long districtId, boolean active) {
		for (Ward ward :
				findByDistrictId_Active(
					districtId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ward);
		}
	}

	/**
	 * Returns the number of wards where districtId = &#63; and active = &#63;.
	 *
	 * @param districtId the district ID
	 * @param active the active
	 * @return the number of matching wards
	 */
	@Override
	public int countByDistrictId_Active(long districtId, boolean active) {
		FinderPath finderPath = _finderPathCountByDistrictId_Active;

		Object[] finderArgs = new Object[] {districtId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WARD_WHERE);

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
		"ward.districtId = ? AND ";

	private static final String _FINDER_COLUMN_DISTRICTID_ACTIVE_ACTIVE_2 =
		"ward.active = ?";

	private FinderPath _finderPathFetchByDistrictId_Name;
	private FinderPath _finderPathCountByDistrictId_Name;

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	@Override
	public Ward findByDistrictId_Name(long districtId, String name)
		throws NoSuchWardException {

		Ward ward = fetchByDistrictId_Name(districtId, name);

		if (ward == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("districtId=");
			msg.append(districtId);

			msg.append(", name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWardException(msg.toString());
		}

		return ward;
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
	@Override
	public Ward fetchByDistrictId_Name(
		long districtId, String name, boolean useFinderCache) {

		return fetchByDistrictId_Name(districtId, name);
	}

	/**
	 * Returns the ward where districtId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Override
	public Ward fetchByDistrictId_Name(long districtId, String name) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {districtId, name};

		Object result = finderCache.getResult(
			_finderPathFetchByDistrictId_Name, finderArgs, this);

		if (result instanceof Ward) {
			Ward ward = (Ward)result;

			if ((districtId != ward.getDistrictId()) ||
				!Objects.equals(name, ward.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WARD_WHERE);

			query.append(_FINDER_COLUMN_DISTRICTID_NAME_DISTRICTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_DISTRICTID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_DISTRICTID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(districtId);

				if (bindName) {
					qPos.add(name);
				}

				List<Ward> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByDistrictId_Name, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WardPersistenceImpl.fetchByDistrictId_Name(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Ward ward = list.get(0);

					result = ward;

					cacheResult(ward);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByDistrictId_Name, finderArgs);

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
			return (Ward)result;
		}
	}

	/**
	 * Removes the ward where districtId = &#63; and name = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the ward that was removed
	 */
	@Override
	public Ward removeByDistrictId_Name(long districtId, String name)
		throws NoSuchWardException {

		Ward ward = findByDistrictId_Name(districtId, name);

		return remove(ward);
	}

	/**
	 * Returns the number of wards where districtId = &#63; and name = &#63;.
	 *
	 * @param districtId the district ID
	 * @param name the name
	 * @return the number of matching wards
	 */
	@Override
	public int countByDistrictId_Name(long districtId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByDistrictId_Name;

		Object[] finderArgs = new Object[] {districtId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WARD_WHERE);

			query.append(_FINDER_COLUMN_DISTRICTID_NAME_DISTRICTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_DISTRICTID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_DISTRICTID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(districtId);

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

	private static final String _FINDER_COLUMN_DISTRICTID_NAME_DISTRICTID_2 =
		"ward.districtId = ? AND ";

	private static final String _FINDER_COLUMN_DISTRICTID_NAME_NAME_2 =
		"ward.name = ?";

	private static final String _FINDER_COLUMN_DISTRICTID_NAME_NAME_3 =
		"(ward.name IS NULL OR ward.name = '')";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the ward where code = &#63; or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching ward
	 * @throws NoSuchWardException if a matching ward could not be found
	 */
	@Override
	public Ward findByCode(String code) throws NoSuchWardException {
		Ward ward = fetchByCode(code);

		if (ward == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWardException(msg.toString());
		}

		return ward;
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
	@Override
	public Ward fetchByCode(String code, boolean useFinderCache) {
		return fetchByCode(code);
	}

	/**
	 * Returns the ward where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ward, or <code>null</code> if a matching ward could not be found
	 */
	@Override
	public Ward fetchByCode(String code) {
		code = Objects.toString(code, "");

		Object[] finderArgs = new Object[] {code};

		Object result = finderCache.getResult(
			_finderPathFetchByCode, finderArgs, this);

		if (result instanceof Ward) {
			Ward ward = (Ward)result;

			if (!Objects.equals(code, ward.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WARD_WHERE);

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

				List<Ward> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCode, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WardPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Ward ward = list.get(0);

					result = ward;

					cacheResult(ward);
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
			return (Ward)result;
		}
	}

	/**
	 * Removes the ward where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the ward that was removed
	 */
	@Override
	public Ward removeByCode(String code) throws NoSuchWardException {
		Ward ward = findByCode(code);

		return remove(ward);
	}

	/**
	 * Returns the number of wards where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching wards
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARD_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_2 = "ward.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(ward.code IS NULL OR ward.code = '')";

	public WardPersistenceImpl() {
		setModelClass(Ward.class);

		setModelImplClass(WardImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ward in the entity cache if it is enabled.
	 *
	 * @param ward the ward
	 */
	@Override
	public void cacheResult(Ward ward) {
		entityCache.putResult(
			entityCacheEnabled, WardImpl.class, ward.getPrimaryKey(), ward);

		finderCache.putResult(
			_finderPathFetchByDistrictId_Name,
			new Object[] {ward.getDistrictId(), ward.getName()}, ward);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {ward.getCode()}, ward);

		ward.resetOriginalValues();
	}

	/**
	 * Caches the wards in the entity cache if it is enabled.
	 *
	 * @param wards the wards
	 */
	@Override
	public void cacheResult(List<Ward> wards) {
		for (Ward ward : wards) {
			if (entityCache.getResult(
					entityCacheEnabled, WardImpl.class, ward.getPrimaryKey()) ==
						null) {

				cacheResult(ward);
			}
			else {
				ward.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wards.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WardImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ward.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ward ward) {
		entityCache.removeResult(
			entityCacheEnabled, WardImpl.class, ward.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WardModelImpl)ward, true);
	}

	@Override
	public void clearCache(List<Ward> wards) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ward ward : wards) {
			entityCache.removeResult(
				entityCacheEnabled, WardImpl.class, ward.getPrimaryKey());

			clearUniqueFindersCache((WardModelImpl)ward, true);
		}
	}

	protected void cacheUniqueFindersCache(WardModelImpl wardModelImpl) {
		Object[] args = new Object[] {
			wardModelImpl.getDistrictId(), wardModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByDistrictId_Name, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDistrictId_Name, args, wardModelImpl, false);

		args = new Object[] {wardModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, wardModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WardModelImpl wardModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				wardModelImpl.getDistrictId(), wardModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByDistrictId_Name, args);
			finderCache.removeResult(_finderPathFetchByDistrictId_Name, args);
		}

		if ((wardModelImpl.getColumnBitmask() &
			 _finderPathFetchByDistrictId_Name.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				wardModelImpl.getOriginalDistrictId(),
				wardModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByDistrictId_Name, args);
			finderCache.removeResult(_finderPathFetchByDistrictId_Name, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {wardModelImpl.getCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}

		if ((wardModelImpl.getColumnBitmask() &
			 _finderPathFetchByCode.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {wardModelImpl.getOriginalCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}
	}

	/**
	 * Creates a new ward with the primary key. Does not add the ward to the database.
	 *
	 * @param wardId the primary key for the new ward
	 * @return the new ward
	 */
	@Override
	public Ward create(long wardId) {
		Ward ward = new WardImpl();

		ward.setNew(true);
		ward.setPrimaryKey(wardId);

		ward.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ward;
	}

	/**
	 * Removes the ward with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward that was removed
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	@Override
	public Ward remove(long wardId) throws NoSuchWardException {
		return remove((Serializable)wardId);
	}

	/**
	 * Removes the ward with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ward
	 * @return the ward that was removed
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	@Override
	public Ward remove(Serializable primaryKey) throws NoSuchWardException {
		Session session = null;

		try {
			session = openSession();

			Ward ward = (Ward)session.get(WardImpl.class, primaryKey);

			if (ward == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWardException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ward);
		}
		catch (NoSuchWardException nsee) {
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
	protected Ward removeImpl(Ward ward) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ward)) {
				ward = (Ward)session.get(
					WardImpl.class, ward.getPrimaryKeyObj());
			}

			if (ward != null) {
				session.delete(ward);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ward != null) {
			clearCache(ward);
		}

		return ward;
	}

	@Override
	public Ward updateImpl(Ward ward) {
		boolean isNew = ward.isNew();

		if (!(ward instanceof WardModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ward.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ward);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ward proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ward implementation " +
					ward.getClass());
		}

		WardModelImpl wardModelImpl = (WardModelImpl)ward;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ward.getCreateDate() == null)) {
			if (serviceContext == null) {
				ward.setCreateDate(now);
			}
			else {
				ward.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wardModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ward.setModifiedDate(now);
			}
			else {
				ward.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ward.isNew()) {
				session.save(ward);

				ward.setNew(false);
			}
			else {
				ward = (Ward)session.merge(ward);
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
			Object[] args = new Object[] {wardModelImpl.isActive()};

			finderCache.removeResult(_finderPathCountByActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActive, args);

			args = new Object[] {
				wardModelImpl.getDistrictId(), wardModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByDistrictId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDistrictId_Active, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((wardModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActive.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					wardModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);

				args = new Object[] {wardModelImpl.isActive()};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);
			}

			if ((wardModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDistrictId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					wardModelImpl.getOriginalDistrictId(),
					wardModelImpl.getOriginalActive()
				};

				finderCache.removeResult(
					_finderPathCountByDistrictId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDistrictId_Active, args);

				args = new Object[] {
					wardModelImpl.getDistrictId(), wardModelImpl.isActive()
				};

				finderCache.removeResult(
					_finderPathCountByDistrictId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDistrictId_Active, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, WardImpl.class, ward.getPrimaryKey(), ward,
			false);

		clearUniqueFindersCache(wardModelImpl, false);
		cacheUniqueFindersCache(wardModelImpl);

		ward.resetOriginalValues();

		return ward;
	}

	/**
	 * Returns the ward with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ward
	 * @return the ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	@Override
	public Ward findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWardException {

		Ward ward = fetchByPrimaryKey(primaryKey);

		if (ward == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWardException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ward;
	}

	/**
	 * Returns the ward with the primary key or throws a <code>NoSuchWardException</code> if it could not be found.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward
	 * @throws NoSuchWardException if a ward with the primary key could not be found
	 */
	@Override
	public Ward findByPrimaryKey(long wardId) throws NoSuchWardException {
		return findByPrimaryKey((Serializable)wardId);
	}

	/**
	 * Returns the ward with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward, or <code>null</code> if a ward with the primary key could not be found
	 */
	@Override
	public Ward fetchByPrimaryKey(long wardId) {
		return fetchByPrimaryKey((Serializable)wardId);
	}

	/**
	 * Returns all the wards.
	 *
	 * @return the wards
	 */
	@Override
	public List<Ward> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ward> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Ward> findAll(
		int start, int end, OrderByComparator<Ward> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Ward> findAll(
		int start, int end, OrderByComparator<Ward> orderByComparator) {

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

		List<Ward> list = (List<Ward>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WARD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WARD;

				if (pagination) {
					sql = sql.concat(WardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Ward>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Ward>)QueryUtil.list(
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
	 * Removes all the wards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ward ward : findAll()) {
			remove(ward);
		}
	}

	/**
	 * Returns the number of wards.
	 *
	 * @return the number of wards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WARD);

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
		return "wardId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WARD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ward persistence.
	 */
	@Activate
	public void activate() {
		WardModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		WardModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName()},
			WardModelImpl.ACTIVE_COLUMN_BITMASK |
			WardModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByDistrictId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistrictId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDistrictId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDistrictId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			WardModelImpl.DISTRICTID_COLUMN_BITMASK |
			WardModelImpl.ACTIVE_COLUMN_BITMASK |
			WardModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByDistrictId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDistrictId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathFetchByDistrictId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDistrictId_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			WardModelImpl.DISTRICTID_COLUMN_BITMASK |
			WardModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByDistrictId_Name = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDistrictId_Name",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, WardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()},
			WardModelImpl.CODE_COLUMN_BITMASK);

		_finderPathCountByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(WardImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.nss.commoncategory.model.Ward"),
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

	private static final String _SQL_SELECT_WARD = "SELECT ward FROM Ward ward";

	private static final String _SQL_SELECT_WARD_WHERE =
		"SELECT ward FROM Ward ward WHERE ";

	private static final String _SQL_COUNT_WARD =
		"SELECT COUNT(ward) FROM Ward ward";

	private static final String _SQL_COUNT_WARD_WHERE =
		"SELECT COUNT(ward) FROM Ward ward WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ward.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ward exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ward exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WardPersistenceImpl.class);

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