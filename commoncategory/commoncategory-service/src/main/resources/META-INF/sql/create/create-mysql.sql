drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_DAD4EAEA on nss_platform_continent (active_);
create index IX_3D25EA63 on nss_platform_continent (code_);
create index IX_B0E4477E on nss_platform_continent (name);

create index IX_82472A88 on nss_platform_country (active_);
create index IX_64BF7981 on nss_platform_country (code_);
create index IX_BA6D5CA0 on nss_platform_country (name);


