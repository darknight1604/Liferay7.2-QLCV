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
 * Provides the remote service utility for TaskType. This utility wraps
 * <code>com.nss.taskcategory.service.impl.TaskTypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypeService
 * @generated
 */
@ProviderType
public class TaskTypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.taskcategory.service.impl.TaskTypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.nss.taskcategory.model.TaskType addTaskType(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTaskType(
			userId, name, code, priority, active, description, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean hasAddPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().hasAddPermission(groupId);
	}

	public static boolean hasUpdatePermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().hasUpdatePermission(groupId);
	}

	public static boolean hasViewPermission(long groupId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().hasViewPermission(groupId);
	}

	public static com.nss.taskcategory.model.TaskType updateTaskType(
			long taskTypeId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTaskType(
			taskTypeId, name, code, priority, active, description,
			serviceContext);
	}

	public static TaskTypeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskTypeService, TaskTypeService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskTypeService.class);

		ServiceTracker<TaskTypeService, TaskTypeService> serviceTracker =
			new ServiceTracker<TaskTypeService, TaskTypeService>(
				bundle.getBundleContext(), TaskTypeService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}