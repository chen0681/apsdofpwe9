package com.free.testspring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.free.testspring.services.IExtendClassMethod;
import com.free.testspring.services.ITestService;

public class TestServiceTest {

	//@Test
	public void testValue1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
		ITestService  testService = context.getBean(ITestService.class);
		String value = testService.testValue("11");
		
		IExtendClassMethod extendClass = (IExtendClassMethod)context.getBean(ITestService.class);
		extendClass.testValue2();
	}
	
	@Test
	public void testMybatis() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml","spring-default.xml");
		
		ITestService  testService = context.getBean(ITestService.class);
		String result = testService.testValue("");
		
		System.out.println(result);
	}
}
