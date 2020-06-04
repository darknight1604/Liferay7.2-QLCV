package com.nss.portlet.commoncategory.service;

import com.nss.commoncategory.service.DistrictLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class DistrictLocalServiceTracker extends ServiceTracker<DistrictLocalService, DistrictLocalService>{
	
	public DistrictLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, DistrictLocalService.class, null);
    }
}
