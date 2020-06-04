package com.nss.portlet.commoncategory.m005.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.exception.DuplicateCodeException;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.model.District;
import com.nss.portlet.commoncategory.m005.lazy.LazyDistrictModel;
import com.nss.portlet.commoncategory.service.CityLocalServiceTracker;
import com.nss.portlet.commoncategory.service.CountryLocalServiceTracker;
import com.nss.portlet.commoncategory.service.DistrictLocalServiceTracker;
import com.nss.portlet.commoncategory.service.DistrictServiceTracker;
import com.nss.portlet.commoncategory.util.LanguageUtil_m005;
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

@ManagedBean(name="districtBean")
@ViewScoped
public class DistrictBean {
	private District district;
	
	private DistrictLocalServiceTracker districtLocalServiceTracker;
	
	private DistrictServiceTracker districtServiceTracker;
	
	private CityLocalServiceTracker cityLocalServiceTracker;
	
	private CountryLocalServiceTracker countryLocalServiceTracker;
	
	private LazyDistrictModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	private List<City> cities;
	
	private List<Country> countries;
	
	private Long cityId;
	
	private Long countryId;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			lazyModel = new LazyDistrictModel(companyId, groupId, districtLocalServiceTracker.getService());
			
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
		districtLocalServiceTracker = new DistrictLocalServiceTracker(bundleContext);
		districtLocalServiceTracker.open();
		cityLocalServiceTracker = new CityLocalServiceTracker(bundleContext);
		cityLocalServiceTracker.open();
		countryLocalServiceTracker = new CountryLocalServiceTracker(bundleContext);
		countryLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		districtServiceTracker = new DistrictServiceTracker(bundleContext);
		districtServiceTracker.open();
	}
	
	private void _initPermission() {
		if(districtServiceTracker.getService() != null) {
			try {
				hasAddPermission = districtServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = districtServiceTracker.getService().hasUpdatePermission(groupId);
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
		districtLocalServiceTracker.close();
		districtServiceTracker.close();
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
			if(district.getDistrictId() > 0) {
				district = districtServiceTracker.getService().updateDistrict(district.getDistrictId(), 
						countryId, cityId, district.getName(), 
								district.getCode(), district.getDescription(), district.getPriority(), 
								district.getCountCode(), district.isActive(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				district = districtServiceTracker.getService().addDistrict(userId, countryId, cityId, district.getName(), 
						district.getCode(), district.getDescription(), district.getPriority(), 
						district.getCountCode(), district.isActive(), serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m005.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
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
		if(districtLocalServiceTracker.getService() != null) {
			district = districtLocalServiceTracker.getService().createDistrict(0L);
			district.setActive(true);
			district.setPriority(100);
			cityId = null;
			countryId = null;
			cities = null;
		} 
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		district = lazyModel.getRowData();
		if(district != null) {
			cityId = district.getCityId();
			countryId = district.getCountryId();
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		district = lazyModel.getRowData();
		if(district != null && districtLocalServiceTracker.getService() != null) {
			district.setActive(!district.isActive());
			district.setModifiedDate(new Date());
			districtLocalServiceTracker.getService().updateDistrict(district);
			
			lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
		}
	}
	
	public void selectQuocGia(ValueChangeEvent event) {
		long quocGiaId = (Long) event.getNewValue();
		if(quocGiaId > 0 && cityLocalServiceTracker.getService() != null) {
			cities = cityLocalServiceTracker.getService().findByCountryId_Active(quocGiaId, true);
		}else {
			cities = null;
		}
	}
	
	//Getter && Setter

	public boolean isHasAddPermission() {
		return hasAddPermission;
	}

	public boolean isHasUpdatePermission() {
		return hasUpdatePermission;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public LazyDistrictModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDistrictModel lazyModel) {
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

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public List<City> getCities() {
		return cities;
	}

}
