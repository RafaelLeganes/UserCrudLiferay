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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EscritorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EscritorLocalService
 * @generated
 */
public class EscritorLocalServiceWrapper
	implements EscritorLocalService, ServiceWrapper<EscritorLocalService> {

	public EscritorLocalServiceWrapper(
		EscritorLocalService escritorLocalService) {

		_escritorLocalService = escritorLocalService;
	}

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
	@Override
	public com.sinenssia.business.model.Escritor addEscritor(
		com.sinenssia.business.model.Escritor escritor) {

		return _escritorLocalService.addEscritor(escritor);
	}

	@Override
	public void addLibroEscritor(
		long libroId, com.sinenssia.business.model.Escritor escritor) {

		_escritorLocalService.addLibroEscritor(libroId, escritor);
	}

	@Override
	public void addLibroEscritor(long libroId, long escritorId) {
		_escritorLocalService.addLibroEscritor(libroId, escritorId);
	}

	@Override
	public void addLibroEscritors(
		long libroId,
		java.util.List<com.sinenssia.business.model.Escritor> escritors) {

		_escritorLocalService.addLibroEscritors(libroId, escritors);
	}

	@Override
	public void addLibroEscritors(long libroId, long[] escritorIds) {
		_escritorLocalService.addLibroEscritors(libroId, escritorIds);
	}

	@Override
	public void clearLibroEscritors(long libroId) {
		_escritorLocalService.clearLibroEscritors(libroId);
	}

	/**
	 * Creates a new escritor with the primary key. Does not add the escritor to the database.
	 *
	 * @param escritorId the primary key for the new escritor
	 * @return the new escritor
	 */
	@Override
	public com.sinenssia.business.model.Escritor createEscritor(
		long escritorId) {

		return _escritorLocalService.createEscritor(escritorId);
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
	@Override
	public com.sinenssia.business.model.Escritor deleteEscritor(
		com.sinenssia.business.model.Escritor escritor) {

		return _escritorLocalService.deleteEscritor(escritor);
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
	@Override
	public com.sinenssia.business.model.Escritor deleteEscritor(long escritorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _escritorLocalService.deleteEscritor(escritorId);
	}

	@Override
	public void deleteLibroEscritor(
		long libroId, com.sinenssia.business.model.Escritor escritor) {

		_escritorLocalService.deleteLibroEscritor(libroId, escritor);
	}

	@Override
	public void deleteLibroEscritor(long libroId, long escritorId) {
		_escritorLocalService.deleteLibroEscritor(libroId, escritorId);
	}

	@Override
	public void deleteLibroEscritors(
		long libroId,
		java.util.List<com.sinenssia.business.model.Escritor> escritors) {

		_escritorLocalService.deleteLibroEscritors(libroId, escritors);
	}

	@Override
	public void deleteLibroEscritors(long libroId, long[] escritorIds) {
		_escritorLocalService.deleteLibroEscritors(libroId, escritorIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _escritorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _escritorLocalService.dynamicQuery();
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

		return _escritorLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _escritorLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _escritorLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
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

		return _escritorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _escritorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sinenssia.business.model.Escritor fetchEscritor(
		long escritorId) {

		return _escritorLocalService.fetchEscritor(escritorId);
	}

	/**
	 * Returns the escritor matching the UUID and group.
	 *
	 * @param uuid the escritor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	 */
	@Override
	public com.sinenssia.business.model.Escritor fetchEscritorByUuidAndGroupId(
		String uuid, long groupId) {

		return _escritorLocalService.fetchEscritorByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _escritorLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the escritor with the primary key.
	 *
	 * @param escritorId the primary key of the escritor
	 * @return the escritor
	 * @throws PortalException if a escritor with the primary key could not be found
	 */
	@Override
	public com.sinenssia.business.model.Escritor getEscritor(long escritorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _escritorLocalService.getEscritor(escritorId);
	}

	/**
	 * Returns the escritor matching the UUID and group.
	 *
	 * @param uuid the escritor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching escritor
	 * @throws PortalException if a matching escritor could not be found
	 */
	@Override
	public com.sinenssia.business.model.Escritor getEscritorByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _escritorLocalService.getEscritorByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.sinenssia.business.model.Escritor> getEscritors(
		int start, int end) {

		return _escritorLocalService.getEscritors(start, end);
	}

	/**
	 * Returns all the escritors matching the UUID and company.
	 *
	 * @param uuid the UUID of the escritors
	 * @param companyId the primary key of the company
	 * @return the matching escritors, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sinenssia.business.model.Escritor>
		getEscritorsByUuidAndCompanyId(String uuid, long companyId) {

		return _escritorLocalService.getEscritorsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.sinenssia.business.model.Escritor>
		getEscritorsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sinenssia.business.model.Escritor> orderByComparator) {

		return _escritorLocalService.getEscritorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of escritors.
	 *
	 * @return the number of escritors
	 */
	@Override
	public int getEscritorsCount() {
		return _escritorLocalService.getEscritorsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _escritorLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _escritorLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sinenssia.business.model.Escritor>
		getLibroEscritors(long libroId) {

		return _escritorLocalService.getLibroEscritors(libroId);
	}

	@Override
	public java.util.List<com.sinenssia.business.model.Escritor>
		getLibroEscritors(long libroId, int start, int end) {

		return _escritorLocalService.getLibroEscritors(libroId, start, end);
	}

	@Override
	public java.util.List<com.sinenssia.business.model.Escritor>
		getLibroEscritors(
			long libroId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sinenssia.business.model.Escritor> orderByComparator) {

		return _escritorLocalService.getLibroEscritors(
			libroId, start, end, orderByComparator);
	}

	@Override
	public int getLibroEscritorsCount(long libroId) {
		return _escritorLocalService.getLibroEscritorsCount(libroId);
	}

	/**
	 * Returns the libroIds of the libros associated with the escritor.
	 *
	 * @param escritorId the escritorId of the escritor
	 * @return long[] the libroIds of libros associated with the escritor
	 */
	@Override
	public long[] getLibroPrimaryKeys(long escritorId) {
		return _escritorLocalService.getLibroPrimaryKeys(escritorId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _escritorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _escritorLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasLibroEscritor(long libroId, long escritorId) {
		return _escritorLocalService.hasLibroEscritor(libroId, escritorId);
	}

	@Override
	public boolean hasLibroEscritors(long libroId) {
		return _escritorLocalService.hasLibroEscritors(libroId);
	}

	@Override
	public void setLibroEscritors(long libroId, long[] escritorIds) {
		_escritorLocalService.setLibroEscritors(libroId, escritorIds);
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
	@Override
	public com.sinenssia.business.model.Escritor updateEscritor(
		com.sinenssia.business.model.Escritor escritor) {

		return _escritorLocalService.updateEscritor(escritor);
	}

	@Override
	public EscritorLocalService getWrappedService() {
		return _escritorLocalService;
	}

	@Override
	public void setWrappedService(EscritorLocalService escritorLocalService) {
		_escritorLocalService = escritorLocalService;
	}

	private EscritorLocalService _escritorLocalService;

}