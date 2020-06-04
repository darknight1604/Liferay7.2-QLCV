package com.nss.portlet.commoncategory.m005.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.commoncategory.model.City;
import com.nss.commoncategory.model.District;
import com.nss.commoncategory.service.CityLocalService;
import com.nss.commoncategory.service.DistrictLocalService;
import com.nss.portlet.commoncategory.m005.criteria.DistrictSearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyDistrictModel extends LazyDataModel<District>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DistrictLocalService districtLocalService;
	
	private DistrictSearchCriteria criteria;
	
	private List<District> districts;
	
	private long companyId;
	
	private long groupId;
	
	public LazyDistrictModel(long companyId, long groupId, DistrictLocalService districtLocalService) {
		this.districtLocalService = districtLocalService;
		criteria = new DistrictSearchCriteria();
		districts = new ArrayList<District>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public District getRowData(String rowKey) {
		long districtId = GetterUtil.getLong(rowKey);
		if(districtId > 0 && !districts.isEmpty()) {
			for(District tmp : districts) {
				if(tmp.getDistrictId() == districtId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(District district) {
		return district.getDistrictId();
	}
	
	@Override
	public List<District> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		districts = new ArrayList<District>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = districtLocalService.countByBaseSearch(companyId, groupId, criteria.getCountryId(), criteria.getCityId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			districts = districtLocalService.findByBaseSearch(companyId, groupId, criteria.getCountryId(), criteria.getCityId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return districts;
	}

	public DistrictSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(DistrictSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
