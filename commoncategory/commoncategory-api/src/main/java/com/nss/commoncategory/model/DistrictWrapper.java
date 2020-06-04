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
 * This class is a wrapper for {@link District}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see District
 * @generated
 */
@ProviderType
public class DistrictWrapper
	extends BaseModelWrapper<District>
	implements District, ModelWrapper<District> {

	public DistrictWrapper(District district) {
		super(district);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("districtId", getDistrictId());
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
		attributes.put("description", getDescription());
		attributes.put("priority", getPriority());
		attributes.put("active", isActive());
		attributes.put("countCode", getCountCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long districtId = (Long)attributes.get("districtId");

		if (districtId != null) {
			setDistrictId(districtId);
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
	 * Returns the active of this district.
	 *
	 * @return the active of this district
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
	 * Returns the city ID of this district.
	 *
	 * @return the city ID of this district
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the code of this district.
	 *
	 * @return the code of this district
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this district.
	 *
	 * @return the company ID of this district
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count code of this district.
	 *
	 * @return the count code of this district
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
	 * Returns the country ID of this district.
	 *
	 * @return the country ID of this district
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this district.
	 *
	 * @return the create date of this district
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this district.
	 *
	 * @return the description of this district
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the district ID of this district.
	 *
	 * @return the district ID of this district
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	/**
	 * Returns the group ID of this district.
	 *
	 * @return the group ID of this district
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this district.
	 *
	 * @return the modified date of this district
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this district.
	 *
	 * @return the name of this district
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this district.
	 *
	 * @return the primary key of this district
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this district.
	 *
	 * @return the priority of this district
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the user ID of this district.
	 *
	 * @return the user ID of this district
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this district.
	 *
	 * @return the user name of this district
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this district.
	 *
	 * @return the user uuid of this district
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this district is active.
	 *
	 * @return <code>true</code> if this district is active; <code>false</code> otherwise
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
	 * Sets whether this district is active.
	 *
	 * @param active the active of this district
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the city ID of this district.
	 *
	 * @param cityId the city ID of this district
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	/**
	 * Sets the code of this district.
	 *
	 * @param code the code of this district
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this district.
	 *
	 * @param companyId the company ID of this district
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count code of this district.
	 *
	 * @param countCode the count code of this district
	 */
	@Override
	public void setCountCode(int countCode) {
		model.setCountCode(countCode);
	}

	/**
	 * Sets the country ID of this district.
	 *
	 * @param countryId the country ID of this district
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this district.
	 *
	 * @param createDate the create date of this district
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this district.
	 *
	 * @param description the description of this district
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the district ID of this district.
	 *
	 * @param districtId the district ID of this district
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the group ID of this district.
	 *
	 * @param groupId the group ID of this district
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this district.
	 *
	 * @param modifiedDate the modified date of this district
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this district.
	 *
	 * @param name the name of this district
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this district.
	 *
	 * @param primaryKey the primary key of this district
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this district.
	 *
	 * @param priority the priority of this district
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the user ID of this district.
	 *
	 * @param userId the user ID of this district
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this district.
	 *
	 * @param userName the user name of this district
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this district.
	 *
	 * @param userUuid the user uuid of this district
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DistrictWrapper wrap(District district) {
		return new DistrictWrapper(district);
	}

}