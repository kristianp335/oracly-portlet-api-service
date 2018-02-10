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

package com.liferay.oracly.accounts.payable.data.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Payable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Payable
 * @generated
 */
@ProviderType
public class PayableWrapper implements Payable, ModelWrapper<Payable> {
	public PayableWrapper(Payable payable) {
		_payable = payable;
	}

	@Override
	public Class<?> getModelClass() {
		return Payable.class;
	}

	@Override
	public String getModelClassName() {
		return Payable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("payableId", getPayableId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("amount", getAmount());
		attributes.put("description", getDescription());
		attributes.put("path", getPath());
		attributes.put("documentId", getDocumentId());
		attributes.put("flag", getFlag());
		attributes.put("supplierName", getSupplierName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long payableId = (Long)attributes.get("payableId");

		if (payableId != null) {
			setPayableId(payableId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Integer flag = (Integer)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}

		String supplierName = (String)attributes.get("supplierName");

		if (supplierName != null) {
			setSupplierName(supplierName);
		}
	}

	@Override
	public Payable toEscapedModel() {
		return new PayableWrapper(_payable.toEscapedModel());
	}

	@Override
	public Payable toUnescapedModel() {
		return new PayableWrapper(_payable.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _payable.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _payable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _payable.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _payable.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Payable> toCacheModel() {
		return _payable.toCacheModel();
	}

	@Override
	public int compareTo(Payable payable) {
		return _payable.compareTo(payable);
	}

	/**
	* Returns the flag of this payable.
	*
	* @return the flag of this payable
	*/
	@Override
	public int getFlag() {
		return _payable.getFlag();
	}

	@Override
	public int hashCode() {
		return _payable.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payable.getPrimaryKeyObj();
	}

	/**
	* Returns the amount of this payable.
	*
	* @return the amount of this payable
	*/
	@Override
	public java.lang.Double getAmount() {
		return _payable.getAmount();
	}

	@Override
	public java.lang.Object clone() {
		return new PayableWrapper((Payable)_payable.clone());
	}

	/**
	* Returns the description of this payable.
	*
	* @return the description of this payable
	*/
	@Override
	public java.lang.String getDescription() {
		return _payable.getDescription();
	}

	/**
	* Returns the path of this payable.
	*
	* @return the path of this payable
	*/
	@Override
	public java.lang.String getPath() {
		return _payable.getPath();
	}

	/**
	* Returns the supplier name of this payable.
	*
	* @return the supplier name of this payable
	*/
	@Override
	public java.lang.String getSupplierName() {
		return _payable.getSupplierName();
	}

	/**
	* Returns the user name of this payable.
	*
	* @return the user name of this payable
	*/
	@Override
	public java.lang.String getUserName() {
		return _payable.getUserName();
	}

	/**
	* Returns the user uuid of this payable.
	*
	* @return the user uuid of this payable
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _payable.getUserUuid();
	}

	/**
	* Returns the uuid of this payable.
	*
	* @return the uuid of this payable
	*/
	@Override
	public java.lang.String getUuid() {
		return _payable.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _payable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _payable.toXmlString();
	}

	/**
	* Returns the create date of this payable.
	*
	* @return the create date of this payable
	*/
	@Override
	public Date getCreateDate() {
		return _payable.getCreateDate();
	}

	/**
	* Returns the due date of this payable.
	*
	* @return the due date of this payable
	*/
	@Override
	public Date getDueDate() {
		return _payable.getDueDate();
	}

	/**
	* Returns the modified date of this payable.
	*
	* @return the modified date of this payable
	*/
	@Override
	public Date getModifiedDate() {
		return _payable.getModifiedDate();
	}

	/**
	* Returns the company ID of this payable.
	*
	* @return the company ID of this payable
	*/
	@Override
	public long getCompanyId() {
		return _payable.getCompanyId();
	}

	/**
	* Returns the document ID of this payable.
	*
	* @return the document ID of this payable
	*/
	@Override
	public long getDocumentId() {
		return _payable.getDocumentId();
	}

	/**
	* Returns the group ID of this payable.
	*
	* @return the group ID of this payable
	*/
	@Override
	public long getGroupId() {
		return _payable.getGroupId();
	}

	/**
	* Returns the payable ID of this payable.
	*
	* @return the payable ID of this payable
	*/
	@Override
	public long getPayableId() {
		return _payable.getPayableId();
	}

	/**
	* Returns the primary key of this payable.
	*
	* @return the primary key of this payable
	*/
	@Override
	public long getPrimaryKey() {
		return _payable.getPrimaryKey();
	}

	/**
	* Returns the user ID of this payable.
	*
	* @return the user ID of this payable
	*/
	@Override
	public long getUserId() {
		return _payable.getUserId();
	}

	@Override
	public void persist() {
		_payable.persist();
	}

	/**
	* Sets the amount of this payable.
	*
	* @param amount the amount of this payable
	*/
	@Override
	public void setAmount(java.lang.Double amount) {
		_payable.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payable.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this payable.
	*
	* @param companyId the company ID of this payable
	*/
	@Override
	public void setCompanyId(long companyId) {
		_payable.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this payable.
	*
	* @param createDate the create date of this payable
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_payable.setCreateDate(createDate);
	}

	/**
	* Sets the description of this payable.
	*
	* @param description the description of this payable
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_payable.setDescription(description);
	}

	/**
	* Sets the document ID of this payable.
	*
	* @param documentId the document ID of this payable
	*/
	@Override
	public void setDocumentId(long documentId) {
		_payable.setDocumentId(documentId);
	}

	/**
	* Sets the due date of this payable.
	*
	* @param dueDate the due date of this payable
	*/
	@Override
	public void setDueDate(Date dueDate) {
		_payable.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_payable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_payable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_payable.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flag of this payable.
	*
	* @param flag the flag of this payable
	*/
	@Override
	public void setFlag(int flag) {
		_payable.setFlag(flag);
	}

	/**
	* Sets the group ID of this payable.
	*
	* @param groupId the group ID of this payable
	*/
	@Override
	public void setGroupId(long groupId) {
		_payable.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this payable.
	*
	* @param modifiedDate the modified date of this payable
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_payable.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_payable.setNew(n);
	}

	/**
	* Sets the path of this payable.
	*
	* @param path the path of this payable
	*/
	@Override
	public void setPath(java.lang.String path) {
		_payable.setPath(path);
	}

	/**
	* Sets the payable ID of this payable.
	*
	* @param payableId the payable ID of this payable
	*/
	@Override
	public void setPayableId(long payableId) {
		_payable.setPayableId(payableId);
	}

	/**
	* Sets the primary key of this payable.
	*
	* @param primaryKey the primary key of this payable
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_payable.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the supplier name of this payable.
	*
	* @param supplierName the supplier name of this payable
	*/
	@Override
	public void setSupplierName(java.lang.String supplierName) {
		_payable.setSupplierName(supplierName);
	}

	/**
	* Sets the user ID of this payable.
	*
	* @param userId the user ID of this payable
	*/
	@Override
	public void setUserId(long userId) {
		_payable.setUserId(userId);
	}

	/**
	* Sets the user name of this payable.
	*
	* @param userName the user name of this payable
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_payable.setUserName(userName);
	}

	/**
	* Sets the user uuid of this payable.
	*
	* @param userUuid the user uuid of this payable
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_payable.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this payable.
	*
	* @param uuid the uuid of this payable
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_payable.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayableWrapper)) {
			return false;
		}

		PayableWrapper payableWrapper = (PayableWrapper)obj;

		if (Objects.equals(_payable, payableWrapper._payable)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _payable.getStagedModelType();
	}

	@Override
	public Payable getWrappedModel() {
		return _payable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _payable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _payable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_payable.resetOriginalValues();
	}

	private final Payable _payable;
}