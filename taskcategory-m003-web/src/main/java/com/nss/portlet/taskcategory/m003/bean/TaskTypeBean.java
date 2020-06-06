package com.nss.portlet.taskcategory.m003.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.portlet.taskcategory.m003.lazy.LazyTaskTypeModel;
import com.nss.portlet.taskcategory.service.TaskTypeLocalServiceTracker;
import com.nss.portlet.taskcategory.service.TaskTypeServiceTracker;
import com.nss.portlet.taskcategory.util.LanguageUtil_m003;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.model.TaskType;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.primefaces.PrimeFaces;

@ManagedBean(name="taskTypeBean")
@ViewScoped
public class TaskTypeBean {
	private TaskType taskType;
	
	private TaskTypeLocalServiceTracker taskTypeLocalServiceTracker;
	
	private TaskTypeServiceTracker taskTypeServiceTracker;
	
	private LazyTaskTypeModel lazyModel;
	
	private long companyId = LiferayPortletHelperUtil.getCompanyId();
	
	private long groupId = LiferayPortletHelperUtil.getScopeGroupId();
	
	private long userId = LiferayPortletHelperUtil.getUserId();
	
	private ServiceContext serviceContext;
	
	private boolean hasAddPermission;
	
	private boolean hasUpdatePermission;
	
	@PostConstruct
	public void init() {
		if(!FacesContext.getCurrentInstance().isPostback()) {
			_initLocalService();
			_initService();
			lazyModel = new LazyTaskTypeModel(companyId, groupId, taskTypeLocalServiceTracker.getService());
			
			serviceContext = new ServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			_initPermission();
		}
	}
	
	private void _initLocalService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		taskTypeLocalServiceTracker = new TaskTypeLocalServiceTracker(bundleContext);
		taskTypeLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		taskTypeServiceTracker = new TaskTypeServiceTracker(bundleContext);
		taskTypeServiceTracker.open();
	}
	
	private void _initPermission() {
		if(taskTypeServiceTracker.getService() != null) {
			try {
				hasAddPermission = taskTypeServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = taskTypeServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		taskTypeServiceTracker.close();
		taskTypeLocalServiceTracker.close();
	}
	
	public void openNewObject(ActionEvent event) {
		_createNewObject();
		PrimeFaces.current().executeScript("PF('dlgAdd').show();"); 
	}
	
	public void saveNew(ActionEvent event) {
		_save(true);
	}
	
	public void save(ActionEvent event) {
		_save(false);
	}
	
	private void _save(boolean saveNew) { 
		try {
			if(taskType.getTaskTypeId() > 0) {
				taskType = taskTypeServiceTracker.getService().updateTaskType(taskType.getTaskTypeId(), 
						taskType.getName(), taskType.getCode(), taskType.getPriority(), taskType.isActive(), taskType.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				taskType = taskTypeServiceTracker.getService().addTaskType(userId, 
						taskType.getName(), taskType.getCode(), taskType.getPriority(), taskType.isActive(), taskType.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m003.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m003.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m003.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m003.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(taskTypeLocalServiceTracker.getService() != null) {
			taskType = taskTypeLocalServiceTracker.getService().createTaskType(0L);
			taskType.setActive(true);
			taskType.setPriority(100);
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		taskType = lazyModel.getRowData();
		if(taskType != null) {
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		taskType = lazyModel.getRowData();
		if(taskType != null && taskTypeLocalServiceTracker.getService() != null) {
			taskType.setActive(!taskType.isActive());
			taskType.setModifiedDate(new Date());
			taskTypeLocalServiceTracker.getService().updateTaskType(taskType);
			
			lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
		}
	}
	
	//Getter && Setter

	public boolean isHasAddPermission() {
		return hasAddPermission;
	}

	public boolean isHasUpdatePermission() {
		return hasUpdatePermission;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public LazyTaskTypeModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyTaskTypeModel lazyModel) {
		this.lazyModel = lazyModel;
	}

}
