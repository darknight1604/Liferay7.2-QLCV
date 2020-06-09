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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.nss.commoncategory.model.Address;
import com.nss.commoncategory.service.AddressLocalServiceUtil;
import com.nss.taskcategory.model.Investor;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the Investor service. Represents a row in the &quot;nss_taskcategory_investor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.nss.taskcategory.model.Investor</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class InvestorImpl extends InvestorBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a investor model instance should use the {@link com.nss.taskcategory.model.Investor} interface instead.
	 */
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Address address;
	
	private static Log _log = LogFactoryUtil.getLog(InvestorImpl.class.getName()); 

	public InvestorImpl() {
	}

	public Address getAddress() {
		if(address == null) {
			try {
				ClassName cnInvestor = ClassNameLocalServiceUtil.getClassName(Investor.class.getName());
				if(cnInvestor != null) {
					List<Address> list = AddressLocalServiceUtil.findByClassNameId_ClassPK(cnInvestor.getClassNameId(), getInvestorId());
					if(list != null && !list.isEmpty()) {
						address = list.get(0);
					}
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		return address;
	}

}