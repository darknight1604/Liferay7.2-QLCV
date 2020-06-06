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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.exception.EmptyCodeException;
import com.nss.taskcategory.model.TaskGroup;
import com.nss.taskcategory.service.base.TaskGroupLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.TaskGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskGroupLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.taskcategory.model.TaskGroup",
	service = AopService.class
)
public class TaskGroupLocalServiceImpl extends TaskGroupLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.taskcategory.service.TaskGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.TaskGroupLocalServiceUtil</code>.
	 */
	
	public TaskGroup addTaskGroup(long userId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateTaskGroupByCode(0, code);
		
		long taskGroupId = counterLocalService.increment(TaskGroup.class.getName());
		TaskGroup taskGroup = createTaskGroup(taskGroupId);
		User user = UserLocalServiceUtil.fetchUser(userId);
		Date now = new Date();
		
		if(user != null) {
			taskGroup.setUserId(userId);
			taskGroup.setUserName(user.getFullName());
		}
		
		taskGroup.setModifiedDate(now);
		taskGroup.setCreateDate(now);
		taskGroup.setCompanyId(serviceContext.getCompanyId());
		taskGroup.setGroupId(serviceContext.getScopeGroupId());
		
		taskGroup.setName(name);
		taskGroup.setCode(code);
		taskGroup.setPriority(priority);
		taskGroup.setActive(active);
		taskGroup.setDescription(description);
		taskGroup.setExpandoBridgeAttributes(serviceContext);
		
		addTaskGroup(taskGroup);
		
		return taskGroup;
	}
	
	public TaskGroup updateTaskGroup(long taskGroupId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateTaskGroupByCode(taskGroupId, code);
		TaskGroup taskGroup = fetchTaskGroup(taskGroupId);
		Date now = new Date();
		taskGroup.setModifiedDate(now);
		
		taskGroup.setName(name);
		taskGroup.setCode(code);
		taskGroup.setPriority(priority);
		taskGroup.setActive(active);
		taskGroup.setDescription(description);
		taskGroup.setExpandoBridgeAttributes(serviceContext);
		
		updateTaskGroup(taskGroup);
		
		return taskGroup;
	}
	
	public TaskGroup fetchByCode(String code) {
		return taskGroupPersistence.fetchByCode(code);
	}
	
	private void _validateTaskGroupByCode(long taskGroupId, String code) throws PortalException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		if (Validator.isNotNull(code)) {
			TaskGroup taskGroup = fetchByCode(code);
			if (taskGroup != null && taskGroup.getTaskGroupId() != taskGroupId) {
				throw new DuplicateCodeException();
			}
		}
	}
	
	public int countByCompanyId(long companyId) {
		return taskGroupPersistence.countByCompanyId(companyId);
	}
	
	public List<TaskGroup> findByCompanyId(long companyId){
		return taskGroupPersistence.findByCompanyId(companyId);
	}
	
	public int countByCompanyId_Active(long companyId, boolean active) {
		return taskGroupPersistence.countByCompanyId_Active(companyId, active);
	}
	
	public List<TaskGroup> findByCompanyId_Active(long companyId, boolean active){
		return taskGroupPersistence.findByCompanyId_Active(companyId, active);
	}
	
	public int countByActive(boolean active) {
		return taskGroupPersistence.countByActive(active);
	}
	
	public List<TaskGroup> findByActive(boolean active) {
		return taskGroupPersistence.findByActive(active);
	}
	
	public int countByBaseSearch(long companyId, long groupId, int active, String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return taskGroupFinder.countByBaseSearch(companyId, groupId, active, name, code, 
				description, andOperator);
	}
	
	public List<TaskGroup> findByBaseSearch(long companyId, long groupId, int active, 
			String name, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return taskGroupFinder.findByBaseSearch(companyId, groupId, active, 
				name, code, description, andOperator, start,
				end, obc);
	}
}