package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.ContinentService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ContinentServiceTracker extends ServiceTracker<ContinentService, ContinentService>{
	
	public ContinentServiceTracker(BundleContext bundleContext) {
        super(bundleContext, ContinentService.class, null);
    }
}
