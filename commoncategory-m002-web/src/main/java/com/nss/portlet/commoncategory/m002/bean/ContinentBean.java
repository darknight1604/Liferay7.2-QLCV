package com.nss.portlet.commoncategory.m002.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.model.Continent;
import com.nss.portlet.commoncategory.m002.lazy.LazyContinentModel;
import com.nss.portlet.commoncategory.service.ContinentLocalServiceTracker;
import com.nss.portlet.commoncategory.service.ContinentServiceTracker;
import com.nss.portlet.commoncategory.util.LanguageUtil_m002;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.primefaces.PrimeFaces;

@ManagedBean(name="continentBean")
@ViewScoped
public class ContinentBean {
	private Continent continent;
	
	private ContinentLocalServiceTracker continentLocalServiceTracker;
	
	private ContinentServiceTracker continentServiceTracker;
	
	private LazyContinentModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			lazyModel = new LazyContinentModel(continentLocalServiceTracker.getService());
			
			serviceContext = new ServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			_initPermission();
		}
	}
	
	private void _initLocalService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		continentLocalServiceTracker = new ContinentLocalServiceTracker(bundleContext);
		continentLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		continentServiceTracker = new ContinentServiceTracker(bundleContext);
		continentServiceTracker.open();
	}
	
	private void _initPermission() {
		if(continentServiceTracker.getService() != null) {
			try {
				hasAddPermission = continentServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = continentServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		continentLocalServiceTracker.close();
		continentServiceTracker.close();
	}
	
	public void openNewObject(ActionEvent event) {
		_createNewObject();
		PrimeFaces.current().executeScript("PF('dlgAdd').show();"); 
	}
	
	public void saveNew(ActionEvent event) {
		_save(true);
	}
	
	public void save(ActionEvent event) { 
		_save(false);
	}
	
	public void _save(boolean saveNew) { 
		try {
			if(continent.getContinentId() > 0) {
				continent = continentServiceTracker.getService().update(continent.getContinentId(), 
						continent.getName(), continent.getInternationalName(), continent.getCode(), 
						continent.getDescription(), continent.getPriority(), continent.getCountCode(), continent.isActive());
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				continent = continentServiceTracker.getService().addContinent(userId, continent.getName(), 
						continent.getInternationalName(), continent.getCode(), 
						continent.getDescription(), continent.getPriority(), continent.getCountCode(), continent.isActive(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m002.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m002.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m002.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m002.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(continentLocalServiceTracker.getService() != null) {
			continent = continentLocalServiceTracker.getService().createContinent(0L);
			continent.setActive(true);
			continent.setPriority(100);
		} 
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		continent = lazyModel.getRowData();
		if(continent != null) {
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		continent = lazyModel.getRowData();
		if(continent != null && continentLocalServiceTracker.getService() != null) {
			continent.setActive(!continent.isActive());
			continent.setModifiedDate(new Date());
			continentLocalServiceTracker.getService().updateContinent(continent);
			
			lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
		}
	}
	
	//Getter && Setter

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public LazyContinentModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyContinentModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public boolean isHasAddPermission() {
		return hasAddPermission;
	}

	public boolean isHasUpdatePermission() {
		return hasUpdatePermission;
	}
}
