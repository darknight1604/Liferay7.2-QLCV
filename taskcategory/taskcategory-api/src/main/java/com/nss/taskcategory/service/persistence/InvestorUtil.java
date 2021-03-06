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

package com.nss.taskcategory.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.model.Investor;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the investor service. This utility wraps <code>com.nss.taskcategory.service.persistence.impl.InvestorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvestorPersistence
 * @generated
 */
@ProviderType
public class InvestorUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Investor investor) {
		getPersistence().clearCache(investor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Investor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Investor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Investor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Investor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Investor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Investor update(Investor investor) {
		return getPersistence().update(investor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Investor update(
		Investor investor, ServiceContext serviceContext) {

		return getPersistence().update(investor, serviceContext);
	}

	/**
	 * Returns all the investors where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching investors
	 */
	public static List<Investor> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the investors where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @return the range of matching investors
	 */
	public static List<Investor> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the investors where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching investors
	 */
	@Deprecated
	public static List<Investor> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Investor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the investors where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching investors
	 */
	public static List<Investor> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Investor> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching investor
	 * @throws NoSuchInvestorException if a matching investor could not be found
	 */
	public static Investor findByCompanyId_First(
			long companyId, OrderByComparator<Investor> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchInvestorException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching investor, or <code>null</code> if a matching investor could not be found
	 */
	public static Investor fetchByCompanyId_First(
		long companyId, OrderByComparator<Investor> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching investor
	 * @throws NoSuchInvestorException if a matching investor could not be found
	 */
	public static Investor findByCompanyId_Last(
			long companyId, OrderByComparator<Investor> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchInvestorException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching investor, or <code>null</code> if a matching investor could not be found
	 */
	public static Investor fetchByCompanyId_Last(
		long companyId, OrderByComparator<Investor> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the investors before and after the current investor in the ordered set where companyId = &#63;.
	 *
	 * @param investorId the primary key of the current investor
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next investor
	 * @throws NoSuchInvestorException if a investor with the primary key could not be found
	 */
	public static Investor[] findByCompanyId_PrevAndNext(
			long investorId, long companyId,
			OrderByComparator<Investor> orderByComparator)
		throws com.nss.taskcategory.exception.NoSuchInvestorException {

		return getPersistence().findByCompanyId_PrevAndNext(
			investorId, companyId, orderByComparator);
	}

	/**
	 * Removes all the investors where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of investors where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching investors
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Caches the investor in the entity cache if it is enabled.
	 *
	 * @param investor the investor
	 */
	public static void cacheResult(Investor investor) {
		getPersistence().cacheResult(investor);
	}

	/**
	 * Caches the investors in the entity cache if it is enabled.
	 *
	 * @param investors the investors
	 */
	public static void cacheResult(List<Investor> investors) {
		getPersistence().cacheResult(investors);
	}

	/**
	 * Creates a new investor with the primary key. Does not add the investor to the database.
	 *
	 * @param investorId the primary key for the new investor
	 * @return the new investor
	 */
	public static Investor create(long investorId) {
		return getPersistence().create(investorId);
	}

	/**
	 * Removes the investor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor that was removed
	 * @throws NoSuchInvestorException if a investor with the primary key could not be found
	 */
	public static Investor remove(long investorId)
		throws com.nss.taskcategory.exception.NoSuchInvestorException {

		return getPersistence().remove(investorId);
	}

	public static Investor updateImpl(Investor investor) {
		return getPersistence().updateImpl(investor);
	}

	/**
	 * Returns the investor with the primary key or throws a <code>NoSuchInvestorException</code> if it could not be found.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor
	 * @throws NoSuchInvestorException if a investor with the primary key could not be found
	 */
	public static Investor findByPrimaryKey(long investorId)
		throws com.nss.taskcategory.exception.NoSuchInvestorException {

		return getPersistence().findByPrimaryKey(investorId);
	}

	/**
	 * Returns the investor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor, or <code>null</code> if a investor with the primary key could not be found
	 */
	public static Investor fetchByPrimaryKey(long investorId) {
		return getPersistence().fetchByPrimaryKey(investorId);
	}

	/**
	 * Returns all the investors.
	 *
	 * @return the investors
	 */
	public static List<Investor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the investors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @return the range of investors
	 */
	public static List<Investor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the investors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of investors
	 */
	@Deprecated
	public static List<Investor> findAll(
		int start, int end, OrderByComparator<Investor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the investors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>InvestorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of investors
	 * @param end the upper bound of the range of investors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of investors
	 */
	public static List<Investor> findAll(
		int start, int end, OrderByComparator<Investor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the investors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of investors.
	 *
	 * @return the number of investors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InvestorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InvestorPersistence, InvestorPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InvestorPersistence.class);

		ServiceTracker<InvestorPersistence, InvestorPersistence>
			serviceTracker =
				new ServiceTracker<InvestorPersistence, InvestorPersistence>(
					bundle.getBundleContext(), InvestorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}