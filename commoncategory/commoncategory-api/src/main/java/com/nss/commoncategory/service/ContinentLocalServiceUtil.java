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
 * Provides the local service utility for Continent. This utility wraps
 * <code>com.nss.commoncategory.service.impl.ContinentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContinentLocalService
 * @generated
 */
@ProviderType
public class ContinentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.commoncategory.service.impl.ContinentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the continent to the database. Also notifies the appropriate model listeners.
	 *
	 * @param continent the continent
	 * @return the continent that was added
	 */
	public static com.nss.commoncategory.model.Continent addContinent(
		com.nss.commoncategory.model.Continent continent) {

		return getService().addContinent(continent);
	}

	public static com.nss.commoncategory.model.Continent addContinent(
			long userId, String name, String internationalName, String code,
			String description, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addContinent(
			userId, name, internationalName, code, description, priority,
			countCode, serContext);
	}

	public static int countByBaseSearch(
			int active, String name, String internationalName, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByBaseSearch(
			active, name, internationalName, code, description, andOperator);
	}

	/**
	 * Creates a new continent with the primary key. Does not add the continent to the database.
	 *
	 * @param continentId the primary key for the new continent
	 * @return the new continent
	 */
	public static com.nss.commoncategory.model.Continent createContinent(
		long continentId) {

		return getService().createContinent(continentId);
	}

	/**
	 * Deletes the continent from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continent the continent
	 * @return the continent that was removed
	 */
	public static com.nss.commoncategory.model.Continent deleteContinent(
		com.nss.commoncategory.model.Continent continent) {

		return getService().deleteContinent(continent);
	}

	/**
	 * Deletes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent that was removed
	 * @throws PortalException if a continent with the primary key could not be found
	 */
	public static com.nss.commoncategory.model.Continent deleteContinent(
			long continentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteContinent(continentId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.nss.commoncategory.model.Continent fetchByCode(
		String code) {

		return getService().fetchByCode(code);
	}

	public static com.nss.commoncategory.model.Continent fetchContinent(
		long continentId) {

		return getService().fetchContinent(continentId);
	}

	public static java.util.List<com.nss.commoncategory.model.Continent>
		findByActive(boolean active) {

		return getService().findByActive(active);
	}

	public static java.util.List<com.nss.commoncategory.model.Continent>
		findByActive(boolean active, int start, int end) {

		return getService().findByActive(active, start, end);
	}

	public static java.util.List<com.nss.commoncategory.model.Continent>
			findByBaseSearch(
				int active, String name, String internationalName, String code,
				String description, boolean andOperator, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByBaseSearch(
			active, name, internationalName, code, description, andOperator,
			start, end, obc);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the continent with the primary key.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent
	 * @throws PortalException if a continent with the primary key could not be found
	 */
	public static com.nss.commoncategory.model.Continent getContinent(
			long continentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getContinent(continentId);
	}

	/**
	 * Returns a range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.ContinentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @return the range of continents
	 */
	public static java.util.List<com.nss.commoncategory.model.Continent>
		getContinents(int start, int end) {

		return getService().getContinents(start, end);
	}

	/**
	 * Returns the number of continents.
	 *
	 * @return the number of continents
	 */
	public static int getContinentsCount() {
		return getService().getContinentsCount();
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

	public static com.nss.commoncategory.model.Continent update(
			long continentId, String name, String internationalName,
			String code, String description, int priority, int countCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().update(
			continentId, name, internationalName, code, description, priority,
			countCode);
	}

	/**
	 * Updates the continent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param continent the continent
	 * @return the continent that was updated
	 */
	public static com.nss.commoncategory.model.Continent updateContinent(
		com.nss.commoncategory.model.Continent continent) {

		return getService().updateContinent(continent);
	}

	public static ContinentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ContinentLocalService, ContinentLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ContinentLocalService.class);

		ServiceTracker<ContinentLocalService, ContinentLocalService>
			serviceTracker =
				new ServiceTracker
					<ContinentLocalService, ContinentLocalService>(
						bundle.getBundleContext(), ContinentLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}