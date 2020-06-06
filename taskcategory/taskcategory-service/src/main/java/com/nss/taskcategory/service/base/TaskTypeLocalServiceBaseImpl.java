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

import com.nss.taskcategory.model.TaskType;
import com.nss.taskcategory.service.TaskTypeLocalService;
import com.nss.taskcategory.service.persistence.TaskGroupFinder;
import com.nss.taskcategory.service.persistence.TaskGroupPersistence;
import com.nss.taskcategory.service.persistence.TaskStatusFinder;
import com.nss.taskcategory.service.persistence.TaskStatusPersistence;
import com.nss.taskcategory.service.persistence.TaskTypeFinder;
import com.nss.taskcategory.service.persistence.TaskTypePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the task type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nss.taskcategory.service.impl.TaskTypeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.nss.taskcategory.service.impl.TaskTypeLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class TaskTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements TaskTypeLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TaskTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.nss.taskcategory.service.TaskTypeLocalServiceUtil</code>.
	 */

	/**
	 * Adds the task type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskType the task type
	 * @return the task type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TaskType addTaskType(TaskType taskType) {
		taskType.setNew(true);

		return taskTypePersistence.update(taskType);
	}

	/**
	 * Creates a new task type with the primary key. Does not add the task type to the database.
	 *
	 * @param taskTypeId the primary key for the new task type
	 * @return the new task type
	 */
	@Override
	@Transactional(enabled = false)
	public TaskType createTaskType(long taskTypeId) {
		return taskTypePersistence.create(taskTypeId);
	}

	/**
	 * Deletes the task type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type that was removed
	 * @throws PortalException if a task type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TaskType deleteTaskType(long taskTypeId) throws PortalException {
		return taskTypePersistence.remove(taskTypeId);
	}

	/**
	 * Deletes the task type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskType the task type
	 * @return the task type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TaskType deleteTaskType(TaskType taskType) {
		return taskTypePersistence.remove(taskType);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			TaskType.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return taskTypePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return taskTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return taskTypePersistence.findWithDynamicQuery(
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
		return taskTypePersistence.countWithDynamicQuery(dynamicQuery);
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

		return taskTypePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TaskType fetchTaskType(long taskTypeId) {
		return taskTypePersistence.fetchByPrimaryKey(taskTypeId);
	}

	/**
	 * Returns the task type with the primary key.
	 *
	 * @param taskTypeId the primary key of the task type
	 * @return the task type
	 * @throws PortalException if a task type with the primary key could not be found
	 */
	@Override
	public TaskType getTaskType(long taskTypeId) throws PortalException {
		return taskTypePersistence.findByPrimaryKey(taskTypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(taskTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TaskType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("taskTypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			taskTypeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TaskType.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("taskTypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(taskTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TaskType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("taskTypeId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return taskTypeLocalService.deleteTaskType((TaskType)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return taskTypePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the task types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.nss.taskcategory.model.impl.TaskTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task types
	 * @param end the upper bound of the range of task types (not inclusive)
	 * @return the range of task types
	 */
	@Override
	public List<TaskType> getTaskTypes(int start, int end) {
		return taskTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of task types.
	 *
	 * @return the number of task types
	 */
	@Override
	public int getTaskTypesCount() {
		return taskTypePersistence.countAll();
	}

	/**
	 * Updates the task type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taskType the task type
	 * @return the task type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TaskType updateTaskType(TaskType taskType) {
		return taskTypePersistence.update(taskType);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TaskTypeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		taskTypeLocalService = (TaskTypeLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TaskTypeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TaskType.class;
	}

	protected String getModelClassName() {
		return TaskType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = taskTypePersistence.getDataSource();

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
	protected TaskGroupPersistence taskGroupPersistence;

	@Reference
	protected TaskGroupFinder taskGroupFinder;

	@Reference
	protected TaskStatusPersistence taskStatusPersistence;

	@Reference
	protected TaskStatusFinder taskStatusFinder;

	protected TaskTypeLocalService taskTypeLocalService;

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
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}