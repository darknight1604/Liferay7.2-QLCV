package com.nss.portlet.taskcategory.bean;

import com.nss.portlet.taskcategory.service.InvestorLocalServiceTracker;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

@ManagedBean(name="investorBean")
@ViewScoped
public class InvestorBean {

	private InvestorLocalServiceTracker investorLocalServiceTracker;
		
	private String name = "error";
	
	@PostConstruct
	public void init() {
		_initLocalService();
	}
	
	private void _initLocalService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		investorLocalServiceTracker = new InvestorLocalServiceTracker(bundleContext);
		investorLocalServiceTracker.open();
		if(investorLocalServiceTracker.getService() != null) {
			name = "success";
		}
	}

	public String getName() {
		return name;
	}
}
