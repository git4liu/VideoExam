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

public class ManagerValidation extends AbstractInterceptor{

	@Resource(name="managerService")
	private ManagerService managerservice;
	
	@Resource(name="authority")
	private Authority authority;
	
	ManagerValidation(){
		System.out.println("interceptor called!");
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("former");
		String retVal = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("manager");
		authority.setManager(manager);
		retVal = invocation.invoke();
		authority.setManager(null);
		return retVal;
	}

}
