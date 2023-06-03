//package com.melting.job;
//
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.melting.service.CrawlingService;
//
//@Component
//public class CrawlingDeleteJob implements Job {
//	
//	private CrawlingService crawlingService;
//	
////	@Autowired
////    private CrawlingService crawlingService;
//	
//	public CrawlingDeleteJob(CrawlingService crawlingService) {
//		this.crawlingService = crawlingService;
//	}
//
//	@Override
//	public void execute(JobExecutionContext context) throws JobExecutionException {
//		
//        try {
//            crawlingService = (CrawlingService) context.getScheduler().getContext().get("crawlingService");
//        } catch (SchedulerException e) {
//        	
//            throw new JobExecutionException(e);
//        }
//		crawlingService.deleteCrawlingData();
//		
//	}
//}