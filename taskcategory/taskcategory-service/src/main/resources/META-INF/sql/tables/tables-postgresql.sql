create table nss_taskcategory_taskgroup (
	taskGroupId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ bool,
	description text null
);

create table nss_taskcategory_taskstatus (
	taskStatusId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ bool,
	description text null
);

create table nss_taskcategory_tasktype (
	taskTypeId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	code_ varchar(75) null,
	priority integer,
	active_ bool,
	description text null
);
