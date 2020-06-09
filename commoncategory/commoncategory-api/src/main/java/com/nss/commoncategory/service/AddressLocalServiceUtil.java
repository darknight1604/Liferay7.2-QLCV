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
 * Provides the local service utility for Address. This utility wraps
 * <code>com.nss.commoncategory.service.impl.AddressLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AddressLocalService
 * @generated
 */
@ProviderType
public class AddressLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.nss.commoncategory.service.impl.AddressLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the address to the database. Also notifies the appropriate model listeners.
	 *
	 * @param address the address
	 * @return the address that was added
	 */
	public static com.nss.commoncategory.model.Address addAddress(
		com.nss.commoncategory.model.Address address) {

		return getService().addAddress(address);
	}

	public static com.nss.commoncategory.model.Address addAddress(
			long userId, long classNameId, long classPK, long countryId,
			long cityId, long districtId, long wardId, long streetId,
			String streetOther, String quarter, String houseNumber,
			String building, String floor, String room, int type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAddress(
			userId, classNameId, classPK, countryId, cityId, districtId, wardId,
			streetId, streetOther, quarter, houseNumber, building, floor, room,
			type, serviceContext);
	}

	public static int countByC_C_T(long classNameId, long classPK, int type) {
		return getService().countByC_C_T(classNameId, classPK, type);
	}

	public static int countByClassNameId_ClassPK(
		long classNameId, long classPK) {

		return getService().countByClassNameId_ClassPK(classNameId, classPK);
	}

	public static int countByCompanyId(long companyId) {
		return getService().countByCompanyId(companyId);
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	public static com.nss.commoncategory.model.Address createAddress(
		long addressId) {

		return getService().createAddress(addressId);
	}

	/**
	 * Deletes the address from the database. Also notifies the appropriate model listeners.
	 *
	 * @param address the address
	 * @return the address that was removed
	 */
	public static com.nss.commoncategory.model.Address deleteAddress(
		com.nss.commoncategory.model.Address address) {

		return getService().deleteAddress(address);
	}

	/**
	 * Deletes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws PortalException if a address with the primary key could not be found
	 */
	public static com.nss.commoncategory.model.Address deleteAddress(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAddress(addressId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.AddressModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.AddressModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.nss.commoncategory.model.Address fetchAddress(
		long addressId) {

		return getService().fetchAddress(addressId);
	}

	public static java.util.List<com.nss.commoncategory.model.Address>
		findByC_C_T(long classNameId, long classPK, int type) {

		return getService().findByC_C_T(classNameId, classPK, type);
	}

	public static java.util.List<com.nss.commoncategory.model.Address>
		findByClassNameId_ClassPK(long classNameId, long classPK) {

		return getService().findByClassNameId_ClassPK(classNameId, classPK);
	}

	public static java.util.List<com.nss.commoncategory.model.Address>
		findByClassNameId_ClassPK(
			long classNameId, long classPK, int start, int end) {

		return getService().findByClassNameId_ClassPK(
			classNameId, classPK, start, end);
	}

	public static java.util.List<com.nss.commoncategory.model.Address>
		findByCompanyId(long companyId) {

		return getService().findByCompanyId(companyId);
	}

	public static java.util.List<com.nss.commoncategory.model.Address>
		findByCompanyId(long companyId, int start, int end) {

		return getService().findByCompanyId(companyId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the address with the primary key.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws PortalException if a address with the primary key could not be found
	 */
	public static com.nss.commoncategory.model.Address getAddress(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAddress(addressId);
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.commoncategory.model.impl.AddressModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	public static java.util.List<com.nss.commoncategory.model.Address>
		getAddresses(int start, int end) {

		return getService().getAddresses(start, end);
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	public static int getAddressesCount() {
		return getService().getAddressesCount();
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

	public static void removeByC_C_T(long classNameId, long classPK, int type) {
		getService().removeByC_C_T(classNameId, classPK, type);
	}

	public static void removeByClassNameId_ClassPK(
		long classNameId, long classPK) {

		getService().removeByClassNameId_ClassPK(classNameId, classPK);
	}

	public static void removeByCompanyId(long companyId) {
		getService().removeByCompanyId(companyId);
	}

	/**
	 * Updates the address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param address the address
	 * @return the address that was updated
	 */
	public static com.nss.commoncategory.model.Address updateAddress(
		com.nss.commoncategory.model.Address address) {

		return getService().updateAddress(address);
	}

	public static com.nss.commoncategory.model.Address updateAddress(
			long addressId, long classNameId, long classPK, long countryId,
			long cityId, long districtId, long wardId, long streetId,
			String streetOther, String quarter, String houseNumber,
			String building, String floor, String room, int type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateAddress(
			addressId, classNameId, classPK, countryId, cityId, districtId,
			wardId, streetId, streetOther, quarter, houseNumber, building,
			floor, room, type, serviceContext);
	}

	public static AddressLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AddressLocalService, AddressLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AddressLocalService.class);

		ServiceTracker<AddressLocalService, AddressLocalService>
			serviceTracker =
				new ServiceTracker<AddressLocalService, AddressLocalService>(
					bundle.getBundleContext(), AddressLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}