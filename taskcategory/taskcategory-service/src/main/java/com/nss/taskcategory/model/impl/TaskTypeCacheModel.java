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

package com.nss.taskcategory.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.nss.taskcategory.model.TaskType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TaskType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaskTypeCacheModel
	implements CacheModel<TaskType>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskTypeCacheModel)) {
			return false;
		}

		TaskTypeCacheModel taskTypeCacheModel = (TaskTypeCacheModel)obj;

		if (taskTypeId == taskTypeCacheModel.taskTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{taskTypeId=");
		sb.append(taskTypeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", active=");
		sb.append(active);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskType toEntityModel() {
		TaskTypeImpl taskTypeImpl = new TaskTypeImpl();

		taskTypeImpl.setTaskTypeId(taskTypeId);
		taskTypeImpl.setGroupId(groupId);
		taskTypeImpl.setCompanyId(companyId);
		taskTypeImpl.setUserId(userId);

		if (userName == null) {
			taskTypeImpl.setUserName("");
		}
		else {
			taskTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taskTypeImpl.setCreateDate(null);
		}
		else {
			taskTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskTypeImpl.setModifiedDate(null);
		}
		else {
			taskTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			taskTypeImpl.setName("");
		}
		else {
			taskTypeImpl.setName(name);
		}

		if (code == null) {
			taskTypeImpl.setCode("");
		}
		else {
			taskTypeImpl.setCode(code);
		}

		taskTypeImpl.setPriority(priority);
		taskTypeImpl.setActive(active);

		if (description == null) {
			taskTypeImpl.setDescription("");
		}
		else {
			taskTypeImpl.setDescription(description);
		}

		taskTypeImpl.resetOriginalValues();

		return taskTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		priority = objectInput.readInt();

		active = objectInput.readBoolean();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taskTypeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(priority);

		objectOutput.writeBoolean(active);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long taskTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
	public int priority;
	public boolean active;
	public String description;

}