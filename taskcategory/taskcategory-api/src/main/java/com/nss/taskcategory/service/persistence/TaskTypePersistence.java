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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.exception.NoSuchTaskTypeException;
import com.nss.taskcategory.model.TaskType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypeUtil
 * @generated
 */
@ProviderType
public interface TaskTypePersistence extends BasePersistence<TaskType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskTypeUtil} to access the task type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching task types
	 */
	public java.util.List<TaskType> findByCompanyId(long companyId);

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
	public java.util.List<TaskType> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<TaskType> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskType> orderByComparator, boolean useFinderCache);

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
	public java.util.List<TaskType> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the first task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByCompanyId_First(
			long companyId, OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the first task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByCompanyId_First(
		long companyId, OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the last task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByCompanyId_Last(
			long companyId, OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the last task type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByCompanyId_Last(
		long companyId, OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the task types before and after the current task type in the ordered set where companyId = &#63;.
	 *
	 * @param taskTypeId the primary key of the current task type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public TaskType[] findByCompanyId_PrevAndNext(
			long taskTypeId, long companyId,
			OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Removes all the task types where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of task types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching task types
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the task types where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching task types
	 */
	public java.util.List<TaskType> findByCompanyId_Active(
		long companyId, boolean active);

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
	public java.util.List<TaskType> findByCompanyId_Active(
		long companyId, boolean active, int start, int end);

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
	public java.util.List<TaskType> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator, boolean useFinderCache);

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
	public java.util.List<TaskType> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the first task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the first task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the last task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the last task type in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<TaskType> orderByComparator);

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
	public TaskType[] findByCompanyId_Active_PrevAndNext(
			long taskTypeId, long companyId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Removes all the task types where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	public void removeByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns the number of task types where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching task types
	 */
	public int countByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns all the task types where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching task types
	 */
	public java.util.List<TaskType> findByActive(boolean active);

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
	public java.util.List<TaskType> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<TaskType> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator, boolean useFinderCache);

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
	public java.util.List<TaskType> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the first task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByActive_First(
			boolean active, OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the first task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByActive_First(
		boolean active, OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the last task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByActive_Last(
			boolean active, OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the last task type in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByActive_Last(
		boolean active, OrderByComparator<TaskType> orderByComparator);

	/**
	 * Returns the task types before and after the current task type in the ordered set where active = &#63;.
	 *
	 * @param taskTypeId the primary key of the current task type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public TaskType[] findByActive_PrevAndNext(
			long taskTypeId, boolean active,
			OrderByComparator<TaskType> orderByComparator)
		throws NoSuchTaskTypeException;

	/**
	 * Removes all the task types where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of task types where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching task types
	 */
	public int countByActive(boolean active);

	/**
	 * Returns the task type where code = &#63; or throws a <code>NoSuchTaskTypeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching task type
	 * @throws NoSuchTaskTypeException if a matching task type could not be found
	 */
	public TaskType findByCode(String code) throws NoSuchTaskTypeException;

	/**
	 * Returns the task type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task type, or <code>null</code> if a matching task type could not be found
	 */
	@Deprecated
	public TaskType fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the task type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task type, or <code>null</code> if a matching task type could not be found
	 */
	public TaskType fetchByCode(String code);

	/**
	 * Removes the task type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the task type that was removed
	 */
	public TaskType removeByCode(String code) throws NoSuchTaskTypeException;

	/**
	 * Returns the number of task types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching task types
	 */
	public int countByCode(String code);

	/**
	 * Caches the task type in the entity cache if it is enabled.
	 *
	 * @param taskType the task type
	 */
	public void cacheResult(TaskType taskType);

	/**
	 * Caches the task types in the entity cache if it is enabled.
	 *
	 * @param taskTypes the task types
	 */
	public void cacheResult(java.util.List<TaskType> taskTypes);

	/**
	 * Creates a new task type with the primary key. Does not add the task type to the database.
	 *
	 * @param taskTypeId the primary key for the new task type
	 * @return the new task type
	 */
	public TaskType create(long taskTypeId);

	/**
	 * Removes the task type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type that was removed
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public TaskType remove(long taskTypeId) throws NoSuchTaskTypeException;

	public TaskType updateImpl(TaskType taskType);

	/**
	 * Returns the task type with the primary key or throws a <code>NoSuchTaskTypeException</code> if it could not be found.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type
	 * @throws NoSuchTaskTypeException if a task type with the primary key could not be found
	 */
	public TaskType findByPrimaryKey(long taskTypeId)
		throws NoSuchTaskTypeException;

	/**
	 * Returns the task type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type, or <code>null</code> if a task type with the primary key could not be found
	 */
	public TaskType fetchByPrimaryKey(long taskTypeId);

	/**
	 * Returns all the task types.
	 *
	 * @return the task types
	 */
	public java.util.List<TaskType> findAll();

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
	public java.util.List<TaskType> findAll(int start, int end);

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
	public java.util.List<TaskType> findAll(
		int start, int end, OrderByComparator<TaskType> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TaskType> findAll(
		int start, int end, OrderByComparator<TaskType> orderByComparator);

	/**
	 * Removes all the task types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task types.
	 *
	 * @return the number of task types
	 */
	public int countAll();

}