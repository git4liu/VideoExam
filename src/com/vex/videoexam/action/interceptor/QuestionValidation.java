package com.vex.videoexam.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class QuestionValidation extends AbstractInterceptor{

	public QuestionValidation(){
		System.out.println("questionvalidation called!!");
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String retVal = null;
		System.out.println("qustionValidation called!");
		retVal = invocation.invoke();
		return retVal;
	}

}
