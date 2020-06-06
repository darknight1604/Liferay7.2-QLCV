package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.TaskStatusLocalService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TaskStatusLocalServiceTracker extends ServiceTracker<TaskStatusLocalService, TaskStatusLocalService>{
	public TaskStatusLocalServiceTracker(BundleContext bundleContext) {
        super(bundleContext, TaskStatusLocalService.class, null);
    }
}
