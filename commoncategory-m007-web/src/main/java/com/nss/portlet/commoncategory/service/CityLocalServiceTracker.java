package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.CityLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class CityLocalServiceTracker extends ServiceTracker<CityLocalService, CityLocalService>{
	
	public CityLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, CityLocalService.class, null);
    }
}
