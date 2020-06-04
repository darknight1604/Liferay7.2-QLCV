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

import com.nss.commoncategory.model.Ward;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Ward in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class WardCacheModel implements CacheModel<Ward>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WardCacheModel)) {
			return false;
		}

		WardCacheModel wardCacheModel = (WardCacheModel)obj;

		if (wardId == wardCacheModel.wardId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wardId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{wardId=");
		sb.append(wardId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", cityId=");
		sb.append(cityId);
		sb.append(", districtId=");
		sb.append(districtId);
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
	public Ward toEntityModel() {
		WardImpl wardImpl = new WardImpl();

		wardImpl.setWardId(wardId);
		wardImpl.setCompanyId(companyId);
		wardImpl.setGroupId(groupId);
		wardImpl.setUserId(userId);

		if (userName == null) {
			wardImpl.setUserName("");
		}
		else {
			wardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			wardImpl.setCreateDate(null);
		}
		else {
			wardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wardImpl.setModifiedDate(null);
		}
		else {
			wardImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			wardImpl.setName("");
		}
		else {
			wardImpl.setName(name);
		}

		if (code == null) {
			wardImpl.setCode("");
		}
		else {
			wardImpl.setCode(code);
		}

		wardImpl.setCountryId(countryId);
		wardImpl.setCityId(cityId);
		wardImpl.setDistrictId(districtId);

		if (description == null) {
			wardImpl.setDescription("");
		}
		else {
			wardImpl.setDescription(description);
		}

		wardImpl.setPriority(priority);
		wardImpl.setActive(active);
		wardImpl.setCountCode(countCode);

		wardImpl.resetOriginalValues();

		return wardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		wardId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		countryId = objectInput.readLong();

		cityId = objectInput.readLong();

		districtId = objectInput.readLong();
		description = objectInput.readUTF();

		priority = objectInput.readInt();

		active = objectInput.readBoolean();

		countCode = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(wardId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(countryId);

		objectOutput.writeLong(cityId);

		objectOutput.writeLong(districtId);

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

	public long wardId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
	public long countryId;
	public long cityId;
	public long districtId;
	public String description;
	public int priority;
	public boolean active;
	public int countCode;

}