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

import com.nss.commoncategory.model.Country;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Country in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CountryCacheModel implements CacheModel<Country>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CountryCacheModel)) {
			return false;
		}

		CountryCacheModel countryCacheModel = (CountryCacheModel)obj;

		if (countryId == countryCacheModel.countryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, countryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{countryId=");
		sb.append(countryId);
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
		sb.append(", continentId=");
		sb.append(continentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", internationalName=");
		sb.append(internationalName);
		sb.append(", nationality=");
		sb.append(nationality);
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
	public Country toEntityModel() {
		CountryImpl countryImpl = new CountryImpl();

		countryImpl.setCountryId(countryId);
		countryImpl.setCompanyId(companyId);
		countryImpl.setGroupId(groupId);
		countryImpl.setUserId(userId);

		if (userName == null) {
			countryImpl.setUserName("");
		}
		else {
			countryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			countryImpl.setCreateDate(null);
		}
		else {
			countryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			countryImpl.setModifiedDate(null);
		}
		else {
			countryImpl.setModifiedDate(new Date(modifiedDate));
		}

		countryImpl.setContinentId(continentId);

		if (name == null) {
			countryImpl.setName("");
		}
		else {
			countryImpl.setName(name);
		}

		if (internationalName == null) {
			countryImpl.setInternationalName("");
		}
		else {
			countryImpl.setInternationalName(internationalName);
		}

		if (nationality == null) {
			countryImpl.setNationality("");
		}
		else {
			countryImpl.setNationality(nationality);
		}

		if (code == null) {
			countryImpl.setCode("");
		}
		else {
			countryImpl.setCode(code);
		}

		if (description == null) {
			countryImpl.setDescription("");
		}
		else {
			countryImpl.setDescription(description);
		}

		countryImpl.setPriority(priority);
		countryImpl.setActive(active);
		countryImpl.setCountCode(countCode);

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		continentId = objectInput.readLong();
		name = objectInput.readUTF();
		internationalName = objectInput.readUTF();
		nationality = objectInput.readUTF();
		code = objectInput.readUTF();
		description = objectInput.readUTF();

		priority = objectInput.readInt();

		active = objectInput.readBoolean();

		countCode = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(countryId);

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

		objectOutput.writeLong(continentId);

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

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
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

	public long countryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long continentId;
	public String name;
	public String internationalName;
	public String nationality;
	public String code;
	public String description;
	public int priority;
	public boolean active;
	public int countCode;

}