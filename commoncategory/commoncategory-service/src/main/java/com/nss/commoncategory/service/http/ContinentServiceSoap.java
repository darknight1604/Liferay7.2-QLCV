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

import com.nss.commoncategory.service.ContinentServiceUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>ContinentServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.commoncategory.model.ContinentSoap</code>. If the method in the
 * service utility returns a
 * <code>com.nss.commoncategory.model.Continent</code>, that is translated to a
 * <code>com.nss.commoncategory.model.ContinentSoap</code>. Methods that SOAP
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
 * @see ContinentServiceHttp
 * @generated
 */
@ProviderType
public class ContinentServiceSoap {

	public static
		com.liferay.portal.kernel.security.permission.PermissionChecker
				getMyPermissionChecker()
			throws RemoteException {

		try {
			com.liferay.portal.kernel.security.permission.PermissionChecker
				returnValue = ContinentServiceUtil.getMyPermissionChecker();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasAddPermission(long groupId)
		throws RemoteException {

		try {
			boolean returnValue = ContinentServiceUtil.hasAddPermission(
				groupId);

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
			boolean returnValue = ContinentServiceUtil.hasUpdatePermission(
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
			boolean returnValue = ContinentServiceUtil.hasViewPermission(
				groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.nss.commoncategory.model.ContinentSoap addContinent(
			long userId, String name, String internationalName, String code,
			String description, int priority, int countCode,
			com.liferay.portal.kernel.service.ServiceContext serContext)
		throws RemoteException {

		try {
			com.nss.commoncategory.model.Continent returnValue =
				ContinentServiceUtil.addContinent(
					userId, name, internationalName, code, description,
					priority, countCode, serContext);

			return com.nss.commoncategory.model.ContinentSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.nss.commoncategory.model.ContinentSoap update(
			long continentId, String name, String internationalName,
			String code, String description, int priority, int countCode)
		throws RemoteException {

		try {
			com.nss.commoncategory.model.Continent returnValue =
				ContinentServiceUtil.update(
					continentId, name, internationalName, code, description,
					priority, countCode);

			return com.nss.commoncategory.model.ContinentSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ContinentServiceSoap.class);

}