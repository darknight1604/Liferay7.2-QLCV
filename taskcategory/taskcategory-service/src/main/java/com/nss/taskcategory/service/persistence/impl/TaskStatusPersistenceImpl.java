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

package com.nss.taskcategory.service.persistence.impl;

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

import com.nss.taskcategory.exception.NoSuchTaskStatusException;
import com.nss.taskcategory.model.TaskStatus;
import com.nss.taskcategory.model.impl.TaskStatusImpl;
import com.nss.taskcategory.model.impl.TaskStatusModelImpl;
import com.nss.taskcategory.service.persistence.TaskStatusPersistence;
import com.nss.taskcategory.service.persistence.impl.constants.TASK_CATEGORYPersistenceConstants;

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
 * The persistence implementation for the task status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TaskStatusPersistence.class)
@ProviderType
public class TaskStatusPersistenceImpl
	extends BasePersistenceImpl<TaskStatus> implements TaskStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaskStatusUtil</code> to access the task status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaskStatusImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the task statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching task statuses
	 */
	@Override
	public List<TaskStatus> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of matching task statuses
	 */
	@Override
	public List<TaskStatus> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task statuses
	 */
	@Deprecated
	@Override
	public List<TaskStatus> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task statuses
	 */
	@Override
	public List<TaskStatus> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompanyId;
			finderArgs = new Object[] {companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<TaskStatus> list = (List<TaskStatus>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TaskStatus taskStatus : list) {
				if ((companyId != taskStatus.getCompanyId())) {
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

			query.append(_SQL_SELECT_TASKSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TaskStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskStatus>)QueryUtil.list(
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
	 * Returns the first task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByCompanyId_First(
			long companyId, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTaskStatusException(msg.toString());
	}

	/**
	 * Returns the first task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByCompanyId_First(
		long companyId, OrderByComparator<TaskStatus> orderByComparator) {

		List<TaskStatus> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByCompanyId_Last(
			long companyId, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTaskStatusException(msg.toString());
	}

	/**
	 * Returns the last task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByCompanyId_Last(
		long companyId, OrderByComparator<TaskStatus> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<TaskStatus> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where companyId = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus[] findByCompanyId_PrevAndNext(
			long taskStatusId, long companyId,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByPrimaryKey(taskStatusId);

		Session session = null;

		try {
			session = openSession();

			TaskStatus[] array = new TaskStatusImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, taskStatus, companyId, orderByComparator, true);

			array[1] = taskStatus;

			array[2] = getByCompanyId_PrevAndNext(
				session, taskStatus, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskStatus getByCompanyId_PrevAndNext(
		Session session, TaskStatus taskStatus, long companyId,
		OrderByComparator<TaskStatus> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TASKSTATUS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(TaskStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskStatus)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaskStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task statuses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (TaskStatus taskStatus :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"taskStatus.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId_Active;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId_Active;
	private FinderPath _finderPathCountByCompanyId_Active;

	/**
	 * Returns all the task statuses where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching task statuses
	 */
	@Override
	public List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active) {

		return findByCompanyId_Active(
			companyId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task statuses where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of matching task statuses
	 */
	@Override
	public List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active, int start, int end) {

		return findByCompanyId_Active(companyId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task statuses where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task statuses
	 */
	@Deprecated
	@Override
	public List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return findByCompanyId_Active(
			companyId, active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task statuses
	 */
	@Override
	public List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompanyId_Active;
			finderArgs = new Object[] {companyId, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompanyId_Active;
			finderArgs = new Object[] {
				companyId, active, start, end, orderByComparator
			};
		}

		List<TaskStatus> list = (List<TaskStatus>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TaskStatus taskStatus : list) {
				if ((companyId != taskStatus.getCompanyId()) ||
					(active != taskStatus.isActive())) {

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

			query.append(_SQL_SELECT_TASKSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_ACTIVE_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(active);

				if (!pagination) {
					list = (List<TaskStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskStatus>)QueryUtil.list(
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
	 * Returns the first task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByCompanyId_Active_First(
			companyId, active, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchTaskStatusException(msg.toString());
	}

	/**
	 * Returns the first task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<TaskStatus> orderByComparator) {

		List<TaskStatus> list = findByCompanyId_Active(
			companyId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByCompanyId_Active_Last(
			companyId, active, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchTaskStatusException(msg.toString());
	}

	/**
	 * Returns the last task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<TaskStatus> orderByComparator) {

		int count = countByCompanyId_Active(companyId, active);

		if (count == 0) {
			return null;
		}

		List<TaskStatus> list = findByCompanyId_Active(
			companyId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus[] findByCompanyId_Active_PrevAndNext(
			long taskStatusId, long companyId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByPrimaryKey(taskStatusId);

		Session session = null;

		try {
			session = openSession();

			TaskStatus[] array = new TaskStatusImpl[3];

			array[0] = getByCompanyId_Active_PrevAndNext(
				session, taskStatus, companyId, active, orderByComparator,
				true);

			array[1] = taskStatus;

			array[2] = getByCompanyId_Active_PrevAndNext(
				session, taskStatus, companyId, active, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskStatus getByCompanyId_Active_PrevAndNext(
		Session session, TaskStatus taskStatus, long companyId, boolean active,
		OrderByComparator<TaskStatus> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TASKSTATUS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_ACTIVE_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYID_ACTIVE_ACTIVE_2);

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
			query.append(TaskStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskStatus)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaskStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task statuses where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	@Override
	public void removeByCompanyId_Active(long companyId, boolean active) {
		for (TaskStatus taskStatus :
				findByCompanyId_Active(
					companyId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByCompanyId_Active(long companyId, boolean active) {
		FinderPath finderPath = _finderPathCountByCompanyId_Active;

		Object[] finderArgs = new Object[] {companyId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TASKSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_ACTIVE_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYID_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_ACTIVE_COMPANYID_2 =
		"taskStatus.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYID_ACTIVE_ACTIVE_2 =
		"taskStatus.active = ?";

	private FinderPath _finderPathWithPaginationFindByActive;
	private FinderPath _finderPathWithoutPaginationFindByActive;
	private FinderPath _finderPathCountByActive;

	/**
	 * Returns all the task statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching task statuses
	 */
	@Override
	public List<TaskStatus> findByActive(boolean active) {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task statuses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of matching task statuses
	 */
	@Override
	public List<TaskStatus> findByActive(boolean active, int start, int end) {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task statuses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task statuses
	 */
	@Deprecated
	@Override
	public List<TaskStatus> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return findByActive(active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task statuses
	 */
	@Override
	public List<TaskStatus> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

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

		List<TaskStatus> list = (List<TaskStatus>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TaskStatus taskStatus : list) {
				if ((active != taskStatus.isActive())) {
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

			query.append(_SQL_SELECT_TASKSTATUS_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<TaskStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskStatus>)QueryUtil.list(
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
	 * Returns the first task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByActive_First(
			boolean active, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByActive_First(active, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchTaskStatusException(msg.toString());
	}

	/**
	 * Returns the first task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByActive_First(
		boolean active, OrderByComparator<TaskStatus> orderByComparator) {

		List<TaskStatus> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByActive_Last(
			boolean active, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByActive_Last(active, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchTaskStatusException(msg.toString());
	}

	/**
	 * Returns the last task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByActive_Last(
		boolean active, OrderByComparator<TaskStatus> orderByComparator) {

		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<TaskStatus> list = findByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where active = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus[] findByActive_PrevAndNext(
			long taskStatusId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByPrimaryKey(taskStatusId);

		Session session = null;

		try {
			session = openSession();

			TaskStatus[] array = new TaskStatusImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, taskStatus, active, orderByComparator, true);

			array[1] = taskStatus;

			array[2] = getByActive_PrevAndNext(
				session, taskStatus, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskStatus getByActive_PrevAndNext(
		Session session, TaskStatus taskStatus, boolean active,
		OrderByComparator<TaskStatus> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TASKSTATUS_WHERE);

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
			query.append(TaskStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskStatus)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaskStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task statuses where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByActive(boolean active) {
		for (TaskStatus taskStatus :
				findByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByActive(boolean active) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKSTATUS_WHERE);

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
		"taskStatus.active = ?";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the task status where code = &#63; or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByCode(String code) throws NoSuchTaskStatusException {
		TaskStatus taskStatus = fetchByCode(code);

		if (taskStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTaskStatusException(msg.toString());
		}

		return taskStatus;
	}

	/**
	 * Returns the task status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Deprecated
	@Override
	public TaskStatus fetchByCode(String code, boolean useFinderCache) {
		return fetchByCode(code);
	}

	/**
	 * Returns the task status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByCode(String code) {
		code = Objects.toString(code, "");

		Object[] finderArgs = new Object[] {code};

		Object result = finderCache.getResult(
			_finderPathFetchByCode, finderArgs, this);

		if (result instanceof TaskStatus) {
			TaskStatus taskStatus = (TaskStatus)result;

			if (!Objects.equals(code, taskStatus.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TASKSTATUS_WHERE);

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

				List<TaskStatus> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCode, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TaskStatusPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TaskStatus taskStatus = list.get(0);

					result = taskStatus;

					cacheResult(taskStatus);
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
			return (TaskStatus)result;
		}
	}

	/**
	 * Removes the task status where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the task status that was removed
	 */
	@Override
	public TaskStatus removeByCode(String code)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByCode(code);

		return remove(taskStatus);
	}

	/**
	 * Returns the number of task statuses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKSTATUS_WHERE);

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
		"taskStatus.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(taskStatus.code IS NULL OR taskStatus.code = '')";

	public TaskStatusPersistenceImpl() {
		setModelClass(TaskStatus.class);

		setModelImplClass(TaskStatusImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the task status in the entity cache if it is enabled.
	 *
	 * @param taskStatus the task status
	 */
	@Override
	public void cacheResult(TaskStatus taskStatus) {
		entityCache.putResult(
			entityCacheEnabled, TaskStatusImpl.class,
			taskStatus.getPrimaryKey(), taskStatus);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {taskStatus.getCode()},
			taskStatus);

		taskStatus.resetOriginalValues();
	}

	/**
	 * Caches the task statuses in the entity cache if it is enabled.
	 *
	 * @param taskStatuses the task statuses
	 */
	@Override
	public void cacheResult(List<TaskStatus> taskStatuses) {
		for (TaskStatus taskStatus : taskStatuses) {
			if (entityCache.getResult(
					entityCacheEnabled, TaskStatusImpl.class,
					taskStatus.getPrimaryKey()) == null) {

				cacheResult(taskStatus);
			}
			else {
				taskStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskStatusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskStatus taskStatus) {
		entityCache.removeResult(
			entityCacheEnabled, TaskStatusImpl.class,
			taskStatus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TaskStatusModelImpl)taskStatus, true);
	}

	@Override
	public void clearCache(List<TaskStatus> taskStatuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskStatus taskStatus : taskStatuses) {
			entityCache.removeResult(
				entityCacheEnabled, TaskStatusImpl.class,
				taskStatus.getPrimaryKey());

			clearUniqueFindersCache((TaskStatusModelImpl)taskStatus, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TaskStatusModelImpl taskStatusModelImpl) {

		Object[] args = new Object[] {taskStatusModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, taskStatusModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TaskStatusModelImpl taskStatusModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {taskStatusModelImpl.getCode()};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}

		if ((taskStatusModelImpl.getColumnBitmask() &
			 _finderPathFetchByCode.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				taskStatusModelImpl.getOriginalCode()
			};

			finderCache.removeResult(_finderPathCountByCode, args);
			finderCache.removeResult(_finderPathFetchByCode, args);
		}
	}

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	@Override
	public TaskStatus create(long taskStatusId) {
		TaskStatus taskStatus = new TaskStatusImpl();

		taskStatus.setNew(true);
		taskStatus.setPrimaryKey(taskStatusId);

		taskStatus.setCompanyId(CompanyThreadLocal.getCompanyId());

		return taskStatus;
	}

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus remove(long taskStatusId)
		throws NoSuchTaskStatusException {

		return remove((Serializable)taskStatusId);
	}

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus remove(Serializable primaryKey)
		throws NoSuchTaskStatusException {

		Session session = null;

		try {
			session = openSession();

			TaskStatus taskStatus = (TaskStatus)session.get(
				TaskStatusImpl.class, primaryKey);

			if (taskStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taskStatus);
		}
		catch (NoSuchTaskStatusException nsee) {
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
	protected TaskStatus removeImpl(TaskStatus taskStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskStatus)) {
				taskStatus = (TaskStatus)session.get(
					TaskStatusImpl.class, taskStatus.getPrimaryKeyObj());
			}

			if (taskStatus != null) {
				session.delete(taskStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskStatus != null) {
			clearCache(taskStatus);
		}

		return taskStatus;
	}

	@Override
	public TaskStatus updateImpl(TaskStatus taskStatus) {
		boolean isNew = taskStatus.isNew();

		if (!(taskStatus instanceof TaskStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taskStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(taskStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taskStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaskStatus implementation " +
					taskStatus.getClass());
		}

		TaskStatusModelImpl taskStatusModelImpl =
			(TaskStatusModelImpl)taskStatus;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (taskStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				taskStatus.setCreateDate(now);
			}
			else {
				taskStatus.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!taskStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taskStatus.setModifiedDate(now);
			}
			else {
				taskStatus.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (taskStatus.isNew()) {
				session.save(taskStatus);

				taskStatus.setNew(false);
			}
			else {
				taskStatus = (TaskStatus)session.merge(taskStatus);
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
			Object[] args = new Object[] {taskStatusModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompanyId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyId, args);

			args = new Object[] {
				taskStatusModelImpl.getCompanyId(),
				taskStatusModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByCompanyId_Active, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyId_Active, args);

			args = new Object[] {taskStatusModelImpl.isActive()};

			finderCache.removeResult(_finderPathCountByActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActive, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((taskStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taskStatusModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);

				args = new Object[] {taskStatusModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);
			}

			if ((taskStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyId_Active.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taskStatusModelImpl.getOriginalCompanyId(),
					taskStatusModelImpl.getOriginalActive()
				};

				finderCache.removeResult(
					_finderPathCountByCompanyId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId_Active, args);

				args = new Object[] {
					taskStatusModelImpl.getCompanyId(),
					taskStatusModelImpl.isActive()
				};

				finderCache.removeResult(
					_finderPathCountByCompanyId_Active, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId_Active, args);
			}

			if ((taskStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActive.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					taskStatusModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);

				args = new Object[] {taskStatusModelImpl.isActive()};

				finderCache.removeResult(_finderPathCountByActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActive, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TaskStatusImpl.class,
			taskStatus.getPrimaryKey(), taskStatus, false);

		clearUniqueFindersCache(taskStatusModelImpl, false);
		cacheUniqueFindersCache(taskStatusModelImpl);

		taskStatus.resetOriginalValues();

		return taskStatus;
	}

	/**
	 * Returns the task status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByPrimaryKey(primaryKey);

		if (taskStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taskStatus;
	}

	/**
	 * Returns the task status with the primary key or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus findByPrimaryKey(long taskStatusId)
		throws NoSuchTaskStatusException {

		return findByPrimaryKey((Serializable)taskStatusId);
	}

	/**
	 * Returns the task status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status, or <code>null</code> if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus fetchByPrimaryKey(long taskStatusId) {
		return fetchByPrimaryKey((Serializable)taskStatusId);
	}

	/**
	 * Returns all the task statuses.
	 *
	 * @return the task statuses
	 */
	@Override
	public List<TaskStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of task statuses
	 */
	@Override
	public List<TaskStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task statuses
	 */
	@Deprecated
	@Override
	public List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task statuses
	 */
	@Override
	public List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator) {

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

		List<TaskStatus> list = (List<TaskStatus>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TASKSTATUS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKSTATUS;

				if (pagination) {
					sql = sql.concat(TaskStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskStatus>)QueryUtil.list(
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
	 * Removes all the task statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskStatus taskStatus : findAll()) {
			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKSTATUS);

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
		return "taskStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASKSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task status persistence.
	 */
	@Activate
	public void activate() {
		TaskStatusModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TaskStatusModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()},
			TaskStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			TaskStatusModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompanyId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId_Active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			TaskStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			TaskStatusModelImpl.ACTIVE_COLUMN_BITMASK |
			TaskStatusModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByCompanyId_Active = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyId_Active",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName()},
			TaskStatusModelImpl.ACTIVE_COLUMN_BITMASK |
			TaskStatusModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName()});

		_finderPathFetchByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()},
			TaskStatusModelImpl.CODE_COLUMN_BITMASK);

		_finderPathCountByCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TaskStatusImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = TASK_CATEGORYPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.nss.taskcategory.model.TaskStatus"),
			true);
	}

	@Override
	@Reference(
		target = TASK_CATEGORYPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TASK_CATEGORYPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_TASKSTATUS =
		"SELECT taskStatus FROM TaskStatus taskStatus";

	private static final String _SQL_SELECT_TASKSTATUS_WHERE =
		"SELECT taskStatus FROM TaskStatus taskStatus WHERE ";

	private static final String _SQL_COUNT_TASKSTATUS =
		"SELECT COUNT(taskStatus) FROM TaskStatus taskStatus";

	private static final String _SQL_COUNT_TASKSTATUS_WHERE =
		"SELECT COUNT(taskStatus) FROM TaskStatus taskStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taskStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaskStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaskStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaskStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

	static {
		try {
			Class.forName(TASK_CATEGORYPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}