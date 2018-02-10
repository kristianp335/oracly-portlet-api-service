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

import com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException;
import com.liferay.oracly.accounts.payable.data.model.Payable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the payable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.oracly.accounts.payable.data.service.persistence.impl.PayablePersistenceImpl
 * @see PayableUtil
 * @generated
 */
@ProviderType
public interface PayablePersistence extends BasePersistence<Payable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayableUtil} to access the payable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the payables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching payables
	*/
	public java.util.List<Payable> findByUuid(java.lang.String uuid);

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
	public java.util.List<Payable> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Payable> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

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
	public java.util.List<Payable> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Returns the first payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

	/**
	* Returns the last payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Returns the last payable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

	/**
	* Returns the payables before and after the current payable in the ordered set where uuid = &#63;.
	*
	* @param payableId the primary key of the current payable
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public Payable[] findByUuid_PrevAndNext(long payableId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Removes all the payables where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of payables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching payables
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the payable where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPayableException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPayableException;

	/**
	* Returns the payable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the payable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the payable where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the payable that was removed
	*/
	public Payable removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPayableException;

	/**
	* Returns the number of payables where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching payables
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the payables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching payables
	*/
	public java.util.List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

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
	public java.util.List<Payable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Returns the first payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

	/**
	* Returns the last payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Returns the last payable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

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
	public Payable[] findByUuid_C_PrevAndNext(long payableId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Removes all the payables where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of payables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching payables
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the payables where amount = &#63;.
	*
	* @param amount the amount
	* @return the matching payables
	*/
	public java.util.List<Payable> findByFindByAmount(java.lang.Double amount);

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
	public java.util.List<Payable> findByFindByAmount(java.lang.Double amount,
		int start, int end);

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
	public java.util.List<Payable> findByFindByAmount(java.lang.Double amount,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

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
	public java.util.List<Payable> findByFindByAmount(java.lang.Double amount,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByFindByAmount_First(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Returns the first payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByFindByAmount_First(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

	/**
	* Returns the last payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable
	* @throws NoSuchPayableException if a matching payable could not be found
	*/
	public Payable findByFindByAmount_Last(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Returns the last payable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payable, or <code>null</code> if a matching payable could not be found
	*/
	public Payable fetchByFindByAmount_Last(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

	/**
	* Returns the payables before and after the current payable in the ordered set where amount = &#63;.
	*
	* @param payableId the primary key of the current payable
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public Payable[] findByFindByAmount_PrevAndNext(long payableId,
		java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException;

	/**
	* Removes all the payables where amount = &#63; from the database.
	*
	* @param amount the amount
	*/
	public void removeByFindByAmount(java.lang.Double amount);

	/**
	* Returns the number of payables where amount = &#63;.
	*
	* @param amount the amount
	* @return the number of matching payables
	*/
	public int countByFindByAmount(java.lang.Double amount);

	/**
	* Caches the payable in the entity cache if it is enabled.
	*
	* @param payable the payable
	*/
	public void cacheResult(Payable payable);

	/**
	* Caches the payables in the entity cache if it is enabled.
	*
	* @param payables the payables
	*/
	public void cacheResult(java.util.List<Payable> payables);

	/**
	* Creates a new payable with the primary key. Does not add the payable to the database.
	*
	* @param payableId the primary key for the new payable
	* @return the new payable
	*/
	public Payable create(long payableId);

	/**
	* Removes the payable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payableId the primary key of the payable
	* @return the payable that was removed
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public Payable remove(long payableId) throws NoSuchPayableException;

	public Payable updateImpl(Payable payable);

	/**
	* Returns the payable with the primary key or throws a {@link NoSuchPayableException} if it could not be found.
	*
	* @param payableId the primary key of the payable
	* @return the payable
	* @throws NoSuchPayableException if a payable with the primary key could not be found
	*/
	public Payable findByPrimaryKey(long payableId)
		throws NoSuchPayableException;

	/**
	* Returns the payable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param payableId the primary key of the payable
	* @return the payable, or <code>null</code> if a payable with the primary key could not be found
	*/
	public Payable fetchByPrimaryKey(long payableId);

	@Override
	public java.util.Map<java.io.Serializable, Payable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the payables.
	*
	* @return the payables
	*/
	public java.util.List<Payable> findAll();

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
	public java.util.List<Payable> findAll(int start, int end);

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
	public java.util.List<Payable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator);

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
	public java.util.List<Payable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the payables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of payables.
	*
	* @return the number of payables
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}