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

package com.nss.taskcategory.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CurrencyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CurrencyLocalService
 * @generated
 */
@ProviderType
public class CurrencyLocalServiceWrapper
	implements CurrencyLocalService, ServiceWrapper<CurrencyLocalService> {

	public CurrencyLocalServiceWrapper(
		CurrencyLocalService currencyLocalService) {

		_currencyLocalService = currencyLocalService;
	}

	/**
	 * Adds the currency to the database. Also notifies the appropriate model listeners.
	 *
	 * @param currency the currency
	 * @return the currency that was added
	 */
	@Override
	public com.nss.taskcategory.model.Currency addCurrency(
		com.nss.taskcategory.model.Currency currency) {

		return _currencyLocalService.addCurrency(currency);
	}

	@Override
	public com.nss.taskcategory.model.Currency addCurrency(
			long userId, String name, String code, int priority, boolean active,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currencyLocalService.addCurrency(
			userId, name, code, priority, active, description, serviceContext);
	}

	@Override
	public int countByActive(boolean active) {
		return _currencyLocalService.countByActive(active);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _currencyLocalService.countByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator);
	}

	@Override
	public int countByCompanyId(long companyId) {
		return _currencyLocalService.countByCompanyId(companyId);
	}

	@Override
	public int countByCompanyId_Active(long companyId, boolean active) {
		return _currencyLocalService.countByCompanyId_Active(companyId, active);
	}

	/**
	 * Creates a new currency with the primary key. Does not add the currency to the database.
	 *
	 * @param currencyId the primary key for the new currency
	 * @return the new currency
	 */
	@Override
	public com.nss.taskcategory.model.Currency createCurrency(long currencyId) {
		return _currencyLocalService.createCurrency(currencyId);
	}

	/**
	 * Deletes the currency from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currency the currency
	 * @return the currency that was removed
	 */
	@Override
	public com.nss.taskcategory.model.Currency deleteCurrency(
		com.nss.taskcategory.model.Currency currency) {

		return _currencyLocalService.deleteCurrency(currency);
	}

	/**
	 * Deletes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency that was removed
	 * @throws PortalException if a currency with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.Currency deleteCurrency(long currencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currencyLocalService.deleteCurrency(currencyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currencyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _currencyLocalService.dynamicQuery();
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

		return _currencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _currencyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _currencyLocalService.dynamicQuery(
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

		return _currencyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _currencyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.nss.taskcategory.model.Currency fetchByCode(String code) {
		return _currencyLocalService.fetchByCode(code);
	}

	@Override
	public com.nss.taskcategory.model.Currency fetchCurrency(long currencyId) {
		return _currencyLocalService.fetchCurrency(currencyId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.Currency> findByActive(
		boolean active) {

		return _currencyLocalService.findByActive(active);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.Currency> findByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _currencyLocalService.findByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator,
			start, end, obc);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.Currency> findByCompanyId(
		long companyId) {

		return _currencyLocalService.findByCompanyId(companyId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.Currency>
		findByCompanyId_Active(long companyId, boolean active) {

		return _currencyLocalService.findByCompanyId_Active(companyId, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _currencyLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.CurrencyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of currencies
	 */
	@Override
	public java.util.List<com.nss.taskcategory.model.Currency> getCurrencies(
		int start, int end) {

		return _currencyLocalService.getCurrencies(start, end);
	}

	/**
	 * Returns the number of currencies.
	 *
	 * @return the number of currencies
	 */
	@Override
	public int getCurrenciesCount() {
		return _currencyLocalService.getCurrenciesCount();
	}

	/**
	 * Returns the currency with the primary key.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency
	 * @throws PortalException if a currency with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.Currency getCurrency(long currencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currencyLocalService.getCurrency(currencyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _currencyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _currencyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currencyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the currency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param currency the currency
	 * @return the currency that was updated
	 */
	@Override
	public com.nss.taskcategory.model.Currency updateCurrency(
		com.nss.taskcategory.model.Currency currency) {

		return _currencyLocalService.updateCurrency(currency);
	}

	@Override
	public com.nss.taskcategory.model.Currency updateCurrency(
			long currencyId, String name, String code, int priority,
			boolean active, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currencyLocalService.updateCurrency(
			currencyId, name, code, priority, active, description,
			serviceContext);
	}

	@Override
	public CurrencyLocalService getWrappedService() {
		return _currencyLocalService;
	}

	@Override
	public void setWrappedService(CurrencyLocalService currencyLocalService) {
		_currencyLocalService = currencyLocalService;
	}

	private CurrencyLocalService _currencyLocalService;

}