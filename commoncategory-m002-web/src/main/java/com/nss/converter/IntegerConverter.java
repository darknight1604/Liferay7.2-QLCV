package com.nss.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Brian Wing Shun Chan
 */
@FacesConverter(value = "integerConverter")
public class IntegerConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent ui, String str) {
		if (Validator.isNotNull(str)) {
			try {
				Integer.parseInt(str);
			} catch (NumberFormatException e) {
				throw new ConverterException();
			}
		}
		return GetterUtil.getInteger(str, 0);
	}

	public String getAsString(FacesContext context, UIComponent ui, Object object) {

		int value = Integer.valueOf(String.valueOf(object));
		if (value < 1) {
			return null;
		}
		return String.valueOf(object);
	}

}
