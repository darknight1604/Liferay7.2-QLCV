package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.CurrencyLocalService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class CurrencyLocalServiceTracker extends ServiceTracker<CurrencyLocalService, CurrencyLocalService>{
	public CurrencyLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, CurrencyLocalService.class, null);
    }
}
