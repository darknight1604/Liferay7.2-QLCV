package com.nss.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Brian Wing Shun Chan
 */
@FacesConverter(value = "LongConverter")
public class LongConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent ui, String str) {
		
		if (Validator.isNotNull(str)) {
			try {
				return Long.parseLong(str);
			} catch (NumberFormatException e) {
				throw new ConverterException();
			}
		}
		
		return 0;
	}

	public String getAsString(FacesContext context, UIComponent ui, Object object) {

		long value = Long.valueOf(String.valueOf(object));
		
		if (value < 1) {
			return null;
		}
		
		return String.valueOf(object);
	}

}
