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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for District. This utility wraps
 * <code>com.nss.commoncategory.service.impl.DistrictLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalService
 * @generated
 */
@ProviderType
public class DistrictLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.commoncategory.service.impl.DistrictLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void _validateDistrictByCode(long districtId, String code)
		throws com.nss.commoncategory.exception.DuplicateCodeException,
			   com.nss.commoncategory.exception.EmptyCodeException {

		getService()._validateDistrictByCode(districtId, code);
	}

	/**
	 * Adds the district to the database. Also notifies the appropriate model listeners.
	 *
	 * @param district the district
	 * @return the district that was added
	 */
	public static com.nss.commoncategory.model.District addDistrict(
		com.nss.commoncategory.model.District district) {

		return getService().addDistrict(district);
	}

	public static com.nss.commoncategory.model.District addDistrict(
			long userId, long countryId, long cityId, String name, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDistrict(
			userId, countryId, cityId, name, code, description, priority,
			countCode, active, serContext);
	}

	public static int countByBaseSearch(
			long companyId, long groupId, long countryId, long cityId,
			int active, String name, String code, String description,
			boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByBaseSearch(
			companyId, groupId, countryId, cityId, active, name, code,
			description, andOperator);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public static com.nss.commoncategory.model.District createDistrict(
		long districtId) {

		return getService().createDistrict(districtId);
	}

	/**
	 * Deletes the district from the database. Also notifies the appropriate model listeners.
	 *
	 * @param district the district
	 * @return the district that was removed
	 */
	public static com.nss.commoncategory.model.District deleteDistrict(
		com.nss.commoncategory.model.District district) {

		return getService().deleteDistrict(district);
	}

	/**
	 * Deletes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws PortalException if a district with the primary key could not be found
	 */
	public static com.nss.commoncategory.model.District deleteDistrict(
			long districtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDistrict(districtId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.nss.commoncategory.model.District fetchByCityId_Name(
		long cityId, String name) {

		return getService().fetchByCityId_Name(cityId, name);
	}

	public static com.nss.commoncategory.model.District fetchByCode(
		String code) {

		return getService().fetchByCode(code);
	}

	public static com.nss.commoncategory.model.District fetchDistrict(
		long districtId) {

		return getService().fetchDistrict(districtId);
	}

	public static java.util.List<com.nss.commoncategory.model.District>
		findByActive(boolean active) {

		return getService().findByActive(active);
	}

	public static java.util.List<com.nss.commoncategory.model.District>
			findByBaseSearch(
				long companyId, long groupId, long countryId, long cityId,
				int active, String name, String code, String description,
				boolean andOperator, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByBaseSearch(
			companyId, groupId, countryId, cityId, active, name, code,
			description, andOperator, start, end, obc);
	}

	public static java.util.List<com.nss.commoncategory.model.District>
		findByCityId_Active(long cityId, boolean active) {

		return getService().findByCityId_Active(cityId, active);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the district with the primary key.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws PortalException if a district with the primary key could not be found
	 */
	public static com.nss.commoncategory.model.District getDistrict(
			long districtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDistrict(districtId);
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
	public static java.util.List<com.nss.commoncategory.model.District>
		getDistricts(int start, int end) {

		return getService().getDistricts(start, end);
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public static int getDistrictsCount() {
		return getService().getDistrictsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param district the district
	 * @return the district that was updated
	 */
	public static com.nss.commoncategory.model.District updateDistrict(
		com.nss.commoncategory.model.District district) {

		return getService().updateDistrict(district);
	}

	public static com.nss.commoncategory.model.District updateDistrict(
			long districtId, long countryId, long cityId, String name,
			String code, String description, int priority, int countCode,
			boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDistrict(
			districtId, countryId, cityId, name, code, description, priority,
			countCode, active, serContext);
	}

	public static DistrictLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DistrictLocalService, DistrictLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DistrictLocalService.class);

		ServiceTracker<DistrictLocalService, DistrictLocalService>
			serviceTracker =
				new ServiceTracker<DistrictLocalService, DistrictLocalService>(
					bundle.getBundleContext(), DistrictLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}