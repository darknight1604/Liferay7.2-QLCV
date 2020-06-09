package com.nss.portlet.commoncategory.m006.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.model.District;
import com.nss.commoncategory.model.Ward;
import com.nss.portlet.commoncategory.m006.lazy.LazyWardModel;
import com.nss.portlet.commoncategory.service.CityLocalServiceTracker;
import com.nss.portlet.commoncategory.service.CountryLocalServiceTracker;
import com.nss.portlet.commoncategory.service.DistrictLocalServiceTracker;
import com.nss.portlet.commoncategory.service.WardLocalServiceTracker;
import com.nss.portlet.commoncategory.service.WardServiceTracker;
import com.nss.portlet.commoncategory.util.LanguageUtil_m006;
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
import javax.faces.event.ValueChangeEvent;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.primefaces.PrimeFaces;

@ManagedBean(name="wardBean")
@ViewScoped
public class WardBean {
	private Ward ward;
	
	private WardLocalServiceTracker wardLocalServiceTracker;
	
	private WardServiceTracker wardServiceTracker;
	
	private DistrictLocalServiceTracker districtLocalServiceTracker;
	
	private CityLocalServiceTracker cityLocalServiceTracker;
	
	private CountryLocalServiceTracker countryLocalServiceTracker;
	
	private LazyWardModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	private List<Country> countries;
	
	private List<City> cities;
	
	private List<District> districts;
	
	private Long cityId;
	private Long countryId;
	private Long districtId;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			lazyModel = new LazyWardModel(companyId, groupId, wardLocalServiceTracker.getService());
			
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
		districtLocalServiceTracker = new DistrictLocalServiceTracker(bundleContext);
		districtLocalServiceTracker.open();
		wardLocalServiceTracker = new WardLocalServiceTracker(bundleContext);
		wardLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		wardServiceTracker = new WardServiceTracker(bundleContext);
		wardServiceTracker.open();
	}
	
	private void _initPermission() {
		if(wardServiceTracker.getService() != null) {
			try {
				hasAddPermission = wardServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = wardServiceTracker.getService().hasUpdatePermission(groupId);
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
	
	private void _initCities(long countryId) {
		if(cityLocalServiceTracker.getService() != null) {
			cities = cityLocalServiceTracker.getService().findByCountryId_Active(countryId, true);
		}
	}
	
	private void _initDistricts(long cityId) {
		if(districtLocalServiceTracker.getService() != null) {
			districts = districtLocalServiceTracker.getService().findByCityId_Active(cityId, true);
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		wardLocalServiceTracker.close();
		wardServiceTracker.close();
		districtLocalServiceTracker.close();
		cityLocalServiceTracker.close();
		countryLocalServiceTracker.close();
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
			if(ward.getWardId() > 0) {
				ward = wardServiceTracker.getService().updateWard(ward.getWardId(), 
						countryId, cityId, districtId, ward.getName(), 
						ward.getCode(), ward.getDescription(), ward.isActive(), ward.getPriority(), 
						ward.getCountCode(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				ward = wardServiceTracker.getService().addWard(userId, 
						countryId, cityId, districtId, ward.getName(), 
						ward.getCode(), ward.getDescription(), ward.isActive(), ward.getPriority(), 
						ward.getCountCode(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m006.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m006.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m006.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m006.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(wardLocalServiceTracker.getService() != null) {
			ward = wardLocalServiceTracker.getService().createWard(0L);
			ward.setActive(true);
			ward.setPriority(100);
			cityId = null;
			countryId = null;
			districtId = null;
			
			cities = null;
			districts = null;
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		ward = lazyModel.getRowData();
		if(ward != null) {
			countryId = ward.getCountryId();
			cityId = ward.getCityId();
			districtId = ward.getDistrictId();
			
			_initCities(countryId);
			_initDistricts(cityId);
			
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		ward = lazyModel.getRowData();
		if(ward != null && wardLocalServiceTracker.getService() != null) {
			ward.setActive(!ward.isActive());
			ward.setModifiedDate(new Date());
			wardLocalServiceTracker.getService().updateWard(ward);
			
			lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
		}
	}
	
	public void selectCountry(ValueChangeEvent event) {
		long countryId = (Long) event.getNewValue();
		if(countryId > 0) {
			_initCities(countryId);
		}else {
			cities = null;
			districts = null;
		}
	}
	
	public void selectCity(ValueChangeEvent event) {
		long cityId = (Long) event.getNewValue();
		if(cityId > 0) {
			_initDistricts(cityId);
		}else {
			districts = null;
		}
	}
	
	//Getter && Setter

	public boolean isHasAddPermission() {
		return hasAddPermission;
	}

	public boolean isHasUpdatePermission() {
		return hasUpdatePermission;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public List<City> getCities() {
		return cities;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public LazyWardModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyWardModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public List<District> getDistricts() {
		return districts;
	}

}
