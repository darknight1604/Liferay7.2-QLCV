package com.nss.portlet.taskcategory.m001.bean;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nss.portlet.taskcategory.m001.lazy.LazyTaskGroupModel;
import com.nss.portlet.taskcategory.service.TaskGroupLocalServiceTracker;
import com.nss.portlet.taskcategory.service.TaskGroupServiceTracker;
import com.nss.portlet.taskcategory.util.LanguageUtil_m001;
import com.nss.portlet.taskcategory.util.constants.MyConstants;
import com.nss.taskcategory.exception.DuplicateCodeException;
import com.nss.taskcategory.model.TaskGroup;
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

@ManagedBean(name="taskGroupBean")
@ViewScoped
public class TaskGroupBean {
	private TaskGroup taskGroup;
	
	private TaskGroupLocalServiceTracker taskGroupLocalServiceTracker;
	
	private TaskGroupServiceTracker taskGroupServiceTracker;
	
	private LazyTaskGroupModel lazyModel;
	
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
			lazyModel = new LazyTaskGroupModel(companyId, groupId, taskGroupLocalServiceTracker.getService());
			
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
		taskGroupLocalServiceTracker = new TaskGroupLocalServiceTracker(bundleContext);
		taskGroupLocalServiceTracker.open();
	}
	
	private void _initService() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		taskGroupServiceTracker = new TaskGroupServiceTracker(bundleContext);
		taskGroupServiceTracker.open();
	}
	
	private void _initPermission() {
		if(taskGroupServiceTracker.getService() != null) {
			try {
				hasAddPermission = taskGroupServiceTracker.getService().hasAddPermission(groupId);
				hasUpdatePermission = taskGroupServiceTracker.getService().hasUpdatePermission(groupId);
			} catch (PrincipalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		taskGroupServiceTracker.close();
		taskGroupLocalServiceTracker.close();
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
			if(taskGroup.getTaskGroupId() > 0) {
				taskGroup = taskGroupServiceTracker.getService().updateTaskGroup(taskGroup.getTaskGroupId(), 
						taskGroup.getName(), taskGroup.getCode(), taskGroup.getPriority(), taskGroup.isActive(), taskGroup.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_DATA);
			}else {
				taskGroup = taskGroupServiceTracker.getService().addTaskGroup(userId, 
						taskGroup.getName(), taskGroup.getCode(), taskGroup.getPriority(), taskGroup.isActive(), taskGroup.getDescription(), 
						serviceContext);
				lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, LanguageUtil_m001.getString(MyConstants.PROCESSED_SUCCESSFULLY), StringPool.BLANK));
			if(saveNew) {
				_createNewObject();
			}
		} catch (Exception e) {
			if(e instanceof PrincipalException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m001.getString(MyConstants.ERROR_PRINCIPAL), StringPool.BLANK));
			} else if(e instanceof DuplicateCodeException){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m001.getString(MyConstants.DUPLICATE_CODE), StringPool.BLANK));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, LanguageUtil_m001.getString(MyConstants.FAILED_TO_COMPLETE), StringPool.BLANK));
			}
			e.printStackTrace();
		}
		PrimeFaces.current().ajax().update(":frm:messages");
	}
	
	private void _createNewObject() {
		if(taskGroupLocalServiceTracker.getService() != null) {
			taskGroup = taskGroupLocalServiceTracker.getService().createTaskGroup(0L);
			taskGroup.setActive(true);
			taskGroup.setPriority(100);
		}
	}
	
	public void search(ActionEvent event) {
		lazyModel.setRowCount(MyConstants.REFRESH_PAGE);
	}
	
	public void update(ActionEvent event) {
		taskGroup = lazyModel.getRowData();
		if(taskGroup != null) {
			PrimeFaces.current().executeScript("PF('dlgAdd').show();");
		}
	}
	
	public void deActivate(ActionEvent event) {
		taskGroup = lazyModel.getRowData();
		if(taskGroup != null && taskGroupLocalServiceTracker.getService() != null) {
			taskGroup.setActive(!taskGroup.isActive());
			taskGroup.setModifiedDate(new Date());
			taskGroupLocalServiceTracker.getService().updateTaskGroup(taskGroup);
			
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

	public TaskGroup getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(TaskGroup taskGroup) {
		this.taskGroup = taskGroup;
	}

	public LazyTaskGroupModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyTaskGroupModel lazyModel) {
		this.lazyModel = lazyModel;
	}


}
