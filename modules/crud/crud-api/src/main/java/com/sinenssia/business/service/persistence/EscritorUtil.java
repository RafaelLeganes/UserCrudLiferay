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

package com.sinenssia.business.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sinenssia.business.model.Escritor;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the escritor service. This utility wraps <code>com.sinenssia.business.service.persistence.impl.EscritorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EscritorPersistence
 * @generated
 */
public class EscritorUtil {

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
	public static void clearCache(Escritor escritor) {
		getPersistence().clearCache(escritor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Escritor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Escritor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Escritor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Escritor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Escritor update(Escritor escritor) {
		return getPersistence().update(escritor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Escritor update(
		Escritor escritor, ServiceContext serviceContext) {

		return getPersistence().update(escritor, serviceContext);
	}

	/**
	 * Returns all the escritors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching escritors
	 */
	public static List<Escritor> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Escritor> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Escritor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Escritor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Escritor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public static Escritor findByUuid_First(
			String uuid, OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByUuid_First(
		String uuid, OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public static Escritor findByUuid_Last(
			String uuid, OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByUuid_Last(
		String uuid, OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Escritor[] findByUuid_PrevAndNext(
			long escritorId, String uuid,
			OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUuid_PrevAndNext(
			escritorId, uuid, orderByComparator);
	}

	/**
	 * Removes all the escritors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of escritors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching escritors
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEscritorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public static Escritor findByUUID_G(String uuid, long groupId)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the escritor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the escritor that was removed
	 */
	public static Escritor removeByUUID_G(String uuid, long groupId)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of escritors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching escritors
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching escritors
	 */
	public static List<Escritor> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Escritor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Escritor findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Escritor findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Escritor[] findByUuid_C_PrevAndNext(
			long escritorId, String uuid, long companyId,
			OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByUuid_C_PrevAndNext(
			escritorId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the escritors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching escritors
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the escritors where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching escritors
	 */
	public static List<Escritor> findByNombre(String nombre) {
		return getPersistence().findByNombre(nombre);
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
	public static List<Escritor> findByNombre(
		String nombre, int start, int end) {

		return getPersistence().findByNombre(nombre, start, end);
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
	public static List<Escritor> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().findByNombre(
			nombre, start, end, orderByComparator);
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
	public static List<Escritor> findByNombre(
		String nombre, int start, int end,
		OrderByComparator<Escritor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNombre(
			nombre, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public static Escritor findByNombre_First(
			String nombre, OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByNombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the first escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByNombre_First(
		String nombre, OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().fetchByNombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the last escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public static Escritor findByNombre_Last(
			String nombre, OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByNombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the last escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchByNombre_Last(
		String nombre, OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().fetchByNombre_Last(nombre, orderByComparator);
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
	public static Escritor[] findByNombre_PrevAndNext(
			long escritorId, String nombre,
			OrderByComparator<Escritor> orderByComparator)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByNombre_PrevAndNext(
			escritorId, nombre, orderByComparator);
	}

	/**
	 * Removes all the escritors where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public static void removeByNombre(String nombre) {
		getPersistence().removeByNombre(nombre);
	}

	/**
	 * Returns the number of escritors where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching escritors
	 */
	public static int countByNombre(String nombre) {
		return getPersistence().countByNombre(nombre);
	}

	/**
	 * Caches the escritor in the entity cache if it is enabled.
	 *
	 * @param escritor the escritor
	 */
	public static void cacheResult(Escritor escritor) {
		getPersistence().cacheResult(escritor);
	}

	/**
	 * Caches the escritors in the entity cache if it is enabled.
	 *
	 * @param escritors the escritors
	 */
	public static void cacheResult(List<Escritor> escritors) {
		getPersistence().cacheResult(escritors);
	}

	/**
	 * Creates a new escritor with the primary key. Does not add the escritor to the database.
	 *
	 * @param escritorId the primary key for the new escritor
	 * @return the new escritor
	 */
	public static Escritor create(long escritorId) {
		return getPersistence().create(escritorId);
	}

	/**
	 * Removes the escritor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor that was removed
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	public static Escritor remove(long escritorId)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().remove(escritorId);
	}

	public static Escritor updateImpl(Escritor escritor) {
		return getPersistence().updateImpl(escritor);
	}

	/**
	 * Returns the escritor with the primary key or throws a <code>NoSuchEscritorException</code> if it could not be found.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	public static Escritor findByPrimaryKey(long escritorId)
		throws com.sinenssia.business.exception.NoSuchEscritorException {

		return getPersistence().findByPrimaryKey(escritorId);
	}

	/**
	 * Returns the escritor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor, or <code>null</code> if a escritor with the primary key could not be found
	 */
	public static Escritor fetchByPrimaryKey(long escritorId) {
		return getPersistence().fetchByPrimaryKey(escritorId);
	}

	/**
	 * Returns all the escritors.
	 *
	 * @return the escritors
	 */
	public static List<Escritor> findAll() {
		return getPersistence().findAll();
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
	public static List<Escritor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Escritor> findAll(
		int start, int end, OrderByComparator<Escritor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Escritor> findAll(
		int start, int end, OrderByComparator<Escritor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the escritors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of escritors.
	 *
	 * @return the number of escritors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return long[] of the primaryKeys of libros associated with the escritor
	 */
	public static long[] getLibroPrimaryKeys(long pk) {
		return getPersistence().getLibroPrimaryKeys(pk);
	}

	/**
	 * Returns all the libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return the libros associated with the escritor
	 */
	public static List<com.sinenssia.business.model.Libro> getLibros(long pk) {
		return getPersistence().getLibros(pk);
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
	public static List<com.sinenssia.business.model.Libro> getLibros(
		long pk, int start, int end) {

		return getPersistence().getLibros(pk, start, end);
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
	public static List<com.sinenssia.business.model.Libro> getLibros(
		long pk, int start, int end,
		OrderByComparator<com.sinenssia.business.model.Libro>
			orderByComparator) {

		return getPersistence().getLibros(pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return the number of libros associated with the escritor
	 */
	public static int getLibrosSize(long pk) {
		return getPersistence().getLibrosSize(pk);
	}

	/**
	 * Returns <code>true</code> if the libro is associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 * @return <code>true</code> if the libro is associated with the escritor; <code>false</code> otherwise
	 */
	public static boolean containsLibro(long pk, long libroPK) {
		return getPersistence().containsLibro(pk, libroPK);
	}

	/**
	 * Returns <code>true</code> if the escritor has any libros associated with it.
	 *
	 * @param pk the primary key of the escritor to check for associations with libros
	 * @return <code>true</code> if the escritor has any libros associated with it; <code>false</code> otherwise
	 */
	public static boolean containsLibros(long pk) {
		return getPersistence().containsLibros(pk);
	}

	/**
	 * Adds an association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 */
	public static void addLibro(long pk, long libroPK) {
		getPersistence().addLibro(pk, libroPK);
	}

	/**
	 * Adds an association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libro the libro
	 */
	public static void addLibro(
		long pk, com.sinenssia.business.model.Libro libro) {

		getPersistence().addLibro(pk, libro);
	}

	/**
	 * Adds an association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros
	 */
	public static void addLibros(long pk, long[] libroPKs) {
		getPersistence().addLibros(pk, libroPKs);
	}

	/**
	 * Adds an association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros
	 */
	public static void addLibros(
		long pk, List<com.sinenssia.business.model.Libro> libros) {

		getPersistence().addLibros(pk, libros);
	}

	/**
	 * Clears all associations between the escritor and its libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor to clear the associated libros from
	 */
	public static void clearLibros(long pk) {
		getPersistence().clearLibros(pk);
	}

	/**
	 * Removes the association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 */
	public static void removeLibro(long pk, long libroPK) {
		getPersistence().removeLibro(pk, libroPK);
	}

	/**
	 * Removes the association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libro the libro
	 */
	public static void removeLibro(
		long pk, com.sinenssia.business.model.Libro libro) {

		getPersistence().removeLibro(pk, libro);
	}

	/**
	 * Removes the association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros
	 */
	public static void removeLibros(long pk, long[] libroPKs) {
		getPersistence().removeLibros(pk, libroPKs);
	}

	/**
	 * Removes the association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros
	 */
	public static void removeLibros(
		long pk, List<com.sinenssia.business.model.Libro> libros) {

		getPersistence().removeLibros(pk, libros);
	}

	/**
	 * Sets the libros associated with the escritor, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros to be associated with the escritor
	 */
	public static void setLibros(long pk, long[] libroPKs) {
		getPersistence().setLibros(pk, libroPKs);
	}

	/**
	 * Sets the libros associated with the escritor, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros to be associated with the escritor
	 */
	public static void setLibros(
		long pk, List<com.sinenssia.business.model.Libro> libros) {

		getPersistence().setLibros(pk, libros);
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EscritorPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EscritorPersistence _persistence;

}