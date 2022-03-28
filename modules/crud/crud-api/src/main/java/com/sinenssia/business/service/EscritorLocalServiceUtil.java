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

package com.sinenssia.business.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sinenssia.business.model.Escritor;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Escritor. This utility wraps
 * <code>com.sinenssia.business.service.impl.EscritorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EscritorLocalService
 * @generated
 */
public class EscritorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sinenssia.business.service.impl.EscritorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the escritor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EscritorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param escritor the escritor
	 * @return the escritor that was added
	 */
	public static Escritor addEscritor(Escritor escritor) {
		return getService().addEscritor(escritor);
	}

	public static void addLibroEscritor(long libroId, Escritor escritor) {
		getService().addLibroEscritor(libroId, escritor);
	}

	public static void addLibroEscritor(long libroId, long escritorId) {
		getService().addLibroEscritor(libroId, escritorId);
	}

	public static void addLibroEscritors(
		long libroId, List<Escritor> escritors) {

		getService().addLibroEscritors(libroId, escritors);
	}

	public static void addLibroEscritors(long libroId, long[] escritorIds) {
		getService().addLibroEscritors(libroId, escritorIds);
	}

	public static void clearLibroEscritors(long libroId) {
		getService().clearLibroEscritors(libroId);
	}

	/**
	 * Creates a new escritor with the primary key. Does not add the escritor to the database.
	 *
	 * @param escritorId the primary key for the new escritor
	 * @return the new escritor
	 */
	public static Escritor createEscritor(long escritorId) {
		return getService().createEscritor(escritorId);
	}

	/**
	 * Deletes the escritor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EscritorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param escritor the escritor
	 * @return the escritor that was removed
	 */
	public static Escritor deleteEscritor(Escritor escritor) {
		return getService().deleteEscritor(escritor);
	}

	/**
	 * Deletes the escritor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EscritorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor that was removed
	 * @throws PortalException if a escritor with the primary key could not be found
	 */
	public static Escritor deleteEscritor(long escritorId)
		throws PortalException {

		return getService().deleteEscritor(escritorId);
	}

	public static void deleteLibroEscritor(long libroId, Escritor escritor) {
		getService().deleteLibroEscritor(libroId, escritor);
	}

	public static void deleteLibroEscritor(long libroId, long escritorId) {
		getService().deleteLibroEscritor(libroId, escritorId);
	}

	public static void deleteLibroEscritors(
		long libroId, List<Escritor> escritors) {

		getService().deleteLibroEscritors(libroId, escritors);
	}

	public static void deleteLibroEscritors(long libroId, long[] escritorIds) {
		getService().deleteLibroEscritors(libroId, escritorIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sinenssia.business.model.impl.EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sinenssia.business.model.impl.EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Escritor fetchEscritor(long escritorId) {
		return getService().fetchEscritor(escritorId);
	}

	/**
	 * Returns the escritor matching the UUID and group.
	 *
	 * @param uuid the escritor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	public static Escritor fetchEscritorByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEscritorByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the escritor with the primary key.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor
	 * @throws PortalException if a escritor with the primary key could not be found
	 */
	public static Escritor getEscritor(long escritorId) throws PortalException {
		return getService().getEscritor(escritorId);
	}

	/**
	 * Returns the escritor matching the UUID and group.
	 *
	 * @param uuid the escritor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching escritor
	 * @throws PortalException if a matching escritor could not be found
	 */
	public static Escritor getEscritorByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEscritorByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the escritors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sinenssia.business.model.impl.EscritorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @return the range of escritors
	 */
	public static List<Escritor> getEscritors(int start, int end) {
		return getService().getEscritors(start, end);
	}

	/**
	 * Returns all the escritors matching the UUID and company.
	 *
	 * @param uuid the UUID of the escritors
	 * @param companyId the primary key of the company
	 * @return the matching escritors, or an empty list if no matches were found
	 */
	public static List<Escritor> getEscritorsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEscritorsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of escritors matching the UUID and company.
	 *
	 * @param uuid the UUID of the escritors
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of escritors
	 * @param end the upper bound of the range of escritors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching escritors, or an empty list if no matches were found
	 */
	public static List<Escritor> getEscritorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return getService().getEscritorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of escritors.
	 *
	 * @return the number of escritors
	 */
	public static int getEscritorsCount() {
		return getService().getEscritorsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Escritor> getLibroEscritors(long libroId) {
		return getService().getLibroEscritors(libroId);
	}

	public static List<Escritor> getLibroEscritors(
		long libroId, int start, int end) {

		return getService().getLibroEscritors(libroId, start, end);
	}

	public static List<Escritor> getLibroEscritors(
		long libroId, int start, int end,
		OrderByComparator<Escritor> orderByComparator) {

		return getService().getLibroEscritors(
			libroId, start, end, orderByComparator);
	}

	public static int getLibroEscritorsCount(long libroId) {
		return getService().getLibroEscritorsCount(libroId);
	}

	/**
	 * Returns the libroIds of the libros associated with the escritor.
	 *
	 * @param escritorId the escritorId of the escritor
	 * @return long[] the libroIds of libros associated with the escritor
	 */
	public static long[] getLibroPrimaryKeys(long escritorId) {
		return getService().getLibroPrimaryKeys(escritorId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasLibroEscritor(long libroId, long escritorId) {
		return getService().hasLibroEscritor(libroId, escritorId);
	}

	public static boolean hasLibroEscritors(long libroId) {
		return getService().hasLibroEscritors(libroId);
	}

	public static void setLibroEscritors(long libroId, long[] escritorIds) {
		getService().setLibroEscritors(libroId, escritorIds);
	}

	/**
	 * Updates the escritor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EscritorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param escritor the escritor
	 * @return the escritor that was updated
	 */
	public static Escritor updateEscritor(Escritor escritor) {
		return getService().updateEscritor(escritor);
	}

	public static EscritorLocalService getService() {
		return _service;
	}

	private static volatile EscritorLocalService _service;

}