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
