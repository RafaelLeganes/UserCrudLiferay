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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sinenssia.business.exception.NoSuchEscritorException;
import com.sinenssia.business.model.Escritor;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the escritor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EscritorUtil
 * @generated
 */
@ProviderType
public interface EscritorPersistence extends BasePersistence<Escritor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EscritorUtil} to access the escritor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Escritor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the escritors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching escritors
	 */
	public java.util.List<Escritor> findByUuid(String uuid);

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
	public java.util.List<Escritor> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Escritor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

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
	public java.util.List<Escritor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

	/**
	 * Returns the escritors before and after the current escritor in the ordered set where uuid = &#63;.
	 *
	 * @param escritorId the primary key of the current escritor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	public Escritor[] findByUuid_PrevAndNext(
			long escritorId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Removes all the escritors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of escritors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching escritors
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEscritorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByUUID_G(String uuid, long groupId)
		throws NoSuchEscritorException;

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the escritor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the escritor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the escritor that was removed
	 */
	public Escritor removeByUUID_G(String uuid, long groupId)
		throws NoSuchEscritorException;

	/**
	 * Returns the number of escritors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching escritors
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching escritors
	 */
	public java.util.List<Escritor> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

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
	public java.util.List<Escritor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Returns the first escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Returns the last escritor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

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
	public Escritor[] findByUuid_C_PrevAndNext(
			long escritorId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Removes all the escritors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of escritors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching escritors
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the escritors where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching escritors
	 */
	public java.util.List<Escritor> findByNombre(String nombre);

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
	public java.util.List<Escritor> findByNombre(
		String nombre, int start, int end);

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
	public java.util.List<Escritor> findByNombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

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
	public java.util.List<Escritor> findByNombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByNombre_First(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Returns the first escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByNombre_First(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

	/**
	 * Returns the last escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor
	 * @throws NoSuchEscritorException if a matching escritor could not be found
	 */
	public Escritor findByNombre_Last(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Returns the last escritor in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public Escritor fetchByNombre_Last(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

	/**
	 * Returns the escritors before and after the current escritor in the ordered set where nombre = &#63;.
	 *
	 * @param escritorId the primary key of the current escritor
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	public Escritor[] findByNombre_PrevAndNext(
			long escritorId, String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Escritor>
				orderByComparator)
		throws NoSuchEscritorException;

	/**
	 * Removes all the escritors where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public void removeByNombre(String nombre);

	/**
	 * Returns the number of escritors where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching escritors
	 */
	public int countByNombre(String nombre);

	/**
	 * Caches the escritor in the entity cache if it is enabled.
	 *
	 * @param escritor the escritor
	 */
	public void cacheResult(Escritor escritor);

	/**
	 * Caches the escritors in the entity cache if it is enabled.
	 *
	 * @param escritors the escritors
	 */
	public void cacheResult(java.util.List<Escritor> escritors);

	/**
	 * Creates a new escritor with the primary key. Does not add the escritor to the database.
	 *
	 * @param escritorId the primary key for the new escritor
	 * @return the new escritor
	 */
	public Escritor create(long escritorId);

	/**
	 * Removes the escritor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor that was removed
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	public Escritor remove(long escritorId) throws NoSuchEscritorException;

	public Escritor updateImpl(Escritor escritor);

	/**
	 * Returns the escritor with the primary key or throws a <code>NoSuchEscritorException</code> if it could not be found.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor
	 * @throws NoSuchEscritorException if a escritor with the primary key could not be found
	 */
	public Escritor findByPrimaryKey(long escritorId)
		throws NoSuchEscritorException;

	/**
	 * Returns the escritor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor, or <code>null</code> if a escritor with the primary key could not be found
	 */
	public Escritor fetchByPrimaryKey(long escritorId);

	/**
	 * Returns all the escritors.
	 *
	 * @return the escritors
	 */
	public java.util.List<Escritor> findAll();

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
	public java.util.List<Escritor> findAll(int start, int end);

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
	public java.util.List<Escritor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator);

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
	public java.util.List<Escritor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Escritor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the escritors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of escritors.
	 *
	 * @return the number of escritors
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return long[] of the primaryKeys of libros associated with the escritor
	 */
	public long[] getLibroPrimaryKeys(long pk);

	/**
	 * Returns all the libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return the libros associated with the escritor
	 */
	public java.util.List<com.sinenssia.business.model.Libro> getLibros(
		long pk);

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
	public java.util.List<com.sinenssia.business.model.Libro> getLibros(
		long pk, int start, int end);

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
	public java.util.List<com.sinenssia.business.model.Libro> getLibros(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sinenssia.business.model.Libro> orderByComparator);

	/**
	 * Returns the number of libros associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @return the number of libros associated with the escritor
	 */
	public int getLibrosSize(long pk);

	/**
	 * Returns <code>true</code> if the libro is associated with the escritor.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 * @return <code>true</code> if the libro is associated with the escritor; <code>false</code> otherwise
	 */
	public boolean containsLibro(long pk, long libroPK);

	/**
	 * Returns <code>true</code> if the escritor has any libros associated with it.
	 *
	 * @param pk the primary key of the escritor to check for associations with libros
	 * @return <code>true</code> if the escritor has any libros associated with it; <code>false</code> otherwise
	 */
	public boolean containsLibros(long pk);

	/**
	 * Adds an association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 */
	public void addLibro(long pk, long libroPK);

	/**
	 * Adds an association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libro the libro
	 */
	public void addLibro(long pk, com.sinenssia.business.model.Libro libro);

	/**
	 * Adds an association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros
	 */
	public void addLibros(long pk, long[] libroPKs);

	/**
	 * Adds an association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros
	 */
	public void addLibros(
		long pk, java.util.List<com.sinenssia.business.model.Libro> libros);

	/**
	 * Clears all associations between the escritor and its libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor to clear the associated libros from
	 */
	public void clearLibros(long pk);

	/**
	 * Removes the association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPK the primary key of the libro
	 */
	public void removeLibro(long pk, long libroPK);

	/**
	 * Removes the association between the escritor and the libro. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libro the libro
	 */
	public void removeLibro(long pk, com.sinenssia.business.model.Libro libro);

	/**
	 * Removes the association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros
	 */
	public void removeLibros(long pk, long[] libroPKs);

	/**
	 * Removes the association between the escritor and the libros. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros
	 */
	public void removeLibros(
		long pk, java.util.List<com.sinenssia.business.model.Libro> libros);

	/**
	 * Sets the libros associated with the escritor, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libroPKs the primary keys of the libros to be associated with the escritor
	 */
	public void setLibros(long pk, long[] libroPKs);

	/**
	 * Sets the libros associated with the escritor, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the escritor
	 * @param libros the libros to be associated with the escritor
	 */
	public void setLibros(
		long pk, java.util.List<com.sinenssia.business.model.Libro> libros);

	@Override
	public Set<String> getBadColumnNames();

}