package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.StreetLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class StreetLocalServiceTracker extends ServiceTracker<StreetLocalService, StreetLocalService>{
	
	public StreetLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, StreetLocalService.class, null);
    }
}
