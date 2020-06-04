package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.WardService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class WardServiceTracker extends ServiceTracker<WardService, WardService>{
	
	public WardServiceTracker(BundleContext bundleContext) {
        super(bundleContext, WardService.class, null);
    }
}
