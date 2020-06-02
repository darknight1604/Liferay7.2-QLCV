package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.ContinentLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ContinentLocalServiceTracker extends ServiceTracker<ContinentLocalService, ContinentLocalService>{
	
	public ContinentLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, ContinentLocalService.class, null);
    }
}
