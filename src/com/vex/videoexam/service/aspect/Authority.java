package com.vex.videoexam.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.vex.videoexam.model.Manager;

@Component("authority")
public class Authority{
	
	private Manager manager;
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public void before(){
		System.out.println("*************************************before");
		if(manager.getCategory() != 1){
			System.out.println("您的权限为<" + manager.getCategory() + ">不允许对管理员进行操作");
		}
	}
	public void after(){
		System.out.println("*************************************after");
	}
	
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal = null;
		
		
//		manager = new Manager();
//		manager.setCategory(1);

		
		//		Object obj [] = pjp.getTarget().getClass().getInterfaces();
		System.out.println("-------------------------------------around1");
		if(manager.getCategory() != 1){
			System.out.println("您的权限为<" + manager.getCategory() + ">不允许对管理员进行操作");
			return retVal;			
		}
		retVal = pjp.proceed();
		System.out.println("-------------------------------------aruond2");
		return retVal;
	  }
}
