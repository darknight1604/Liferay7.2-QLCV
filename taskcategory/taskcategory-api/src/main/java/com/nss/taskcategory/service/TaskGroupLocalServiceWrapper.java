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
 * Provides a wrapper for {@link TaskGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskGroupLocalService
 * @generated
 */
@ProviderType
public class TaskGroupLocalServiceWrapper
	implements TaskGroupLocalService, ServiceWrapper<TaskGroupLocalService> {

	public TaskGroupLocalServiceWrapper(
		TaskGroupLocalService taskGroupLocalService) {

		_taskGroupLocalService = taskGroupLocalService;
	}

	@Override
	public com.nss.taskcategory.model.TaskGroup addTaskGroup(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskGroupLocalService.addTaskGroup(
			userId, name, code, priority, active, description, serviceContext);
	}

	/**
	 * Adds the task group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroup the task group
	 * @return the task group that was added
	 */
	@Override
	public com.nss.taskcategory.model.TaskGroup addTaskGroup(
		com.nss.taskcategory.model.TaskGroup taskGroup) {

		return _taskGroupLocalService.addTaskGroup(taskGroup);
	}

	@Override
	public int countByActive(boolean active) {
		return _taskGroupLocalService.countByActive(active);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taskGroupLocalService.countByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator);
	}

	@Override
	public int countByCompanyId(long companyId) {
		return _taskGroupLocalService.countByCompanyId(companyId);
	}

	@Override
	public int countByCompanyId_Active(long companyId, boolean active) {
		return _taskGroupLocalService.countByCompanyId_Active(
			companyId, active);
	}

	/**
	 * Creates a new task group with the primary key. Does not add the task group to the database.
	 *
	 * @param taskGroupId the primary key for the new task group
	 * @return the new task group
	 */
	@Override
	public com.nss.taskcategory.model.TaskGroup createTaskGroup(
		long taskGroupId) {

		return _taskGroupLocalService.createTaskGroup(taskGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskGroupLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group that was removed
	 * @throws PortalException if a task group with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.TaskGroup deleteTaskGroup(
			long taskGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskGroupLocalService.deleteTaskGroup(taskGroupId);
	}

	/**
	 * Deletes the task group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroup the task group
	 * @return the task group that was removed
	 */
	@Override
	public com.nss.taskcategory.model.TaskGroup deleteTaskGroup(
		com.nss.taskcategory.model.TaskGroup taskGroup) {

		return _taskGroupLocalService.deleteTaskGroup(taskGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskGroupLocalService.dynamicQuery();
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

		return _taskGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taskGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taskGroupLocalService.dynamicQuery(
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

		return _taskGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _taskGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.nss.taskcategory.model.TaskGroup fetchByCode(String code) {
		return _taskGroupLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.taskcategory.model.TaskGroup fetchTaskGroup(
		long taskGroupId) {

		return _taskGroupLocalService.fetchTaskGroup(taskGroupId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskGroup> findByActive(
		boolean active) {

		return _taskGroupLocalService.findByActive(active);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskGroup>
			findByBaseSearch(
				long companyId, long groupId, int active, String name,
				String code, String description, boolean andOperator, int start,
				int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taskGroupLocalService.findByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator,
			start, end, obc);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskGroup> findByCompanyId(
		long companyId) {

		return _taskGroupLocalService.findByCompanyId(companyId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.TaskGroup>
		findByCompanyId_Active(long companyId, boolean active) {

		return _taskGroupLocalService.findByCompanyId_Active(companyId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskGroupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskGroupLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task group with the primary key.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group
	 * @throws PortalException if a task group with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.TaskGroup getTaskGroup(long taskGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskGroupLocalService.getTaskGroup(taskGroupId);
	}

	/**
	 * Returns a range of all the task groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskGroupModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task groups
	 * @param end the upper bound of the range of task groups (not inclusive)
	 * @return the range of task groups
	 */
	@Override
	public java.util.List<com.nss.taskcategory.model.TaskGroup> getTaskGroups(
		int start, int end) {

		return _taskGroupLocalService.getTaskGroups(start, end);
	}

	/**
	 * Returns the number of task groups.
	 *
	 * @return the number of task groups
	 */
	@Override
	public int getTaskGroupsCount() {
		return _taskGroupLocalService.getTaskGroupsCount();
	}

	@Override
	public com.nss.taskcategory.model.TaskGroup updateTaskGroup(
			long taskGroupId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskGroupLocalService.updateTaskGroup(
			taskGroupId, name, code, priority, active, description,
			serviceContext);
	}

	/**
	 * Updates the task group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroup the task group
	 * @return the task group that was updated
	 */
	@Override
	public com.nss.taskcategory.model.TaskGroup updateTaskGroup(
		com.nss.taskcategory.model.TaskGroup taskGroup) {

		return _taskGroupLocalService.updateTaskGroup(taskGroup);
	}

	@Override
	public TaskGroupLocalService getWrappedService() {
		return _taskGroupLocalService;
	}

	@Override
	public void setWrappedService(TaskGroupLocalService taskGroupLocalService) {
		_taskGroupLocalService = taskGroupLocalService;
	}

	private TaskGroupLocalService _taskGroupLocalService;

}