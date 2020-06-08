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

package com.nss.taskcategory.model.impl;

import com.nss.taskcategory.model.Currency;
import com.nss.taskcategory.service.CurrencyLocalServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model base implementation for the Currency service. Represents a row in the &quot;nss_taskcategory_currency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CurrencyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrencyImpl
 * @see Currency
 * @generated
 */
@ProviderType
public abstract class CurrencyBaseImpl
	extends CurrencyModelImpl implements Currency {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a currency model instance should use the <code>Currency</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CurrencyLocalServiceUtil.addCurrency(this);
		}
		else {
			CurrencyLocalServiceUtil.updateCurrency(this);
		}
	}

}