/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.oracly.accounts.payable.data.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oracly.accounts.payable.data.model.Payable;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Payable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Payable
 * @generated
 */
@ProviderType
public class PayableCacheModel implements CacheModel<Payable>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayableCacheModel)) {
			return false;
		}

		PayableCacheModel payableCacheModel = (PayableCacheModel)obj;

		if (payableId == payableCacheModel.payableId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payableId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", payableId=");
		sb.append(payableId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", description=");
		sb.append(description);
		sb.append(", path=");
		sb.append(path);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", flag=");
		sb.append(flag);
		sb.append(", supplierName=");
		sb.append(supplierName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Payable toEntityModel() {
		PayableImpl payableImpl = new PayableImpl();

		if (uuid == null) {
			payableImpl.setUuid(StringPool.BLANK);
		}
		else {
			payableImpl.setUuid(uuid);
		}

		payableImpl.setPayableId(payableId);
		payableImpl.setGroupId(groupId);
		payableImpl.setCompanyId(companyId);
		payableImpl.setUserId(userId);

		if (userName == null) {
			payableImpl.setUserName(StringPool.BLANK);
		}
		else {
			payableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			payableImpl.setCreateDate(null);
		}
		else {
			payableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payableImpl.setModifiedDate(null);
		}
		else {
			payableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			payableImpl.setDueDate(null);
		}
		else {
			payableImpl.setDueDate(new Date(dueDate));
		}

		payableImpl.setAmount(amount);

		if (description == null) {
			payableImpl.setDescription(StringPool.BLANK);
		}
		else {
			payableImpl.setDescription(description);
		}

		if (path == null) {
			payableImpl.setPath(StringPool.BLANK);
		}
		else {
			payableImpl.setPath(path);
		}

		payableImpl.setDocumentId(documentId);
		payableImpl.setFlag(flag);

		if (supplierName == null) {
			payableImpl.setSupplierName(StringPool.BLANK);
		}
		else {
			payableImpl.setSupplierName(supplierName);
		}

		payableImpl.resetOriginalValues();

		return payableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		payableId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dueDate = objectInput.readLong();

		amount = objectInput.readDouble();
		description = objectInput.readUTF();
		path = objectInput.readUTF();

		documentId = objectInput.readLong();

		flag = objectInput.readInt();
		supplierName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(payableId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dueDate);

		objectOutput.writeDouble(amount);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeLong(documentId);

		objectOutput.writeInt(flag);

		if (supplierName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplierName);
		}
	}

	public String uuid;
	public long payableId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dueDate;
	public double amount;
	public String description;
	public String path;
	public long documentId;
	public int flag;
	public String supplierName;
}