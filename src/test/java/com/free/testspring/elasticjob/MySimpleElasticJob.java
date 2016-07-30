package com.free.testspring.elasticjob;

import java.util.concurrent.TimeUnit;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;

public class MySimpleElasticJob extends AbstractSimpleElasticJob {

	@Override
	public void process(JobExecutionMultipleShardingContext arg0) {
		System.out.println("execute MySimpleElasticJob start");
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("execute MySimpleElasticJob end");
	}

}
