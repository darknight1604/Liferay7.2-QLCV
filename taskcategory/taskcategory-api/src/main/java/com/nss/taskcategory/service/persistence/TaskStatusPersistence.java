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

import com.nss.taskcategory.exception.NoSuchTaskStatusException;
import com.nss.taskcategory.model.TaskStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusUtil
 * @generated
 */
@ProviderType
public interface TaskStatusPersistence extends BasePersistence<TaskStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskStatusUtil} to access the task status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching task statuses
	 */
	public java.util.List<TaskStatus> findByCompanyId(long companyId);

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
	public java.util.List<TaskStatus> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<TaskStatus> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TaskStatus> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the first task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByCompanyId_First(
			long companyId, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the first task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByCompanyId_First(
		long companyId, OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the last task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByCompanyId_Last(
			long companyId, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the last task status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByCompanyId_Last(
		long companyId, OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where companyId = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus[] findByCompanyId_PrevAndNext(
			long taskStatusId, long companyId,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Removes all the task statuses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of task statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching task statuses
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the task statuses where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching task statuses
	 */
	public java.util.List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active);

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
	public java.util.List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active, int start, int end);

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
	public java.util.List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the first task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByCompanyId_Active_First(
			long companyId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the first task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByCompanyId_Active_First(
		long companyId, boolean active,
		OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the last task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByCompanyId_Active_Last(
			long companyId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the last task status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByCompanyId_Active_Last(
		long companyId, boolean active,
		OrderByComparator<TaskStatus> orderByComparator);

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
	public TaskStatus[] findByCompanyId_Active_PrevAndNext(
			long taskStatusId, long companyId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Removes all the task statuses where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 */
	public void removeByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns the number of task statuses where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching task statuses
	 */
	public int countByCompanyId_Active(long companyId, boolean active);

	/**
	 * Returns all the task statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching task statuses
	 */
	public java.util.List<TaskStatus> findByActive(boolean active);

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
	public java.util.List<TaskStatus> findByActive(
		boolean active, int start, int end);

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
	public java.util.List<TaskStatus> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TaskStatus> findByActive(
		boolean active, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the first task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByActive_First(
			boolean active, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the first task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByActive_First(
		boolean active, OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the last task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByActive_Last(
			boolean active, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the last task status in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByActive_Last(
		boolean active, OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where active = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus[] findByActive_PrevAndNext(
			long taskStatusId, boolean active,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Removes all the task statuses where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of task statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching task statuses
	 */
	public int countByActive(boolean active);

	/**
	 * Returns the task status where code = &#63; or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByCode(String code) throws NoSuchTaskStatusException;

	/**
	 * Returns the task status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByCode(String)}
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Deprecated
	public TaskStatus fetchByCode(String code, boolean useFinderCache);

	/**
	 * Returns the task status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByCode(String code);

	/**
	 * Removes the task status where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the task status that was removed
	 */
	public TaskStatus removeByCode(String code)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the number of task statuses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching task statuses
	 */
	public int countByCode(String code);

	/**
	 * Caches the task status in the entity cache if it is enabled.
	 *
	 * @param taskStatus the task status
	 */
	public void cacheResult(TaskStatus taskStatus);

	/**
	 * Caches the task statuses in the entity cache if it is enabled.
	 *
	 * @param taskStatuses the task statuses
	 */
	public void cacheResult(java.util.List<TaskStatus> taskStatuses);

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	public TaskStatus create(long taskStatusId);

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus remove(long taskStatusId)
		throws NoSuchTaskStatusException;

	public TaskStatus updateImpl(TaskStatus taskStatus);

	/**
	 * Returns the task status with the primary key or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus findByPrimaryKey(long taskStatusId)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the task status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status, or <code>null</code> if a task status with the primary key could not be found
	 */
	public TaskStatus fetchByPrimaryKey(long taskStatusId);

	/**
	 * Returns all the task statuses.
	 *
	 * @return the task statuses
	 */
	public java.util.List<TaskStatus> findAll();

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
	public java.util.List<TaskStatus> findAll(int start, int end);

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
	public java.util.List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator);

	/**
	 * Removes all the task statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	public int countAll();

}