package com.nss.portlet.commoncategory.m003.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.commoncategory.model.Country;
import com.nss.commoncategory.service.CountryLocalService;
import com.nss.portlet.commoncategory.m003.criteria.CountrySearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCountryModel extends LazyDataModel<Country>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CountryLocalService countryLocalService;
	
	private CountrySearchCriteria criteria;
	
	private List<Country> countries;
	
	private long companyId;
	
	private long groupId;
	
	public LazyCountryModel(long companyId, long groupId, CountryLocalService countryLocalService) {
		this.countryLocalService = countryLocalService;
		criteria = new CountrySearchCriteria();
		countries = new ArrayList<Country>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public Country getRowData(String rowKey) {
		long countryId = GetterUtil.getLong(rowKey);
		if(countryId > 0 && !countries.isEmpty()) {
			for(Country tmp : countries) {
				if(tmp.getCountryId() == countryId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Country country) {
		return country.getCountryId();
	}
	
	@Override
	public List<Country> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		countries = new ArrayList<Country>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = countryLocalService.countByBaseSearch(companyId, groupId, criteria.getContinentId(), criteria.getActive(), criteria.getName(), criteria.getInternationalName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			countries = countryLocalService.findByBaseSearch(companyId, groupId, criteria.getContinentId(), criteria.getActive(), criteria.getName(), criteria.getInternationalName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return countries;
	}

	public CountrySearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(CountrySearchCriteria criteria) {
		this.criteria = criteria;
	}

}
