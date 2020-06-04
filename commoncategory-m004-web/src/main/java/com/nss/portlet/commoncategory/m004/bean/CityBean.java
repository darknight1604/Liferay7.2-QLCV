package com.nss.portlet.commoncategory.m004.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.Country;
import com.nss.portlet.commoncategory.m004.lazy.LazyCityModel;
import com.nss.portlet.commoncategory.service.CityLocalServiceTracker;
import com.nss.portlet.commoncategory.service.CityServiceTracker;
import com.nss.portlet.commoncategory.service.CountryLocalServiceTracker;
import com.nss.portlet.commoncategory.util.LanguageUtil_m004;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.primefaces.PrimeFaces;

@ManagedBean(name="cityBean")
@ViewScoped
public class CityBean {
	private City city;
	
	private CityLocalServiceTracker cityLocalServiceTracker;
	
	private CountryLocalServiceTracker countryLocalServiceTracker;
	
	private CityServiceTracker cityServiceTracker;
	
	private LazyCityModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	private List<Country> countries;
	
	private Long countryId;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
			viewRoot.setLocale(new Locale("vi"));
			
			_initLocalService();
			_initService();
			lazyModel = new LazyCityModel(companyId, groupId, cityLocalServiceTracker.getService());
			
			serviceContext = new ServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			_initPermission();
			_initCountries();
		}
	}
	
	private void _initLocalService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		countryLocalServiceTracker = new CountryLocalServiceTracker(bundleContext);
		countryLocalServiceTracker.open();
		cityLocalServiceTracker = new CityLocalServiceTracker(bundleContext);
		cityLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		cityServiceTracker = new CityServiceTracker(bundleContext);
		cityServiceTracker.open();
	}
	
	private void _initPermission() {
		if(cityServiceTracker.getService() != null) {
			try {
				hasAddPermission = cityServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = cityServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void _initCountries() {
		if(countryLocalServiceTracker.getService() != null) {
			countries = countryLocalServiceTracker.getService().findByActive(true);
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		countryLocalServiceTracker.close();
		cityServiceTracker.close();
		cityLocalServiceTracker.close();
	}
	
	public void openNewObject(ActionEvent event) {
		_createNewObject();
		PrimeFaces.current().executeScript("PF('dlgAdd').show();"); 
	}
	
	public void saveNew(ActionEvent event) {
		save(event);
		_createNewObject();
	}
	
	public void save(ActionEvent event) { 
		try {
			if(city.getCityId() > 0) {
				city = cityServiceTracker.getService().updateCity(city.getCityId(), countryId, city.getName(), 
						city.getCode(), city.getDescription(), city.getPriority(), city.getCountCode(), city.isActive(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				city = cityServiceTracker.getService().addCity(userId, countryId, city.getName(), 
						city.getCode(), city.getDescription(), city.getPriority(), city.getCountCode(), city.isActive(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m004.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m004.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m004.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m004.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(cityLocalServiceTracker.getService() != null) {
			city = cityLocalServiceTracker.getService().createCity(0L);
			city.setActive(true);
			city.setPriority(100);
			countryId = null;
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		city = lazyModel.getRowData();
		if(city != null) {
			countryId = city.getCountryId();
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		city = lazyModel.getRowData();
		if(city != null && cityLocalServiceTracker.getService() != null) {
			city.setActive(!city.isActive());
			city.setModifiedDate(new Date());
			cityLocalServiceTracker.getService().updateCity(city);
			
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public LazyCityModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyCityModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public List<Country> getCountries() {
		return countries;
	}

}
