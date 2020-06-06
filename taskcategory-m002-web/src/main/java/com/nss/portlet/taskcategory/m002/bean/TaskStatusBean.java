package com.nss.portlet.taskcategory.m002.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.portlet.taskcategory.m002.lazy.LazyTaskStatusModel;
import com.nss.portlet.taskcategory.service.TaskStatusLocalServiceTracker;
import com.nss.portlet.taskcategory.service.TaskStatusServiceTracker;
import com.nss.portlet.taskcategory.util.LanguageUtil_m002;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.model.TaskStatus;

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

@ManagedBean(name="taskStatusBean")
@ViewScoped
public class TaskStatusBean {
	private TaskStatus taskStatus;
	
	private TaskStatusLocalServiceTracker taskStatusLocalServiceTracker;
	
	private TaskStatusServiceTracker taskStatusServiceTracker;
	
	private LazyTaskStatusModel lazyModel;
	
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
			lazyModel = new LazyTaskStatusModel(companyId, groupId, taskStatusLocalServiceTracker.getService());
			
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
		taskStatusLocalServiceTracker = new TaskStatusLocalServiceTracker(bundleContext);
		taskStatusLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		taskStatusServiceTracker = new TaskStatusServiceTracker(bundleContext);
		taskStatusServiceTracker.open();
	}
	
	private void _initPermission() {
		if(taskStatusServiceTracker.getService() != null) {
			try {
				hasAddPermission = taskStatusServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = taskStatusServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		taskStatusServiceTracker.close();
		taskStatusLocalServiceTracker.close();
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
			if(taskStatus.getTaskStatusId() > 0) {
				taskStatus = taskStatusServiceTracker.getService().updateTaskStatus(taskStatus.getTaskStatusId(), 
						taskStatus.getName(), taskStatus.getCode(), taskStatus.getPriority(), taskStatus.isActive(), taskStatus.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				taskStatus = taskStatusServiceTracker.getService().addTaskStatus(userId, 
						taskStatus.getName(), taskStatus.getCode(), taskStatus.getPriority(), taskStatus.isActive(), taskStatus.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m002.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m002.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m002.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m002.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(taskStatusLocalServiceTracker.getService() != null) {
			taskStatus = taskStatusLocalServiceTracker.getService().createTaskStatus(0L);
			taskStatus.setActive(true);
			taskStatus.setPriority(100);
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		taskStatus = lazyModel.getRowData();
		if(taskStatus != null) {
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		taskStatus = lazyModel.getRowData();
		if(taskStatus != null && taskStatusLocalServiceTracker.getService() != null) {
			taskStatus.setActive(!taskStatus.isActive());
			taskStatus.setModifiedDate(new Date());
			taskStatusLocalServiceTracker.getService().updateTaskStatus(taskStatus);
			
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

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LazyTaskStatusModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyTaskStatusModel lazyModel) {
		this.lazyModel = lazyModel;
	}


}
