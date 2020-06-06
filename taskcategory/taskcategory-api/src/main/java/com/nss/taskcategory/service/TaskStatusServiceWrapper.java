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
 * Provides a wrapper for {@link TaskStatusService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusService
 * @generated
 */
@ProviderType
public class TaskStatusServiceWrapper
	implements TaskStatusService, ServiceWrapper<TaskStatusService> {

	public TaskStatusServiceWrapper(TaskStatusService taskStatusService) {
		_taskStatusService = taskStatusService;
	}

	@Override
	public com.nss.taskcategory.model.TaskStatus addTaskStatus(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusService.addTaskStatus(
			userId, name, code, priority, active, description, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskStatusService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _taskStatusService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _taskStatusService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _taskStatusService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.taskcategory.model.TaskStatus updateTaskStatus(
			long taskTypeId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusService.updateTaskStatus(
			taskTypeId, name, code, priority, active, description,
			serviceContext);
	}

	@Override
	public TaskStatusService getWrappedService() {
		return _taskStatusService;
	}

	@Override
	public void setWrappedService(TaskStatusService taskStatusService) {
		_taskStatusService = taskStatusService;
	}

	private TaskStatusService _taskStatusService;

}