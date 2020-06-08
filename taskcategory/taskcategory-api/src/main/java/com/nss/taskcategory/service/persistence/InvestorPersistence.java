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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nss.taskcategory.exception.NoSuchInvestorException;
import com.nss.taskcategory.model.Investor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the investor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvestorUtil
 * @generated
 */
@ProviderType
public interface InvestorPersistence extends BasePersistence<Investor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvestorUtil} to access the investor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the investors where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching investors
	 */
	public java.util.List<Investor> findByCompanyId(long companyId);

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
	public java.util.List<Investor> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<Investor> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Investor> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Investor> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Investor> orderByComparator);

	/**
	 * Returns the first investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching investor
	 * @throws NoSuchInvestorException if a matching investor could not be found
	 */
	public Investor findByCompanyId_First(
			long companyId, OrderByComparator<Investor> orderByComparator)
		throws NoSuchInvestorException;

	/**
	 * Returns the first investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching investor, or <code>null</code> if a matching investor could not be found
	 */
	public Investor fetchByCompanyId_First(
		long companyId, OrderByComparator<Investor> orderByComparator);

	/**
	 * Returns the last investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching investor
	 * @throws NoSuchInvestorException if a matching investor could not be found
	 */
	public Investor findByCompanyId_Last(
			long companyId, OrderByComparator<Investor> orderByComparator)
		throws NoSuchInvestorException;

	/**
	 * Returns the last investor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching investor, or <code>null</code> if a matching investor could not be found
	 */
	public Investor fetchByCompanyId_Last(
		long companyId, OrderByComparator<Investor> orderByComparator);

	/**
	 * Returns the investors before and after the current investor in the ordered set where companyId = &#63;.
	 *
	 * @param investorId the primary key of the current investor
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next investor
	 * @throws NoSuchInvestorException if a investor with the primary key could not be found
	 */
	public Investor[] findByCompanyId_PrevAndNext(
			long investorId, long companyId,
			OrderByComparator<Investor> orderByComparator)
		throws NoSuchInvestorException;

	/**
	 * Removes all the investors where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of investors where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching investors
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Caches the investor in the entity cache if it is enabled.
	 *
	 * @param investor the investor
	 */
	public void cacheResult(Investor investor);

	/**
	 * Caches the investors in the entity cache if it is enabled.
	 *
	 * @param investors the investors
	 */
	public void cacheResult(java.util.List<Investor> investors);

	/**
	 * Creates a new investor with the primary key. Does not add the investor to the database.
	 *
	 * @param investorId the primary key for the new investor
	 * @return the new investor
	 */
	public Investor create(long investorId);

	/**
	 * Removes the investor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor that was removed
	 * @throws NoSuchInvestorException if a investor with the primary key could not be found
	 */
	public Investor remove(long investorId) throws NoSuchInvestorException;

	public Investor updateImpl(Investor investor);

	/**
	 * Returns the investor with the primary key or throws a <code>NoSuchInvestorException</code> if it could not be found.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor
	 * @throws NoSuchInvestorException if a investor with the primary key could not be found
	 */
	public Investor findByPrimaryKey(long investorId)
		throws NoSuchInvestorException;

	/**
	 * Returns the investor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param investorId the primary key of the investor
	 * @return the investor, or <code>null</code> if a investor with the primary key could not be found
	 */
	public Investor fetchByPrimaryKey(long investorId);

	/**
	 * Returns all the investors.
	 *
	 * @return the investors
	 */
	public java.util.List<Investor> findAll();

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
	public java.util.List<Investor> findAll(int start, int end);

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
	public java.util.List<Investor> findAll(
		int start, int end, OrderByComparator<Investor> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Investor> findAll(
		int start, int end, OrderByComparator<Investor> orderByComparator);

	/**
	 * Removes all the investors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of investors.
	 *
	 * @return the number of investors
	 */
	public int countAll();

}