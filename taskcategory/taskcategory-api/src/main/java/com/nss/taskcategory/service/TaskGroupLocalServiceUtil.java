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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TaskGroup. This utility wraps
 * <code>com.nss.taskcategory.service.impl.TaskGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaskGroupLocalService
 * @generated
 */
@ProviderType
public class TaskGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.taskcategory.service.impl.TaskGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.nss.taskcategory.model.TaskGroup addTaskGroup(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTaskGroup(
			userId, name, code, priority, active, description, serviceContext);
	}

	/**
	 * Adds the task group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroup the task group
	 * @return the task group that was added
	 */
	public static com.nss.taskcategory.model.TaskGroup addTaskGroup(
		com.nss.taskcategory.model.TaskGroup taskGroup) {

		return getService().addTaskGroup(taskGroup);
	}

	public static int countByActive(boolean active) {
		return getService().countByActive(active);
	}

	public static int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator);
	}

	public static int countByCompanyId(long companyId) {
		return getService().countByCompanyId(companyId);
	}

	public static int countByCompanyId_Active(long companyId, boolean active) {
		return getService().countByCompanyId_Active(companyId, active);
	}

	/**
	 * Creates a new task group with the primary key. Does not add the task group to the database.
	 *
	 * @param taskGroupId the primary key for the new task group
	 * @return the new task group
	 */
	public static com.nss.taskcategory.model.TaskGroup createTaskGroup(
		long taskGroupId) {

		return getService().createTaskGroup(taskGroupId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group that was removed
	 * @throws PortalException if a task group with the primary key could not be found
	 */
	public static com.nss.taskcategory.model.TaskGroup deleteTaskGroup(
			long taskGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTaskGroup(taskGroupId);
	}

	/**
	 * Deletes the task group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroup the task group
	 * @return the task group that was removed
	 */
	public static com.nss.taskcategory.model.TaskGroup deleteTaskGroup(
		com.nss.taskcategory.model.TaskGroup taskGroup) {

		return getService().deleteTaskGroup(taskGroup);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.nss.taskcategory.model.TaskGroup fetchByCode(
		String code) {

		return getService().fetchByCode(code);
	}

	public static com.nss.taskcategory.model.TaskGroup fetchTaskGroup(
		long taskGroupId) {

		return getService().fetchTaskGroup(taskGroupId);
	}

	public static java.util.List<com.nss.taskcategory.model.TaskGroup>
		findByActive(boolean active) {

		return getService().findByActive(active);
	}

	public static java.util.List<com.nss.taskcategory.model.TaskGroup>
			findByBaseSearch(
				long companyId, long groupId, int active, String name,
				String code, String description, boolean andOperator, int start,
				int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator,
			start, end, obc);
	}

	public static java.util.List<com.nss.taskcategory.model.TaskGroup>
		findByCompanyId(long companyId) {

		return getService().findByCompanyId(companyId);
	}

	public static java.util.List<com.nss.taskcategory.model.TaskGroup>
		findByCompanyId_Active(long companyId, boolean active) {

		return getService().findByCompanyId_Active(companyId, active);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task group with the primary key.
	 *
	 * @param taskGroupId the primary key of the task group
	 * @return the task group
	 * @throws PortalException if a task group with the primary key could not be found
	 */
	public static com.nss.taskcategory.model.TaskGroup getTaskGroup(
			long taskGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTaskGroup(taskGroupId);
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
	public static java.util.List<com.nss.taskcategory.model.TaskGroup>
		getTaskGroups(int start, int end) {

		return getService().getTaskGroups(start, end);
	}

	/**
	 * Returns the number of task groups.
	 *
	 * @return the number of task groups
	 */
	public static int getTaskGroupsCount() {
		return getService().getTaskGroupsCount();
	}

	public static com.nss.taskcategory.model.TaskGroup updateTaskGroup(
			long taskGroupId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTaskGroup(
			taskGroupId, name, code, priority, active, description,
			serviceContext);
	}

	/**
	 * Updates the task group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taskGroup the task group
	 * @return the task group that was updated
	 */
	public static com.nss.taskcategory.model.TaskGroup updateTaskGroup(
		com.nss.taskcategory.model.TaskGroup taskGroup) {

		return getService().updateTaskGroup(taskGroup);
	}

	public static TaskGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskGroupLocalService, TaskGroupLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskGroupLocalService.class);

		ServiceTracker<TaskGroupLocalService, TaskGroupLocalService>
			serviceTracker =
				new ServiceTracker
					<TaskGroupLocalService, TaskGroupLocalService>(
						bundle.getBundleContext(), TaskGroupLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}