package com.vex.videoexam.Dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.vex.videoexam.model.Choice;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.model.Question;
import com.vex.videoexam.model.Specify;
import com.vex.videoexam.model.Student;
import com.vex.*;

@ContextConfiguration(locations = "classpath:beans.xml")
public class TestDao extends AbstractJUnit4SpringContextTests{

	@Resource
	private ManagerDao managerDao;
		
	@Resource
	private PaperDao paperDao;
	
	@Resource
	private QuestionDao questionDao;
	
	@Resource
	private StudentDao studentDao;
	
	@Resource
	private SpecifyDao specifyDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Rollback(false)
	public void testAdd(){
		
		Specify specify = new Specify();
		specify.setName("root");
		specify.setLeaf('Y');
		
		specifyDao.save(specify);
		
//		System.out.println(managerDao);
//		System.out.println(choiceDao);
//		System.out.println(paperDao);
	}
}
