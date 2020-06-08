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

package com.nss.taskcategory.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.nss.taskcategory.model.Investor;
import com.nss.taskcategory.service.InvestorService;
import com.nss.taskcategory.service.persistence.CurrencyFinder;
import com.nss.taskcategory.service.persistence.CurrencyPersistence;
import com.nss.taskcategory.service.persistence.InvestorFinder;
import com.nss.taskcategory.service.persistence.InvestorPersistence;
import com.nss.taskcategory.service.persistence.TaskGroupFinder;
import com.nss.taskcategory.service.persistence.TaskGroupPersistence;
import com.nss.taskcategory.service.persistence.TaskStatusFinder;
import com.nss.taskcategory.service.persistence.TaskStatusPersistence;
import com.nss.taskcategory.service.persistence.TaskTypeFinder;
import com.nss.taskcategory.service.persistence.TaskTypePersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the investor remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nss.taskcategory.service.impl.InvestorServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.nss.taskcategory.service.impl.InvestorServiceImpl
 * @generated
 */
public abstract class InvestorServiceBaseImpl
	extends BaseServiceImpl
	implements InvestorService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>InvestorService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.InvestorServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			InvestorService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		investorService = (InvestorService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return InvestorService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Investor.class;
	}

	protected String getModelClassName() {
		return Investor.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = investorPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected CurrencyPersistence currencyPersistence;

	@Reference
	protected CurrencyFinder currencyFinder;

	@Reference
	protected com.nss.taskcategory.service.InvestorLocalService
		investorLocalService;

	protected InvestorService investorService;

	@Reference
	protected InvestorPersistence investorPersistence;

	@Reference
	protected InvestorFinder investorFinder;

	@Reference
	protected TaskGroupPersistence taskGroupPersistence;

	@Reference
	protected TaskGroupFinder taskGroupFinder;

	@Reference
	protected TaskStatusPersistence taskStatusPersistence;

	@Reference
	protected TaskStatusFinder taskStatusFinder;

	@Reference
	protected TaskTypePersistence taskTypePersistence;

	@Reference
	protected TaskTypeFinder taskTypeFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}