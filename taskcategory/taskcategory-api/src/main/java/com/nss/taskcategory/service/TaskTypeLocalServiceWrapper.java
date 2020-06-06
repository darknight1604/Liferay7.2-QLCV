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
 * Provides a wrapper for {@link TaskTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypeLocalService
 * @generated
 */
@ProviderType
public class TaskTypeLocalServiceWrapper
	implements TaskTypeLocalService, ServiceWrapper<TaskTypeLocalService> {

	public TaskTypeLocalServiceWrapper(
		TaskTypeLocalService taskTypeLocalService) {

		_taskTypeLocalService = taskTypeLocalService;
	}

	/**
	 * Adds the task type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskType the task type
	 * @return the task type that was added
	 */
	@Override
	public com.nss.taskcategory.model.TaskType addTaskType(
		com.nss.taskcategory.model.TaskType taskType) {

		return _taskTypeLocalService.addTaskType(taskType);
	}

	/**
	 * Creates a new task type with the primary key. Does not add the task type to the database.
	 *
	 * @param taskTypeId the primary key for the new task type
	 * @return the new task type
	 */
	@Override
	public com.nss.taskcategory.model.TaskType createTaskType(long taskTypeId) {
		return _taskTypeLocalService.createTaskType(taskTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type that was removed
	 * @throws PortalException if a task type with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.TaskType deleteTaskType(long taskTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskTypeLocalService.deleteTaskType(taskTypeId);
	}

	/**
	 * Deletes the task type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskType the task type
	 * @return the task type that was removed
	 */
	@Override
	public com.nss.taskcategory.model.TaskType deleteTaskType(
		com.nss.taskcategory.model.TaskType taskType) {

		return _taskTypeLocalService.deleteTaskType(taskType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskTypeLocalService.dynamicQuery();
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

		return _taskTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taskTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taskTypeLocalService.dynamicQuery(
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

		return _taskTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _taskTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.nss.taskcategory.model.TaskType fetchTaskType(long taskTypeId) {
		return _taskTypeLocalService.fetchTaskType(taskTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskTypeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task type with the primary key.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type
	 * @throws PortalException if a task type with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.TaskType getTaskType(long taskTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskTypeLocalService.getTaskType(taskTypeId);
	}

	/**
	 * Returns a range of all the task types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @return the range of task types
	 */
	@Override
	public java.util.List<com.nss.taskcategory.model.TaskType> getTaskTypes(
		int start, int end) {

		return _taskTypeLocalService.getTaskTypes(start, end);
	}

	/**
	 * Returns the number of task types.
	 *
	 * @return the number of task types
	 */
	@Override
	public int getTaskTypesCount() {
		return _taskTypeLocalService.getTaskTypesCount();
	}

	/**
	 * Updates the task type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taskType the task type
	 * @return the task type that was updated
	 */
	@Override
	public com.nss.taskcategory.model.TaskType updateTaskType(
		com.nss.taskcategory.model.TaskType taskType) {

		return _taskTypeLocalService.updateTaskType(taskType);
	}

	@Override
	public TaskTypeLocalService getWrappedService() {
		return _taskTypeLocalService;
	}

	@Override
	public void setWrappedService(TaskTypeLocalService taskTypeLocalService) {
		_taskTypeLocalService = taskTypeLocalService;
	}

	private TaskTypeLocalService _taskTypeLocalService;

}