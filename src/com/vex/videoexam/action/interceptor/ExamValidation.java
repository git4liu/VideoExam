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

public class ExamValidation extends AbstractInterceptor{


	
	ExamValidation(){
		System.out.println("exam interceptor called!");
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("exam validation");
		
		return invocation.invoke();
		
	}

}
