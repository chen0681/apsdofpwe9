package com.free.testspring.dubbo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dubbo/app-dubbo-server.xml"})
public class DubboServer extends AbstractJUnit4SpringContextTests {
	
	@Test
	public void testServer() throws InterruptedException, IOException {
		System.out.println("server start");

		System.in.read();
	}
}
