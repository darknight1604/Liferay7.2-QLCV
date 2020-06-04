package com.nss.common;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DanhMucCoBanComparator extends OrderByComparator {

    private static final long serialVersionUID = 1L;

    public String ORDER_BY_ASC;

    public String ORDER_BY_DESC;

    private boolean _ascending;

    public DanhMucCoBanComparator(boolean ascending, String... field) {
        ORDER_BY_ASC = "";
        ORDER_BY_DESC = "";
        for (int i = 0; i < field.length; i++) {
            String tmp = field[i];
            if (i == field.length - 1) {
                ORDER_BY_ASC += tmp + " ASC";
                ORDER_BY_DESC += tmp + " DESC";
            } else {
                ORDER_BY_ASC += tmp + " ASC, ";
                ORDER_BY_DESC += tmp + " DESC, ";
            }
        }
        _ascending = ascending;
    }

    public int compare(Object obj1, Object obj2) {

        return 0;
    }

    public String getOrderBy() {

        if (_ascending) {
            return ORDER_BY_ASC;
        } else {
            return ORDER_BY_DESC;
        }
    }

    public boolean isAscending() {

        return _ascending;
    }
}
