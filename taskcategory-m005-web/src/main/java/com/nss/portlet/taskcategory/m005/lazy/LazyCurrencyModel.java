package com.nss.portlet.taskcategory.m005.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.portlet.taskcategory.m005.criteria.CurrencySearchCriteria;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.model.Currency;
import com.nss.taskcategory.service.CurrencyLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCurrencyModel extends LazyDataModel<Currency>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CurrencyLocalService currencyLocalService;
	
	private CurrencySearchCriteria criteria;
	
	private List<Currency> currencies;
	
	private long companyId;
	
	private long groupId;
	
	public LazyCurrencyModel(long companyId, long groupId, CurrencyLocalService currencyLocalService) {
		this.currencyLocalService = currencyLocalService;
		criteria = new CurrencySearchCriteria();
		currencies = new ArrayList<Currency>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public Currency getRowData(String rowKey) {
		long currencyId = GetterUtil.getLong(rowKey);
		if(currencyId > 0 && !currencies.isEmpty()) {
			for(Currency tmp : currencies) {
				if(tmp.getCurrencyId() == currencyId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Currency currency) {
		return currency.getCurrencyId();
	}
	
	@Override
	public List<Currency> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		currencies = new ArrayList<Currency>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = currencyLocalService.countByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			currencies = currencyLocalService.findByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return currencies;
	}

	public CurrencySearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(CurrencySearchCriteria criteria) {
		this.criteria = criteria;
	}
}
