package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.DistrictService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class DistrictServiceTracker extends ServiceTracker<DistrictService, DistrictService>{
	
	public DistrictServiceTracker(BundleContext bundleContext) {
        super(bundleContext, DistrictService.class, null);
    }
}
