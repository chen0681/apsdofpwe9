package com.free.testspring.elasticjob;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:elasticjob/elastic-job.xml" })
public class StartElasticJob {

	@Test
	public void startJob() throws InterruptedException {
		TimeUnit.HOURS.sleep(1);
	}
}
