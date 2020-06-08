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

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface CurrencyFinder {

	public int countByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.nss.taskcategory.model.Currency> findByBaseSearch(
			long companyId, long groupId, int active, String name, String code,
			String description, boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

}