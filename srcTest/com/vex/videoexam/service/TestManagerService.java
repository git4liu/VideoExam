package com.vex.videoexam.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vex.videoexam.model.Choice;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.model.Specify;

@ContextConfiguration(locations = "classpath:beans.xml")
public class TestManagerService extends AbstractJUnit4SpringContextTests{

	@Resource(name="managerService")
	private ManagerService managerService;
	
	@Resource(name="paperService")
	private PaperService paperService;
	
	@Resource(name="questionService")
	private QuestionService questionService;
	
	@Resource(name="specifyService")
	private SpecifyService specifyService;
	
	@Resource(name="studentService")
	private StudentService studentService;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Rollback(false)
	public void testAdd(){
		
		
		for(int i = 1; i < 4; i ++ ){
			Manager manager = new Manager();
			manager.setName(i + "");
			manager.setPswd("0");
			manager.setCategory(i);
			managerService.add(manager);
		}
////		Paper paper = new Paper();
////		paper.setScore(99);
////		paper.setDegree('A');
////		paper.setManager(manager);
////		paper.setTime(new Date().toString());
//		
//		
//		List<Manager> managers = new ArrayList<Manager> ();
//		managers = managerService.list(null);
//		for(int i = 0 ; i < managers.size(); i ++ ){
//			System.out.println(managers.get(i).getName());
//		}
		
		
		
		Specify specify = new Specify();
		specify.setName("root");
		specify.setLeaf('N');
		specify.setFather(specify);
		specify.setDesc("¸ù½Úµã");
		
		specifyService.add(specify);
	}
}
