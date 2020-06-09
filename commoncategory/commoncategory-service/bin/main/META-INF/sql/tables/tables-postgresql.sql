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
	description text null,
	priority integer,
	active_ bool,
	countCode integer
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
	description text null,
	priority integer,
	active_ bool,
	countCode integer
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
	description text null,
	priority integer,
	active_ bool,
	countCode integer
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
	description text null,
	priority integer,
	active_ bool,
	countCode integer
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
	description text null,
	priority integer,
	active_ bool,
	countCode integer
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
	description text null,
	priority integer,
	active_ bool,
	countCode integer
);
