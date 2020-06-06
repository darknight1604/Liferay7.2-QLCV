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

package com.nss.taskcategory.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.taskcategory.constants.TaskCategoryActionKeys;
import com.nss.taskcategory.constants.TaskCategoryResourceConstants;
import com.nss.taskcategory.model.TaskType;
import com.nss.taskcategory.service.base.TaskTypeServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.TaskTypeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypeServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=task_category",
		"json.web.service.context.path=TaskType"
	},
	service = AopService.class
)
public class TaskTypeServiceImpl extends TaskTypeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.nss.taskcategory.service.TaskTypeServiceUtil</code> to access the task type remote service.
	 */
	private static volatile PortletResourcePermission _portletResourcePermission = PortletResourcePermissionFactory.getInstance(TaskTypeServiceImpl.class, "_portletResourcePermission", TaskCategoryResourceConstants.RESOURCE_NAME);
	
	public TaskType addTaskType(long userId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), TaskCategoryActionKeys.ADD_TASKTYPE);
		return taskTypeLocalService.addTaskType(userId, name, 
				code, priority, active, description, serviceContext);
	}
	
	public TaskType updateTaskType(long taskTypeId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_portletResourcePermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), TaskCategoryActionKeys.UPDATE);
		return taskTypeLocalService.updateTaskType(taskTypeId, name, 
				code, priority, active, description, serviceContext);
	}
	
	public boolean hasAddPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, TaskCategoryActionKeys.ADD_TASKTYPE);
	}
	
	public boolean hasUpdatePermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, TaskCategoryActionKeys.UPDATE);
	}
	
	public boolean hasViewPermission(long groupId) throws PrincipalException {
		return _portletResourcePermission.contains(getPermissionChecker(), groupId, TaskCategoryActionKeys.VIEW);
	}
}