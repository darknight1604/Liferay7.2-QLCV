package com.nss.portlet.taskcategory.service;

import com.nss.taskcategory.service.TaskTypeService;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TaskTypeServiceTracker extends ServiceTracker<TaskTypeService, TaskTypeService>{
	public TaskTypeServiceTracker(BundleContext bundleContext) {
        super(bundleContext, TaskTypeService.class, null);
    }
}
