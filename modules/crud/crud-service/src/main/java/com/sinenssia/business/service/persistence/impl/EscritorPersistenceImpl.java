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

package com.sinenssia.business.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sinenssia.business.exception.NoSuchEscritorException;
import com.sinenssia.business.model.Escritor;
import com.sinenssia.business.model.impl.EscritorImpl;
import com.sinenssia.business.model.impl.EscritorModelImpl;
import com.sinenssia.business.service.persistence.EscritorPersistence;
import com.sinenssia.business.service.persistence.EscritorUtil;
import com.sinenssia.business.service.persistence.LibroPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the escritor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EscritorPersistenceImpl
	extends BasePersistenceImpl<Escritor> implements EscritorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EscritorUtil</code> to access the escritor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EscritorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the escritors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching escritors
	 */
	@Override
	public List<Escritor> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the escritors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @return the range of matching escritors
	 */
	@Override
	public List<Escritor> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the escritors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching escritors
	 */
	@Override
	public List<Escritor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the escritors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching escritors
	 */
	@Override
	public List<Escritor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Escritor> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Escritor> list = null;

		if (useFinderCache) {
			list = (List<Escritor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Escritor escritor : list) {
					if (!uuid.equals(escritor.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ESCRITOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EscritorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Escritor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByUuid_First(
			String uuid, OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByUuid_First(uuid, orderByComparator);

		if (escritor != null) {
			return escritor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEscritorException(sb.toString());
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByUuid_First(
		String uuid, OrderByComparator<Escritor> orderByComparator) {

		List<Escritor> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByUuid_Last(
			String uuid, OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByUuid_Last(uuid, orderByComparator);

		if (escritor != null) {
			return escritor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEscritorException(sb.toString());
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByUuid_Last(
		String uuid, OrderByComparator<Escritor> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Escritor> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the escritors before and after the current escritor in the ordered set where uuid = &#63;.
	 *
	 * @param escritorId the primary key of the current escritor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor[] findByUuid_PrevAndNext(
			long escritorId, String uuid,
			OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		uuid = Objects.toString(uuid, "");

		Escritor escritor = findByPrimaryKey(escritorId);

		Session session = null;

		try {
			session = openSession();

			Escritor[] array = new EscritorImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, escritor, uuid, orderByComparator, true);

			array[1] = escritor;

			array[2] = getByUuid_PrevAndNext(
				session, escritor, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Escritor getByUuid_PrevAndNext(
		Session session, Escritor escritor, String uuid,
		OrderByComparator<Escritor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ESCRITOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EscritorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(escritor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Escritor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the escritors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Escritor escritor :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(escritor);
		}
	}

	/**
	 * Returns the number of escritors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching escritors
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ESCRITOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"escritor.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(escritor.uuid IS NULL OR escritor.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEscritorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByUUID_G(String uuid, long groupId)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByUUID_G(uuid, groupId);

		if (escritor == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEscritorException(sb.toString());
		}

		return escritor;
	}

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Escritor) {
			Escritor escritor = (Escritor)result;

			if (!Objects.equals(uuid, escritor.getUuid()) ||
				(groupId != escritor.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ESCRITOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Escritor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Escritor escritor = list.get(0);

					result = escritor;

					cacheResult(escritor);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Escritor)result;
		}
	}

	/**
	 * Removes the escritor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the escritor that was removed
	 */
	@Override
	public Escritor removeByUUID_G(String uuid, long groupId)
		throws NoSuchEscritorException {

		Escritor escritor = findByUUID_G(uuid, groupId);

		return remove(escritor);
	}

	/**
	 * Returns the number of escritors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching escritors
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ESCRITOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"escritor.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(escritor.uuid IS NULL OR escritor.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"escritor.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching escritors
	 */
	@Override
	public List<Escritor> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @return the range of matching escritors
	 */
	@Override
	public List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching escritors
	 */
	@Override
	public List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching escritors
	 */
	@Override
	public List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Escritor> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Escritor> list = null;

		if (useFinderCache) {
			list = (List<Escritor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Escritor escritor : list) {
					if (!uuid.equals(escritor.getUuid()) ||
						(companyId != escritor.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ESCRITOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EscritorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Escritor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (escritor != null) {
			return escritor;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEscritorException(sb.toString());
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Escritor> orderByComparator) {

		List<Escritor> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (escritor != null) {
			return escritor;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEscritorException(sb.toString());
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Escritor> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Escritor> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the escritors before and after the current escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param escritorId the primary key of the current escritor
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor[] findByUuid_C_PrevAndNext(
			long escritorId, String uuid, long companyId,
			OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		uuid = Objects.toString(uuid, "");

		Escritor escritor = findByPrimaryKey(escritorId);

		Session session = null;

		try {
			session = openSession();

			Escritor[] array = new EscritorImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, escritor, uuid, companyId, orderByComparator, true);

			array[1] = escritor;

			array[2] = getByUuid_C_PrevAndNext(
				session, escritor, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Escritor getByUuid_C_PrevAndNext(
		Session session, Escritor escritor, String uuid, long companyId,
		OrderByComparator<Escritor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ESCRITOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EscritorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(escritor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Escritor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the escritors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Escritor escritor :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(escritor);
		}
	}

	/**
	 * Returns the number of escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching escritors
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ESCRITOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"escritor.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(escritor.uuid IS NULL OR escritor.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"escritor.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNombre;
	private FinderPath _finderPathWithoutPaginationFindByNombre;
	private FinderPath _finderPathCountByNombre;

	/**
	 * Returns all the escritors where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching escritors
	 */
	@Override
	public List<Escritor> findByNombre(String nombre) {
		return findByNombre(nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the escritors where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @return the range of matching escritors
	 */
	@Override
	public List<Escritor> findByNombre(String nombre, int start, int end) {
		return findByNombre(nombre, start, end, null);
	}

	/**
	 * Returns an ordered range of all the escritors where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching escritors
	 */
	@Override
	public List<Escritor> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return findByNombre(nombre, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the escritors where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching escritors
	 */
	@Override
	public List<Escritor> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Escritor> orderByComparator, boolean useFinderCache) {

		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNombre;
				finderArgs = new Object[] {nombre};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNombre;
			finderArgs = new Object[] {nombre, start, end, orderByComparator};
		}

		List<Escritor> list = null;

		if (useFinderCache) {
			list = (List<Escritor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Escritor escritor : list) {
					if (!nombre.equals(escritor.getNombre())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ESCRITOR_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
			}
			else {
				bindNombre = true;

				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EscritorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNombre) {
					queryPos.add(nombre);
				}

				list = (List<Escritor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByNombre_First(
			String nombre, OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByNombre_First(nombre, orderByComparator);

		if (escritor != null) {
			return escritor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchEscritorException(sb.toString());
	}

	/**
	 * Returns the first escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByNombre_First(
		String nombre, OrderByComparator<Escritor> orderByComparator) {

		List<Escritor> list = findByNombre(nombre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	@Override
	public Escritor findByNombre_Last(
			String nombre, OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByNombre_Last(nombre, orderByComparator);

		if (escritor != null) {
			return escritor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchEscritorException(sb.toString());
	}

	/**
	 * Returns the last escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public Escritor fetchByNombre_Last(
		String nombre, OrderByComparator<Escritor> orderByComparator) {

		int count = countByNombre(nombre);

		if (count == 0) {
			return null;
		}

		List<Escritor> list = findByNombre(
			nombre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the escritors before and after the current escritor in the ordered set where nombre = &#63;.
	 *
	 * @param escritorId the primary key of the current escritor
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor[] findByNombre_PrevAndNext(
			long escritorId, String nombre,
			OrderByComparator<Escritor> orderByComparator)
		throws NoSuchEscritorException {

		nombre = Objects.toString(nombre, "");

		Escritor escritor = findByPrimaryKey(escritorId);

		Session session = null;

		try {
			session = openSession();

			Escritor[] array = new EscritorImpl[3];

			array[0] = getByNombre_PrevAndNext(
				session, escritor, nombre, orderByComparator, true);

			array[1] = escritor;

			array[2] = getByNombre_PrevAndNext(
				session, escritor, nombre, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Escritor getByNombre_PrevAndNext(
		Session session, Escritor escritor, String nombre,
		OrderByComparator<Escritor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ESCRITOR_WHERE);

		boolean bindNombre = false;

		if (nombre.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
		}
		else {
			bindNombre = true;

			sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EscritorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNombre) {
			queryPos.add(nombre);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(escritor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Escritor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the escritors where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	@Override
	public void removeByNombre(String nombre) {
		for (Escritor escritor :
				findByNombre(
					nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(escritor);
		}
	}

	/**
	 * Returns the number of escritors where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching escritors
	 */
	@Override
	public int countByNombre(String nombre) {
		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = _finderPathCountByNombre;

		Object[] finderArgs = new Object[] {nombre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ESCRITOR_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
			}
			else {
				bindNombre = true;

				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNombre) {
					queryPos.add(nombre);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_2 =
		"escritor.nombre = ?";

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 =
		"(escritor.nombre IS NULL OR escritor.nombre = '')";

	public EscritorPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(Escritor.class);
	}

	/**
	 * Caches the escritor in the entity cache if it is enabled.
	 *
	 * @param escritor the escritor
	 */
	@Override
	public void cacheResult(Escritor escritor) {
		entityCache.putResult(
			EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
			escritor.getPrimaryKey(), escritor);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {escritor.getUuid(), escritor.getGroupId()}, escritor);

		escritor.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the escritors in the entity cache if it is enabled.
	 *
	 * @param escritors the escritors
	 */
	@Override
	public void cacheResult(List<Escritor> escritors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (escritors.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Escritor escritor : escritors) {
			if (entityCache.getResult(
					EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
					escritor.getPrimaryKey()) == null) {

				cacheResult(escritor);
			}
			else {
				escritor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all escritors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EscritorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the escritor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Escritor escritor) {
		entityCache.removeResult(
			EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
			escritor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EscritorModelImpl)escritor, true);
	}

	@Override
	public void clearCache(List<Escritor> escritors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Escritor escritor : escritors) {
			entityCache.removeResult(
				EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
				escritor.getPrimaryKey());

			clearUniqueFindersCache((EscritorModelImpl)escritor, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EscritorModelImpl escritorModelImpl) {

		Object[] args = new Object[] {
			escritorModelImpl.getUuid(), escritorModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, escritorModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EscritorModelImpl escritorModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				escritorModelImpl.getUuid(), escritorModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((escritorModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				escritorModelImpl.getOriginalUuid(),
				escritorModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new escritor with the primary key. Does not add the escritor to the database.
	 *
	 * @param escritorId the primary key for the new escritor
	 * @return the new escritor
	 */
	@Override
	public Escritor create(long escritorId) {
		Escritor escritor = new EscritorImpl();

		escritor.setNew(true);
		escritor.setPrimaryKey(escritorId);

		String uuid = PortalUUIDUtil.generate();

		escritor.setUuid(uuid);

		escritor.setCompanyId(CompanyThreadLocal.getCompanyId());

		return escritor;
	}

	/**
	 * Removes the escritor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor that was removed
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor remove(long escritorId) throws NoSuchEscritorException {
		return remove((Serializable)escritorId);
	}

	/**
	 * Removes the escritor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the escritor
	 * @return the escritor that was removed
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor remove(Serializable primaryKey)
		throws NoSuchEscritorException {

		Session session = null;

		try {
			session = openSession();

			Escritor escritor = (Escritor)session.get(
				EscritorImpl.class, primaryKey);

			if (escritor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEscritorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(escritor);
		}
		catch (NoSuchEscritorException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Escritor removeImpl(Escritor escritor) {
		escritorToLibroTableMapper.deleteLeftPrimaryKeyTableMappings(
			escritor.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(escritor)) {
				escritor = (Escritor)session.get(
					EscritorImpl.class, escritor.getPrimaryKeyObj());
			}

			if (escritor != null) {
				session.delete(escritor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (escritor != null) {
			clearCache(escritor);
		}

		return escritor;
	}

	@Override
	public Escritor updateImpl(Escritor escritor) {
		boolean isNew = escritor.isNew();

		if (!(escritor instanceof EscritorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(escritor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(escritor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in escritor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Escritor implementation " +
					escritor.getClass());
		}

		EscritorModelImpl escritorModelImpl = (EscritorModelImpl)escritor;

		if (Validator.isNull(escritor.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			escritor.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (escritor.getCreateDate() == null)) {
			if (serviceContext == null) {
				escritor.setCreateDate(date);
			}
			else {
				escritor.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!escritorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				escritor.setModifiedDate(date);
			}
			else {
				escritor.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(escritor);

				escritor.setNew(false);
			}
			else {
				escritor = (Escritor)session.merge(escritor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EscritorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {escritorModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				escritorModelImpl.getUuid(), escritorModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {escritorModelImpl.getNombre()};

			finderCache.removeResult(_finderPathCountByNombre, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNombre, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((escritorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					escritorModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {escritorModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((escritorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					escritorModelImpl.getOriginalUuid(),
					escritorModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					escritorModelImpl.getUuid(),
					escritorModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((escritorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNombre.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					escritorModelImpl.getOriginalNombre()
				};

				finderCache.removeResult(_finderPathCountByNombre, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNombre, args);

				args = new Object[] {escritorModelImpl.getNombre()};

				finderCache.removeResult(_finderPathCountByNombre, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNombre, args);
			}
		}

		entityCache.putResult(
			EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
			escritor.getPrimaryKey(), escritor, false);

		clearUniqueFindersCache(escritorModelImpl, false);
		cacheUniqueFindersCache(escritorModelImpl);

		escritor.resetOriginalValues();

		return escritor;
	}

	/**
	 * Returns the escritor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the escritor
	 * @return the escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEscritorException {

		Escritor escritor = fetchByPrimaryKey(primaryKey);

		if (escritor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEscritorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return escritor;
	}

	/**
	 * Returns the escritor with the primary key or throws a <code>NoSuchEscritorException</code> if it could not be found.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor findByPrimaryKey(long escritorId)
		throws NoSuchEscritorException {

		return findByPrimaryKey((Serializable)escritorId);
	}

	/**
	 * Returns the escritor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the escritor
	 * @return the escritor, or <code>null</code> if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Escritor escritor = (Escritor)serializable;

		if (escritor == null) {
			Session session = null;

			try {
				session = openSession();

				escritor = (Escritor)session.get(
					EscritorImpl.class, primaryKey);

				if (escritor != null) {
					cacheResult(escritor);
				}
				else {
					entityCache.putResult(
						EscritorModelImpl.ENTITY_CACHE_ENABLED,
						EscritorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return escritor;
	}

	/**
	 * Returns the escritor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor, or <code>null</code> if a escritor with the primary key could not be found
	 */
	@Override
	public Escritor fetchByPrimaryKey(long escritorId) {
		return fetchByPrimaryKey((Serializable)escritorId);
	}

	@Override
	public Map<Serializable, Escritor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Escritor> map = new HashMap<Serializable, Escritor>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Escritor escritor = fetchByPrimaryKey(primaryKey);

			if (escritor != null) {
				map.put(primaryKey, escritor);
			}

			return map;
		}

		if ((databaseInMaxParameters > 0) &&
			(primaryKeys.size() > databaseInMaxParameters)) {

			Iterator<Serializable> iterator = primaryKeys.iterator();

			while (iterator.hasNext()) {
				Set<Serializable> page = new HashSet<>();

				for (int i = 0;
					 (i < databaseInMaxParameters) && iterator.hasNext(); i++) {

					page.add(iterator.next());
				}

				map.putAll(fetchByPrimaryKeys(page));
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Escritor)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_ESCRITOR_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (Escritor escritor : (List<Escritor>)query.list()) {
				map.put(escritor.getPrimaryKeyObj(), escritor);

				cacheResult(escritor);

				uncachedPrimaryKeys.remove(escritor.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					EscritorModelImpl.ENTITY_CACHE_ENABLED, EscritorImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the escritors.
	 *
	 * @return the escritors
	 */
	@Override
	public List<Escritor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the escritors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @return the range of escritors
	 */
	@Override
	public List<Escritor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the escritors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of escritors
	 */
	@Override
	public List<Escritor> findAll(
		int start, int end, OrderByComparator<Escritor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the escritors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of escritors
	 */
	@Override
	public List<Escritor> findAll(
		int start, int end, OrderByComparator<Escritor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Escritor> list = null;

		if (useFinderCache) {
			list = (List<Escritor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ESCRITOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ESCRITOR;

				sql = sql.concat(EscritorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Escritor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the escritors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Escritor escritor : findAll()) {
			remove(escritor);
		}
	}

	/**
	 * Returns the number of escritors.
	 *
	 * @return the number of escritors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ESCRITOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return long[] of the primaryKeys of libros associated with the escritor
	 */
	@Override
	public long[] getLibroPrimaryKeys(long pk) {
		long[] pks = escritorToLibroTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return the libros associated with the escritor
	 */
	@Override
	public List<com.sinenssia.business.model.Libro> getLibros(long pk) {
		return getLibros(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the libros associated with the escritor.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the escritor
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @return the range of libros associated with the escritor
	 */
	@Override
	public List<com.sinenssia.business.model.Libro> getLibros(
		long pk, int start, int end) {

		return getLibros(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the libros associated with the escritor.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the escritor
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of libros associated with the escritor
	 */
	@Override
	public List<com.sinenssia.business.model.Libro> getLibros(
		long pk, int start, int end,
		OrderByComparator<com.sinenssia.business.model.Libro>
			orderByComparator) {

		return escritorToLibroTableMapper.getRightBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return the number of libros associated with the escritor
	 */
	@Override
	public int getLibrosSize(long pk) {
		long[] pks = escritorToLibroTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the libro is associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 * @return <code>true</code> if the libro is associated with the escritor; <code>false</code> otherwise
	 */
	@Override
	public boolean containsLibro(long pk, long libroPK) {
		return escritorToLibroTableMapper.containsTableMapping(pk, libroPK);
	}

	/**
	 * Returns <code>true</code> if the escritor has any libros associated with it.
	 *
	 * @param pk the primary key of the escritor to check for associations with libros
	 * @return <code>true</code> if the escritor has any libros associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsLibros(long pk) {
		if (getLibrosSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 */
	@Override
	public void addLibro(long pk, long libroPK) {
		Escritor escritor = fetchByPrimaryKey(pk);

		if (escritor == null) {
			escritorToLibroTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, libroPK);
		}
		else {
			escritorToLibroTableMapper.addTableMapping(
				escritor.getCompanyId(), pk, libroPK);
		}
	}

	/**
	 * Adds an association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libro the libro
	 */
	@Override
	public void addLibro(long pk, com.sinenssia.business.model.Libro libro) {
		Escritor escritor = fetchByPrimaryKey(pk);

		if (escritor == null) {
			escritorToLibroTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, libro.getPrimaryKey());
		}
		else {
			escritorToLibroTableMapper.addTableMapping(
				escritor.getCompanyId(), pk, libro.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros
	 */
	@Override
	public void addLibros(long pk, long[] libroPKs) {
		long companyId = 0;

		Escritor escritor = fetchByPrimaryKey(pk);

		if (escritor == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = escritor.getCompanyId();
		}

		escritorToLibroTableMapper.addTableMappings(companyId, pk, libroPKs);
	}

	/**
	 * Adds an association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros
	 */
	@Override
	public void addLibros(
		long pk, List<com.sinenssia.business.model.Libro> libros) {

		addLibros(
			pk,
			ListUtil.toLongArray(
				libros, com.sinenssia.business.model.Libro.LIBRO_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the escritor and its libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor to clear the associated libros from
	 */
	@Override
	public void clearLibros(long pk) {
		escritorToLibroTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 */
	@Override
	public void removeLibro(long pk, long libroPK) {
		escritorToLibroTableMapper.deleteTableMapping(pk, libroPK);
	}

	/**
	 * Removes the association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libro the libro
	 */
	@Override
	public void removeLibro(long pk, com.sinenssia.business.model.Libro libro) {
		escritorToLibroTableMapper.deleteTableMapping(
			pk, libro.getPrimaryKey());
	}

	/**
	 * Removes the association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros
	 */
	@Override
	public void removeLibros(long pk, long[] libroPKs) {
		escritorToLibroTableMapper.deleteTableMappings(pk, libroPKs);
	}

	/**
	 * Removes the association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros
	 */
	@Override
	public void removeLibros(
		long pk, List<com.sinenssia.business.model.Libro> libros) {

		removeLibros(
			pk,
			ListUtil.toLongArray(
				libros, com.sinenssia.business.model.Libro.LIBRO_ID_ACCESSOR));
	}

	/**
	 * Sets the libros associated with the escritor, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros to be associated with the escritor
	 */
	@Override
	public void setLibros(long pk, long[] libroPKs) {
		Set<Long> newLibroPKsSet = SetUtil.fromArray(libroPKs);
		Set<Long> oldLibroPKsSet = SetUtil.fromArray(
			escritorToLibroTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeLibroPKsSet = new HashSet<Long>(oldLibroPKsSet);

		removeLibroPKsSet.removeAll(newLibroPKsSet);

		escritorToLibroTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeLibroPKsSet));

		newLibroPKsSet.removeAll(oldLibroPKsSet);

		long companyId = 0;

		Escritor escritor = fetchByPrimaryKey(pk);

		if (escritor == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = escritor.getCompanyId();
		}

		escritorToLibroTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newLibroPKsSet));
	}

	/**
	 * Sets the libros associated with the escritor, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros to be associated with the escritor
	 */
	@Override
	public void setLibros(
		long pk, List<com.sinenssia.business.model.Libro> libros) {

		try {
			long[] libroPKs = new long[libros.size()];

			for (int i = 0; i < libros.size(); i++) {
				com.sinenssia.business.model.Libro libro = libros.get(i);

				libroPKs[i] = libro.getPrimaryKey();
			}

			setLibros(pk, libroPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EscritorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the escritor persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		escritorToLibroTableMapper = TableMapperFactory.getTableMapper(
			"LIBRO_Libros_Escritores", "companyId", "escritorId", "libroId",
			this, libroPersistence);

		_finderPathWithPaginationFindAll = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			EscritorModelImpl.UUID_COLUMN_BITMASK |
			EscritorModelImpl.NOMBRE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			EscritorModelImpl.UUID_COLUMN_BITMASK |
			EscritorModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			EscritorModelImpl.UUID_COLUMN_BITMASK |
			EscritorModelImpl.COMPANYID_COLUMN_BITMASK |
			EscritorModelImpl.NOMBRE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByNombre = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNombre",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNombre = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, EscritorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNombre",
			new String[] {String.class.getName()},
			EscritorModelImpl.NOMBRE_COLUMN_BITMASK);

		_finderPathCountByNombre = new FinderPath(
			EscritorModelImpl.ENTITY_CACHE_ENABLED,
			EscritorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNombre",
			new String[] {String.class.getName()});

		_setEscritorUtilPersistence(this);
	}

	public void destroy() {
		_setEscritorUtilPersistence(null);

		entityCache.removeCache(EscritorImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("LIBRO_Libros_Escritores");
	}

	private void _setEscritorUtilPersistence(
		EscritorPersistence escritorPersistence) {

		try {
			Field field = EscritorUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, escritorPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	@BeanReference(type = LibroPersistence.class)
	protected LibroPersistence libroPersistence;

	protected TableMapper<Escritor, com.sinenssia.business.model.Libro>
		escritorToLibroTableMapper;

	private static final String _SQL_SELECT_ESCRITOR =
		"SELECT escritor FROM Escritor escritor";

	private static final String _SQL_SELECT_ESCRITOR_WHERE_PKS_IN =
		"SELECT escritor FROM Escritor escritor WHERE escritorId IN (";

	private static final String _SQL_SELECT_ESCRITOR_WHERE =
		"SELECT escritor FROM Escritor escritor WHERE ";

	private static final String _SQL_COUNT_ESCRITOR =
		"SELECT COUNT(escritor) FROM Escritor escritor";

	private static final String _SQL_COUNT_ESCRITOR_WHERE =
		"SELECT COUNT(escritor) FROM Escritor escritor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "escritor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Escritor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Escritor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EscritorPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}