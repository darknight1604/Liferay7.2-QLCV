package com.nss.commoncategory.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.nss.commoncategory.model.Street;
import com.nss.commoncategory.model.impl.StreetImpl;
import com.nss.commoncategory.model.impl.StreetModelImpl;
import com.nss.commoncategory.service.persistence.StreetFinder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@SuppressWarnings("unchecked")
@Component(service = StreetFinder.class)
public class StreetFinderImpl extends StreetFinderBaseImpl implements StreetFinder {
	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StreetModelImpl.TABLE_COLUMNS_MAP;
	}

	@Reference
	private CustomSQL customSQL;
	public static final String COUNT_BY_BASE_SEARCH = StreetFinder.class.getName() + ".countByBaseSearch";
	public static final String FIND_BY_BASE_SEARCH = StreetFinder.class.getName() + ".findByBaseSearch";

	public int countByBaseSearch(long companyId, long groupId, long countryId, 
			long cityId, long districtId, long wardId, int active, 
			String name, String code, 
			String description, boolean andOperator) throws SystemException {
		return countByBaseSearch(companyId, groupId, countryId, cityId, districtId, wardId, active, 
				new String[] { name }, new String[] { code }, new String[] { description }, andOperator);
	}

	private int countByBaseSearch(long companyId, long groupId, long countryId, long cityId, 
			long districtId, long wardId, int active, 
			String[] names, String[] codes, 
			String[] descriptions, boolean andOperator)
			throws SystemException {
		names = customSQL.keywords(names);
		codes = customSQL.keywords(codes);
		descriptions = customSQL.keywords(descriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), COUNT_BY_BASE_SEARCH);
			if (groupId == 0) {
				sql = StringUtil.replace(sql, "AND groupId = ?", StringPool.BLANK);
			}
			if (countryId == 0) {
				sql = StringUtil.replace(sql, "AND countryId = ?", StringPool.BLANK);
			}
			if (cityId == 0) {
				sql = StringUtil.replace(sql, "AND cityId = ?", StringPool.BLANK);
			}
			if (active == 0) {
				sql = StringUtil.replace(sql, "AND active_ = ?", StringPool.BLANK);
			}
			if (districtId == 0) {
				sql = StringUtil.replace(sql, "AND districtId = ?", StringPool.BLANK);
			}
			if (wardId == 0) {
				sql = StringUtil.replace(sql, "AND wardId = ?", StringPool.BLANK);
			}
			sql = customSQL.replaceKeywords(sql, "LOWER(name)", StringPool.LIKE, false, names);
			sql = customSQL.replaceKeywords(sql, "LOWER(code_)", StringPool.LIKE, false, codes);
			sql = customSQL.replaceKeywords(sql, "LOWER(description)", StringPool.LIKE, true, descriptions);
			sql = customSQL.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			if (groupId > 0) {
				qPos.add(groupId);
			}
			if (active > 0) {
				qPos.add(active == 1 ? Boolean.TRUE : Boolean.FALSE);
			}
			if (countryId > 0) {
				qPos.add(countryId);
			}
			if (cityId > 0) {
				qPos.add(cityId);
			}
			if (districtId > 0) {
				qPos.add(districtId);
			}
			if (wardId > 0) {
				qPos.add(wardId);
			}
			qPos.add(names, 2);
			qPos.add(codes, 2);
			qPos.add(descriptions, 2);
			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Street> findByBaseSearch(long companyId, long groupId, long countryId, 
			long cityId, long districtId, long wardId, int active, String name, 
			String code, String description, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return findByBaseSearch(companyId, groupId, countryId, cityId, districtId, wardId, active, new String[] { name }, new String[] { code }, new String[] { description }, andOperator, start, end,
				obc);
	}

	private List<Street> findByBaseSearch(long companyId, long groupId, long countryId, long cityId, 
			long districtId, long wardId, int active, String[] names, String[] codes, String[] descriptions, boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException {
		names = customSQL.keywords(names);
		codes = customSQL.keywords(codes);
		descriptions = customSQL.keywords(descriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), FIND_BY_BASE_SEARCH);
			if (active == 0) {
				sql = StringUtil.replace(sql, "AND active_ = ?", StringPool.BLANK);
			}
			if (groupId == 0) {
				sql = StringUtil.replace(sql, "AND groupId = ?", StringPool.BLANK);
			}
			if (countryId == 0) {
				sql = StringUtil.replace(sql, "AND countryId = ?", StringPool.BLANK);
			}
			if (cityId == 0) {
				sql = StringUtil.replace(sql, "AND cityId = ?", StringPool.BLANK);
			}
			if (districtId == 0) {
				sql = StringUtil.replace(sql, "AND districtId = ?", StringPool.BLANK);
			}
			if (wardId == 0) {
				sql = StringUtil.replace(sql, "AND wardId = ?", StringPool.BLANK);
			}
			sql = customSQL.replaceKeywords(sql, "LOWER(name)", StringPool.LIKE, false, names);
			sql = customSQL.replaceKeywords(sql, "LOWER(code_)", StringPool.LIKE, false, codes);
			sql = customSQL.replaceKeywords(sql, "LOWER(description)", StringPool.LIKE, true, descriptions);
			sql = customSQL.replaceAndOperator(sql, andOperator);
			sql = customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Street", StreetImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			if (groupId > 0) {
				qPos.add(groupId);
			}
			if (active > 0) {
				qPos.add(active == 1 ? Boolean.TRUE : Boolean.FALSE);
			}
			if (countryId > 0) {
				qPos.add(countryId);
			}
			if (cityId > 0) {
				qPos.add(cityId);
			}
			if (districtId > 0) {
				qPos.add(districtId);
			}
			if (wardId > 0) {
				qPos.add(wardId);
			}
			qPos.add(names, 2);
			qPos.add(codes, 2);
			qPos.add(descriptions, 2);
			return (List<Street>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	

}
