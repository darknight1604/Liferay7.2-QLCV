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
 * This class is used by SOAP remote services, specifically {@link com.nss.taskcategory.service.http.InvestorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class InvestorSoap implements Serializable {

	public static InvestorSoap toSoapModel(Investor model) {
		InvestorSoap soapModel = new InvestorSoap();

		soapModel.setInvestorId(model.getInvestorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static InvestorSoap[] toSoapModels(Investor[] models) {
		InvestorSoap[] soapModels = new InvestorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvestorSoap[][] toSoapModels(Investor[][] models) {
		InvestorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvestorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvestorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvestorSoap[] toSoapModels(List<Investor> models) {
		List<InvestorSoap> soapModels = new ArrayList<InvestorSoap>(
			models.size());

		for (Investor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvestorSoap[soapModels.size()]);
	}

	public InvestorSoap() {
	}

	public long getPrimaryKey() {
		return _investorId;
	}

	public void setPrimaryKey(long pk) {
		setInvestorId(pk);
	}

	public long getInvestorId() {
		return _investorId;
	}

	public void setInvestorId(long investorId) {
		_investorId = investorId;
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

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _investorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _phoneNumber;
	private String _email;

}