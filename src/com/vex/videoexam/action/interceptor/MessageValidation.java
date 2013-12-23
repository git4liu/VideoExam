package com.vex.videoexam.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MessageValidation extends AbstractInterceptor{

	public MessageValidation(){
		System.out.println("messagevalidation called!!");
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String retVal = null;
		System.out.println("messageValidation called!");
		retVal = invocation.invoke();
		return retVal;
	}

}
