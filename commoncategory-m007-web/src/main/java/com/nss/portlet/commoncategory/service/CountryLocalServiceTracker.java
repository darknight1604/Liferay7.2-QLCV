package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.CountryLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class CountryLocalServiceTracker extends ServiceTracker<CountryLocalService, CountryLocalService>{
	
	public CountryLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, CountryLocalService.class, null);
    }
}
