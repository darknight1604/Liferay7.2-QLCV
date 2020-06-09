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

package com.nss.taskcategory.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.nss.taskcategory.service.InvestorServiceUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>InvestorServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.taskcategory.model.InvestorSoap</code>. If the method in the
 * service utility returns a
 * <code>com.nss.taskcategory.model.Investor</code>, that is translated to a
 * <code>com.nss.taskcategory.model.InvestorSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvestorServiceHttp
 * @generated
 */
@ProviderType
public class InvestorServiceSoap {

	public static com.nss.taskcategory.model.InvestorSoap addInvestor(
			long userId, String name, String phoneNumber, String email,
			boolean active, com.nss.commoncategory.model.AddressDTO addressDTO,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.nss.taskcategory.model.Investor returnValue =
				InvestorServiceUtil.addInvestor(
					userId, name, phoneNumber, email, active, addressDTO,
					serviceContext);

			return com.nss.taskcategory.model.InvestorSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.nss.taskcategory.model.InvestorSoap updateInvestor(
			long investorId, String name, String phoneNumber, String email,
			boolean active, com.nss.commoncategory.model.AddressDTO addressDTO,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.nss.taskcategory.model.Investor returnValue =
				InvestorServiceUtil.updateInvestor(
					investorId, name, phoneNumber, email, active, addressDTO,
					serviceContext);

			return com.nss.taskcategory.model.InvestorSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasAddPermission(long groupId)
		throws RemoteException {

		try {
			boolean returnValue = InvestorServiceUtil.hasAddPermission(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasUpdatePermission(long groupId)
		throws RemoteException {

		try {
			boolean returnValue = InvestorServiceUtil.hasUpdatePermission(
				groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasViewPermission(long groupId)
		throws RemoteException {

		try {
			boolean returnValue = InvestorServiceUtil.hasViewPermission(
				groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(InvestorServiceSoap.class);

}