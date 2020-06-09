-- LƯU Ý: FILE ĐƯỢC SẮP XẾP THEO THỜI GIAN GIẢM DẦN
--@Author: tanhq
--@CreateDate: 08/06/2020
create table nss_taskcategory_investor (
	investorId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(255) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	phoneNumber varchar(75) null,
	email varchar(75) null
);
create index IX_2F348FDF on nss_taskcategory_investor (companyId);

create table nss_taskcategory_currency (
	currencyId bigint not null primary key,
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

create index IX_ACEBDB67 on nss_taskcategory_currency (active_);
create index IX_4C48D620 on nss_taskcategory_currency (code_);
create index IX_CBD664C3 on nss_taskcategory_currency (companyId, active_);
ALTER TABLE nss_taskcategory_investor ADD COLUMN active_ BOOL default true;
--@Author: tanhq
--@CreateDate: 05/06/2020
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
create index IX_56066634 on nss_taskcategory_taskgroup (active_);
create index IX_4C31B02D on nss_taskcategory_taskgroup (code_);
create index IX_3AE307D6 on nss_taskcategory_taskgroup (companyId, active_);
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

create index IX_67D6A8C1 on nss_taskcategory_taskstatus (active_);
create index IX_425B31FA on nss_taskcategory_taskstatus (code_);
create index IX_F08D9B29 on nss_taskcategory_taskstatus (companyId, active_);

create index IX_9AACC879 on nss_taskcategory_tasktype (active_);
create index IX_FD25DFB2 on nss_taskcategory_tasktype (code_);
create index IX_C6ACF871 on nss_taskcategory_tasktype (companyId, active_);