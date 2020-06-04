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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Ward}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ward
 * @generated
 */
@ProviderType
public class WardWrapper
	extends BaseModelWrapper<Ward> implements Ward, ModelWrapper<Ward> {

	public WardWrapper(Ward ward) {
		super(ward);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wardId", getWardId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("countryId", getCountryId());
		attributes.put("cityId", getCityId());
		attributes.put("districtId", getDistrictId());
		attributes.put("description", getDescription());
		attributes.put("priority", getPriority());
		attributes.put("active", isActive());
		attributes.put("countCode", getCountCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wardId = (Long)attributes.get("wardId");

		if (wardId != null) {
			setWardId(wardId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		Long districtId = (Long)attributes.get("districtId");

		if (districtId != null) {
			setDistrictId(districtId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Integer countCode = (Integer)attributes.get("countCode");

		if (countCode != null) {
			setCountCode(countCode);
		}
	}

	/**
	 * Returns the active of this ward.
	 *
	 * @return the active of this ward
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	@Override
	public City getCity() {
		return model.getCity();
	}

	/**
	 * Returns the city ID of this ward.
	 *
	 * @return the city ID of this ward
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the code of this ward.
	 *
	 * @return the code of this ward
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this ward.
	 *
	 * @return the company ID of this ward
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count code of this ward.
	 *
	 * @return the count code of this ward
	 */
	@Override
	public int getCountCode() {
		return model.getCountCode();
	}

	@Override
	public Country getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the country ID of this ward.
	 *
	 * @return the country ID of this ward
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this ward.
	 *
	 * @return the create date of this ward
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this ward.
	 *
	 * @return the description of this ward
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	@Override
	public District getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the district ID of this ward.
	 *
	 * @return the district ID of this ward
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	/**
	 * Returns the group ID of this ward.
	 *
	 * @return the group ID of this ward
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this ward.
	 *
	 * @return the modified date of this ward
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this ward.
	 *
	 * @return the name of this ward
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this ward.
	 *
	 * @return the primary key of this ward
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this ward.
	 *
	 * @return the priority of this ward
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the user ID of this ward.
	 *
	 * @return the user ID of this ward
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ward.
	 *
	 * @return the user name of this ward
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ward.
	 *
	 * @return the user uuid of this ward
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the ward ID of this ward.
	 *
	 * @return the ward ID of this ward
	 */
	@Override
	public long getWardId() {
		return model.getWardId();
	}

	/**
	 * Returns <code>true</code> if this ward is active.
	 *
	 * @return <code>true</code> if this ward is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this ward is active.
	 *
	 * @param active the active of this ward
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the city ID of this ward.
	 *
	 * @param cityId the city ID of this ward
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	/**
	 * Sets the code of this ward.
	 *
	 * @param code the code of this ward
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this ward.
	 *
	 * @param companyId the company ID of this ward
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count code of this ward.
	 *
	 * @param countCode the count code of this ward
	 */
	@Override
	public void setCountCode(int countCode) {
		model.setCountCode(countCode);
	}

	/**
	 * Sets the country ID of this ward.
	 *
	 * @param countryId the country ID of this ward
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this ward.
	 *
	 * @param createDate the create date of this ward
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this ward.
	 *
	 * @param description the description of this ward
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the district ID of this ward.
	 *
	 * @param districtId the district ID of this ward
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the group ID of this ward.
	 *
	 * @param groupId the group ID of this ward
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this ward.
	 *
	 * @param modifiedDate the modified date of this ward
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this ward.
	 *
	 * @param name the name of this ward
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this ward.
	 *
	 * @param primaryKey the primary key of this ward
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this ward.
	 *
	 * @param priority the priority of this ward
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the user ID of this ward.
	 *
	 * @param userId the user ID of this ward
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ward.
	 *
	 * @param userName the user name of this ward
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ward.
	 *
	 * @param userUuid the user uuid of this ward
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the ward ID of this ward.
	 *
	 * @param wardId the ward ID of this ward
	 */
	@Override
	public void setWardId(long wardId) {
		model.setWardId(wardId);
	}

	@Override
	protected WardWrapper wrap(Ward ward) {
		return new WardWrapper(ward);
	}

}