package com.nss.taskcategory.service.persistence.impl;

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
import com.nss.taskcategory.model.Investor;
import com.nss.taskcategory.model.impl.InvestorImpl;
import com.nss.taskcategory.model.impl.InvestorModelImpl;
import com.nss.taskcategory.service.persistence.InvestorFinder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@SuppressWarnings("unchecked")
@Component(service = InvestorFinder.class)
public class InvestorFinderImpl extends InvestorFinderBaseImpl implements InvestorFinder {
	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InvestorModelImpl.TABLE_COLUMNS_MAP;
	}

	@Reference
	private CustomSQL customSQL;
	public static final String COUNT_BY_BASE_SEARCH = InvestorFinder.class.getName() + ".countByBaseSearch";
	public static final String FIND_BY_BASE_SEARCH = InvestorFinder.class.getName() + ".findByBaseSearch";

	public int countByBaseSearch(long companyId, long groupId, int active, String name, String phoneNumber, 
			String email, boolean andOperator) throws SystemException {
		return countByBaseSearch(companyId, groupId, active, new String[] { name }, new String[] { phoneNumber }, 
				new String[] { email }, andOperator);
	}

	private int countByBaseSearch(long companyId, long groupId, int active, String[] names, 
			String[] phoneNumbers, String[] emails, boolean andOperator)
			throws SystemException {
		names = customSQL.keywords(names);
		phoneNumbers = customSQL.keywords(phoneNumbers);
		emails = customSQL.keywords(emails);
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), COUNT_BY_BASE_SEARCH);
			if (active == 0) {
				sql = StringUtil.replace(sql, "AND active_ = ?", StringPool.BLANK);
			}
			if (groupId == 0) {
				sql = StringUtil.replace(sql, "AND groupId = ?", StringPool.BLANK);
			}
			sql = customSQL.replaceKeywords(sql, "LOWER(name)", StringPool.LIKE, false, names);
			sql = customSQL.replaceKeywords(sql, "LOWER(phonenumber)", StringPool.LIKE, false, phoneNumbers);
			sql = customSQL.replaceKeywords(sql, "LOWER(email)", StringPool.LIKE, true, emails);
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
			qPos.add(names, 2);
			qPos.add(phoneNumbers, 2);
			qPos.add(emails, 2);
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
	
	public List<Investor> findByBaseSearch(long companyId, long groupId, int active, 
			String name, String phoneNumber, 
			String email, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException {
		return findByBaseSearch(companyId, groupId, active, new String[] { name }, 
				new String[] { phoneNumber }, new String[] { email }, andOperator, start, end,
				obc);
	}

	private List<Investor> findByBaseSearch(long companyId, long groupId, int active, String[] names, 
			String[] phoneNumbers, String[] emails, boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException {
		names = customSQL.keywords(names);
		phoneNumbers = customSQL.keywords(phoneNumbers);
		emails = customSQL.keywords(emails);
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
			sql = customSQL.replaceKeywords(sql, "LOWER(name)", StringPool.LIKE, false, names);
			sql = customSQL.replaceKeywords(sql, "LOWER(phonenumber)", StringPool.LIKE, false, phoneNumbers);
			sql = customSQL.replaceKeywords(sql, "LOWER(email)", StringPool.LIKE, true, emails);
			sql = customSQL.replaceAndOperator(sql, andOperator);
			sql = customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Investor", InvestorImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(companyId);
			if (groupId > 0) {
				qPos.add(groupId);
			}
			if (active > 0) {
				qPos.add(active == 1 ? Boolean.TRUE : Boolean.FALSE);
			}
			qPos.add(names, 2);
			qPos.add(phoneNumbers, 2);
			qPos.add(emails, 2);
			return (List<Investor>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	

}
