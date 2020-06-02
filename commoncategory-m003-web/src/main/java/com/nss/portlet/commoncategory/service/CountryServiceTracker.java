package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.CountryService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class CountryServiceTracker extends ServiceTracker<CountryService, CountryService>{
	
	public CountryServiceTracker(BundleContext bundleContext) {
        super(bundleContext, CountryService.class, null);
    }
}
