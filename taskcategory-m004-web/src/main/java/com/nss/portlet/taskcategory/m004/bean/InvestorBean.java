package com.nss.portlet.taskcategory.m004.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.commoncategory.model.Address;
import com.nss.commoncategory.model.AddressDTO;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.model.District;
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.model.Ward;
import com.nss.portlet.taskcategory.m004.lazy.LazyInvestorModel;
import com.nss.portlet.taskcategory.service.CityLocalServiceTracker;
import com.nss.portlet.taskcategory.service.CountryLocalServiceTracker;
import com.nss.portlet.taskcategory.service.DistrictLocalServiceTracker;
import com.nss.portlet.taskcategory.service.InvestorLocalServiceTracker;
import com.nss.portlet.taskcategory.service.InvestorServiceTracker;
import com.nss.portlet.taskcategory.service.StreetLocalServiceTracker;
import com.nss.portlet.taskcategory.service.WardLocalServiceTracker;
import com.nss.portlet.taskcategory.util.LanguageUtil_m004;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.model.Investor;

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

@ManagedBean(name="investorBean")
@ViewScoped
public class InvestorBean {
	
	private Investor investor;

	private InvestorLocalServiceTracker investorLocalServiceTracker;
	
	private InvestorServiceTracker investorServiceTracker;
	
	private LazyInvestorModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	private AddressDTO addressDTO;
	
	private long classNameId;
	
	private CountryLocalServiceTracker countryLocalServiceTracker;
	
	private CityLocalServiceTracker cityLocalServiceTracker;
	
	private DistrictLocalServiceTracker districtLocalServiceTracker;
	
	private WardLocalServiceTracker wardLocalServiceTracker;
	
	private StreetLocalServiceTracker streetLocalServiceTracker;
	
	private List<Country> countries;
	
	private List<City> cities;
	
	private List<District> districts;
	
	private List<Ward> wards;
	
	private List<Street> streets;
		
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			ClassName clazzName = ClassNameLocalServiceUtil.getClassName(Investor.class.getName());
			if(clazzName != null) {
				classNameId = clazzName.getClassNameId();
			}
			lazyModel = new LazyInvestorModel(companyId, groupId, investorLocalServiceTracker.getService());
			
			serviceContext = new ServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			_initPermission();
			_initCountry();
			_initAddressDTO(null);
		}
	}
	
	private void _initCountry() {
		if(countryLocalServiceTracker.getService() != null) {
			countries = countryLocalServiceTracker.getService().findByActive(true);
		}
	}
	
	private void _initLocalService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		investorLocalServiceTracker = new InvestorLocalServiceTracker(bundleContext);
		investorLocalServiceTracker.open();
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
		investorServiceTracker = new InvestorServiceTracker(bundleContext);
		investorServiceTracker.open();
	}
	
	private void _initPermission() {
		if(investorServiceTracker.getService() != null) {
			try {
				hasAddPermission = investorServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = investorServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		investorServiceTracker.close();
		investorLocalServiceTracker.close();
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
	
	private void _save(boolean saveNew) { 
		try {
			if(investor.getInvestorId() > 0) {
				investor = investorServiceTracker.getService().updateInvestor(investor.getInvestorId(), 
						investor.getName(), investor.getPhoneNumber(), investor.getEmail(), investor.isActive(), addressDTO, serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				investor = investorServiceTracker.getService().addInvestor(userId, 
						investor.getName(), investor.getPhoneNumber(), investor.getEmail(), investor.isActive(), addressDTO, 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m004.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
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
		if(investorLocalServiceTracker.getService() != null) {
			investor = investorLocalServiceTracker.getService().createInvestor(0L);
			investor.setActive(true);
			
			_initAddressDTO(null);
		}
	}
	
	private void _initAddressDTO(Address address) {
		if(address != null) {
			addressDTO = new AddressDTO(address);
		}else {
			addressDTO = new AddressDTO(classNameId, /*classPK*/0, /*countryId*/0, /*cityId*/0, /*districtId*/0, 
					/*wardId*/0, /*streetId*/0, /*streetOther*/null, /*quarter*/null, 
					/*houseNumber*/null, /*building*/null, /*floor*/null, /*room*/null, /*type*/0);
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		investor = lazyModel.getRowData();
		if(investor != null) {
			_initAddressDTO(investor.getAddress());
			_initCountryById(addressDTO.getCountryId());
			_initCityById(addressDTO.getCityId());
			_initDistrictById(addressDTO.getDistrictId());
			_initWardById(addressDTO.getWardId());
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		investor = lazyModel.getRowData();
		if(investor != null && investorLocalServiceTracker.getService() != null) {
			investor.setActive(!investor.isActive());
			investor.setModifiedDate(new Date());
			investorLocalServiceTracker.getService().updateInvestor(investor);
			
			lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
		}
	}
	
	public void selectCountry(ValueChangeEvent event) {
		long countryId = (Long) event.getNewValue();
		if(countryId > 0) {
			_initCountryById(countryId);
		}else {
			cities = null;
			districts = null;
			wards = null;
			streets = null;
		}
	}
	
	private void _initCountryById(long countryId) {
		if(countryId > 0 && cityLocalServiceTracker.getService() != null) {
			cities = cityLocalServiceTracker.getService().findByCountryId_Active(countryId, true);
		}
	}
	
	public void selectCity(ValueChangeEvent event) {
		long cityId = (Long) event.getNewValue();
		if(cityId > 0) {
			_initCityById(cityId);
		}else {
			districts = null;
			wards = null;
			streets = null;
		}
	}
	
	private void _initCityById(long cityId) {
		if(cityId > 0 && districtLocalServiceTracker.getService() != null) {
			districts = districtLocalServiceTracker.getService().findByCityId_Active(cityId, true);
		}
	}
	
	public void selectDistrict(ValueChangeEvent event) {
		long districtId = (Long) event.getNewValue();
		if(districtId > 0) {
			_initDistrictById(districtId);
		}else {
			wards = null;
			streets = null;
		}
	}
	
	private void _initDistrictById(long districtId) {
		if(districtId > 0 && wardLocalServiceTracker.getService() != null) {
			wards = wardLocalServiceTracker.getService().findByDistrictId_Active(districtId, true);
		}
	}
	
	public void selectWard(ValueChangeEvent event) {
		long wardId = (Long) event.getNewValue();
		if(wardId > 0) {
			_initWardById(wardId);
		}else {
			streets = null;
		}
	}
	
	private void _initWardById(long wardId) {
		if(wardId > 0 && streetLocalServiceTracker.getService() != null) {
			streets = streetLocalServiceTracker.getService().findByWardId_Active(wardId, true);
		}
	}
	
	//Getter && Setter

	public boolean isHasAddPermission() {
		return hasAddPermission;
	}

	public boolean isHasUpdatePermission() {
		return hasUpdatePermission;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public LazyInvestorModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyInvestorModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public List<City> getCities() {
		return cities;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public List<Ward> getWards() {
		return wards;
	}

	public List<Street> getStreets() {
		return streets;
	}

}
