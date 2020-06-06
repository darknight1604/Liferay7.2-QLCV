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
import com.nss.taskcategory.model.TaskType;
import com.nss.taskcategory.service.base.TaskTypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.TaskTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.taskcategory.model.TaskType",
	service = AopService.class
)
public class TaskTypeLocalServiceImpl extends TaskTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.taskcategory.service.TaskTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.TaskTypeLocalServiceUtil</code>.
	 */
	public TaskType addTaskType(long userId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateTaskTypeByCode(0, code);
		
		long taskTypeId = counterLocalService.increment(TaskType.class.getName());
		TaskType taskType = createTaskType(taskTypeId);
		User user = UserLocalServiceUtil.fetchUser(userId);
		Date now = new Date();
		
		if(user != null) {
			taskType.setUserId(userId);
			taskType.setUserName(user.getFullName());
		}
		
		taskType.setModifiedDate(now);
		taskType.setCreateDate(now);
		taskType.setCompanyId(serviceContext.getCompanyId());
		taskType.setGroupId(serviceContext.getScopeGroupId());
		
		taskType.setName(name);
		taskType.setCode(code);
		taskType.setPriority(priority);
		taskType.setActive(active);
		taskType.setDescription(description);
		taskType.setExpandoBridgeAttributes(serviceContext);
		
		addTaskType(taskType);
		
		return taskType;
	}
	
	public TaskType updateTaskType(long taskTypeId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateTaskTypeByCode(taskTypeId, code);
		TaskType taskType = fetchTaskType(taskTypeId);
		Date now = new Date();
		taskType.setModifiedDate(now);
		
		taskType.setName(name);
		taskType.setCode(code);
		taskType.setPriority(priority);
		taskType.setActive(active);
		taskType.setDescription(description);
		taskType.setExpandoBridgeAttributes(serviceContext);
		
		updateTaskType(taskType);
		
		return taskType;
	}
	
	public TaskType fetchByCode(String code) {
		return taskTypePersistence.fetchByCode(code);
	}
	
	private void _validateTaskTypeByCode(long taskTypeId, String code) throws PortalException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		if (Validator.isNotNull(code)) {
			TaskType taskType = fetchByCode(code);
			if (taskType != null && taskType.getTaskTypeId() != taskTypeId) {
				throw new DuplicateCodeException();
			}
		}
	}
	
	public int countByCompanyId(long companyId) {
		return taskTypePersistence.countByCompanyId(companyId);
	}
	
	public List<TaskType> findByCompanyId(long companyId){
		return taskTypePersistence.findByCompanyId(companyId);
	}
	
	public int countByCompanyId_Active(long companyId, boolean active) {
		return taskTypePersistence.countByCompanyId_Active(companyId, active);
	}
	
	public List<TaskType> findByCompanyId_Active(long companyId, boolean active){
		return taskTypePersistence.findByCompanyId_Active(companyId, active);
	}
	
	public int countByActive(boolean active) {
		return taskTypePersistence.countByActive(active);
	}
	
	public List<TaskType> findByActive(boolean active) {
		return taskTypePersistence.findByActive(active);
	}
	
	public int countByBaseSearch(long companyId, long groupId, int active, String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return taskTypeFinder.countByBaseSearch(companyId, groupId, active, name, code, 
				description, andOperator);
	}
	
	public List<TaskType> findByBaseSearch(long companyId, long groupId, int active, 
			String name, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return taskTypeFinder.findByBaseSearch(companyId, groupId, active, 
				name, code, description, andOperator, start,
				end, obc);
	}
}