package com.free.testspring.elasticjob;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.api.listener.AbstractDistributeOnceElasticJobListener;

public class MyOnceElasticJobListener extends AbstractDistributeOnceElasticJobListener {

	public MyOnceElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
		super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
	}

	@Override
	public void doAfterJobExecutedAtLastCompleted(JobExecutionMultipleShardingContext arg0) {
		System.out.println(arg0.getJobName());
	}

	@Override
	public void doBeforeJobExecutedAtLastStarted(JobExecutionMultipleShardingContext arg0) {
		System.out.println(arg0.getJobName());
	}

}
