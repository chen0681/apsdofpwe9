package com.free.testspring.camel;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:camel/camel-kafka-consumer.xml" })
public class CamelConsumerTest {

	@Test
	public void testConsumers() throws InterruptedException {
		TimeUnit.HOURS.sleep(1);
	}
}
