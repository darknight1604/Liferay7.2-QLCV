package com.nss.portlet.taskcategory.m002.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.portlet.taskcategory.m002.criteria.TaskStatusSearchCriteria;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.model.TaskStatus;
import com.nss.taskcategory.service.TaskStatusLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTaskStatusModel extends LazyDataModel<TaskStatus>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TaskStatusLocalService taskStatusLocalService;
	
	private TaskStatusSearchCriteria criteria;
	
	private List<TaskStatus> taskStatuss;
	
	private long companyId;
	
	private long groupId;
	
	public LazyTaskStatusModel(long companyId, long groupId, TaskStatusLocalService taskStatusLocalService) {
		this.taskStatusLocalService = taskStatusLocalService;
		criteria = new TaskStatusSearchCriteria();
		taskStatuss = new ArrayList<TaskStatus>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public TaskStatus getRowData(String rowKey) {
		long taskStatusId = GetterUtil.getLong(rowKey);
		if(taskStatusId > 0 && !taskStatuss.isEmpty()) {
			for(TaskStatus tmp : taskStatuss) {
				if(tmp.getTaskStatusId() == taskStatusId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(TaskStatus taskStatus) {
		return taskStatus.getTaskStatusId();
	}
	
	@Override
	public List<TaskStatus> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		taskStatuss = new ArrayList<TaskStatus>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = taskStatusLocalService.countByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			taskStatuss = taskStatusLocalService.findByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return taskStatuss;
	}

	public TaskStatusSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(TaskStatusSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
