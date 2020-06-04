package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.StreetService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class StreetServiceTracker extends ServiceTracker<StreetService, StreetService>{
	
	public StreetServiceTracker(BundleContext bundleContext) {
        super(bundleContext, StreetService.class, null);
    }
}
