create index IX_2249504B on nss_commoncategory_address (classNameId, classPK, type_);
create index IX_764D0B53 on nss_commoncategory_address (companyId);

create index IX_9CA81A73 on nss_commoncategory_city (active_);
create index IX_BFE1682C on nss_commoncategory_city (code_);
create index IX_AB1CFBBE on nss_commoncategory_city (countryId, active_);
create index IX_211E072A on nss_commoncategory_city (countryId, name);

create index IX_BD02D5F4 on nss_commoncategory_continent (active_);
create index IX_13070FED on nss_commoncategory_continent (code_);
create index IX_1AE348B4 on nss_commoncategory_continent (name);

create index IX_58285012 on nss_commoncategory_country (active_);
create index IX_3EE0798B on nss_commoncategory_country (code_);
create index IX_3873356 on nss_commoncategory_country (name);

create index IX_6906F0 on nss_commoncategory_district (active_);
create index IX_D652EF56 on nss_commoncategory_district (cityId, active_);
create index IX_A25E7A92 on nss_commoncategory_district (cityId, name);
create index IX_7AFD4FE9 on nss_commoncategory_district (code_);

create index IX_1AFE121B on nss_commoncategory_street (active_);
create index IX_642B9F81 on nss_commoncategory_street (cityId, active_);
create index IX_F2129D4 on nss_commoncategory_street (code_);
create index IX_34B8CE3E on nss_commoncategory_street (districtId, active_);
create index IX_69F9AA10 on nss_commoncategory_street (wardId, active_);
create index IX_D6AE4A18 on nss_commoncategory_street (wardId, name);

create index IX_14457CC2 on nss_commoncategory_ward (active_);
create index IX_F0C1123B on nss_commoncategory_ward (code_);
create index IX_53AA7665 on nss_commoncategory_ward (districtId, active_);
create index IX_382FE5E3 on nss_commoncategory_ward (districtId, name);

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
