-- LƯU Ý: FILE ĐƯỢC SẮP XẾP THEO THỜI GIAN TĂNG DẦN

--@Author: tanhq
--@CreateDate: 04/06/2020
create table nss_commoncategory_address (
	addressId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	wardId bigint,
	streetId bigint,
	streetOther varchar(255) null,
	quarter varchar(255) null,
	houseNumber varchar(75) null,
	building varchar(255) null,
	floor varchar(75) null,
	room varchar(75) null,
	type_ integer
);

create table nss_commoncategory_city (
	cityId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);

create table nss_commoncategory_continent (
	continentId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	internationalName varchar(255) null,
	code_ varchar(75) null,
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);

create table nss_commoncategory_country (
	countryId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	continentId bigint,
	name varchar(255) null,
	internationalName varchar(255) null,
	nationality varchar(255) null,
	code_ varchar(75) null,
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);

create table nss_commoncategory_district (
	districtId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);

create table nss_commoncategory_street (
	streetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	wardId bigint,
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);

create table nss_commoncategory_ward (
	wardId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);

create index IX_2249504B on nss_commoncategory_address (classNameId, classPK, type_);
create index IX_764D0B53 on nss_commoncategory_address (companyId);

create index IX_9CA81A73 on nss_commoncategory_city (active_);
create index IX_BFE1682C on nss_commoncategory_city (code_);
create index IX_AB1CFBBE on nss_commoncategory_city (countryId, active_);
create index IX_211E072A on nss_commoncategory_city (countryId, name);

create index IX_BD02D5F4 on nss_commoncategory_continent (active_);
create index IX_13070FED on nss_commoncategory_continent (code_);
create index IX_1AE348B4 on nss_commoncategory_continent (name);

create index IX_58285012 on nss_commoncategory_country (active_);
create index IX_3EE0798B on nss_commoncategory_country (code_);
create index IX_3873356 on nss_commoncategory_country (name);

create index IX_6906F0 on nss_commoncategory_district (active_);
create index IX_D652EF56 on nss_commoncategory_district (cityId, active_);
create index IX_A25E7A92 on nss_commoncategory_district (cityId, name);
create index IX_7AFD4FE9 on nss_commoncategory_district (code_);

create index IX_1AFE121B on nss_commoncategory_street (active_);
create index IX_642B9F81 on nss_commoncategory_street (cityId, active_);
create index IX_F2129D4 on nss_commoncategory_street (code_);
create index IX_34B8CE3E on nss_commoncategory_street (districtId, active_);
create index IX_69F9AA10 on nss_commoncategory_street (wardId, active_);
create index IX_D6AE4A18 on nss_commoncategory_street (wardId, name);

create index IX_14457CC2 on nss_commoncategory_ward (active_);
create index IX_F0C1123B on nss_commoncategory_ward (code_);
create index IX_53AA7665 on nss_commoncategory_ward (districtId, active_);
create index IX_382FE5E3 on nss_commoncategory_ward (districtId, name);