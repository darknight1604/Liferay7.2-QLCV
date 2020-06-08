package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.CurrencyService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class CurrencyServiceTracker extends ServiceTracker<CurrencyService, CurrencyService>{
	public CurrencyServiceTracker(BundleContext bundleContext) {
        super(bundleContext, CurrencyService.class, null);
    }
}
