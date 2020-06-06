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

import com.nss.taskcategory.model.TaskStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TaskStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaskStatusCacheModel
	implements CacheModel<TaskStatus>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskStatusCacheModel)) {
			return false;
		}

		TaskStatusCacheModel taskStatusCacheModel = (TaskStatusCacheModel)obj;

		if (taskStatusId == taskStatusCacheModel.taskStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{taskStatusId=");
		sb.append(taskStatusId);
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
	public TaskStatus toEntityModel() {
		TaskStatusImpl taskStatusImpl = new TaskStatusImpl();

		taskStatusImpl.setTaskStatusId(taskStatusId);
		taskStatusImpl.setGroupId(groupId);
		taskStatusImpl.setCompanyId(companyId);
		taskStatusImpl.setUserId(userId);

		if (userName == null) {
			taskStatusImpl.setUserName("");
		}
		else {
			taskStatusImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taskStatusImpl.setCreateDate(null);
		}
		else {
			taskStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskStatusImpl.setModifiedDate(null);
		}
		else {
			taskStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			taskStatusImpl.setName("");
		}
		else {
			taskStatusImpl.setName(name);
		}

		if (code == null) {
			taskStatusImpl.setCode("");
		}
		else {
			taskStatusImpl.setCode(code);
		}

		taskStatusImpl.setPriority(priority);
		taskStatusImpl.setActive(active);

		if (description == null) {
			taskStatusImpl.setDescription("");
		}
		else {
			taskStatusImpl.setDescription(description);
		}

		taskStatusImpl.resetOriginalValues();

		return taskStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskStatusId = objectInput.readLong();

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
		objectOutput.writeLong(taskStatusId);

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

	public long taskStatusId;
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