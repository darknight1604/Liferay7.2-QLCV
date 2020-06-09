create table nss_commoncategory_address (
	addressId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
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
) engine InnoDB;

create table nss_commoncategory_city (
	cityId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_commoncategory_continent (
	continentId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	internationalName varchar(255) null,
	code_ varchar(75) null,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_commoncategory_country (
	countryId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	continentId bigint,
	name varchar(255) null,
	internationalName varchar(255) null,
	nationality varchar(255) null,
	code_ varchar(75) null,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_commoncategory_district (
	districtId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_commoncategory_street (
	streetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	wardId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_commoncategory_ward (
	wardId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_platform_city (
	cityId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_platform_continent (
	continentId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	internationalName varchar(255) null,
	code_ varchar(75) null,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_platform_country (
	countryId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	continentId bigint,
	name varchar(255) null,
	internationalName varchar(255) null,
	nationality varchar(255) null,
	code_ varchar(75) null,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_platform_district (
	districtId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_platform_street (
	streetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	wardId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;

create table nss_platform_ward (
	wardId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	countryId bigint,
	cityId bigint,
	districtId bigint,
	description longtext null,
	priority integer,
	active_ tinyint,
	countCode integer
) engine InnoDB;
