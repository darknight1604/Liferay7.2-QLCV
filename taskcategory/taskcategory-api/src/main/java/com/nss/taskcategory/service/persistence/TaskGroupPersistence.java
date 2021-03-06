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

import com.nss.taskcategory.exception.NoSuchTaskGroupException;
import com.nss.taskcategory.model.TaskGroup;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskGroupUtil
 * @generated
 */
@ProviderType
public interface TaskGroupPersistence extends BasePersistence<TaskGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskGroupUtil} to access the task group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task groups where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching task groups
	 */
	public java.util.List<TaskGroup> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the task groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @return the range of matching task groups
	 */
	public java.util.List<TaskGroup> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the task groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task groups
	 */
	@Deprecated
	public java.util.List<TaskGroup> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskGroup> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the task groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task groups
	 */
	public java.util.List<TaskGroup> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the first task group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByCompanyId_First(
			long companyId, OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the first task group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByCompanyId_First(
		long companyId, OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the last task group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByCompanyId_Last(
			long companyId, OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the last task group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByCompanyId_Last(
		long companyId, OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the task groups before and after the current task group in the ordered set where companyId = &#63;.
	 *
	 * @param taskGroupId the primary key of the current task group
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task group
	 * @throws NoSuchTaskGroupException if a task group with the primary key could not be found
	 */
	public TaskGroup[] findByCompanyId_PrevAndNext(
			long taskGroupId, long companyId,
			OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Removes all the task groups where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of task groups where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching task groups
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the task groups where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching task groups
	 */
	public java.util.List<TaskGroup> findByCompanyId_Active(
		long companyId, boolean active);

	/**
	 * Returns a range of all the task groups where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @return the range of matching task groups
	 */
	public java.util.List<TaskGroup> findByCompanyId_Active(
		long companyId, boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the task groups where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId_Active(long,boolean, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task groups
	 */
	@Deprecated
	public java.util.List<TaskGroup> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskGroup> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the task groups where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task groups
	 */
	public java.util.List<TaskGroup> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the first task group in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the first task group in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the last task group in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the last task group in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the task groups before and after the current task group in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param taskGroupId the primary key of the current task group
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task group
	 * @throws NoSuchTaskGroupException if a task group with the primary key could not be found
	 */
	public TaskGroup[] findByCompanyId_Active_PrevAndNext(
			long taskGroupId, long companyId, boolean active,
			OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Removes all the task groups where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	public void removeByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns the number of task groups where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching task groups
	 */
	public int countByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns all the task groups where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching task groups
	 */
	public java.util.List<TaskGroup> findByActive(boolean active);

	/**
	 * Returns a range of all the task groups where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @return the range of matching task groups
	 */
	public java.util.List<TaskGroup> findByActive(
		boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the task groups where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByActive(boolean, int, int, OrderByComparator)}
	 * @param active the active
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task groups
	 */
	@Deprecated
	public java.util.List<TaskGroup> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskGroup> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the task groups where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task groups
	 */
	public java.util.List<TaskGroup> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the first task group in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByActive_First(
			boolean active, OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the first task group in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByActive_First(
		boolean active, OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the last task group in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByActive_Last(
			boolean active, OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the last task group in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByActive_Last(
		boolean active, OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Returns the task groups before and after the current task group in the ordered set where active = &#63;.
	 *
	 * @param taskGroupId the primary key of the current task group
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task group
	 * @throws NoSuchTaskGroupException if a task group with the primary key could not be found
	 */
	public TaskGroup[] findByActive_PrevAndNext(
			long taskGroupId, boolean active,
			OrderByComparator<TaskGroup> orderByComparator)
		throws NoSuchTaskGroupException;

	/**
	 * Removes all the task groups where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of task groups where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching task groups
	 */
	public int countByActive(boolean active);

	/**
	 * Returns the task group where code = &#63; or throws a <code>NoSuchTaskGroupException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching task group
	 * @throws NoSuchTaskGroupException if a matching task group could not be found
	 */
	public TaskGroup findByCode(String code) throws NoSuchTaskGroupException;

	/**
	 * Returns the task group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task group, or <code>null</code> if a matching task group could not be found
	 */
	@Deprecated
	public TaskGroup fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the task group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task group, or <code>null</code> if a matching task group could not be found
	 */
	public TaskGroup fetchByCode(String code);

	/**
	 * Removes the task group where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the task group that was removed
	 */
	public TaskGroup removeByCode(String code) throws NoSuchTaskGroupException;

	/**
	 * Returns the number of task groups where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching task groups
	 */
	public int countByCode(String code);

	/**
	 * Caches the task group in the entity cache if it is enabled.
	 *
	 * @param taskGroup the task group
	 */
	public void cacheResult(TaskGroup taskGroup);

	/**
	 * Caches the task groups in the entity cache if it is enabled.
	 *
	 * @param taskGroups the task groups
	 */
	public void cacheResult(java.util.List<TaskGroup> taskGroups);

	/**
	 * Creates a new task group with the primary key. Does not add the task group to the database.
	 *
	 * @param taskGroupId the primary key for the new task group
	 * @return the new task group
	 */
	public TaskGroup create(long taskGroupId);

	/**
	 * Removes the task group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group that was removed
	 * @throws NoSuchTaskGroupException if a task group with the primary key could not be found
	 */
	public TaskGroup remove(long taskGroupId) throws NoSuchTaskGroupException;

	public TaskGroup updateImpl(TaskGroup taskGroup);

	/**
	 * Returns the task group with the primary key or throws a <code>NoSuchTaskGroupException</code> if it could not be found.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group
	 * @throws NoSuchTaskGroupException if a task group with the primary key could not be found
	 */
	public TaskGroup findByPrimaryKey(long taskGroupId)
		throws NoSuchTaskGroupException;

	/**
	 * Returns the task group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group, or <code>null</code> if a task group with the primary key could not be found
	 */
	public TaskGroup fetchByPrimaryKey(long taskGroupId);

	/**
	 * Returns all the task groups.
	 *
	 * @return the task groups
	 */
	public java.util.List<TaskGroup> findAll();

	/**
	 * Returns a range of all the task groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @return the range of task groups
	 */
	public java.util.List<TaskGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the task groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task groups
	 */
	@Deprecated
	public java.util.List<TaskGroup> findAll(
		int start, int end, OrderByComparator<TaskGroup> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the task groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task groups
	 */
	public java.util.List<TaskGroup> findAll(
		int start, int end, OrderByComparator<TaskGroup> orderByComparator);

	/**
	 * Removes all the task groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task groups.
	 *
	 * @return the number of task groups
	 */
	public int countAll();

}