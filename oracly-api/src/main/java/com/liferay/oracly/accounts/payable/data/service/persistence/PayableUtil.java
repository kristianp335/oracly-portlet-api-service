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

package com.liferay.oracly.accounts.payable.data.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oracly.accounts.payable.data.model.Payable;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the payable service. This utility wraps {@link com.liferay.oracly.accounts.payable.data.service.persistence.impl.PayablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayablePersistence
 * @see com.liferay.oracly.accounts.payable.data.service.persistence.impl.PayablePersistenceImpl
 * @generated
 */
@ProviderType
public class PayableUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Payable payable) {
		getPersistence().clearCache(payable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Payable> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Payable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Payable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Payable update(Payable payable) {
		return getPersistence().update(payable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Payable update(Payable payable, ServiceContext serviceContext) {
		return getPersistence().update(payable, serviceContext);
	}

	/**
	* Returns all the payables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching payables
	*/
	public static List<Payable> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the payables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @return the range of matching payables
	*/
	public static List<Payable> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the payables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching payables
	*/
	public static List<Payable> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Payable> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching payables
	*/
	public static List<Payable> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByUuid_First(java.lang.String uuid,
		OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the payables before and after the current payable in the ordered set where uuid = &#63;.
	*
	* @param payableId the primary key of the current payable
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public static Payable[] findByUuid_PrevAndNext(long payableId,
		java.lang.String uuid, OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByUuid_PrevAndNext(payableId, uuid, orderByComparator);
	}

	/**
	* Removes all the payables where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of payables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching payables
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the payable where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPayableException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the payable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the payable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the payable where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the payable that was removed
	*/
	public static Payable removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of payables where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching payables
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the payables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching payables
	*/
	public static List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the payables where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @return the range of matching payables
	*/
	public static List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the payables where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching payables
	*/
	public static List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payables where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching payables
	*/
	public static List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Payable> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the payables before and after the current payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param payableId the primary key of the current payable
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public static Payable[] findByUuid_C_PrevAndNext(long payableId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(payableId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the payables where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of payables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching payables
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the payables where amount = &#63;.
	*
	* @param amount the amount
	* @return the matching payables
	*/
	public static List<Payable> findByFindByAmount(java.lang.Double amount) {
		return getPersistence().findByFindByAmount(amount);
	}

	/**
	* Returns a range of all the payables where amount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param amount the amount
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @return the range of matching payables
	*/
	public static List<Payable> findByFindByAmount(java.lang.Double amount,
		int start, int end) {
		return getPersistence().findByFindByAmount(amount, start, end);
	}

	/**
	* Returns an ordered range of all the payables where amount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param amount the amount
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching payables
	*/
	public static List<Payable> findByFindByAmount(java.lang.Double amount,
		int start, int end, OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .findByFindByAmount(amount, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payables where amount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param amount the amount
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching payables
	*/
	public static List<Payable> findByFindByAmount(java.lang.Double amount,
		int start, int end, OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFindByAmount(amount, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByFindByAmount_First(java.lang.Double amount,
		OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByFindByAmount_First(amount, orderByComparator);
	}

	/**
	* Returns the first payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByFindByAmount_First(java.lang.Double amount,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .fetchByFindByAmount_First(amount, orderByComparator);
	}

	/**
	* Returns the last payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public static Payable findByFindByAmount_Last(java.lang.Double amount,
		OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByFindByAmount_Last(amount, orderByComparator);
	}

	/**
	* Returns the last payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public static Payable fetchByFindByAmount_Last(java.lang.Double amount,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence()
				   .fetchByFindByAmount_Last(amount, orderByComparator);
	}

	/**
	* Returns the payables before and after the current payable in the ordered set where amount = &#63;.
	*
	* @param payableId the primary key of the current payable
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public static Payable[] findByFindByAmount_PrevAndNext(long payableId,
		java.lang.Double amount, OrderByComparator<Payable> orderByComparator)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence()
				   .findByFindByAmount_PrevAndNext(payableId, amount,
			orderByComparator);
	}

	/**
	* Removes all the payables where amount = &#63; from the database.
	*
	* @param amount the amount
	*/
	public static void removeByFindByAmount(java.lang.Double amount) {
		getPersistence().removeByFindByAmount(amount);
	}

	/**
	* Returns the number of payables where amount = &#63;.
	*
	* @param amount the amount
	* @return the number of matching payables
	*/
	public static int countByFindByAmount(java.lang.Double amount) {
		return getPersistence().countByFindByAmount(amount);
	}

	/**
	* Caches the payable in the entity cache if it is enabled.
	*
	* @param payable the payable
	*/
	public static void cacheResult(Payable payable) {
		getPersistence().cacheResult(payable);
	}

	/**
	* Caches the payables in the entity cache if it is enabled.
	*
	* @param payables the payables
	*/
	public static void cacheResult(List<Payable> payables) {
		getPersistence().cacheResult(payables);
	}

	/**
	* Creates a new payable with the primary key. Does not add the payable to the database.
	*
	* @param payableId the primary key for the new payable
	* @return the new payable
	*/
	public static Payable create(long payableId) {
		return getPersistence().create(payableId);
	}

	/**
	* Removes the payable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payableId the primary key of the payable
	* @return the payable that was removed
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public static Payable remove(long payableId)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence().remove(payableId);
	}

	public static Payable updateImpl(Payable payable) {
		return getPersistence().updateImpl(payable);
	}

	/**
	* Returns the payable with the primary key or throws a {@link NoSuchPayableException} if it could not be found.
	*
	* @param payableId the primary key of the payable
	* @return the payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public static Payable findByPrimaryKey(long payableId)
		throws com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException {
		return getPersistence().findByPrimaryKey(payableId);
	}

	/**
	* Returns the payable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param payableId the primary key of the payable
	* @return the payable, or <code>null</code> if a payable with the primary key could not be found
	*/
	public static Payable fetchByPrimaryKey(long payableId) {
		return getPersistence().fetchByPrimaryKey(payableId);
	}

	public static java.util.Map<java.io.Serializable, Payable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the payables.
	*
	* @return the payables
	*/
	public static List<Payable> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the payables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @return the range of payables
	*/
	public static List<Payable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the payables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of payables
	*/
	public static List<Payable> findAll(int start, int end,
		OrderByComparator<Payable> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the payables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payables
	* @param end the upper bound of the range of payables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of payables
	*/
	public static List<Payable> findAll(int start, int end,
		OrderByComparator<Payable> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the payables from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of payables.
	*
	* @return the number of payables
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PayablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayablePersistence, PayablePersistence> _serviceTracker =
		ServiceTrackerFactory.open(PayablePersistence.class);
}