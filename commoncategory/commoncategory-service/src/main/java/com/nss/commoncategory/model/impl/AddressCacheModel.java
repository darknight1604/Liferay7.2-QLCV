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

import com.nss.commoncategory.model.Address;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AddressCacheModel implements CacheModel<Address>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressCacheModel)) {
			return false;
		}

		AddressCacheModel addressCacheModel = (AddressCacheModel)obj;

		if (addressId == addressCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{addressId=");
		sb.append(addressId);
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
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", cityId=");
		sb.append(cityId);
		sb.append(", districtId=");
		sb.append(districtId);
		sb.append(", wardId=");
		sb.append(wardId);
		sb.append(", streetId=");
		sb.append(streetId);
		sb.append(", streetOther=");
		sb.append(streetOther);
		sb.append(", quarter=");
		sb.append(quarter);
		sb.append(", houseNumber=");
		sb.append(houseNumber);
		sb.append(", building=");
		sb.append(building);
		sb.append(", floor=");
		sb.append(floor);
		sb.append(", room=");
		sb.append(room);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(addressId);
		addressImpl.setGroupId(groupId);
		addressImpl.setCompanyId(companyId);
		addressImpl.setUserId(userId);

		if (userName == null) {
			addressImpl.setUserName("");
		}
		else {
			addressImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			addressImpl.setCreateDate(null);
		}
		else {
			addressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			addressImpl.setModifiedDate(null);
		}
		else {
			addressImpl.setModifiedDate(new Date(modifiedDate));
		}

		addressImpl.setClassNameId(classNameId);
		addressImpl.setClassPK(classPK);
		addressImpl.setCountryId(countryId);
		addressImpl.setCityId(cityId);
		addressImpl.setDistrictId(districtId);
		addressImpl.setWardId(wardId);
		addressImpl.setStreetId(streetId);

		if (streetOther == null) {
			addressImpl.setStreetOther("");
		}
		else {
			addressImpl.setStreetOther(streetOther);
		}

		if (quarter == null) {
			addressImpl.setQuarter("");
		}
		else {
			addressImpl.setQuarter(quarter);
		}

		if (houseNumber == null) {
			addressImpl.setHouseNumber("");
		}
		else {
			addressImpl.setHouseNumber(houseNumber);
		}

		if (building == null) {
			addressImpl.setBuilding("");
		}
		else {
			addressImpl.setBuilding(building);
		}

		if (floor == null) {
			addressImpl.setFloor("");
		}
		else {
			addressImpl.setFloor(floor);
		}

		if (room == null) {
			addressImpl.setRoom("");
		}
		else {
			addressImpl.setRoom(room);
		}

		addressImpl.setType(type);

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		countryId = objectInput.readLong();

		cityId = objectInput.readLong();

		districtId = objectInput.readLong();

		wardId = objectInput.readLong();

		streetId = objectInput.readLong();
		streetOther = objectInput.readUTF();
		quarter = objectInput.readUTF();
		houseNumber = objectInput.readUTF();
		building = objectInput.readUTF();
		floor = objectInput.readUTF();
		room = objectInput.readUTF();

		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addressId);

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

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeLong(countryId);

		objectOutput.writeLong(cityId);

		objectOutput.writeLong(districtId);

		objectOutput.writeLong(wardId);

		objectOutput.writeLong(streetId);

		if (streetOther == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(streetOther);
		}

		if (quarter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quarter);
		}

		if (houseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(houseNumber);
		}

		if (building == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(building);
		}

		if (floor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(floor);
		}

		if (room == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(room);
		}

		objectOutput.writeInt(type);
	}

	public long addressId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public long countryId;
	public long cityId;
	public long districtId;
	public long wardId;
	public long streetId;
	public String streetOther;
	public String quarter;
	public String houseNumber;
	public String building;
	public String floor;
	public String room;
	public int type;

}