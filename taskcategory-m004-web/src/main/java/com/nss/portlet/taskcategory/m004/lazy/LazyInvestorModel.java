package com.nss.portlet.taskcategory.m004.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.portlet.taskcategory.m004.criteria.InvestorSearchCriteria;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.model.Investor;
import com.nss.taskcategory.service.InvestorLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyInvestorModel extends LazyDataModel<Investor>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InvestorLocalService investorLocalService;
	
	private InvestorSearchCriteria criteria;
	
	private List<Investor> investors;
	
	private long companyId;
	
	private long groupId;
	
	public LazyInvestorModel(long companyId, long groupId, InvestorLocalService investorLocalService) {
		this.investorLocalService = investorLocalService;
		criteria = new InvestorSearchCriteria();
		investors = new ArrayList<Investor>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public Investor getRowData(String rowKey) {
		long investorId = GetterUtil.getLong(rowKey);
		if(investorId > 0 && !investors.isEmpty()) {
			for(Investor tmp : investors) {
				if(tmp.getInvestorId() == investorId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Investor investor) {
		return investor.getInvestorId();
	}
	
	@Override
	public List<Investor> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		investors = new ArrayList<Investor>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = investorLocalService.countByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getPhoneNumber(), 
						criteria.getEmail(), true);
				this.setRowCount(count);
			}
			// List
			investors = investorLocalService.findByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getPhoneNumber(), 
					criteria.getEmail(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return investors;
	}

	public InvestorSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(InvestorSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
