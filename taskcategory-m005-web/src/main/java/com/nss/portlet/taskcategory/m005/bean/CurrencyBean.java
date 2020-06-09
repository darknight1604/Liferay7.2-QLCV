package com.nss.portlet.taskcategory.m005.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.portlet.taskcategory.m005.lazy.LazyCurrencyModel;
import com.nss.portlet.taskcategory.service.CurrencyLocalServiceTracker;
import com.nss.portlet.taskcategory.service.CurrencyServiceTracker;
import com.nss.portlet.taskcategory.util.LanguageUtil_m005;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.model.Currency;

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

@ManagedBean(name="currencyBean")
@ViewScoped
public class CurrencyBean {
	private Currency currency;
	
	private CurrencyLocalServiceTracker currencyLocalServiceTracker;
	
	private CurrencyServiceTracker currencyServiceTracker;
	
	private LazyCurrencyModel lazyModel;
	
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
			lazyModel = new LazyCurrencyModel(companyId, groupId, currencyLocalServiceTracker.getService());
			
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
		currencyLocalServiceTracker = new CurrencyLocalServiceTracker(bundleContext);
		currencyLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		currencyServiceTracker = new CurrencyServiceTracker(bundleContext);
		currencyServiceTracker.open();
	}
	
	private void _initPermission() {
		if(currencyServiceTracker.getService() != null) {
			try {
				hasAddPermission = currencyServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = currencyServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		currencyServiceTracker.close();
		currencyLocalServiceTracker.close();
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
	
	private void _save(boolean saveNew) { 
		try {
			if(currency.getCurrencyId() > 0) {
				currency = currencyServiceTracker.getService().updateCurrency(currency.getCurrencyId(), 
						currency.getName(), currency.getCode(), currency.getPriority(), currency.isActive(), currency.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				currency = currencyServiceTracker.getService().addCurrency(userId, 
						currency.getName(), currency.getCode(), currency.getPriority(), currency.isActive(), currency.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m005.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m005.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m005.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m005.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(currencyLocalServiceTracker.getService() != null) {
			currency = currencyLocalServiceTracker.getService().createCurrency(0L);
			currency.setActive(true);
			currency.setPriority(100);
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		currency = lazyModel.getRowData();
		if(currency != null) {
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		currency = lazyModel.getRowData();
		if(currency != null && currencyLocalServiceTracker.getService() != null) {
			currency.setActive(!currency.isActive());
			currency.setModifiedDate(new Date());
			currencyLocalServiceTracker.getService().updateCurrency(currency);
			
			lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
		}
	}
	
	//Getter && Setter

	public boolean isHasAddPermission() {
		return hasAddPermission;
	}

	public boolean isHasUpdatePermission() {
		return hasUpdatePermission;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public LazyCurrencyModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyCurrencyModel lazyModel) {
		this.lazyModel = lazyModel;
	}

}
