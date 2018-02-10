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

package com.liferay.oracly.accounts.payable.data.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PayableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayableLocalService
 * @generated
 */
@ProviderType
public class PayableLocalServiceWrapper implements PayableLocalService,
	ServiceWrapper<PayableLocalService> {
	public PayableLocalServiceWrapper(PayableLocalService payableLocalService) {
		_payableLocalService = payableLocalService;
	}

	/**
	* Adds the payable to the database. Also notifies the appropriate model listeners.
	*
	* @param payable the payable
	* @return the payable that was added
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable addPayable(
		com.liferay.oracly.accounts.payable.data.model.Payable payable) {
		return _payableLocalService.addPayable(payable);
	}

	/**
	* Creates a new payable with the primary key. Does not add the payable to the database.
	*
	* @param payableId the primary key for the new payable
	* @return the new payable
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable createPayable(
		long payableId) {
		return _payableLocalService.createPayable(payableId);
	}

	/**
	* Deletes the payable from the database. Also notifies the appropriate model listeners.
	*
	* @param payable the payable
	* @return the payable that was removed
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable deletePayable(
		com.liferay.oracly.accounts.payable.data.model.Payable payable) {
		return _payableLocalService.deletePayable(payable);
	}

	/**
	* Deletes the payable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payableId the primary key of the payable
	* @return the payable that was removed
	* @throws PortalException if a payable with the primary key could not be found
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable deletePayable(
		long payableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payableLocalService.deletePayable(payableId);
	}

	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable fetchPayable(
		long payableId) {
		return _payableLocalService.fetchPayable(payableId);
	}

	/**
	* Returns the payable matching the UUID and group.
	*
	* @param uuid the payable's UUID
	* @param groupId the primary key of the group
	* @return the matching payable, or <code>null</code> if a matching payable could not be found
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable fetchPayableByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _payableLocalService.fetchPayableByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the payable with the primary key.
	*
	* @param payableId the primary key of the payable
	* @return the payable
	* @throws PortalException if a payable with the primary key could not be found
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable getPayable(
		long payableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payableLocalService.getPayable(payableId);
	}

	/**
	* Returns the payable matching the UUID and group.
	*
	* @param uuid the payable's UUID
	* @param groupId the primary key of the group
	* @return the matching payable
	* @throws PortalException if a matching payable could not be found
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable getPayableByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payableLocalService.getPayableByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the payable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payable the payable
	* @return the payable that was updated
	*/
	@Override
	public com.liferay.oracly.accounts.payable.data.model.Payable updatePayable(
		com.liferay.oracly.accounts.payable.data.model.Payable payable) {
		return _payableLocalService.updatePayable(payable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _payableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payableLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _payableLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _payableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of payables.
	*
	* @return the number of payables
	*/
	@Override
	public int getPayablesCount() {
		return _payableLocalService.getPayablesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _payableLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _payableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oracly.accounts.payable.data.model.impl.PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _payableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oracly.accounts.payable.data.model.impl.PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _payableLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.oracly.accounts.payable.data.model.Payable> getJSONPayables() {
		return _payableLocalService.getJSONPayables();
	}

	/**
	* Returns a range of all the payables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oracly.accounts.payable.data.model.impl.PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @return the range of payables
	*/
	@Override
	public java.util.List<com.liferay.oracly.accounts.payable.data.model.Payable> getPayables(
		int start, int end) {
		return _payableLocalService.getPayables(start, end);
	}

	/**
	* Returns all the payables matching the UUID and company.
	*
	* @param uuid the UUID of the payables
	* @param companyId the primary key of the company
	* @return the matching payables, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.oracly.accounts.payable.data.model.Payable> getPayablesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _payableLocalService.getPayablesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of payables matching the UUID and company.
	*
	* @param uuid the UUID of the payables
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching payables, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.oracly.accounts.payable.data.model.Payable> getPayablesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.oracly.accounts.payable.data.model.Payable> orderByComparator) {
		return _payableLocalService.getPayablesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _payableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _payableLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public PayableLocalService getWrappedService() {
		return _payableLocalService;
	}

	@Override
	public void setWrappedService(PayableLocalService payableLocalService) {
		_payableLocalService = payableLocalService;
	}

	private PayableLocalService _payableLocalService;
}