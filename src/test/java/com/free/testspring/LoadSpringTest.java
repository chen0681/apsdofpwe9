package com.free.testspring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.free.testspring.services.ITestService;

public class LoadSpringTest {

	@Test
	public void testLoadString(){
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("spring-default.xml", "spring-mvc.xml");
		ITestService testService = context.getBean(ITestService.class);
		System.out.println("");
	}
}
