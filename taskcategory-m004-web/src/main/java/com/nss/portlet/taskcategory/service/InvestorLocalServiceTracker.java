package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.InvestorLocalService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class InvestorLocalServiceTracker extends ServiceTracker<InvestorLocalService, InvestorLocalService>{
	public InvestorLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, InvestorLocalService.class, null);
    }
}
