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
 * This class is used by SOAP remote services, specifically {@link com.nss.commoncategory.service.http.StreetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class StreetSoap implements Serializable {

	public static StreetSoap toSoapModel(Street model) {
		StreetSoap soapModel = new StreetSoap();

		soapModel.setStreetId(model.getStreetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCityId(model.getCityId());
		soapModel.setDistrictId(model.getDistrictId());
		soapModel.setWardId(model.getWardId());
		soapModel.setDescription(model.getDescription());
		soapModel.setPriority(model.getPriority());
		soapModel.setActive(model.isActive());
		soapModel.setCountCode(model.getCountCode());

		return soapModel;
	}

	public static StreetSoap[] toSoapModels(Street[] models) {
		StreetSoap[] soapModels = new StreetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StreetSoap[][] toSoapModels(Street[][] models) {
		StreetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StreetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StreetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StreetSoap[] toSoapModels(List<Street> models) {
		List<StreetSoap> soapModels = new ArrayList<StreetSoap>(models.size());

		for (Street model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StreetSoap[soapModels.size()]);
	}

	public StreetSoap() {
	}

	public long getPrimaryKey() {
		return _streetId;
	}

	public void setPrimaryKey(long pk) {
		setStreetId(pk);
	}

	public long getStreetId() {
		return _streetId;
	}

	public void setStreetId(long streetId) {
		_streetId = streetId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public int getCountCode() {
		return _countCode;
	}

	public void setCountCode(int countCode) {
		_countCode = countCode;
	}

	private long _streetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _code;
	private long _countryId;
	private long _cityId;
	private long _districtId;
	private long _wardId;
	private String _description;
	private int _priority;
	private boolean _active;
	private int _countCode;

}