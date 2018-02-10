create index IX_E70A7DA7 on Oracly_Payable (amount);
create index IX_899AEC0F on Oracly_Payable (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3DBD2A51 on Oracly_Payable (uuid_[$COLUMN_LENGTH:75$], groupId);