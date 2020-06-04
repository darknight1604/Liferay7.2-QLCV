package com.nss.portlet.commoncategory.m004.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.service.CityLocalService;
import com.nss.portlet.commoncategory.m004.criteria.CitySearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCityModel extends LazyDataModel<City>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CityLocalService cityLocalService;
	
	private CitySearchCriteria criteria;
	
	private List<City> cities;
	
	private long companyId;
	
	private long groupId;
	
	public LazyCityModel(long companyId, long groupId, CityLocalService cityLocalService) {
		this.cityLocalService = cityLocalService;
		criteria = new CitySearchCriteria();
		cities = new ArrayList<City>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public City getRowData(String rowKey) {
		long cityId = GetterUtil.getLong(rowKey);
		if(cityId > 0 && !cities.isEmpty()) {
			for(City tmp : cities) {
				if(tmp.getCityId() == cityId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(City city) {
		return city.getCityId();
	}
	
	@Override
	public List<City> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		cities = new ArrayList<City>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = cityLocalService.countByBaseSearch(companyId, groupId, criteria.getCountryId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			cities = cityLocalService.findByBaseSearch(companyId, groupId, criteria.getCountryId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return cities;
	}

	public CitySearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(CitySearchCriteria criteria) {
		this.criteria = criteria;
	}
}
