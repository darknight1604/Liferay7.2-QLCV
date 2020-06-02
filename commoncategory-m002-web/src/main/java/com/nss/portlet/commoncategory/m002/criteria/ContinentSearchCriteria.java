package com.nss.portlet.commoncategory.m002.criteria;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.common.DanhMucCoBanComparator;
import com.nss.common.SearchCriteria;
import com.nss.portlet.commoncategory.util.constants.MyConstants;

public class ContinentSearchCriteria extends SearchCriteria{
	
	protected String name;
	protected String code;
	protected String description;
	protected int active;
	protected String internationalName;

	public ContinentSearchCriteria() {
		this.active = MyConstants.ACTIVATE;
		this.lowerCase = true;
	}

	public String getName() {
		if (formatExpressions) {
			return formatExpression(name, lowerCase);
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		if (formatExpressions) {
			return formatExpression(code, lowerCase);
		}
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		if (formatExpressions) {
			return formatExpression(description, lowerCase);
		}
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public OrderByComparator getOrderByComparator(String orderByCol, boolean ascending) {
		if (Validator.isNotNull(orderByCol)) {
			return new DanhMucCoBanComparator(ascending, orderByCol);
		}
		return null;
	}

	public String getInternationalName() {
		if (formatExpressions) {
			return formatExpression(internationalName, lowerCase);
		}
		return internationalName;
	}

	public void setInternationalName(String internationalName) {
		this.internationalName = internationalName;
	}
}
