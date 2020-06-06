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

package com.nss.taskcategory.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.model.TaskType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the task type service. This utility wraps <code>com.nss.taskcategory.service.persistence.impl.TaskTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypePersistence
 * @generated
 */
@ProviderType
public class TaskTypeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TaskType taskType) {
		getPersistence().clearCache(taskType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TaskType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaskType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskType update(TaskType taskType) {
		return getPersistence().update(taskType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskType update(
		TaskType taskType, ServiceContext serviceContext) {

		return getPersistence().update(taskType, serviceContext);
	}

	/**
	 * Returns all the task types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching task types
	 */
	public static List<TaskType> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the task types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @return the range of matching task types
	 */
	public static List<TaskType> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the task types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task types
	 */
	@Deprecated
	public static List<TaskType> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the task types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task types
	 */
	public static List<TaskType> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByCompanyId_First(
			long companyId, OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByCompanyId_First(
		long companyId, OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByCompanyId_Last(
			long companyId, OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByCompanyId_Last(
		long companyId, OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the task types before and after the current task type in the ordered set where companyId = &#63;.
	 *
	 * @param taskTypeId the primary key of the current task type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public static TaskType[] findByCompanyId_PrevAndNext(
			long taskTypeId, long companyId,
			OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCompanyId_PrevAndNext(
			taskTypeId, companyId, orderByComparator);
	}

	/**
	 * Removes all the task types where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of task types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching task types
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the task types where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching task types
	 */
	public static List<TaskType> findByCompanyId_Active(
		long companyId, boolean active) {

		return getPersistence().findByCompanyId_Active(companyId, active);
	}

	/**
	 * Returns a range of all the task types where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @return the range of matching task types
	 */
	public static List<TaskType> findByCompanyId_Active(
		long companyId, boolean active, int start, int end) {

		return getPersistence().findByCompanyId_Active(
			companyId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the task types where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task types
	 */
	@Deprecated
	public static List<TaskType> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId_Active(
			companyId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the task types where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task types
	 */
	public static List<TaskType> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().findByCompanyId_Active(
			companyId, active, start, end, orderByComparator);
	}

	/**
	 * Returns the first task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCompanyId_Active_First(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the first task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().fetchByCompanyId_Active_First(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the last task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCompanyId_Active_Last(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the last task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().fetchByCompanyId_Active_Last(
			companyId, active, orderByComparator);
	}

	/**
	 * Returns the task types before and after the current task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param taskTypeId the primary key of the current task type
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public static TaskType[] findByCompanyId_Active_PrevAndNext(
			long taskTypeId, long companyId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCompanyId_Active_PrevAndNext(
			taskTypeId, companyId, active, orderByComparator);
	}

	/**
	 * Removes all the task types where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	public static void removeByCompanyId_Active(
		long companyId, boolean active) {

		getPersistence().removeByCompanyId_Active(companyId, active);
	}

	/**
	 * Returns the number of task types where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching task types
	 */
	public static int countByCompanyId_Active(long companyId, boolean active) {
		return getPersistence().countByCompanyId_Active(companyId, active);
	}

	/**
	 * Returns all the task types where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching task types
	 */
	public static List<TaskType> findByActive(boolean active) {
		return getPersistence().findByActive(active);
	}

	/**
	 * Returns a range of all the task types where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @return the range of matching task types
	 */
	public static List<TaskType> findByActive(
		boolean active, int start, int end) {

		return getPersistence().findByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the task types where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task types
	 */
	@Deprecated
	public static List<TaskType> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the task types where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task types
	 */
	public static List<TaskType> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().findByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns the first task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByActive_First(
			boolean active, OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the first task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByActive_First(
		boolean active, OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	 * Returns the last task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByActive_Last(
			boolean active, OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByActive_Last(
		boolean active, OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	 * Returns the task types before and after the current task type in the ordered set where active = &#63;.
	 *
	 * @param taskTypeId the primary key of the current task type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public static TaskType[] findByActive_PrevAndNext(
			long taskTypeId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByActive_PrevAndNext(
			taskTypeId, active, orderByComparator);
	}

	/**
	 * Removes all the task types where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByActive(boolean active) {
		getPersistence().removeByActive(active);
	}

	/**
	 * Returns the number of task types where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching task types
	 */
	public static int countByActive(boolean active) {
		return getPersistence().countByActive(active);
	}

	/**
	 * Returns the task type where code = &#63; or throws a <code>NoSuchTaskTypeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public static TaskType findByCode(String code)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the task type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task type, or <code>null</code> if a matching task type could not be found
	 */
	@Deprecated
	public static TaskType fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Returns the task type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public static TaskType fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Removes the task type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the task type that was removed
	 */
	public static TaskType removeByCode(String code)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of task types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching task types
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the task type in the entity cache if it is enabled.
	 *
	 * @param taskType the task type
	 */
	public static void cacheResult(TaskType taskType) {
		getPersistence().cacheResult(taskType);
	}

	/**
	 * Caches the task types in the entity cache if it is enabled.
	 *
	 * @param taskTypes the task types
	 */
	public static void cacheResult(List<TaskType> taskTypes) {
		getPersistence().cacheResult(taskTypes);
	}

	/**
	 * Creates a new task type with the primary key. Does not add the task type to the database.
	 *
	 * @param taskTypeId the primary key for the new task type
	 * @return the new task type
	 */
	public static TaskType create(long taskTypeId) {
		return getPersistence().create(taskTypeId);
	}

	/**
	 * Removes the task type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type that was removed
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public static TaskType remove(long taskTypeId)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().remove(taskTypeId);
	}

	public static TaskType updateImpl(TaskType taskType) {
		return getPersistence().updateImpl(taskType);
	}

	/**
	 * Returns the task type with the primary key or throws a <code>NoSuchTaskTypeException</code> if it could not be found.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public static TaskType findByPrimaryKey(long taskTypeId)
		throws com.nss.taskcategory.exception.NoSuchTaskTypeException {

		return getPersistence().findByPrimaryKey(taskTypeId);
	}

	/**
	 * Returns the task type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type, or <code>null</code> if a task type with the primary key could not be found
	 */
	public static TaskType fetchByPrimaryKey(long taskTypeId) {
		return getPersistence().fetchByPrimaryKey(taskTypeId);
	}

	/**
	 * Returns all the task types.
	 *
	 * @return the task types
	 */
	public static List<TaskType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the task types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @return the range of task types
	 */
	public static List<TaskType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the task types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task types
	 */
	@Deprecated
	public static List<TaskType> findAll(
		int start, int end, OrderByComparator<TaskType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the task types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task types
	 */
	public static List<TaskType> findAll(
		int start, int end, OrderByComparator<TaskType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the task types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of task types.
	 *
	 * @return the number of task types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskTypePersistence, TaskTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskTypePersistence.class);

		ServiceTracker<TaskTypePersistence, TaskTypePersistence>
			serviceTracker =
				new ServiceTracker<TaskTypePersistence, TaskTypePersistence>(
					bundle.getBundleContext(), TaskTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}