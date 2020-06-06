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

package com.nss.taskcategory.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link TaskStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatus
 * @generated
 */
@ProviderType
public class TaskStatusWrapper
	extends BaseModelWrapper<TaskStatus>
	implements TaskStatus, ModelWrapper<TaskStatus> {

	public TaskStatusWrapper(TaskStatus taskStatus) {
		super(taskStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskStatusId", getTaskStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("priority", getPriority());
		attributes.put("active", isActive());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskStatusId = (Long)attributes.get("taskStatusId");

		if (taskStatusId != null) {
			setTaskStatusId(taskStatusId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the active of this task status.
	 *
	 * @return the active of this task status
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this task status.
	 *
	 * @return the code of this task status
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this task status.
	 *
	 * @return the company ID of this task status
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this task status.
	 *
	 * @return the create date of this task status
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this task status.
	 *
	 * @return the description of this task status
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this task status.
	 *
	 * @return the group ID of this task status
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this task status.
	 *
	 * @return the modified date of this task status
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this task status.
	 *
	 * @return the name of this task status
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this task status.
	 *
	 * @return the primary key of this task status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this task status.
	 *
	 * @return the priority of this task status
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the task status ID of this task status.
	 *
	 * @return the task status ID of this task status
	 */
	@Override
	public long getTaskStatusId() {
		return model.getTaskStatusId();
	}

	/**
	 * Returns the user ID of this task status.
	 *
	 * @return the user ID of this task status
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this task status.
	 *
	 * @return the user name of this task status
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this task status.
	 *
	 * @return the user uuid of this task status
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this task status is active.
	 *
	 * @return <code>true</code> if this task status is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this task status is active.
	 *
	 * @param active the active of this task status
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this task status.
	 *
	 * @param code the code of this task status
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this task status.
	 *
	 * @param companyId the company ID of this task status
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this task status.
	 *
	 * @param createDate the create date of this task status
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this task status.
	 *
	 * @param description the description of this task status
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this task status.
	 *
	 * @param groupId the group ID of this task status
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this task status.
	 *
	 * @param modifiedDate the modified date of this task status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this task status.
	 *
	 * @param name the name of this task status
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this task status.
	 *
	 * @param primaryKey the primary key of this task status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this task status.
	 *
	 * @param priority the priority of this task status
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the task status ID of this task status.
	 *
	 * @param taskStatusId the task status ID of this task status
	 */
	@Override
	public void setTaskStatusId(long taskStatusId) {
		model.setTaskStatusId(taskStatusId);
	}

	/**
	 * Sets the user ID of this task status.
	 *
	 * @param userId the user ID of this task status
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this task status.
	 *
	 * @param userName the user name of this task status
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this task status.
	 *
	 * @param userUuid the user uuid of this task status
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TaskStatusWrapper wrap(TaskStatus taskStatus) {
		return new TaskStatusWrapper(taskStatus);
	}

}