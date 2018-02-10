create table Oracly_Payable (
	uuid_ VARCHAR(75) null,
	payableId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dueDate DATE null,
	amount DOUBLE,
	description VARCHAR(75) null,
	path_ VARCHAR(75) null,
	documentId LONG,
	flag INTEGER,
	supplierName VARCHAR(75) null
);