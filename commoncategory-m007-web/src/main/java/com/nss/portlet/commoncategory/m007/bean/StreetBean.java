package com.nss.portlet.commoncategory.m007.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.model.District;
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.model.Ward;
import com.nss.portlet.commoncategory.m007.lazy.LazyStreetModel;
import com.nss.portlet.commoncategory.service.CityLocalServiceTracker;
import com.nss.portlet.commoncategory.service.CountryLocalServiceTracker;
import com.nss.portlet.commoncategory.service.DistrictLocalServiceTracker;
import com.nss.portlet.commoncategory.service.StreetLocalServiceTracker;
import com.nss.portlet.commoncategory.service.StreetServiceTracker;
import com.nss.portlet.commoncategory.service.WardLocalServiceTracker;
import com.nss.portlet.commoncategory.util.LanguageUtil_m007;
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

@ManagedBean(name="streetBean")
@ViewScoped
public class StreetBean {
	private Street street;
	
	private StreetLocalServiceTracker streetLocalServiceTracker;
	
	private StreetServiceTracker streetServiceTracker;
	
	private WardLocalServiceTracker wardLocalServiceTracker;
	
	private DistrictLocalServiceTracker districtLocalServiceTracker;
	
	private CityLocalServiceTracker cityLocalServiceTracker;
	
	private CountryLocalServiceTracker countryLocalServiceTracker;
	
	private LazyStreetModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	private List<Country> countries;
	
	private List<City> cities;
	
	private List<District> districts;
	
	private List<Ward> wards;
	
	private Long cityId;
	private Long countryId;
	private Long districtId;
	private Long wardId;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			lazyModel = new LazyStreetModel(companyId, groupId, streetLocalServiceTracker.getService());
			
			serviceContext = new ServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			_initPermission();
			_initCountries();
//			_initCities();
//			_initDistricts();
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
		streetLocalServiceTracker = new StreetLocalServiceTracker(bundleContext);
		streetLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		streetServiceTracker = new StreetServiceTracker(bundleContext);
		streetServiceTracker.open();
	}
	
	private void _initPermission() {
		if(streetServiceTracker.getService() != null) {
			try {
				hasAddPermission = streetServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = streetServiceTracker.getService().hasUpdatePermission(groupId);
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
	
	private void _initWards(long districtId) {
		if(wardLocalServiceTracker.getService() != null) {
			wards = wardLocalServiceTracker.getService().findByDistrictId_Active(districtId, true);
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		streetLocalServiceTracker.close();
		streetServiceTracker.close();
		wardLocalServiceTracker.close();
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
			if(street.getStreetId() > 0) {
				street = streetServiceTracker.getService().updateStreet(street.getStreetId(), 
						countryId, cityId, districtId, wardId, street.getName(), 
						street.getCode(), street.getDescription(), street.isActive(), street.getPriority(), 
						street.getCountCode(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				street = streetServiceTracker.getService().addStreet(userId, 
						countryId, cityId, districtId, wardId, street.getName(), 
						street.getCode(), street.getDescription(), street.isActive(), street.getPriority(), 
						street.getCountCode(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m007.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m007.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m007.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m007.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(streetLocalServiceTracker.getService() != null) {
			street = streetLocalServiceTracker.getService().createStreet(0L);
			street.setActive(true);
			street.setPriority(100);
			cityId = null;
			countryId = null;
			districtId = null;
			wardId = null;
			
			cities = null;
			districts = null;
			wards = null;
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		street = lazyModel.getRowData();
		if(street != null) {
			countryId = street.getCountryId();
			cityId = street.getCityId();
			districtId = street.getDistrictId();
			wardId = street.getWardId();
			
			_initCities(countryId);
			_initDistricts(cityId);
			_initWards(districtId);
			
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		street = lazyModel.getRowData();
		if(street != null && streetLocalServiceTracker.getService() != null) {
			street.setActive(!street.isActive());
			street.setModifiedDate(new Date());
			streetLocalServiceTracker.getService().updateStreet(street);
			
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
	
	public void selectDistrict(ValueChangeEvent event) {
		long districtId = (Long) event.getNewValue();
		if(districtId > 0) {
			_initWards(districtId);
		}else {
			wards = null;
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

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public LazyStreetModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyStreetModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public Long getWardId() {
		return wardId;
	}

	public void setWardId(Long wardId) {
		this.wardId = wardId;
	}

	public List<Ward> getWards() {
		return wards;
	}

}
