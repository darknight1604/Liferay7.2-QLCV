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

package com.nss.commoncategory.model.impl;

import com.nss.commoncategory.model.Ward;
import com.nss.commoncategory.service.WardLocalServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model base implementation for the Ward service. Represents a row in the &quot;nss_commoncategory_ward&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WardImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WardImpl
 * @see Ward
 * @generated
 */
@ProviderType
public abstract class WardBaseImpl extends WardModelImpl implements Ward {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ward model instance should use the <code>Ward</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			WardLocalServiceUtil.addWard(this);
		}
		else {
			WardLocalServiceUtil.updateWard(this);
		}
	}

}