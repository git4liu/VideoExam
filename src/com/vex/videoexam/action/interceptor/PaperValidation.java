package com.vex.videoexam.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PaperValidation extends AbstractInterceptor{

	public PaperValidation(){
		System.out.println("papervalidation called!!");
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String retVal = null;
		retVal = invocation.invoke();
		return retVal;
	}

}
