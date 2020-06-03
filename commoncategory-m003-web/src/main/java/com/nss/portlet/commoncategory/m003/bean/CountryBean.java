package com.nss.portlet.commoncategory.m003.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.model.Continent;
import com.nss.commoncategory.model.Country;
import com.nss.portlet.commoncategory.m003.lazy.LazyCountryModel;
import com.nss.portlet.commoncategory.service.ContinentLocalServiceTracker;
import com.nss.portlet.commoncategory.service.CountryLocalServiceTracker;
import com.nss.portlet.commoncategory.service.CountryServiceTracker;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.Date;
import java.util.List;
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

@ManagedBean(name="countryBean")
@ViewScoped
public class CountryBean {
	private Country country;
	
	private CountryLocalServiceTracker countryLocalServiceTracker;
	
	private ContinentLocalServiceTracker continentLocalServiceTracker;
	
	private CountryServiceTracker countryServiceTracker;
	
	private LazyCountryModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	private List<Continent> continents;
	
	private Long continentId;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			lazyModel = new LazyCountryModel(companyId, groupId, countryLocalServiceTracker.getService());
			
			serviceContext = new ServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			_initPermission();
			_initContinents();
		}
	}
	
	private void _initLocalService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		countryLocalServiceTracker = new CountryLocalServiceTracker(bundleContext);
		countryLocalServiceTracker.open();
		continentLocalServiceTracker = new ContinentLocalServiceTracker(bundleContext);
		continentLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		countryServiceTracker = new CountryServiceTracker(bundleContext);
		countryServiceTracker.open();
	}
	
	private void _initPermission() {
		if(countryServiceTracker.getService() != null) {
			try {
				hasAddPermission = countryServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = countryServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void _initContinents() {
		if(continentLocalServiceTracker.getService() != null) {
			continents = continentLocalServiceTracker.getService().findByActive(true);
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		countryLocalServiceTracker.close();
		countryServiceTracker.close();
		continentLocalServiceTracker.close();
	}
	
	public void openNewObject(ActionEvent event) {
		
		if(countryLocalServiceTracker.getService() != null) {
			country = countryLocalServiceTracker.getService().createCountry(0L);
			country.setActive(true);
			country.setPriority(100);
			continentId = null;
		} 
		PrimeFaces.current().executeScript("PF('dlgAdd').show();"); 
	}
	
	public void save(ActionEvent event) { 
		try {
			if(country.getCountryId() > 0) {
				country = countryServiceTracker.getService().updateCountry(country.getCountryId(), continentId, country.getName(), country.getInternationalName(), 
						country.getNationality(), country.getCode(), country.getDescription(), country.getPriority(), country.getCountCode());
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				country = countryServiceTracker.getService().addCountry(userId, continentId, country.getName(), country.getInternationalName(), 
						country.getNationality(), country.getCode(), country.getDescription(), country.getPriority(), country.getCountCode(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, MyConstants.PROCESSED_SUCCESSFULLY, StringPool.BLANK));
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, MyConstants.ERROR_PRINCIPAL, StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, MyConstants.DUPLICATE_CODE, StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, MyConstants.FAILED_TO_COMPLETE, StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		country = lazyModel.getRowData();
		if(country != null) {
			continentId = country.getContinentId();
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		country = lazyModel.getRowData();
		if(country != null && countryLocalServiceTracker.getService() != null) {
			country.setActive(!country.isActive());
			country.setModifiedDate(new Date());
			countryLocalServiceTracker.getService().updateCountry(country);
			
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public LazyCountryModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyCountryModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public List<Continent> getContinents() {
		return continents;
	}

	public Long getContinentId() {
		return continentId;
	}

	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}
}
