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

package com.nss.commoncategory.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link WardLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WardLocalService
 * @generated
 */
@ProviderType
public class WardLocalServiceWrapper
	implements WardLocalService, ServiceWrapper<WardLocalService> {

	public WardLocalServiceWrapper(WardLocalService wardLocalService) {
		_wardLocalService = wardLocalService;
	}

	@Override
	public void _validateWardByCode(long wardId, String code)
		throws com.nss.commoncategory.exception.DuplicateCodeException,
			   com.nss.commoncategory.exception.EmptyCodeException {

		_wardLocalService._validateWardByCode(wardId, code);
	}

	@Override
	public com.nss.commoncategory.model.Ward addWard(
			long userId, long countryId, long cityId, long districtId,
			String name, String code, String description, boolean active,
			int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardLocalService.addWard(
			userId, countryId, cityId, districtId, name, code, description,
			active, priority, countCode, serContext);
	}

	/**
	 * Adds the ward to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ward the ward
	 * @return the ward that was added
	 */
	@Override
	public com.nss.commoncategory.model.Ward addWard(
		com.nss.commoncategory.model.Ward ward) {

		return _wardLocalService.addWard(ward);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, long countryId, long cityId,
			long districtId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _wardLocalService.countByBaseSearch(
			companyId, groupId, countryId, cityId, districtId, active, name,
			code, description, andOperator);
	}

	/**
	 * Creates a new ward with the primary key. Does not add the ward to the database.
	 *
	 * @param wardId the primary key for the new ward
	 * @return the new ward
	 */
	@Override
	public com.nss.commoncategory.model.Ward createWard(long wardId) {
		return _wardLocalService.createWard(wardId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ward with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward that was removed
	 * @throws PortalException if a ward with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.Ward deleteWard(long wardId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardLocalService.deleteWard(wardId);
	}

	/**
	 * Deletes the ward from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ward the ward
	 * @return the ward that was removed
	 */
	@Override
	public com.nss.commoncategory.model.Ward deleteWard(
		com.nss.commoncategory.model.Ward ward) {

		return _wardLocalService.deleteWard(ward);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wardLocalService.dynamicQuery();
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

		return _wardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _wardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _wardLocalService.dynamicQuery(
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

		return _wardLocalService.dynamicQueryCount(dynamicQuery);
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

		return _wardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nss.commoncategory.model.Ward fetchByCode(String code) {
		return _wardLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.commoncategory.model.Ward fetchByDistrictId_Name(
		long districtId, String name) {

		return _wardLocalService.fetchByDistrictId_Name(districtId, name);
	}

	@Override
	public com.nss.commoncategory.model.Ward fetchWard(long wardId) {
		return _wardLocalService.fetchWard(wardId);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Ward> findByBaseSearch(
			long companyId, long groupId, long countryId, long cityId,
			long districtId, int active, String name, String code,
			String description, boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _wardLocalService.findByBaseSearch(
			companyId, groupId, countryId, cityId, districtId, active, name,
			code, description, andOperator, start, end, obc);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Ward>
		findByDistrictId_Active(long districtId, boolean active) {

		return _wardLocalService.findByDistrictId_Active(districtId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _wardLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _wardLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wardLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ward with the primary key.
	 *
	 * @param wardId the primary key of the ward
	 * @return the ward
	 * @throws PortalException if a ward with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.Ward getWard(long wardId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardLocalService.getWard(wardId);
	}

	/**
	 * Returns a range of all the wards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.WardModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wards
	 * @param end the upper bound of the range of wards (not inclusive)
	 * @return the range of wards
	 */
	@Override
	public java.util.List<com.nss.commoncategory.model.Ward> getWards(
		int start, int end) {

		return _wardLocalService.getWards(start, end);
	}

	/**
	 * Returns the number of wards.
	 *
	 * @return the number of wards
	 */
	@Override
	public int getWardsCount() {
		return _wardLocalService.getWardsCount();
	}

	@Override
	public com.nss.commoncategory.model.Ward updateWard(
			long wardId, long countryId, long cityId, long districtId,
			String name, String code, String description, boolean active,
			int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wardLocalService.updateWard(
			wardId, countryId, cityId, districtId, name, code, description,
			active, priority, countCode, serContext);
	}

	/**
	 * Updates the ward in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ward the ward
	 * @return the ward that was updated
	 */
	@Override
	public com.nss.commoncategory.model.Ward updateWard(
		com.nss.commoncategory.model.Ward ward) {

		return _wardLocalService.updateWard(ward);
	}

	@Override
	public WardLocalService getWrappedService() {
		return _wardLocalService;
	}

	@Override
	public void setWrappedService(WardLocalService wardLocalService) {
		_wardLocalService = wardLocalService;
	}

	private WardLocalService _wardLocalService;

}