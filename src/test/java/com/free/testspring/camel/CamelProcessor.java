package com.free.testspring.camel;

import java.util.concurrent.TimeUnit;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class CamelProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		
		System.out.println(in.getBody());
		System.out.println(in.getHeaders());
		
		String headVal = in.getHeader("headerId").toString();
		in.setHeader("headerId", headVal + 1);
		System.out.println("headVal=" + headVal);
		TimeUnit.SECONDS.sleep(5);
	}

}
