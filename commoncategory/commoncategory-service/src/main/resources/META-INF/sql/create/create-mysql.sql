drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_538E43BD on nss_platform_city (active_);
create index IX_2BF55BF6 on nss_platform_city (code_);
create index IX_754D0034 on nss_platform_city (countryId, active_);
create index IX_63934674 on nss_platform_city (countryId, name);

create index IX_DAD4EAEA on nss_platform_continent (active_);
create index IX_3D25EA63 on nss_platform_continent (code_);
create index IX_B0E4477E on nss_platform_continent (name);

create index IX_82472A88 on nss_platform_country (active_);
create index IX_64BF7981 on nss_platform_country (code_);
create index IX_BA6D5CA0 on nss_platform_country (name);

create index IX_1A257B3A on nss_platform_district (active_);
create index IX_522379A0 on nss_platform_district (cityId, active_);
create index IX_AE912488 on nss_platform_district (cityId, name);
create index IX_10FE4EB3 on nss_platform_district (code_);

create index IX_B0FF10E5 on nss_platform_street (active_);
create index IX_DE4E344B on nss_platform_street (cityId, active_);
create index IX_C607531E on nss_platform_street (code_);
create index IX_FE8FEE08 on nss_platform_street (districtId, active_);
create index IX_E41C3EDA on nss_platform_street (wardId, active_);
create index IX_C84EF98E on nss_platform_street (wardId, name);

create index IX_CB2BA60C on nss_platform_ward (active_);
create index IX_5CD50605 on nss_platform_ward (code_);
create index IX_CF7B00AF on nss_platform_ward (districtId, active_);
create index IX_44628FD9 on nss_platform_ward (districtId, name);


