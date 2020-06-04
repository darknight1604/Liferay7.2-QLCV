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
 * This class is a wrapper for {@link City}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see City
 * @generated
 */
@ProviderType
public class CityWrapper
	extends BaseModelWrapper<City> implements City, ModelWrapper<City> {

	public CityWrapper(City city) {
		super(city);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("countryId", getCountryId());
		attributes.put("description", getDescription());
		attributes.put("priority", getPriority());
		attributes.put("active", isActive());
		attributes.put("countCode", getCountCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
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
	 * Returns the active of this city.
	 *
	 * @return the active of this city
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the city ID of this city.
	 *
	 * @return the city ID of this city
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the code of this city.
	 *
	 * @return the code of this city
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this city.
	 *
	 * @return the company ID of this city
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count code of this city.
	 *
	 * @return the count code of this city
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
	 * Returns the country ID of this city.
	 *
	 * @return the country ID of this city
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this city.
	 *
	 * @return the create date of this city
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this city.
	 *
	 * @return the description of this city
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this city.
	 *
	 * @return the group ID of this city
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this city.
	 *
	 * @return the modified date of this city
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this city.
	 *
	 * @return the name of this city
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this city.
	 *
	 * @return the primary key of this city
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this city.
	 *
	 * @return the priority of this city
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the user ID of this city.
	 *
	 * @return the user ID of this city
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this city.
	 *
	 * @return the user name of this city
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this city.
	 *
	 * @return the user uuid of this city
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this city is active.
	 *
	 * @return <code>true</code> if this city is active; <code>false</code> otherwise
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
	 * Sets whether this city is active.
	 *
	 * @param active the active of this city
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the city ID of this city.
	 *
	 * @param cityId the city ID of this city
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	/**
	 * Sets the code of this city.
	 *
	 * @param code the code of this city
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this city.
	 *
	 * @param companyId the company ID of this city
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count code of this city.
	 *
	 * @param countCode the count code of this city
	 */
	@Override
	public void setCountCode(int countCode) {
		model.setCountCode(countCode);
	}

	/**
	 * Sets the country ID of this city.
	 *
	 * @param countryId the country ID of this city
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this city.
	 *
	 * @param createDate the create date of this city
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this city.
	 *
	 * @param description the description of this city
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this city.
	 *
	 * @param groupId the group ID of this city
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this city.
	 *
	 * @param modifiedDate the modified date of this city
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this city.
	 *
	 * @param name the name of this city
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this city.
	 *
	 * @param primaryKey the primary key of this city
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this city.
	 *
	 * @param priority the priority of this city
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the user ID of this city.
	 *
	 * @param userId the user ID of this city
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this city.
	 *
	 * @param userName the user name of this city
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this city.
	 *
	 * @param userUuid the user uuid of this city
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CityWrapper wrap(City city) {
		return new CityWrapper(city);
	}

}