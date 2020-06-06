/**
 * 
 */

package com.nss.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

import javax.faces.event.ActionEvent;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author tanhq
 */
public abstract class SearchCriteria implements Cloneable {

	protected boolean andSearch = true;
	protected boolean formatExpressions = false;
	protected String keywords;
	protected boolean advanced = false;
	protected boolean lowerCase;
	protected boolean lucence = false;

	/**
	 * @param lowerCase
	 */
	public SearchCriteria(boolean lowerCase) {

		this.lowerCase = lowerCase;
	}

	/**
	 * 
	 */
	public SearchCriteria() {

		lowerCase = true;
	}

	public String formatExpression(String value) {

		return formatExpression(value, null, true);
	}

	public String formatExpression(String value, boolean toLowerCase) {

		return formatExpression(value, null, toLowerCase);
	}

	public String formatExpression(String value, String defaultValue) {

		return formatExpression(value, defaultValue, true);
	}

	public String formatExpression(String value, String defaultValue,
			boolean toLowerCase) {

		if ((value != null) && (!value.isEmpty())) {
			value = value.trim();

			if (toLowerCase && lucence) {
				value = "\"" + value.toLowerCase() + "\"";
			} else if (toLowerCase) {
				value = value.toLowerCase();
			}
		}

		if (Validator.isNull(value)) {
			value = defaultValue;
		} else {
			value = StringPool.PERCENT + value + StringPool.PERCENT;
		}

		return value;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {

		if (formatExpressions) {
			return formatExpression(keywords, lowerCase);
		}
		return keywords;
	}

	public abstract OrderByComparator getOrderByComparator(String orderByCol,
			boolean asc);

	/**
	 * @return the advanced
	 */
	public boolean isAdvanced() {

		return advanced;
	}

	/**
	 * @return the andSearch
	 */
	public boolean isAndSearch() {

		return andSearch;
	}

	/**
	 * @return the formatExpressions
	 */
	public boolean isFormatExpressions() {

		return formatExpressions;
	}

	/**
	 * @return the lowerCase
	 */
	public boolean isLowerCase() {

		return lowerCase;
	}

	public void searchToggle(ActionEvent event) {

		advanced = !advanced;
	}

	/**
	 * @param advanced
	 *            the advanced to set
	 */
	public void setAdvanced(boolean advanced) {

		this.advanced = advanced;
	}

	/**
	 * @param andSearch
	 *            the andSearch to set
	 */
	public void setAndSearch(boolean andSearch) {

		this.andSearch = andSearch;
	}

	/**
	 * @param formatExpressions
	 *            the formatExpressions to set
	 */
	public void setFormatExpressions(boolean formatExpressions) {

		this.formatExpressions = formatExpressions;
	}

	/**
	 * @param keywords
	 *            the keywords to set
	 */
	public void setKeywords(String keywords) {

		this.keywords = keywords;
	}

	/**
	 * @param lowerCase
	 *            the lowerCase to set
	 */
	public void setLowerCase(boolean lowerCase) {

		this.lowerCase = lowerCase;
	}

	public boolean isLucence() {
		return lucence;
	}

	public void setLucence(boolean lucence) {
		this.lucence = lucence;
	}

	public Object clone() throws CloneNotSupportedException {

		Class<? extends Object> clazz = this.getClass();
		try {
			Object fromObj = this;
			Object toObj = clazz.newInstance();
			BeanInfo fromBean = Introspector.getBeanInfo(clazz);
			BeanInfo toBean = Introspector.getBeanInfo(clazz);

			PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			List<PropertyDescriptor> fromPd = Arrays.asList(fromBean
					.getPropertyDescriptors());

			for (PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();
				PropertyDescriptor pd = fromPd.get(fromPd
						.indexOf(propertyDescriptor));
				if (pd.getDisplayName().equals(
						propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")) {
					if (propertyDescriptor.getWriteMethod() != null) {
						propertyDescriptor.getWriteMethod().invoke(toObj,
								pd.getReadMethod().invoke(fromObj, null));
					}
				}
			}
			return toObj;
		} catch (Exception e) {
			throw new CloneNotSupportedException();
		}
	}

}
