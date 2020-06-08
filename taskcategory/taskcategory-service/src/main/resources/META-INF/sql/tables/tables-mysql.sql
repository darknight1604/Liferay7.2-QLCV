create table nss_taskcategory_currency (
	currencyId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ tinyint,
	description longtext null
) engine InnoDB;

create table nss_taskcategory_investor (
	investorId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(75) null,
	phoneNumber varchar(75) null,
	email varchar(75) null
) engine InnoDB;

create table nss_taskcategory_taskgroup (
	taskGroupId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ tinyint,
	description longtext null
) engine InnoDB;

create table nss_taskcategory_taskstatus (
	taskStatusId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ tinyint,
	description longtext null
) engine InnoDB;

create table nss_taskcategory_tasktype (
	taskTypeId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(75) null,
	code_ varchar(75) null,
	priority integer,
	active_ tinyint,
	description varchar(75) null
) engine InnoDB;
