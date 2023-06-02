package com.melting.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.melting.service.CrawlingService;

@Component
public class CrawlingDeleteJob implements Job {
	
//	private CrawlingService crawlingService;
	
	@Autowired
    private CrawlingService crawlingService;
	
//	public CrawlingDeleteJob(CrawlingService crawlingService) {
//		this.crawlingService = crawlingService;
//	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		CrawlingService crawlingService = (CrawlingService) context.getScheduler().getContext().get("crawlingService");
		
		crawlingService.deleteCrawlingData();
		
	}
}