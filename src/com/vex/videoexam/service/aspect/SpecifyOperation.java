package com.vex.videoexam.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.vex.videoexam.model.Manager;

@Component("specifyOperation")
public class SpecifyOperation{
	
	private Manager manager;
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal = null;
		
		
//		manager = new Manager();
//		manager.setCategory(1);
		
		
		System.out.println("-------------------------------------around1");
		if(manager.getCategory() !=1 && manager.getCategory() != 2){
			System.out.println("您的权限为<" + manager.getCategory() + ">不允许对试题进行操作");
			return retVal;			
		}
		retVal = pjp.proceed();
		System.out.println("-------------------------------------aruond2");
		return retVal;
	  }
}
