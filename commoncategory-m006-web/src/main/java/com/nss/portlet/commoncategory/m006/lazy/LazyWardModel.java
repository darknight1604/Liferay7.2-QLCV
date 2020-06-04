package com.nss.portlet.commoncategory.m006.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.commoncategory.model.Ward;
import com.nss.commoncategory.service.WardLocalService;
import com.nss.portlet.commoncategory.m006.criteria.WardSearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyWardModel extends LazyDataModel<Ward>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WardLocalService wardLocalService;
	
	private WardSearchCriteria criteria;
	
	private List<Ward> wards;
	
	private long companyId;
	
	private long groupId;
	
	public LazyWardModel(long companyId, long groupId, WardLocalService wardLocalService) {
		this.wardLocalService = wardLocalService;
		criteria = new WardSearchCriteria();
		wards = new ArrayList<Ward>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public Ward getRowData(String rowKey) {
		long wardId = GetterUtil.getLong(rowKey);
		if(wardId > 0 && !wards.isEmpty()) {
			for(Ward tmp : wards) {
				if(tmp.getWardId() == wardId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Ward ward) {
		return ward.getWardId();
	}
	
	@Override
	public List<Ward> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		wards = new ArrayList<Ward>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = wardLocalService.countByBaseSearch(companyId, groupId, criteria.getCountryId(), 
						criteria.getCityId(), criteria.getDistrictId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			wards = wardLocalService.findByBaseSearch(companyId, groupId, criteria.getCountryId(), 
					criteria.getCityId(), criteria.getDistrictId(), criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return wards;
	}

	public WardSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(WardSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
