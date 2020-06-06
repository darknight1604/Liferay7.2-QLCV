package com.nss.portlet.taskcategory.m001.lazy;

import com.liferay.portal.kernel.util.GetterUtil;
import com.nss.portlet.taskcategory.m001.criteria.TaskGroupSearchCriteria;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.model.TaskGroup;
import com.nss.taskcategory.service.TaskGroupLocalService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTaskGroupModel extends LazyDataModel<TaskGroup>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TaskGroupLocalService taskGroupLocalService;
	
	private TaskGroupSearchCriteria criteria;
	
	private List<TaskGroup> taskGroups;
	
	private long companyId;
	
	private long groupId;
	
	public LazyTaskGroupModel(long companyId, long groupId, TaskGroupLocalService taskGroupLocalService) {
		this.taskGroupLocalService = taskGroupLocalService;
		criteria = new TaskGroupSearchCriteria();
		taskGroups = new ArrayList<TaskGroup>();
		setRowCount(MyConstants.REFRESH_PAGE);
		this.groupId = groupId;
		this.companyId = companyId;
	}
	
	@Override
	public TaskGroup getRowData(String rowKey) {
		long taskGroupId = GetterUtil.getLong(rowKey);
		if(taskGroupId > 0 && !taskGroups.isEmpty()) {
			for(TaskGroup tmp : taskGroups) {
				if(tmp.getTaskGroupId() == taskGroupId) {
					return tmp;
				}
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(TaskGroup taskGroup) {
		return taskGroup.getTaskGroupId();
	}
	
	@Override
	public List<TaskGroup> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		taskGroups = new ArrayList<TaskGroup>();
		criteria.setFormatExpressions(true);
		try {
			// rowCount
			if (getRowCount() < 0) {
				int count = 0;
				if (getRowCount() == -1) {
					first = 0;
				}
				count = taskGroupLocalService.countByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
						criteria.getDescription(), true);
				this.setRowCount(count);
			}
			// List
			taskGroups = taskGroupLocalService.findByBaseSearch(companyId, groupId, criteria.getActive(), criteria.getName(), criteria.getCode(), 
					criteria.getDescription(), true, first, first + pageSize, criteria.getOrderByComparator(sortField, SortOrder.ASCENDING.equals(sortOrder)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		criteria.setFormatExpressions(false);
		return taskGroups;
	}

	public TaskGroupSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(TaskGroupSearchCriteria criteria) {
		this.criteria = criteria;
	}
}
