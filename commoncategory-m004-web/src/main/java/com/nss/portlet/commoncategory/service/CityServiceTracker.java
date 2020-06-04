package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.CityService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class CityServiceTracker extends ServiceTracker<CityService, CityService>{
	
	public CityServiceTracker(BundleContext bundleContext) {
        super(bundleContext, CityService.class, null);
    }
}
