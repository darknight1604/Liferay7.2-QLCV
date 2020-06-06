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
	userName varchar(255) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ tinyint,
	description longtext null
) engine InnoDB;
