package com.nss.portlet.taskcategory.service;

import com.nss.commoncategory.service.WardLocalService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class WardLocalServiceTracker extends ServiceTracker<WardLocalService, WardLocalService>{
	public WardLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, WardLocalService.class, null);
    }
}
