package com.nss.portlet.taskcategory.m004.criteria;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.common.DanhMucCoBanComparator;
import com.nss.common.SearchCriteria;
import com.nss.portlet.taskcategory.util.constants.MyConstants;

public class InvestorSearchCriteria extends SearchCriteria{
	
	protected String name;
	protected String phoneNumber;
	protected String email;
	protected int active;

	public InvestorSearchCriteria() {
		this.active = MyConstants.ACTIVATE;
		this.lowerCase = true;
	}
	
	public OrderByComparator getOrderByComparator(String orderByCol, boolean ascending) {
		if (Validator.isNotNull(orderByCol)) {
			return new DanhMucCoBanComparator(ascending, orderByCol);
		}
		return null;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPhoneNumber() {
		if (formatExpressions) {
			return formatExpression(phoneNumber);
		}
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		if (formatExpressions) {
			return formatExpression(email);
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
