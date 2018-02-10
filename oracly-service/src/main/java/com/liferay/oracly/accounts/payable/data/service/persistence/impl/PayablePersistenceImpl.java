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

package com.liferay.oracly.accounts.payable.data.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oracly.accounts.payable.data.exception.NoSuchPayableException;
import com.liferay.oracly.accounts.payable.data.model.Payable;
import com.liferay.oracly.accounts.payable.data.model.impl.PayableImpl;
import com.liferay.oracly.accounts.payable.data.model.impl.PayableModelImpl;
import com.liferay.oracly.accounts.payable.data.service.persistence.PayablePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the payable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayablePersistence
 * @see com.liferay.oracly.accounts.payable.data.service.persistence.PayableUtil
 * @generated
 */
@ProviderType
public class PayablePersistenceImpl extends BasePersistenceImpl<Payable>
	implements PayablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayableUtil} to access the payable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PayableModelImpl.UUID_COLUMN_BITMASK |
			PayableModelImpl.DUEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the payables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching payables
	 */
	@Override
	public List<Payable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Payable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Payable> findByUuid(String uuid, int start, int end,
		OrderByComparator<Payable> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Payable> findByUuid(String uuid, int start, int end,
		OrderByComparator<Payable> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Payable> list = null;

		if (retrieveFromCache) {
			list = (List<Payable>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Payable payable : list) {
					if (!Objects.equals(uuid, payable.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PAYABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first payable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payable
	 * @throws NoSuchPayableException if a matching payable could not be found
	 */
	@Override
	public Payable findByUuid_First(String uuid,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = fetchByUuid_First(uuid, orderByComparator);

		if (payable != null) {
			return payable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayableException(msg.toString());
	}

	/**
	 * Returns the first payable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByUuid_First(String uuid,
		OrderByComparator<Payable> orderByComparator) {
		List<Payable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payable
	 * @throws NoSuchPayableException if a matching payable could not be found
	 */
	@Override
	public Payable findByUuid_Last(String uuid,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = fetchByUuid_Last(uuid, orderByComparator);

		if (payable != null) {
			return payable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayableException(msg.toString());
	}

	/**
	 * Returns the last payable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByUuid_Last(String uuid,
		OrderByComparator<Payable> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Payable> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Payable[] findByUuid_PrevAndNext(long payableId, String uuid,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = findByPrimaryKey(payableId);

		Session session = null;

		try {
			session = openSession();

			Payable[] array = new PayableImpl[3];

			array[0] = getByUuid_PrevAndNext(session, payable, uuid,
					orderByComparator, true);

			array[1] = payable;

			array[2] = getByUuid_PrevAndNext(session, payable, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Payable getByUuid_PrevAndNext(Session session, Payable payable,
		String uuid, OrderByComparator<Payable> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYABLE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PayableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Payable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Payable payable : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(payable);
		}
	}

	/**
	 * Returns the number of payables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching payables
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PAYABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "payable.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "payable.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(payable.uuid IS NULL OR payable.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PayableModelImpl.UUID_COLUMN_BITMASK |
			PayableModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the payable where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPayableException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching payable
	 * @throws NoSuchPayableException if a matching payable could not be found
	 */
	@Override
	public Payable findByUUID_G(String uuid, long groupId)
		throws NoSuchPayableException {
		Payable payable = fetchByUUID_G(uuid, groupId);

		if (payable == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPayableException(msg.toString());
		}

		return payable;
	}

	/**
	 * Returns the payable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the payable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Payable) {
			Payable payable = (Payable)result;

			if (!Objects.equals(uuid, payable.getUuid()) ||
					(groupId != payable.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PAYABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Payable> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Payable payable = list.get(0);

					result = payable;

					cacheResult(payable);

					if ((payable.getUuid() == null) ||
							!payable.getUuid().equals(uuid) ||
							(payable.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, payable);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Payable)result;
		}
	}

	/**
	 * Removes the payable where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the payable that was removed
	 */
	@Override
	public Payable removeByUUID_G(String uuid, long groupId)
		throws NoSuchPayableException {
		Payable payable = findByUUID_G(uuid, groupId);

		return remove(payable);
	}

	/**
	 * Returns the number of payables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching payables
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "payable.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "payable.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(payable.uuid IS NULL OR payable.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "payable.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PayableModelImpl.UUID_COLUMN_BITMASK |
			PayableModelImpl.COMPANYID_COLUMN_BITMASK |
			PayableModelImpl.DUEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the payables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching payables
	 */
	@Override
	public List<Payable> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Payable> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Payable> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Payable> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Payable> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Payable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Payable> list = null;

		if (retrieveFromCache) {
			list = (List<Payable>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Payable payable : list) {
					if (!Objects.equals(uuid, payable.getUuid()) ||
							(companyId != payable.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PAYABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Payable findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (payable != null) {
			return payable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayableException(msg.toString());
	}

	/**
	 * Returns the first payable in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Payable> orderByComparator) {
		List<Payable> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Payable findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (payable != null) {
			return payable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayableException(msg.toString());
	}

	/**
	 * Returns the last payable in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Payable> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Payable> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Payable[] findByUuid_C_PrevAndNext(long payableId, String uuid,
		long companyId, OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = findByPrimaryKey(payableId);

		Session session = null;

		try {
			session = openSession();

			Payable[] array = new PayableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, payable, uuid,
					companyId, orderByComparator, true);

			array[1] = payable;

			array[2] = getByUuid_C_PrevAndNext(session, payable, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Payable getByUuid_C_PrevAndNext(Session session, Payable payable,
		String uuid, long companyId,
		OrderByComparator<Payable> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PAYABLE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PayableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Payable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Payable payable : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(payable);
		}
	}

	/**
	 * Returns the number of payables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching payables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "payable.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "payable.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(payable.uuid IS NULL OR payable.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "payable.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYAMOUNT =
		new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByAmount",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT =
		new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, PayableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindByAmount",
			new String[] { Double.class.getName() },
			PayableModelImpl.AMOUNT_COLUMN_BITMASK |
			PayableModelImpl.DUEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYAMOUNT = new FinderPath(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindByAmount",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the payables where amount = &#63;.
	 *
	 * @param amount the amount
	 * @return the matching payables
	 */
	@Override
	public List<Payable> findByFindByAmount(Double amount) {
		return findByFindByAmount(amount, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Payable> findByFindByAmount(Double amount, int start, int end) {
		return findByFindByAmount(amount, start, end, null);
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
	@Override
	public List<Payable> findByFindByAmount(Double amount, int start, int end,
		OrderByComparator<Payable> orderByComparator) {
		return findByFindByAmount(amount, start, end, orderByComparator, true);
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
	@Override
	public List<Payable> findByFindByAmount(Double amount, int start, int end,
		OrderByComparator<Payable> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT;
			finderArgs = new Object[] { amount };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYAMOUNT;
			finderArgs = new Object[] { amount, start, end, orderByComparator };
		}

		List<Payable> list = null;

		if (retrieveFromCache) {
			list = (List<Payable>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Payable payable : list) {
					if (!Objects.equals(amount, payable.getAmount())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PAYABLE_WHERE);

			query.append(_FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(amount.doubleValue());

				if (!pagination) {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first payable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payable
	 * @throws NoSuchPayableException if a matching payable could not be found
	 */
	@Override
	public Payable findByFindByAmount_First(Double amount,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = fetchByFindByAmount_First(amount, orderByComparator);

		if (payable != null) {
			return payable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("amount=");
		msg.append(amount);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayableException(msg.toString());
	}

	/**
	 * Returns the first payable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByFindByAmount_First(Double amount,
		OrderByComparator<Payable> orderByComparator) {
		List<Payable> list = findByFindByAmount(amount, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payable
	 * @throws NoSuchPayableException if a matching payable could not be found
	 */
	@Override
	public Payable findByFindByAmount_Last(Double amount,
		OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = fetchByFindByAmount_Last(amount, orderByComparator);

		if (payable != null) {
			return payable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("amount=");
		msg.append(amount);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayableException(msg.toString());
	}

	/**
	 * Returns the last payable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payable, or <code>null</code> if a matching payable could not be found
	 */
	@Override
	public Payable fetchByFindByAmount_Last(Double amount,
		OrderByComparator<Payable> orderByComparator) {
		int count = countByFindByAmount(amount);

		if (count == 0) {
			return null;
		}

		List<Payable> list = findByFindByAmount(amount, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Payable[] findByFindByAmount_PrevAndNext(long payableId,
		Double amount, OrderByComparator<Payable> orderByComparator)
		throws NoSuchPayableException {
		Payable payable = findByPrimaryKey(payableId);

		Session session = null;

		try {
			session = openSession();

			Payable[] array = new PayableImpl[3];

			array[0] = getByFindByAmount_PrevAndNext(session, payable, amount,
					orderByComparator, true);

			array[1] = payable;

			array[2] = getByFindByAmount_PrevAndNext(session, payable, amount,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Payable getByFindByAmount_PrevAndNext(Session session,
		Payable payable, Double amount,
		OrderByComparator<Payable> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYABLE_WHERE);

		query.append(_FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PayableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(amount.doubleValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Payable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payables where amount = &#63; from the database.
	 *
	 * @param amount the amount
	 */
	@Override
	public void removeByFindByAmount(Double amount) {
		for (Payable payable : findByFindByAmount(amount, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(payable);
		}
	}

	/**
	 * Returns the number of payables where amount = &#63;.
	 *
	 * @param amount the amount
	 * @return the number of matching payables
	 */
	@Override
	public int countByFindByAmount(Double amount) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYAMOUNT;

		Object[] finderArgs = new Object[] { amount };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PAYABLE_WHERE);

			query.append(_FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(amount.doubleValue());

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2 = "payable.amount = ?";

	public PayablePersistenceImpl() {
		setModelClass(Payable.class);
	}

	/**
	 * Caches the payable in the entity cache if it is enabled.
	 *
	 * @param payable the payable
	 */
	@Override
	public void cacheResult(Payable payable) {
		entityCache.putResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableImpl.class, payable.getPrimaryKey(), payable);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { payable.getUuid(), payable.getGroupId() }, payable);

		payable.resetOriginalValues();
	}

	/**
	 * Caches the payables in the entity cache if it is enabled.
	 *
	 * @param payables the payables
	 */
	@Override
	public void cacheResult(List<Payable> payables) {
		for (Payable payable : payables) {
			if (entityCache.getResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
						PayableImpl.class, payable.getPrimaryKey()) == null) {
				cacheResult(payable);
			}
			else {
				payable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all payables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payable.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Payable payable) {
		entityCache.removeResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableImpl.class, payable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PayableModelImpl)payable);
	}

	@Override
	public void clearCache(List<Payable> payables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Payable payable : payables) {
			entityCache.removeResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
				PayableImpl.class, payable.getPrimaryKey());

			clearUniqueFindersCache((PayableModelImpl)payable);
		}
	}

	protected void cacheUniqueFindersCache(PayableModelImpl payableModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					payableModelImpl.getUuid(), payableModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				payableModelImpl);
		}
		else {
			if ((payableModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payableModelImpl.getUuid(),
						payableModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					payableModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(PayableModelImpl payableModelImpl) {
		Object[] args = new Object[] {
				payableModelImpl.getUuid(), payableModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((payableModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					payableModelImpl.getOriginalUuid(),
					payableModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new payable with the primary key. Does not add the payable to the database.
	 *
	 * @param payableId the primary key for the new payable
	 * @return the new payable
	 */
	@Override
	public Payable create(long payableId) {
		Payable payable = new PayableImpl();

		payable.setNew(true);
		payable.setPrimaryKey(payableId);

		String uuid = PortalUUIDUtil.generate();

		payable.setUuid(uuid);

		payable.setCompanyId(companyProvider.getCompanyId());

		return payable;
	}

	/**
	 * Removes the payable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payableId the primary key of the payable
	 * @return the payable that was removed
	 * @throws NoSuchPayableException if a payable with the primary key could not be found
	 */
	@Override
	public Payable remove(long payableId) throws NoSuchPayableException {
		return remove((Serializable)payableId);
	}

	/**
	 * Removes the payable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payable
	 * @return the payable that was removed
	 * @throws NoSuchPayableException if a payable with the primary key could not be found
	 */
	@Override
	public Payable remove(Serializable primaryKey)
		throws NoSuchPayableException {
		Session session = null;

		try {
			session = openSession();

			Payable payable = (Payable)session.get(PayableImpl.class, primaryKey);

			if (payable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payable);
		}
		catch (NoSuchPayableException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Payable removeImpl(Payable payable) {
		payable = toUnwrappedModel(payable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payable)) {
				payable = (Payable)session.get(PayableImpl.class,
						payable.getPrimaryKeyObj());
			}

			if (payable != null) {
				session.delete(payable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payable != null) {
			clearCache(payable);
		}

		return payable;
	}

	@Override
	public Payable updateImpl(Payable payable) {
		payable = toUnwrappedModel(payable);

		boolean isNew = payable.isNew();

		PayableModelImpl payableModelImpl = (PayableModelImpl)payable;

		if (Validator.isNull(payable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			payable.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payable.getCreateDate() == null)) {
			if (serviceContext == null) {
				payable.setCreateDate(now);
			}
			else {
				payable.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!payableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payable.setModifiedDate(now);
			}
			else {
				payable.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (payable.isNew()) {
				session.save(payable);

				payable.setNew(false);
			}
			else {
				payable = (Payable)session.merge(payable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PayableModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((payableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { payableModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { payableModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((payableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payableModelImpl.getOriginalUuid(),
						payableModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						payableModelImpl.getUuid(),
						payableModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((payableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payableModelImpl.getOriginalAmount()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYAMOUNT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT,
					args);

				args = new Object[] { payableModelImpl.getAmount() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYAMOUNT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT,
					args);
			}
		}

		entityCache.putResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
			PayableImpl.class, payable.getPrimaryKey(), payable, false);

		clearUniqueFindersCache(payableModelImpl);
		cacheUniqueFindersCache(payableModelImpl, isNew);

		payable.resetOriginalValues();

		return payable;
	}

	protected Payable toUnwrappedModel(Payable payable) {
		if (payable instanceof PayableImpl) {
			return payable;
		}

		PayableImpl payableImpl = new PayableImpl();

		payableImpl.setNew(payable.isNew());
		payableImpl.setPrimaryKey(payable.getPrimaryKey());

		payableImpl.setUuid(payable.getUuid());
		payableImpl.setPayableId(payable.getPayableId());
		payableImpl.setGroupId(payable.getGroupId());
		payableImpl.setCompanyId(payable.getCompanyId());
		payableImpl.setUserId(payable.getUserId());
		payableImpl.setUserName(payable.getUserName());
		payableImpl.setCreateDate(payable.getCreateDate());
		payableImpl.setModifiedDate(payable.getModifiedDate());
		payableImpl.setDueDate(payable.getDueDate());
		payableImpl.setAmount(payable.getAmount());
		payableImpl.setDescription(payable.getDescription());
		payableImpl.setPath(payable.getPath());
		payableImpl.setDocumentId(payable.getDocumentId());
		payableImpl.setFlag(payable.getFlag());
		payableImpl.setSupplierName(payable.getSupplierName());

		return payableImpl;
	}

	/**
	 * Returns the payable with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the payable
	 * @return the payable
	 * @throws NoSuchPayableException if a payable with the primary key could not be found
	 */
	@Override
	public Payable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayableException {
		Payable payable = fetchByPrimaryKey(primaryKey);

		if (payable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payable;
	}

	/**
	 * Returns the payable with the primary key or throws a {@link NoSuchPayableException} if it could not be found.
	 *
	 * @param payableId the primary key of the payable
	 * @return the payable
	 * @throws NoSuchPayableException if a payable with the primary key could not be found
	 */
	@Override
	public Payable findByPrimaryKey(long payableId)
		throws NoSuchPayableException {
		return findByPrimaryKey((Serializable)payableId);
	}

	/**
	 * Returns the payable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payable
	 * @return the payable, or <code>null</code> if a payable with the primary key could not be found
	 */
	@Override
	public Payable fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
				PayableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Payable payable = (Payable)serializable;

		if (payable == null) {
			Session session = null;

			try {
				session = openSession();

				payable = (Payable)session.get(PayableImpl.class, primaryKey);

				if (payable != null) {
					cacheResult(payable);
				}
				else {
					entityCache.putResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
						PayableImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
					PayableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payable;
	}

	/**
	 * Returns the payable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payableId the primary key of the payable
	 * @return the payable, or <code>null</code> if a payable with the primary key could not be found
	 */
	@Override
	public Payable fetchByPrimaryKey(long payableId) {
		return fetchByPrimaryKey((Serializable)payableId);
	}

	@Override
	public Map<Serializable, Payable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Payable> map = new HashMap<Serializable, Payable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Payable payable = fetchByPrimaryKey(primaryKey);

			if (payable != null) {
				map.put(primaryKey, payable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
					PayableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Payable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAYABLE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Payable payable : (List<Payable>)q.list()) {
				map.put(payable.getPrimaryKeyObj(), payable);

				cacheResult(payable);

				uncachedPrimaryKeys.remove(payable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PayableModelImpl.ENTITY_CACHE_ENABLED,
					PayableImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the payables.
	 *
	 * @return the payables
	 */
	@Override
	public List<Payable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Payable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Payable> findAll(int start, int end,
		OrderByComparator<Payable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Payable> findAll(int start, int end,
		OrderByComparator<Payable> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Payable> list = null;

		if (retrieveFromCache) {
			list = (List<Payable>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAYABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYABLE;

				if (pagination) {
					sql = sql.concat(PayableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Payable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the payables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Payable payable : findAll()) {
			remove(payable);
		}
	}

	/**
	 * Returns the number of payables.
	 *
	 * @return the number of payables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYABLE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PayableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payable persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PayableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PAYABLE = "SELECT payable FROM Payable payable";
	private static final String _SQL_SELECT_PAYABLE_WHERE_PKS_IN = "SELECT payable FROM Payable payable WHERE payableId IN (";
	private static final String _SQL_SELECT_PAYABLE_WHERE = "SELECT payable FROM Payable payable WHERE ";
	private static final String _SQL_COUNT_PAYABLE = "SELECT COUNT(payable) FROM Payable payable";
	private static final String _SQL_COUNT_PAYABLE_WHERE = "SELECT COUNT(payable) FROM Payable payable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Payable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Payable exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PayablePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "path"
			});
}