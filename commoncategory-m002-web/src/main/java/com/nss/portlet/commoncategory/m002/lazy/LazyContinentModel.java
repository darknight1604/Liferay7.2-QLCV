package com.nss.portlet.commoncategory.m002.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.commoncategory.model.Continent;
import com.nss.commoncategory.service.ContinentLocalService;
import com.nss.portlet.commoncategory.m002.criteria.ContinentSearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyContinentModel extends LazyDataModel<Continent>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ContinentLocalService continentLocalService;
	
	private ContinentSearchCriteria criteria;
	
	private List<Continent> continents;
	
	public LazyContinentModel(ContinentLocalService continentLocalService) {
		this.continentLocalService = continentLocalService;
		criteria = new ContinentSearchCriteria();
		continents = new ArrayList<Continent>();
		setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	@Override
	public Continent getRowData(String rowKey) {
		long continentId = GetterUtil.getLong(rowKey);
		if(continentId > 0 && !continents.isEmpty()) {
			for(Continent tmp : continents) {
				if(tmp.getContinentId() == continentId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Continent continent) {
		return continent.getContinentId();
	}
	
	@Override
	public List<Continent> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		continents = new ArrayList<Continent>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = continentLocalService.countByBaseSearch(criteria.getActive(), criteria.getName(), criteria.getInternationalName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			continents = continentLocalService.findByBaseSearch(criteria.getActive(), criteria.getName(), criteria.getInternationalName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return continents;
	}

	public ContinentSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(ContinentSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
