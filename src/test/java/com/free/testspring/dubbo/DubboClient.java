package com.free.testspring.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.free.testspring.dubbo.service.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dubbo/app-dubbo-client.xml"})
public class DubboClient extends AbstractJUnit4SpringContextTests {

	@Test
	public void testClient() { 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath*:dubbo/app-dubbo-client.xml"});
		context.start();
		
		HelloService service =(HelloService) context.getBean("helloService");
		service.sayHello("xxx");
	}
}
