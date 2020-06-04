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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Ward service. Represents a row in the &quot;nss_platform_ward&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.nss.commoncategory.model.impl.WardModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.nss.commoncategory.model.impl.WardImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ward
 * @generated
 */
@ProviderType
public interface WardModel extends BaseModel<Ward>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ward model instance should use the {@link Ward} interface instead.
	 */

	/**
	 * Returns the primary key of this ward.
	 *
	 * @return the primary key of this ward
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ward.
	 *
	 * @param primaryKey the primary key of this ward
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ward ID of this ward.
	 *
	 * @return the ward ID of this ward
	 */
	public long getWardId();

	/**
	 * Sets the ward ID of this ward.
	 *
	 * @param wardId the ward ID of this ward
	 */
	public void setWardId(long wardId);

	/**
	 * Returns the company ID of this ward.
	 *
	 * @return the company ID of this ward
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ward.
	 *
	 * @param companyId the company ID of this ward
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this ward.
	 *
	 * @return the group ID of this ward
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this ward.
	 *
	 * @param groupId the group ID of this ward
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this ward.
	 *
	 * @return the user ID of this ward
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ward.
	 *
	 * @param userId the user ID of this ward
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ward.
	 *
	 * @return the user uuid of this ward
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ward.
	 *
	 * @param userUuid the user uuid of this ward
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ward.
	 *
	 * @return the user name of this ward
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ward.
	 *
	 * @param userName the user name of this ward
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ward.
	 *
	 * @return the create date of this ward
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ward.
	 *
	 * @param createDate the create date of this ward
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ward.
	 *
	 * @return the modified date of this ward
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ward.
	 *
	 * @param modifiedDate the modified date of this ward
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this ward.
	 *
	 * @return the name of this ward
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this ward.
	 *
	 * @param name the name of this ward
	 */
	public void setName(String name);

	/**
	 * Returns the code of this ward.
	 *
	 * @return the code of this ward
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this ward.
	 *
	 * @param code the code of this ward
	 */
	public void setCode(String code);

	/**
	 * Returns the country ID of this ward.
	 *
	 * @return the country ID of this ward
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this ward.
	 *
	 * @param countryId the country ID of this ward
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the city ID of this ward.
	 *
	 * @return the city ID of this ward
	 */
	public long getCityId();

	/**
	 * Sets the city ID of this ward.
	 *
	 * @param cityId the city ID of this ward
	 */
	public void setCityId(long cityId);

	/**
	 * Returns the district ID of this ward.
	 *
	 * @return the district ID of this ward
	 */
	public long getDistrictId();

	/**
	 * Sets the district ID of this ward.
	 *
	 * @param districtId the district ID of this ward
	 */
	public void setDistrictId(long districtId);

	/**
	 * Returns the description of this ward.
	 *
	 * @return the description of this ward
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this ward.
	 *
	 * @param description the description of this ward
	 */
	public void setDescription(String description);

	/**
	 * Returns the priority of this ward.
	 *
	 * @return the priority of this ward
	 */
	public int getPriority();

	/**
	 * Sets the priority of this ward.
	 *
	 * @param priority the priority of this ward
	 */
	public void setPriority(int priority);

	/**
	 * Returns the active of this ward.
	 *
	 * @return the active of this ward
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this ward is active.
	 *
	 * @return <code>true</code> if this ward is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this ward is active.
	 *
	 * @param active the active of this ward
	 */
	public void setActive(boolean active);

	/**
	 * Returns the count code of this ward.
	 *
	 * @return the count code of this ward
	 */
	public int getCountCode();

	/**
	 * Sets the count code of this ward.
	 *
	 * @param countCode the count code of this ward
	 */
	public void setCountCode(int countCode);

}