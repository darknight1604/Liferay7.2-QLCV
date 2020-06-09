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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.nss.commoncategory.model.Continent;
import com.nss.commoncategory.service.ContinentLocalService;
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

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the continent local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nss.commoncategory.service.impl.ContinentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.nss.commoncategory.service.impl.ContinentLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class ContinentLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ContinentLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ContinentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.commoncategory.service.ContinentLocalServiceUtil</code>.
	 */

	/**
	 * Adds the continent to the database. Also notifies the appropriate model listeners.
	 *
	 * @param continent the continent
	 * @return the continent that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Continent addContinent(Continent continent) {
		continent.setNew(true);

		return continentPersistence.update(continent);
	}

	/**
	 * Creates a new continent with the primary key. Does not add the continent to the database.
	 *
	 * @param continentId the primary key for the new continent
	 * @return the new continent
	 */
	@Override
	@Transactional(enabled = false)
	public Continent createContinent(long continentId) {
		return continentPersistence.create(continentId);
	}

	/**
	 * Deletes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent that was removed
	 * @throws PortalException if a continent with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Continent deleteContinent(long continentId) throws PortalException {
		return continentPersistence.remove(continentId);
	}

	/**
	 * Deletes the continent from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continent the continent
	 * @return the continent that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Continent deleteContinent(Continent continent) {
		return continentPersistence.remove(continent);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Continent.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return continentPersistence.findWithDynamicQuery(dynamicQuery);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return continentPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return continentPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return continentPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return continentPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Continent fetchContinent(long continentId) {
		return continentPersistence.fetchByPrimaryKey(continentId);
	}

	/**
	 * Returns the continent with the primary key.
	 *
	 * @param continentId the primary key of the continent
	 * @return the continent
	 * @throws PortalException if a continent with the primary key could not be found
	 */
	@Override
	public Continent getContinent(long continentId) throws PortalException {
		return continentPersistence.findByPrimaryKey(continentId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(continentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Continent.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("continentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			continentLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Continent.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"continentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(continentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Continent.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("continentId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return continentLocalService.deleteContinent((Continent)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return continentPersistence.findByPrimaryKey(primaryKeyObj);
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
	@Override
	public List<Continent> getContinents(int start, int end) {
		return continentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of continents.
	 *
	 * @return the number of continents
	 */
	@Override
	public int getContinentsCount() {
		return continentPersistence.countAll();
	}

	/**
	 * Updates the continent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param continent the continent
	 * @return the continent that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Continent updateContinent(Continent continent) {
		return continentPersistence.update(continent);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ContinentLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		continentLocalService = (ContinentLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ContinentLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Continent.class;
	}

	protected String getModelClassName() {
		return Continent.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = continentPersistence.getDataSource();

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
	protected CityPersistence cityPersistence;

	@Reference
	protected CityFinder cityFinder;

	protected ContinentLocalService continentLocalService;

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
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}