package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.TaskGroupService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TaskGroupServiceTracker extends ServiceTracker<TaskGroupService, TaskGroupService>{
	public TaskGroupServiceTracker(BundleContext bundleContext) {
        super(bundleContext, TaskGroupService.class, null);
    }
}
