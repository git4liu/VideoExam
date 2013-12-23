package com.vex.videoexam.test;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test(){
		String s = "AB";
		System.out.println(s.contains("A"));
	}
}
