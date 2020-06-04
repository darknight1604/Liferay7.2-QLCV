create table nss_platform_city (
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
	description longvarchar null,
	priority int,
	active_ bit,
	countCode int
);

create table nss_platform_continent (
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
	description longvarchar null,
	priority int,
	active_ bit,
	countCode int
);

create table nss_platform_country (
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
	description longvarchar null,
	priority int,
	active_ bit,
	countCode int
);

create table nss_platform_district (
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
	description longvarchar null,
	priority int,
	active_ bit,
	countCode int
);

create table nss_platform_street (
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
	description longvarchar null,
	priority int,
	active_ bit,
	countCode int
);

create table nss_platform_ward (
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
	description longvarchar null,
	priority int,
	active_ bit,
	countCode int
);
