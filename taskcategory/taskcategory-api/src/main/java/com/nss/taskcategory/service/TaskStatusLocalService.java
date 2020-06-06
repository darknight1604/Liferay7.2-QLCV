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

package com.nss.taskcategory.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.model.TaskStatus;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TaskStatus. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TaskStatusLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskStatusLocalServiceUtil} to access the task status local service. Add custom service methods to <code>com.nss.taskcategory.service.impl.TaskStatusLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public TaskStatus addTaskStatus(
			long userId, String name, String code, int priority, boolean active,
			String description, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the task status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatus the task status
	 * @return the task status that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TaskStatus addTaskStatus(TaskStatus taskStatus);

	public int countByActive(boolean active);

	public int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws SystemException;

	public int countByCompanyId(long companyId);

	public int countByCompanyId_Active(long companyId, boolean active);

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	@Transactional(enabled = false)
	public TaskStatus createTaskStatus(long taskStatusId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws PortalException if a task status with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TaskStatus deleteTaskStatus(long taskStatusId)
		throws PortalException;

	/**
	 * Deletes the task status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatus the task status
	 * @return the task status that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TaskStatus deleteTaskStatus(TaskStatus taskStatus);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TaskStatus fetchByCode(String code);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TaskStatus fetchTaskStatus(long taskStatusId);

	public List<TaskStatus> findByActive(boolean active);

	public List<TaskStatus> findByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator, int start, int end,
			OrderByComparator obc)
		throws SystemException;

	public List<TaskStatus> findByCompanyId(long companyId);

	public List<TaskStatus> findByCompanyId_Active(
		long companyId, boolean active);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the task status with the primary key.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws PortalException if a task status with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TaskStatus getTaskStatus(long taskStatusId) throws PortalException;

	/**
	 * Returns a range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of task statuses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TaskStatus> getTaskStatuses(int start, int end);

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTaskStatusesCount();

	public TaskStatus updateTaskStatus(
			long taskStatusId, String name, String code, int priority,
			boolean active, String description, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the task status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatus the task status
	 * @return the task status that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TaskStatus updateTaskStatus(TaskStatus taskStatus);

}