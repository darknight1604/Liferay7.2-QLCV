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
import com.nss.taskcategory.model.TaskStatus;
import com.nss.taskcategory.service.base.TaskStatusLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task status local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.service.TaskStatusLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.nss.taskcategory.model.TaskStatus",
	service = AopService.class
)
public class TaskStatusLocalServiceImpl extends TaskStatusLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.nss.taskcategory.service.TaskStatusLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.TaskStatusLocalServiceUtil</code>.
	 */
	public TaskStatus addTaskStatus(long userId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateTaskStatusByCode(0, code);
		
		long taskStatusId = counterLocalService.increment(TaskStatus.class.getName());
		TaskStatus taskStatus = createTaskStatus(taskStatusId);
		User user = UserLocalServiceUtil.fetchUser(userId);
		Date now = new Date();
		
		if(user != null) {
			taskStatus.setUserId(userId);
			taskStatus.setUserName(user.getFullName());
		}
		
		taskStatus.setModifiedDate(now);
		taskStatus.setCreateDate(now);
		taskStatus.setCompanyId(serviceContext.getCompanyId());
		taskStatus.setGroupId(serviceContext.getScopeGroupId());
		
		taskStatus.setName(name);
		taskStatus.setCode(code);
		taskStatus.setPriority(priority);
		taskStatus.setActive(active);
		taskStatus.setDescription(description);
		taskStatus.setExpandoBridgeAttributes(serviceContext);
		
		addTaskStatus(taskStatus);
		
		return taskStatus;
	}
	
	public TaskStatus updateTaskStatus(long taskStatusId, String name, 
			String code, int priority, boolean active, String description, ServiceContext serviceContext) throws PortalException {
		_validateTaskStatusByCode(taskStatusId, code);
		TaskStatus taskStatus = fetchTaskStatus(taskStatusId);
		Date now = new Date();
		taskStatus.setModifiedDate(now);
		
		taskStatus.setName(name);
		taskStatus.setCode(code);
		taskStatus.setPriority(priority);
		taskStatus.setActive(active);
		taskStatus.setDescription(description);
		taskStatus.setExpandoBridgeAttributes(serviceContext);
		
		updateTaskStatus(taskStatus);
		
		return taskStatus;
	}
	
	public TaskStatus fetchByCode(String code) {
		return taskStatusPersistence.fetchByCode(code);
	}
	
	private void _validateTaskStatusByCode(long taskStatusId, String code) throws PortalException {
		if (Validator.isNull(code)) {
			throw new EmptyCodeException();
		}
		if (Validator.isNotNull(code)) {
			TaskStatus taskStatus = fetchByCode(code);
			if (taskStatus != null && taskStatus.getTaskStatusId() != taskStatusId) {
				throw new DuplicateCodeException();
			}
		}
	}
	
	public int countByCompanyId(long companyId) {
		return taskStatusPersistence.countByCompanyId(companyId);
	}
	
	public List<TaskStatus> findByCompanyId(long companyId){
		return taskStatusPersistence.findByCompanyId(companyId);
	}
	
	public int countByCompanyId_Active(long companyId, boolean active) {
		return taskStatusPersistence.countByCompanyId_Active(companyId, active);
	}
	
	public List<TaskStatus> findByCompanyId_Active(long companyId, boolean active){
		return taskStatusPersistence.findByCompanyId_Active(companyId, active);
	}
	
	public int countByActive(boolean active) {
		return taskStatusPersistence.countByActive(active);
	}
	
	public List<TaskStatus> findByActive(boolean active) {
		return taskStatusPersistence.findByActive(active);
	}
	
	public int countByBaseSearch(long companyId, long groupId, int active, String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return taskStatusFinder.countByBaseSearch(companyId, groupId, active, name, code, 
				description, andOperator);
	}
	
	public List<TaskStatus> findByBaseSearch(long companyId, long groupId, int active, 
			String name, String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return taskStatusFinder.findByBaseSearch(companyId, groupId, active, 
				name, code, description, andOperator, start,
				end, obc);
	}
}