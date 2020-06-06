package com.nss.portlet.taskcategory.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import java.util.ResourceBundle;

public class LanguageUtil_m001 {
	
    public static String getString(String target) {
        if (Validator.isNotNull(target)) {
        	ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language");
        	return resourceBundle.getString(target);
        }
        return StringPool.BLANK;
    }
}
