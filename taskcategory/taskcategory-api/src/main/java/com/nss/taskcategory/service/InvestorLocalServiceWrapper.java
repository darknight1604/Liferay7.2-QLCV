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
 * Provides a wrapper for {@link InvestorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvestorLocalService
 * @generated
 */
@ProviderType
public class InvestorLocalServiceWrapper
	implements InvestorLocalService, ServiceWrapper<InvestorLocalService> {

	public InvestorLocalServiceWrapper(
		InvestorLocalService investorLocalService) {

		_investorLocalService = investorLocalService;
	}

	/**
	 * Adds the investor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param investor the investor
	 * @return the investor that was added
	 */
	@Override
	public com.nss.taskcategory.model.Investor addInvestor(
		com.nss.taskcategory.model.Investor investor) {

		return _investorLocalService.addInvestor(investor);
	}

	@Override
	public com.nss.taskcategory.model.Investor addInvestor(
			long userId, String name, String phoneNumber, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorLocalService.addInvestor(
			userId, name, phoneNumber, email, serviceContext);
	}

	@Override
	public int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _investorLocalService.countByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator);
	}

	@Override
	public int countByCompanyId(long companyId) {
		return _investorLocalService.countByCompanyId(companyId);
	}

	/**
	 * Creates a new investor with the primary key. Does not add the investor to the database.
	 *
	 * @param investorId the primary key for the new investor
	 * @return the new investor
	 */
	@Override
	public com.nss.taskcategory.model.Investor createInvestor(long investorId) {
		return _investorLocalService.createInvestor(investorId);
	}

	/**
	 * Deletes the investor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param investor the investor
	 * @return the investor that was removed
	 */
	@Override
	public com.nss.taskcategory.model.Investor deleteInvestor(
		com.nss.taskcategory.model.Investor investor) {

		return _investorLocalService.deleteInvestor(investor);
	}

	/**
	 * Deletes the investor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor that was removed
	 * @throws PortalException if a investor with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.Investor deleteInvestor(long investorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorLocalService.deleteInvestor(investorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _investorLocalService.dynamicQuery();
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

		return _investorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _investorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _investorLocalService.dynamicQuery(
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

		return _investorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _investorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.nss.taskcategory.model.Investor fetchInvestor(long investorId) {
		return _investorLocalService.fetchInvestor(investorId);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.Investor> findByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _investorLocalService.findByBaseSearch(
			companyId, groupId, active, name, code, description, andOperator,
			start, end, obc);
	}

	@Override
	public java.util.List<com.nss.taskcategory.model.Investor> findByCompanyId(
		long companyId) {

		return _investorLocalService.findByCompanyId(companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _investorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _investorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the investor with the primary key.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor
	 * @throws PortalException if a investor with the primary key could not be found
	 */
	@Override
	public com.nss.taskcategory.model.Investor getInvestor(long investorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorLocalService.getInvestor(investorId);
	}

	/**
	 * Returns a range of all the investors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @return the range of investors
	 */
	@Override
	public java.util.List<com.nss.taskcategory.model.Investor> getInvestors(
		int start, int end) {

		return _investorLocalService.getInvestors(start, end);
	}

	/**
	 * Returns the number of investors.
	 *
	 * @return the number of investors
	 */
	@Override
	public int getInvestorsCount() {
		return _investorLocalService.getInvestorsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _investorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the investor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param investor the investor
	 * @return the investor that was updated
	 */
	@Override
	public com.nss.taskcategory.model.Investor updateInvestor(
		com.nss.taskcategory.model.Investor investor) {

		return _investorLocalService.updateInvestor(investor);
	}

	@Override
	public com.nss.taskcategory.model.Investor updateInvestor(
			long investorId, String name, String phoneNumber, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _investorLocalService.updateInvestor(
			investorId, name, phoneNumber, email, serviceContext);
	}

	@Override
	public InvestorLocalService getWrappedService() {
		return _investorLocalService;
	}

	@Override
	public void setWrappedService(InvestorLocalService investorLocalService) {
		_investorLocalService = investorLocalService;
	}

	private InvestorLocalService _investorLocalService;

}