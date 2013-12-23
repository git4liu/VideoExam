package com.vex.videoexam.action.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.service.ManagerService;
import com.vex.videoexam.service.aspect.Authority;
import com.vex.videoexam.service.aspect.SpecifyOperation;

public class SpecifyValidation extends AbstractInterceptor{

	
	@Resource(name="specifyOperation")
	private SpecifyOperation specifyOperation;
	
	SpecifyValidation(){
		System.out.println("specifyInterceptor called!");
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("former");
		String retVal = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("manager");
		specifyOperation.setManager(manager);
		retVal = invocation.invoke();
		specifyOperation.setManager(null);
		return retVal;
	}

}
