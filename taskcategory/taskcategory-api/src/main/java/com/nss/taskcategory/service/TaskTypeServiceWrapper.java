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
 * Provides a wrapper for {@link TaskTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypeService
 * @generated
 */
@ProviderType
public class TaskTypeServiceWrapper
	implements TaskTypeService, ServiceWrapper<TaskTypeService> {

	public TaskTypeServiceWrapper(TaskTypeService taskTypeService) {
		_taskTypeService = taskTypeService;
	}

	@Override
	public com.nss.taskcategory.model.TaskType addTaskType(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskTypeService.addTaskType(
			userId, name, code, priority, active, description, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _taskTypeService.hasAddPermission(groupId);
	}

	@Override
	public boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _taskTypeService.hasUpdatePermission(groupId);
	}

	@Override
	public boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _taskTypeService.hasViewPermission(groupId);
	}

	@Override
	public com.nss.taskcategory.model.TaskType updateTaskType(
			long taskTypeId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskTypeService.updateTaskType(
			taskTypeId, name, code, priority, active, description,
			serviceContext);
	}

	@Override
	public TaskTypeService getWrappedService() {
		return _taskTypeService;
	}

	@Override
	public void setWrappedService(TaskTypeService taskTypeService) {
		_taskTypeService = taskTypeService;
	}

	private TaskTypeService _taskTypeService;

}