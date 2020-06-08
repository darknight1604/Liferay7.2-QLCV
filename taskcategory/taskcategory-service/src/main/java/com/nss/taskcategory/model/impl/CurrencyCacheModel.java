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

import com.nss.taskcategory.model.Currency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Currency in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CurrencyCacheModel
	implements CacheModel<Currency>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurrencyCacheModel)) {
			return false;
		}

		CurrencyCacheModel currencyCacheModel = (CurrencyCacheModel)obj;

		if (currencyId == currencyCacheModel.currencyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, currencyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{currencyId=");
		sb.append(currencyId);
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
	public Currency toEntityModel() {
		CurrencyImpl currencyImpl = new CurrencyImpl();

		currencyImpl.setCurrencyId(currencyId);
		currencyImpl.setGroupId(groupId);
		currencyImpl.setCompanyId(companyId);
		currencyImpl.setUserId(userId);

		if (userName == null) {
			currencyImpl.setUserName("");
		}
		else {
			currencyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			currencyImpl.setCreateDate(null);
		}
		else {
			currencyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			currencyImpl.setModifiedDate(null);
		}
		else {
			currencyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			currencyImpl.setName("");
		}
		else {
			currencyImpl.setName(name);
		}

		if (code == null) {
			currencyImpl.setCode("");
		}
		else {
			currencyImpl.setCode(code);
		}

		currencyImpl.setPriority(priority);
		currencyImpl.setActive(active);

		if (description == null) {
			currencyImpl.setDescription("");
		}
		else {
			currencyImpl.setDescription(description);
		}

		currencyImpl.resetOriginalValues();

		return currencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		currencyId = objectInput.readLong();

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
		objectOutput.writeLong(currencyId);

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

	public long currencyId;
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