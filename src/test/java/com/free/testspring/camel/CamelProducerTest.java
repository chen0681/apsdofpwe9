package com.free.testspring.camel;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:camel/camel-kafka-producer.xml" })
public class CamelProducerTest {

	@Autowired
	private CamelContext context;

	@Test
	public void testSendKafka() {
		ProducerTemplate producer = context.createProducerTemplate();
		String endpoint = "kafka:localhost:9092?topic=test&groupId=1";
		Map<String, String> va = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			va.put("key" + i, "value" + i);
		}
		String bodyStr = "body value";
		
		producer.sendBodyAndHeader(endpoint, bodyStr.getBytes(), "headerId", "headerValue");
	}
}
