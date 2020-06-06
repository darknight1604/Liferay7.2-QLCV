package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.TaskStatusService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TaskStatusServiceTracker extends ServiceTracker<TaskStatusService, TaskStatusService>{
	public TaskStatusServiceTracker(BundleContext bundleContext) {
        super(bundleContext, TaskStatusService.class, null);
    }
}
