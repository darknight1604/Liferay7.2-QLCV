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

package com.nss.commoncategory.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AddressSoap implements Serializable {

	public static AddressSoap toSoapModel(Address model) {
		AddressSoap soapModel = new AddressSoap();

		soapModel.setAddressId(model.getAddressId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCityId(model.getCityId());
		soapModel.setDistrictId(model.getDistrictId());
		soapModel.setWardId(model.getWardId());
		soapModel.setStreetId(model.getStreetId());
		soapModel.setStreetOther(model.getStreetOther());
		soapModel.setQuarter(model.getQuarter());
		soapModel.setHouseNumber(model.getHouseNumber());
		soapModel.setBuilding(model.getBuilding());
		soapModel.setFloor(model.getFloor());
		soapModel.setRoom(model.getRoom());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static AddressSoap[] toSoapModels(Address[] models) {
		AddressSoap[] soapModels = new AddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressSoap[][] toSoapModels(Address[][] models) {
		AddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressSoap[] toSoapModels(List<Address> models) {
		List<AddressSoap> soapModels = new ArrayList<AddressSoap>(
			models.size());

		for (Address model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressSoap[soapModels.size()]);
	}

	public AddressSoap() {
	}

	public long getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(long pk) {
		setAddressId(pk);
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public long getDistrictId() {
		return _districtId;
	}

	public void setDistrictId(long districtId) {
		_districtId = districtId;
	}

	public long getWardId() {
		return _wardId;
	}

	public void setWardId(long wardId) {
		_wardId = wardId;
	}

	public long getStreetId() {
		return _streetId;
	}

	public void setStreetId(long streetId) {
		_streetId = streetId;
	}

	public String getStreetOther() {
		return _streetOther;
	}

	public void setStreetOther(String streetOther) {
		_streetOther = streetOther;
	}

	public String getQuarter() {
		return _quarter;
	}

	public void setQuarter(String quarter) {
		_quarter = quarter;
	}

	public String getHouseNumber() {
		return _houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		_houseNumber = houseNumber;
	}

	public String getBuilding() {
		return _building;
	}

	public void setBuilding(String building) {
		_building = building;
	}

	public String getFloor() {
		return _floor;
	}

	public void setFloor(String floor) {
		_floor = floor;
	}

	public String getRoom() {
		return _room;
	}

	public void setRoom(String room) {
		_room = room;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _addressId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _countryId;
	private long _cityId;
	private long _districtId;
	private long _wardId;
	private long _streetId;
	private String _streetOther;
	private String _quarter;
	private String _houseNumber;
	private String _building;
	private String _floor;
	private String _room;
	private int _type;

}