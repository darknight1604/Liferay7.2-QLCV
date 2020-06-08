create table nss_taskcategory_investor (
	investorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(255) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(255) null,
	code_ VARCHAR(75) null,
	priority INTEGER,
	active_ BOOLEAN,
	description STRING null
);

create table nss_taskcategory_taskgroup (
	taskGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(255) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(255) null,
	code_ VARCHAR(75) null,
	priority INTEGER,
	active_ BOOLEAN,
	description STRING null
);

create table nss_taskcategory_taskstatus (
	taskStatusId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(255) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(255) null,
	code_ VARCHAR(75) null,
	priority INTEGER,
	active_ BOOLEAN,
	description STRING null
);

create table nss_taskcategory_tasktype (
	taskTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	priority INTEGER,
	active_ BOOLEAN,
	description VARCHAR(75) null
);