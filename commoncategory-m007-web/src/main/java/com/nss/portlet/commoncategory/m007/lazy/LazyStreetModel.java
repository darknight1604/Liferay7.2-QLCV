package com.nss.portlet.commoncategory.m007.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.service.StreetLocalService;
import com.nss.portlet.commoncategory.m007.criteria.StreetSearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyStreetModel extends LazyDataModel<Street>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StreetLocalService streetLocalService;
	
	private StreetSearchCriteria criteria;
	
	private List<Street> streets;
	
	private long companyId;
	
	private long groupId;
	
	public LazyStreetModel(long companyId, long groupId, StreetLocalService streetLocalService) {
		this.streetLocalService = streetLocalService;
		criteria = new StreetSearchCriteria();
		streets = new ArrayList<Street>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public Street getRowData(String rowKey) {
		long streetId = GetterUtil.getLong(rowKey);
		if(streetId > 0 && !streets.isEmpty()) {
			for(Street tmp : streets) {
				if(tmp.getStreetId() == streetId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Street street) {
		return street.getStreetId();
	}
	
	@Override
	public List<Street> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		streets = new ArrayList<Street>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = streetLocalService.countByBaseSearch(companyId, groupId, criteria.getCountryId(), 
						criteria.getCityId(), criteria.getDistrictId(), criteria.getWardId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			streets = streetLocalService.findByBaseSearch(companyId, groupId, criteria.getCountryId(), 
					criteria.getCityId(), criteria.getDistrictId(), criteria.getWardId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return streets;
	}

	public StreetSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(StreetSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
