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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TaskStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusLocalService
 * @generated
 */
@ProviderType
public class TaskStatusLocalServiceWrapper
	implements TaskStatusLocalService, ServiceWrapper<TaskStatusLocalService> {

	public TaskStatusLocalServiceWrapper(
		TaskStatusLocalService taskStatusLocalService) {

		_taskStatusLocalService = taskStatusLocalService;
	}

	@Override
	public com.nss.taskcategory.model.TaskStatus addTaskStatus(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusLocalService.addTaskStatus(
			userId, name, code, priority, active, description, serviceContext);
	}

	/**
	 * Adds the task status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatus the task status
	 * @return the task status that was added
	 */
	@Override
	public com.nss.taskcategory.model.TaskStatus addTaskStatus(
		com.nss.taskcategory.model.TaskStatus taskStatus) {

		return _taskStatusLocalService.addTaskStatus(taskStatus);
	}

	@Override
	public int countByActive(boolean active) {
		return _taskStatusLocalService.countByActive(active);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taskStatusLocalService.countByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator);
	}

	@Override
	public int countByCompanyId(long companyId) {
		return _taskStatusLocalService.countByCompanyId(companyId);
	}

	@Override
	public int countByCompanyId_Active(long companyId, boolean active) {
		return _taskStatusLocalService.countByCompanyId_Active(
			companyId, active);
	}

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	@Override
	public com.nss.taskcategory.model.TaskStatus createTaskStatus(
		long taskStatusId) {

		return _taskStatusLocalService.createTaskStatus(taskStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws PortalException if a task status with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.TaskStatus deleteTaskStatus(
			long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusLocalService.deleteTaskStatus(taskStatusId);
	}

	/**
	 * Deletes the task status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatus the task status
	 * @return the task status that was removed
	 */
	@Override
	public com.nss.taskcategory.model.TaskStatus deleteTaskStatus(
		com.nss.taskcategory.model.TaskStatus taskStatus) {

		return _taskStatusLocalService.deleteTaskStatus(taskStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskStatusLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskStatusLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _taskStatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _taskStatusLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskStatusLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _taskStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.nss.taskcategory.model.TaskStatus fetchByCode(String code) {
		return _taskStatusLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.taskcategory.model.TaskStatus fetchTaskStatus(
		long taskStatusId) {

		return _taskStatusLocalService.fetchTaskStatus(taskStatusId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskStatus> findByActive(
		boolean active) {

		return _taskStatusLocalService.findByActive(active);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskStatus>
			findByBaseSearch(
				long companyId, long groupId, int active, String name,
				String code, String description, boolean andOperator, int start,
				int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taskStatusLocalService.findByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator,
			start, end, obc);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskStatus>
		findByCompanyId(long companyId) {

		return _taskStatusLocalService.findByCompanyId(companyId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskStatus>
		findByCompanyId_Active(long companyId, boolean active) {

		return _taskStatusLocalService.findByCompanyId_Active(
			companyId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskStatusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskStatusLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task status with the primary key.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws PortalException if a task status with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.TaskStatus getTaskStatus(
			long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusLocalService.getTaskStatus(taskStatusId);
	}

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
	@Override
	public java.util.List<com.nss.taskcategory.model.TaskStatus>
		getTaskStatuses(int start, int end) {

		return _taskStatusLocalService.getTaskStatuses(start, end);
	}

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	@Override
	public int getTaskStatusesCount() {
		return _taskStatusLocalService.getTaskStatusesCount();
	}

	@Override
	public com.nss.taskcategory.model.TaskStatus updateTaskStatus(
			long taskStatusId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusLocalService.updateTaskStatus(
			taskStatusId, name, code, priority, active, description,
			serviceContext);
	}

	/**
	 * Updates the task status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatus the task status
	 * @return the task status that was updated
	 */
	@Override
	public com.nss.taskcategory.model.TaskStatus updateTaskStatus(
		com.nss.taskcategory.model.TaskStatus taskStatus) {

		return _taskStatusLocalService.updateTaskStatus(taskStatus);
	}

	@Override
	public TaskStatusLocalService getWrappedService() {
		return _taskStatusLocalService;
	}

	@Override
	public void setWrappedService(
		TaskStatusLocalService taskStatusLocalService) {

		_taskStatusLocalService = taskStatusLocalService;
	}

	private TaskStatusLocalService _taskStatusLocalService;

}