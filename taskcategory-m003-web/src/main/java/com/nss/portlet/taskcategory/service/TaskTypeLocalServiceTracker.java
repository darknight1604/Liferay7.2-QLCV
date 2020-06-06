package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.TaskTypeLocalService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TaskTypeLocalServiceTracker extends ServiceTracker<TaskTypeLocalService, TaskTypeLocalService>{
	public TaskTypeLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, TaskTypeLocalService.class, null);
    }
}
