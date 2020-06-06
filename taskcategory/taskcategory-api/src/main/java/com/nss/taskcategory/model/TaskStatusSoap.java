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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.nss.taskcategory.service.http.TaskStatusServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaskStatusSoap implements Serializable {

	public static TaskStatusSoap toSoapModel(TaskStatus model) {
		TaskStatusSoap soapModel = new TaskStatusSoap();

		soapModel.setTaskStatusId(model.getTaskStatusId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setPriority(model.getPriority());
		soapModel.setActive(model.isActive());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static TaskStatusSoap[] toSoapModels(TaskStatus[] models) {
		TaskStatusSoap[] soapModels = new TaskStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskStatusSoap[][] toSoapModels(TaskStatus[][] models) {
		TaskStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskStatusSoap[] toSoapModels(List<TaskStatus> models) {
		List<TaskStatusSoap> soapModels = new ArrayList<TaskStatusSoap>(
			models.size());

		for (TaskStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskStatusSoap[soapModels.size()]);
	}

	public TaskStatusSoap() {
	}

	public long getPrimaryKey() {
		return _taskStatusId;
	}

	public void setPrimaryKey(long pk) {
		setTaskStatusId(pk);
	}

	public long getTaskStatusId() {
		return _taskStatusId;
	}

	public void setTaskStatusId(long taskStatusId) {
		_taskStatusId = taskStatusId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _taskStatusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _code;
	private int _priority;
	private boolean _active;
	private String _description;

}