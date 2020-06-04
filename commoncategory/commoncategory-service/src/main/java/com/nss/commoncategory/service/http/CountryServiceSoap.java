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

package com.nss.commoncategory.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.nss.commoncategory.service.CountryServiceUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>CountryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.commoncategory.model.CountrySoap</code>. If the method in the
 * service utility returns a
 * <code>com.nss.commoncategory.model.Country</code>, that is translated to a
 * <code>com.nss.commoncategory.model.CountrySoap</code>. Methods that SOAP
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
 * @see CountryServiceHttp
 * @generated
 */
@ProviderType
public class CountryServiceSoap {

	public static boolean hasAddPermission(long groupId)
		throws RemoteException {

		try {
			boolean returnValue = CountryServiceUtil.hasAddPermission(groupId);

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
			boolean returnValue = CountryServiceUtil.hasUpdatePermission(
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
			boolean returnValue = CountryServiceUtil.hasViewPermission(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.nss.commoncategory.model.CountrySoap addCountry(
			long userId, long continentId, String name,
			String internationalName, String nationality, String code,
			String description, int priority, int countCode, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws RemoteException {

		try {
			com.nss.commoncategory.model.Country returnValue =
				CountryServiceUtil.addCountry(
					userId, continentId, name, internationalName, nationality,
					code, description, priority, countCode, active, serContext);

			return com.nss.commoncategory.model.CountrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.nss.commoncategory.model.CountrySoap updateCountry(
			long countryId, long continentId, String name,
			String internationalName, String nationality, String code,
			String description, int priority, int countCode, boolean active)
		throws RemoteException {

		try {
			com.nss.commoncategory.model.Country returnValue =
				CountryServiceUtil.updateCountry(
					countryId, continentId, name, internationalName,
					nationality, code, description, priority, countCode,
					active);

			return com.nss.commoncategory.model.CountrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CountryServiceSoap.class);

}