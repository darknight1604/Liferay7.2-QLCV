package com.nss.commoncategory.model;

public class AddressDTO {
	private long classNameId;
	private long classPK;
	
	private long countryId;
	private long cityId;
	private long districtId;
	private long wardId;
	private long streetId;
	private String streetOther;
	private String quarter;
	private String houseNumber;
	private String building;
	private String floor;
	private String room;
	private int type;
	
	public AddressDTO(Address address) {
		this.classNameId = address.getClassNameId();
		this.classPK = address.getClassPK();
		this.countryId = address.getCountryId();
		this.cityId = address.getCityId();
		this.districtId = address.getDistrictId();
		this.wardId = address.getWardId();
		this.streetId = address.getStreetId();
		this.streetOther = address.getStreetOther();
		this.quarter = address.getQuarter();
		this.houseNumber = address.getHouseNumber();
		this.building = address.getBuilding();
		this.floor = address.getFloor();
		this.room = address.getRoom();
		this.type = address.getType();
	}
	
	public AddressDTO(long classNameId, long classPK, long countryId, long cityId, long districtId, long wardId,
			long streetId, String streetOther, String quarter, String houseNumber, String building, String floor,
			String room, int type) {
		super();
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.countryId = countryId;
		this.cityId = cityId;
		this.districtId = districtId;
		this.wardId = wardId;
		this.streetId = streetId;
		this.streetOther = streetOther;
		this.quarter = quarter;
		this.houseNumber = houseNumber;
		this.building = building;
		this.floor = floor;
		this.room = room;
		this.type = type;
	}

	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}

	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getWardId() {
		return wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public long getStreetId() {
		return streetId;
	}

	public void setStreetId(long streetId) {
		this.streetId = streetId;
	}

	public String getStreetOther() {
		return streetOther;
	}

	public void setStreetOther(String streetOther) {
		this.streetOther = streetOther;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
