create table nss_platform_continent (
	continentId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(255) null,
	internationalName VARCHAR(255) null,
	code_ VARCHAR(75) null,
	description STRING null,
	priority INTEGER,
	active_ BOOLEAN,
	countCode INTEGER
);

create table nss_platform_country (
	countryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	continentId LONG,
	name VARCHAR(255) null,
	internationalName VARCHAR(255) null,
	nationality VARCHAR(255) null,
	code_ VARCHAR(75) null,
	description STRING null,
	priority INTEGER,
	active_ BOOLEAN,
	countCode INTEGER
);