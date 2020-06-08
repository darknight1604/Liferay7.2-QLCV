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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Investor service. Represents a row in the &quot;nss_taskcategory_investor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.nss.taskcategory.model.impl.InvestorModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.nss.taskcategory.model.impl.InvestorImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Investor
 * @generated
 */
@ProviderType
public interface InvestorModel
	extends BaseModel<Investor>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a investor model instance should use the {@link Investor} interface instead.
	 */

	/**
	 * Returns the primary key of this investor.
	 *
	 * @return the primary key of this investor
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this investor.
	 *
	 * @param primaryKey the primary key of this investor
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the investor ID of this investor.
	 *
	 * @return the investor ID of this investor
	 */
	public long getInvestorId();

	/**
	 * Sets the investor ID of this investor.
	 *
	 * @param investorId the investor ID of this investor
	 */
	public void setInvestorId(long investorId);

	/**
	 * Returns the group ID of this investor.
	 *
	 * @return the group ID of this investor
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this investor.
	 *
	 * @param groupId the group ID of this investor
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this investor.
	 *
	 * @return the company ID of this investor
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this investor.
	 *
	 * @param companyId the company ID of this investor
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this investor.
	 *
	 * @return the user ID of this investor
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this investor.
	 *
	 * @param userId the user ID of this investor
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this investor.
	 *
	 * @return the user uuid of this investor
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this investor.
	 *
	 * @param userUuid the user uuid of this investor
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this investor.
	 *
	 * @return the user name of this investor
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this investor.
	 *
	 * @param userName the user name of this investor
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this investor.
	 *
	 * @return the create date of this investor
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this investor.
	 *
	 * @param createDate the create date of this investor
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this investor.
	 *
	 * @return the modified date of this investor
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this investor.
	 *
	 * @param modifiedDate the modified date of this investor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this investor.
	 *
	 * @return the name of this investor
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this investor.
	 *
	 * @param name the name of this investor
	 */
	public void setName(String name);

	/**
	 * Returns the phone number of this investor.
	 *
	 * @return the phone number of this investor
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this investor.
	 *
	 * @param phoneNumber the phone number of this investor
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the email of this investor.
	 *
	 * @return the email of this investor
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this investor.
	 *
	 * @param email the email of this investor
	 */
	public void setEmail(String email);

}