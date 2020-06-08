create index IX_ACEBDB67 on nss_taskcategory_currency (active_);
create index IX_4C48D620 on nss_taskcategory_currency (code_[$COLUMN_LENGTH:75$]);
create index IX_CBD664C3 on nss_taskcategory_currency (companyId, active_);

create index IX_2F348FDF on nss_taskcategory_investor (companyId);

create index IX_56066634 on nss_taskcategory_taskgroup (active_);
create index IX_4C31B02D on nss_taskcategory_taskgroup (code_[$COLUMN_LENGTH:75$]);
create index IX_3AE307D6 on nss_taskcategory_taskgroup (companyId, active_);

create index IX_67D6A8C1 on nss_taskcategory_taskstatus (active_);
create index IX_425B31FA on nss_taskcategory_taskstatus (code_[$COLUMN_LENGTH:75$]);
create index IX_F08D9B29 on nss_taskcategory_taskstatus (companyId, active_);

create index IX_9AACC879 on nss_taskcategory_tasktype (active_);
create index IX_FD25DFB2 on nss_taskcategory_tasktype (code_[$COLUMN_LENGTH:75$]);
create index IX_C6ACF871 on nss_taskcategory_tasktype (companyId, active_);