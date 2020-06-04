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
 * Provides a wrapper for {@link CityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CityLocalService
 * @generated
 */
@ProviderType
public class CityLocalServiceWrapper
	implements CityLocalService, ServiceWrapper<CityLocalService> {

	public CityLocalServiceWrapper(CityLocalService cityLocalService) {
		_cityLocalService = cityLocalService;
	}

	/**
	 * Adds the city to the database. Also notifies the appropriate model listeners.
	 *
	 * @param city the city
	 * @return the city that was added
	 */
	@Override
	public com.nss.commoncategory.model.City addCity(
		com.nss.commoncategory.model.City city) {

		return _cityLocalService.addCity(city);
	}

	@Override
	public com.nss.commoncategory.model.City addCity(
			long userId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityLocalService.addCity(
			userId, countryId, name, code, description, priority, countCode,
			active, serContext);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, long countryId, int active,
			String name, String code, String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cityLocalService.countByBaseSearch(
			companyId, groupId, countryId, active, name, code, description,
			andOperator);
	}

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityId the primary key for the new city
	 * @return the new city
	 */
	@Override
	public com.nss.commoncategory.model.City createCity(long cityId) {
		return _cityLocalService.createCity(cityId);
	}

	/**
	 * Deletes the city from the database. Also notifies the appropriate model listeners.
	 *
	 * @param city the city
	 * @return the city that was removed
	 */
	@Override
	public com.nss.commoncategory.model.City deleteCity(
		com.nss.commoncategory.model.City city) {

		return _cityLocalService.deleteCity(city);
	}

	/**
	 * Deletes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city
	 * @return the city that was removed
	 * @throws PortalException if a city with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.City deleteCity(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityLocalService.deleteCity(cityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cityLocalService.dynamicQuery();
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

		return _cityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _cityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _cityLocalService.dynamicQuery(
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

		return _cityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nss.commoncategory.model.City fetchByCode(String code) {
		return _cityLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.commoncategory.model.City fetchByCountryId_Name(
		long countryId, String name) {

		return _cityLocalService.fetchByCountryId_Name(countryId, name);
	}

	@Override
	public com.nss.commoncategory.model.City fetchCity(long cityId) {
		return _cityLocalService.fetchCity(cityId);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.City> findByActive(
		boolean active) {

		return _cityLocalService.findByActive(active);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.City> findByBaseSearch(
			long companyId, long groupId, long countryId, int active,
			String name, String code, String description, boolean andOperator,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cityLocalService.findByBaseSearch(
			companyId, groupId, countryId, active, name, code, description,
			andOperator, start, end, obc);
	}

	@Override
	public java.util.List<com.nss.commoncategory.model.City>
		findByCountryId_Active(long countryId, boolean active) {

		return _cityLocalService.findByCountryId_Active(countryId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cityLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.CityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of cities
	 */
	@Override
	public java.util.List<com.nss.commoncategory.model.City> getCities(
		int start, int end) {

		return _cityLocalService.getCities(start, end);
	}

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 */
	@Override
	public int getCitiesCount() {
		return _cityLocalService.getCitiesCount();
	}

	/**
	 * Returns the city with the primary key.
	 *
	 * @param cityId the primary key of the city
	 * @return the city
	 * @throws PortalException if a city with the primary key could not be found
	 */
	@Override
	public com.nss.commoncategory.model.City getCity(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityLocalService.getCity(cityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cityLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param city the city
	 * @return the city that was updated
	 */
	@Override
	public com.nss.commoncategory.model.City updateCity(
		com.nss.commoncategory.model.City city) {

		return _cityLocalService.updateCity(city);
	}

	@Override
	public com.nss.commoncategory.model.City updateCity(
			long cityId, long countryId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cityLocalService.updateCity(
			cityId, countryId, name, code, description, priority, countCode,
			active, serContext);
	}

	@Override
	public CityLocalService getWrappedService() {
		return _cityLocalService;
	}

	@Override
	public void setWrappedService(CityLocalService cityLocalService) {
		_cityLocalService = cityLocalService;
	}

	private CityLocalService _cityLocalService;

}