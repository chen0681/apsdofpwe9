/**
 * 
 */
package com.free.testspring.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class CamelTest {
	@Test
	public void test1() throws Exception {
		CamelContext context = new DefaultCamelContext(); 
		
		context.addRoutes( new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
//				from("file:d:/?fileName=ddd.txt").to("file:d:/?fileName=xxx.txt");
				System.out.println("aaa");
			}
		});
		context.start();
		
		Thread.sleep(10000); 
		context.stop();
	}
}
