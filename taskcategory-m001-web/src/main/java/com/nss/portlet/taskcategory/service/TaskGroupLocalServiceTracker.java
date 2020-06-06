package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.TaskGroupLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TaskGroupLocalServiceTracker extends ServiceTracker<TaskGroupLocalService, TaskGroupLocalService>{
	public TaskGroupLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, TaskGroupLocalService.class, null);
    }
}
