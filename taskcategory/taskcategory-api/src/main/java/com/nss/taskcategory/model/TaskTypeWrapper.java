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
 * This class is a wrapper for {@link TaskType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskType
 * @generated
 */
@ProviderType
public class TaskTypeWrapper
	extends BaseModelWrapper<TaskType>
	implements TaskType, ModelWrapper<TaskType> {

	public TaskTypeWrapper(TaskType taskType) {
		super(taskType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskTypeId", getTaskTypeId());
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
		Long taskTypeId = (Long)attributes.get("taskTypeId");

		if (taskTypeId != null) {
			setTaskTypeId(taskTypeId);
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
	 * Returns the active of this task type.
	 *
	 * @return the active of this task type
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this task type.
	 *
	 * @return the code of this task type
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this task type.
	 *
	 * @return the company ID of this task type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this task type.
	 *
	 * @return the create date of this task type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this task type.
	 *
	 * @return the description of this task type
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this task type.
	 *
	 * @return the group ID of this task type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this task type.
	 *
	 * @return the modified date of this task type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this task type.
	 *
	 * @return the name of this task type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this task type.
	 *
	 * @return the primary key of this task type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this task type.
	 *
	 * @return the priority of this task type
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the task type ID of this task type.
	 *
	 * @return the task type ID of this task type
	 */
	@Override
	public long getTaskTypeId() {
		return model.getTaskTypeId();
	}

	/**
	 * Returns the user ID of this task type.
	 *
	 * @return the user ID of this task type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this task type.
	 *
	 * @return the user name of this task type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this task type.
	 *
	 * @return the user uuid of this task type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this task type is active.
	 *
	 * @return <code>true</code> if this task type is active; <code>false</code> otherwise
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
	 * Sets whether this task type is active.
	 *
	 * @param active the active of this task type
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this task type.
	 *
	 * @param code the code of this task type
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this task type.
	 *
	 * @param companyId the company ID of this task type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this task type.
	 *
	 * @param createDate the create date of this task type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this task type.
	 *
	 * @param description the description of this task type
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this task type.
	 *
	 * @param groupId the group ID of this task type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this task type.
	 *
	 * @param modifiedDate the modified date of this task type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this task type.
	 *
	 * @param name the name of this task type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this task type.
	 *
	 * @param primaryKey the primary key of this task type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this task type.
	 *
	 * @param priority the priority of this task type
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the task type ID of this task type.
	 *
	 * @param taskTypeId the task type ID of this task type
	 */
	@Override
	public void setTaskTypeId(long taskTypeId) {
		model.setTaskTypeId(taskTypeId);
	}

	/**
	 * Sets the user ID of this task type.
	 *
	 * @param userId the user ID of this task type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this task type.
	 *
	 * @param userName the user name of this task type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this task type.
	 *
	 * @param userUuid the user uuid of this task type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TaskTypeWrapper wrap(TaskType taskType) {
		return new TaskTypeWrapper(taskType);
	}

}