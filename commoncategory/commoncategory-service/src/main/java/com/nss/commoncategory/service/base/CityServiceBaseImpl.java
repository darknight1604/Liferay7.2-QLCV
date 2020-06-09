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

package com.nss.commoncategory.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.nss.commoncategory.model.City;
import com.nss.commoncategory.service.CityService;
import com.nss.commoncategory.service.persistence.AddressPersistence;
import com.nss.commoncategory.service.persistence.CityFinder;
import com.nss.commoncategory.service.persistence.CityPersistence;
import com.nss.commoncategory.service.persistence.ContinentFinder;
import com.nss.commoncategory.service.persistence.ContinentPersistence;
import com.nss.commoncategory.service.persistence.CountryFinder;
import com.nss.commoncategory.service.persistence.CountryPersistence;
import com.nss.commoncategory.service.persistence.DistrictFinder;
import com.nss.commoncategory.service.persistence.DistrictPersistence;
import com.nss.commoncategory.service.persistence.StreetFinder;
import com.nss.commoncategory.service.persistence.StreetPersistence;
import com.nss.commoncategory.service.persistence.WardFinder;
import com.nss.commoncategory.service.persistence.WardPersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the city remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nss.commoncategory.service.impl.CityServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.nss.commoncategory.service.impl.CityServiceImpl
 * @generated
 */
public abstract class CityServiceBaseImpl
	extends BaseServiceImpl
	implements CityService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CityService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.CityServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CityService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		cityService = (CityService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CityService.class.getName();
	}

	protected Class<?> getModelClass() {
		return City.class;
	}

	protected String getModelClassName() {
		return City.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = cityPersistence.getDataSource();

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
	protected AddressPersistence addressPersistence;

	@Reference
	protected com.nss.commoncategory.service.CityLocalService cityLocalService;

	protected CityService cityService;

	@Reference
	protected CityPersistence cityPersistence;

	@Reference
	protected CityFinder cityFinder;

	@Reference
	protected ContinentPersistence continentPersistence;

	@Reference
	protected ContinentFinder continentFinder;

	@Reference
	protected CountryPersistence countryPersistence;

	@Reference
	protected CountryFinder countryFinder;

	@Reference
	protected DistrictPersistence districtPersistence;

	@Reference
	protected DistrictFinder districtFinder;

	@Reference
	protected StreetPersistence streetPersistence;

	@Reference
	protected StreetFinder streetFinder;

	@Reference
	protected WardPersistence wardPersistence;

	@Reference
	protected WardFinder wardFinder;

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