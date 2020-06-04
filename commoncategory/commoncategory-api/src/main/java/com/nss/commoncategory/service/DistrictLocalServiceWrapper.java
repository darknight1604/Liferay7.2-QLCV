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
 * Provides a wrapper for {@link DistrictLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalService
 * @generated
 */
@ProviderType
public class DistrictLocalServiceWrapper
	implements DistrictLocalService, ServiceWrapper<DistrictLocalService> {

	public DistrictLocalServiceWrapper(
		DistrictLocalService districtLocalService) {

		_districtLocalService = districtLocalService;
	}

	@Override
	public void _validateDistrictByCode(long districtId, String code)
		throws com.nss.commoncategory.exception.DuplicateCodeException,
			   com.nss.commoncategory.exception.EmptyCodeException {

		_districtLocalService._validateDistrictByCode(districtId, code);
	}

	/**
	 * Adds the district to the database. Also notifies the appropriate model listeners.
	 *
	 * @param district the district
	 * @return the district that was added
	 */
	@Override
	public com.nss.commoncategory.model.District addDistrict(
		com.nss.commoncategory.model.District district) {

		return _districtLocalService.addDistrict(district);
	}

	@Override
	public com.nss.commoncategory.model.District addDistrict(
			long userId, long countryId, long cityId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.addDistrict(
			userId, countryId, cityId, name, code, description, priority,
			countCode, active, serContext);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, long countryId, long cityId,
			int active, String name, String code, String description,
			boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _districtLocalService.countByBaseSearch(
			companyId, groupId, countryId, cityId, active, name, code,
			description, andOperator);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	@Override
	public com.nss.commoncategory.model.District createDistrict(
		long districtId) {

		return _districtLocalService.createDistrict(districtId);
	}

	/**
	 * Deletes the district from the database. Also notifies the appropriate model listeners.
	 *
	 * @param district the district
	 * @return the district that was removed
	 */
	@Override
	public com.nss.commoncategory.model.District deleteDistrict(
		com.nss.commoncategory.model.District district) {

		return _districtLocalService.deleteDistrict(district);
	}

	/**
	 * Deletes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws PortalException if a district with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.District deleteDistrict(long districtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.deleteDistrict(districtId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _districtLocalService.dynamicQuery();
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

		return _districtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _districtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _districtLocalService.dynamicQuery(
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

		return _districtLocalService.dynamicQueryCount(dynamicQuery);
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

		return _districtLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.nss.commoncategory.model.District fetchByCityId_Name(
		long cityId, String name) {

		return _districtLocalService.fetchByCityId_Name(cityId, name);
	}

	@Override
	public com.nss.commoncategory.model.District fetchByCode(String code) {
		return _districtLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.commoncategory.model.District fetchDistrict(
		long districtId) {

		return _districtLocalService.fetchDistrict(districtId);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.District> findByActive(
		boolean active) {

		return _districtLocalService.findByActive(active);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.District>
			findByBaseSearch(
				long companyId, long groupId, long countryId, long cityId,
				int active, String name, String code, String description,
				boolean andOperator, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _districtLocalService.findByBaseSearch(
			companyId, groupId, countryId, cityId, active, name, code,
			description, andOperator, start, end, obc);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.District>
		findByCityId_Active(long cityId, boolean active) {

		return _districtLocalService.findByCityId_Active(cityId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _districtLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the district with the primary key.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws PortalException if a district with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.District getDistrict(long districtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.getDistrict(districtId);
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.DistrictModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	@Override
	public java.util.List<com.nss.commoncategory.model.District> getDistricts(
		int start, int end) {

		return _districtLocalService.getDistricts(start, end);
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	@Override
	public int getDistrictsCount() {
		return _districtLocalService.getDistrictsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _districtLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _districtLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param district the district
	 * @return the district that was updated
	 */
	@Override
	public com.nss.commoncategory.model.District updateDistrict(
		com.nss.commoncategory.model.District district) {

		return _districtLocalService.updateDistrict(district);
	}

	@Override
	public com.nss.commoncategory.model.District updateDistrict(
			long districtId, long countryId, long cityId, String name,
			String code, String description, int priority, int countCode,
			boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.updateDistrict(
			districtId, countryId, cityId, name, code, description, priority,
			countCode, active, serContext);
	}

	@Override
	public DistrictLocalService getWrappedService() {
		return _districtLocalService;
	}

	@Override
	public void setWrappedService(DistrictLocalService districtLocalService) {
		_districtLocalService = districtLocalService;
	}

	private DistrictLocalService _districtLocalService;

}