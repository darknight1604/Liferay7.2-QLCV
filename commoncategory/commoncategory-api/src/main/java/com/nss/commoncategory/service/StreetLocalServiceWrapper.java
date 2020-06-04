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
 * Provides a wrapper for {@link StreetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StreetLocalService
 * @generated
 */
@ProviderType
public class StreetLocalServiceWrapper
	implements StreetLocalService, ServiceWrapper<StreetLocalService> {

	public StreetLocalServiceWrapper(StreetLocalService streetLocalService) {
		_streetLocalService = streetLocalService;
	}

	@Override
	public void _validateStreetByCode(long streetId, String code)
		throws com.nss.commoncategory.exception.DuplicateCodeException,
			   com.nss.commoncategory.exception.EmptyCodeException {

		_streetLocalService._validateStreetByCode(streetId, code);
	}

	@Override
	public com.nss.commoncategory.model.Street addStreet(
			long userId, long countryId, long cityId, long districtId,
			long wardId, String name, String code, String description,
			boolean active, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _streetLocalService.addStreet(
			userId, countryId, cityId, districtId, wardId, name, code,
			description, active, priority, countCode, serContext);
	}

	/**
	 * Adds the street to the database. Also notifies the appropriate model listeners.
	 *
	 * @param street the street
	 * @return the street that was added
	 */
	@Override
	public com.nss.commoncategory.model.Street addStreet(
		com.nss.commoncategory.model.Street street) {

		return _streetLocalService.addStreet(street);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, long countryId, long cityId,
			long districtId, long wardId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _streetLocalService.countByBaseSearch(
			companyId, groupId, countryId, cityId, districtId, wardId, active,
			name, code, description, andOperator);
	}

	/**
	 * Creates a new street with the primary key. Does not add the street to the database.
	 *
	 * @param streetId the primary key for the new street
	 * @return the new street
	 */
	@Override
	public com.nss.commoncategory.model.Street createStreet(long streetId) {
		return _streetLocalService.createStreet(streetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _streetLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streetId the primary key of the street
	 * @return the street that was removed
	 * @throws PortalException if a street with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.Street deleteStreet(long streetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _streetLocalService.deleteStreet(streetId);
	}

	/**
	 * Deletes the street from the database. Also notifies the appropriate model listeners.
	 *
	 * @param street the street
	 * @return the street that was removed
	 */
	@Override
	public com.nss.commoncategory.model.Street deleteStreet(
		com.nss.commoncategory.model.Street street) {

		return _streetLocalService.deleteStreet(street);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _streetLocalService.dynamicQuery();
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

		return _streetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _streetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _streetLocalService.dynamicQuery(
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

		return _streetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _streetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nss.commoncategory.model.Street fetchByCode(String code) {
		return _streetLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.commoncategory.model.Street fetchByWardId_Name(
		long wardId, String name) {

		return _streetLocalService.fetchByWardId_Name(wardId, name);
	}

	@Override
	public com.nss.commoncategory.model.Street fetchStreet(long streetId) {
		return _streetLocalService.fetchStreet(streetId);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Street> findByActive(
		boolean active) {

		return _streetLocalService.findByActive(active);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Street> findByBaseSearch(
			long companyId, long groupId, long countryId, long cityId,
			long districtId, long wardId, int active, String name, String code,
			String description, boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _streetLocalService.findByBaseSearch(
			companyId, groupId, countryId, cityId, districtId, wardId, active,
			name, code, description, andOperator, start, end, obc);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Street>
		findByCityId_Active(long cityId, boolean active) {

		return _streetLocalService.findByCityId_Active(cityId, active);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Street>
		findByDistrictId_Active(long districtId, boolean active) {

		return _streetLocalService.findByDistrictId_Active(districtId, active);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.Street>
		findByWardId_Active(long wardId, boolean active) {

		return _streetLocalService.findByWardId_Active(wardId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _streetLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _streetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _streetLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _streetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the street with the primary key.
	 *
	 * @param streetId the primary key of the street
	 * @return the street
	 * @throws PortalException if a street with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.Street getStreet(long streetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _streetLocalService.getStreet(streetId);
	}

	/**
	 * Returns a range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.StreetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of streets
	 */
	@Override
	public java.util.List<com.nss.commoncategory.model.Street> getStreets(
		int start, int end) {

		return _streetLocalService.getStreets(start, end);
	}

	/**
	 * Returns the number of streets.
	 *
	 * @return the number of streets
	 */
	@Override
	public int getStreetsCount() {
		return _streetLocalService.getStreetsCount();
	}

	@Override
	public com.nss.commoncategory.model.Street updateStreet(
			long streetId, long countryId, long cityId, long districtId,
			long wardId, String name, String code, String description,
			boolean active, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _streetLocalService.updateStreet(
			streetId, countryId, cityId, districtId, wardId, name, code,
			description, active, priority, countCode, serContext);
	}

	/**
	 * Updates the street in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param street the street
	 * @return the street that was updated
	 */
	@Override
	public com.nss.commoncategory.model.Street updateStreet(
		com.nss.commoncategory.model.Street street) {

		return _streetLocalService.updateStreet(street);
	}

	@Override
	public StreetLocalService getWrappedService() {
		return _streetLocalService;
	}

	@Override
	public void setWrappedService(StreetLocalService streetLocalService) {
		_streetLocalService = streetLocalService;
	}

	private StreetLocalService _streetLocalService;

}