package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.InvestorService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class InvestorServiceTracker extends ServiceTracker<InvestorService, InvestorService>{
	public InvestorServiceTracker(BundleContext bundleContext) {
        super(bundleContext, InvestorService.class, null);
    }
}
