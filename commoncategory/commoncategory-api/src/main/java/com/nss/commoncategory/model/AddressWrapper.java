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
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
@ProviderType
public class AddressWrapper
	extends BaseModelWrapper<Address>
	implements Address, ModelWrapper<Address> {

	public AddressWrapper(Address address) {
		super(address);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("countryId", getCountryId());
		attributes.put("cityId", getCityId());
		attributes.put("districtId", getDistrictId());
		attributes.put("wardId", getWardId());
		attributes.put("streetId", getStreetId());
		attributes.put("streetOther", getStreetOther());
		attributes.put("quarter", getQuarter());
		attributes.put("houseNumber", getHouseNumber());
		attributes.put("building", getBuilding());
		attributes.put("floor", getFloor());
		attributes.put("room", getRoom());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
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

		Long wardId = (Long)attributes.get("wardId");

		if (wardId != null) {
			setWardId(wardId);
		}

		Long streetId = (Long)attributes.get("streetId");

		if (streetId != null) {
			setStreetId(streetId);
		}

		String streetOther = (String)attributes.get("streetOther");

		if (streetOther != null) {
			setStreetOther(streetOther);
		}

		String quarter = (String)attributes.get("quarter");

		if (quarter != null) {
			setQuarter(quarter);
		}

		String houseNumber = (String)attributes.get("houseNumber");

		if (houseNumber != null) {
			setHouseNumber(houseNumber);
		}

		String building = (String)attributes.get("building");

		if (building != null) {
			setBuilding(building);
		}

		String floor = (String)attributes.get("floor");

		if (floor != null) {
			setFloor(floor);
		}

		String room = (String)attributes.get("room");

		if (room != null) {
			setRoom(room);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the building of this address.
	 *
	 * @return the building of this address
	 */
	@Override
	public String getBuilding() {
		return model.getBuilding();
	}

	/**
	 * Returns the city ID of this address.
	 *
	 * @return the city ID of this address
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the fully qualified class name of this address.
	 *
	 * @return the fully qualified class name of this address
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class name ID of this address.
	 *
	 * @return the class name ID of this address
	 */
	@Override
	public long getClassNameId() {
		return model.getClassNameId();
	}

	/**
	 * Returns the class pk of this address.
	 *
	 * @return the class pk of this address
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this address.
	 *
	 * @return the company ID of this address
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country ID of this address.
	 *
	 * @return the country ID of this address
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this address.
	 *
	 * @return the create date of this address
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district ID of this address.
	 *
	 * @return the district ID of this address
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	/**
	 * Returns the floor of this address.
	 *
	 * @return the floor of this address
	 */
	@Override
	public String getFloor() {
		return model.getFloor();
	}

	/**
	 * Returns the group ID of this address.
	 *
	 * @return the group ID of this address
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the house number of this address.
	 *
	 * @return the house number of this address
	 */
	@Override
	public String getHouseNumber() {
		return model.getHouseNumber();
	}

	/**
	 * Returns the modified date of this address.
	 *
	 * @return the modified date of this address
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quarter of this address.
	 *
	 * @return the quarter of this address
	 */
	@Override
	public String getQuarter() {
		return model.getQuarter();
	}

	/**
	 * Returns the room of this address.
	 *
	 * @return the room of this address
	 */
	@Override
	public String getRoom() {
		return model.getRoom();
	}

	/**
	 * Returns the street ID of this address.
	 *
	 * @return the street ID of this address
	 */
	@Override
	public long getStreetId() {
		return model.getStreetId();
	}

	/**
	 * Returns the street other of this address.
	 *
	 * @return the street other of this address
	 */
	@Override
	public String getStreetOther() {
		return model.getStreetOther();
	}

	/**
	 * Returns the type of this address.
	 *
	 * @return the type of this address
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this address.
	 *
	 * @return the user ID of this address
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this address.
	 *
	 * @return the user name of this address
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this address.
	 *
	 * @return the user uuid of this address
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the ward ID of this address.
	 *
	 * @return the ward ID of this address
	 */
	@Override
	public long getWardId() {
		return model.getWardId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the building of this address.
	 *
	 * @param building the building of this address
	 */
	@Override
	public void setBuilding(String building) {
		model.setBuilding(building);
	}

	/**
	 * Sets the city ID of this address.
	 *
	 * @param cityId the city ID of this address
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class name ID of this address.
	 *
	 * @param classNameId the class name ID of this address
	 */
	@Override
	public void setClassNameId(long classNameId) {
		model.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this address.
	 *
	 * @param classPK the class pk of this address
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this address.
	 *
	 * @param companyId the company ID of this address
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country ID of this address.
	 *
	 * @param countryId the country ID of this address
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this address.
	 *
	 * @param createDate the create date of this address
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district ID of this address.
	 *
	 * @param districtId the district ID of this address
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the floor of this address.
	 *
	 * @param floor the floor of this address
	 */
	@Override
	public void setFloor(String floor) {
		model.setFloor(floor);
	}

	/**
	 * Sets the group ID of this address.
	 *
	 * @param groupId the group ID of this address
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the house number of this address.
	 *
	 * @param houseNumber the house number of this address
	 */
	@Override
	public void setHouseNumber(String houseNumber) {
		model.setHouseNumber(houseNumber);
	}

	/**
	 * Sets the modified date of this address.
	 *
	 * @param modifiedDate the modified date of this address
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quarter of this address.
	 *
	 * @param quarter the quarter of this address
	 */
	@Override
	public void setQuarter(String quarter) {
		model.setQuarter(quarter);
	}

	/**
	 * Sets the room of this address.
	 *
	 * @param room the room of this address
	 */
	@Override
	public void setRoom(String room) {
		model.setRoom(room);
	}

	/**
	 * Sets the street ID of this address.
	 *
	 * @param streetId the street ID of this address
	 */
	@Override
	public void setStreetId(long streetId) {
		model.setStreetId(streetId);
	}

	/**
	 * Sets the street other of this address.
	 *
	 * @param streetOther the street other of this address
	 */
	@Override
	public void setStreetOther(String streetOther) {
		model.setStreetOther(streetOther);
	}

	/**
	 * Sets the type of this address.
	 *
	 * @param type the type of this address
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this address.
	 *
	 * @param userId the user ID of this address
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this address.
	 *
	 * @param userName the user name of this address
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this address.
	 *
	 * @param userUuid the user uuid of this address
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the ward ID of this address.
	 *
	 * @param wardId the ward ID of this address
	 */
	@Override
	public void setWardId(long wardId) {
		model.setWardId(wardId);
	}

	@Override
	protected AddressWrapper wrap(Address address) {
		return new AddressWrapper(address);
	}

}