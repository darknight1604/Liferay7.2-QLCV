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

package com.nss.commoncategory.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.nss.commoncategory.model.Continent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Continent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ContinentCacheModel
	implements CacheModel<Continent>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContinentCacheModel)) {
			return false;
		}

		ContinentCacheModel continentCacheModel = (ContinentCacheModel)obj;

		if (continentId == continentCacheModel.continentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, continentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{continentId=");
		sb.append(continentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", internationalName=");
		sb.append(internationalName);
		sb.append(", code=");
		sb.append(code);
		sb.append(", description=");
		sb.append(description);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", active=");
		sb.append(active);
		sb.append(", countCode=");
		sb.append(countCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Continent toEntityModel() {
		ContinentImpl continentImpl = new ContinentImpl();

		continentImpl.setContinentId(continentId);
		continentImpl.setCompanyId(companyId);
		continentImpl.setGroupId(groupId);
		continentImpl.setUserId(userId);

		if (userName == null) {
			continentImpl.setUserName("");
		}
		else {
			continentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			continentImpl.setCreateDate(null);
		}
		else {
			continentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			continentImpl.setModifiedDate(null);
		}
		else {
			continentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			continentImpl.setName("");
		}
		else {
			continentImpl.setName(name);
		}

		if (internationalName == null) {
			continentImpl.setInternationalName("");
		}
		else {
			continentImpl.setInternationalName(internationalName);
		}

		if (code == null) {
			continentImpl.setCode("");
		}
		else {
			continentImpl.setCode(code);
		}

		if (description == null) {
			continentImpl.setDescription("");
		}
		else {
			continentImpl.setDescription(description);
		}

		continentImpl.setPriority(priority);
		continentImpl.setActive(active);
		continentImpl.setCountCode(countCode);

		continentImpl.resetOriginalValues();

		return continentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		continentId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		internationalName = objectInput.readUTF();
		code = objectInput.readUTF();
		description = objectInput.readUTF();

		priority = objectInput.readInt();

		active = objectInput.readBoolean();

		countCode = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(continentId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

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

		if (internationalName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(internationalName);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(priority);

		objectOutput.writeBoolean(active);

		objectOutput.writeInt(countCode);
	}

	public long continentId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String internationalName;
	public String code;
	public String description;
	public int priority;
	public boolean active;
	public int countCode;

}