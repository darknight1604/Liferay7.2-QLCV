package com.nss.portlet.taskcategory.m003.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.portlet.taskcategory.m003.criteria.TaskTypeSearchCriteria;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.model.TaskType;
import com.nss.taskcategory.service.TaskTypeLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTaskTypeModel extends LazyDataModel<TaskType>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TaskTypeLocalService taskTypeLocalService;
	
	private TaskTypeSearchCriteria criteria;
	
	private List<TaskType> taskTypes;
	
	private long companyId;
	
	private long groupId;
	
	public LazyTaskTypeModel(long companyId, long groupId, TaskTypeLocalService taskTypeLocalService) {
		this.taskTypeLocalService = taskTypeLocalService;
		criteria = new TaskTypeSearchCriteria();
		taskTypes = new ArrayList<TaskType>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public TaskType getRowData(String rowKey) {
		long taskTypeId = GetterUtil.getLong(rowKey);
		if(taskTypeId > 0 && !taskTypes.isEmpty()) {
			for(TaskType tmp : taskTypes) {
				if(tmp.getTaskTypeId() == taskTypeId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(TaskType taskType) {
		return taskType.getTaskTypeId();
	}
	
	@Override
	public List<TaskType> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		taskTypes = new ArrayList<TaskType>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = taskTypeLocalService.countByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			taskTypes = taskTypeLocalService.findByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return taskTypes;
	}

	public TaskTypeSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(TaskTypeSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
