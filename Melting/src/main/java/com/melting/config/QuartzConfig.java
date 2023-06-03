//package com.melting.config;
//
//import org.quartz.CronScheduleBuilder;
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.melting.job.CrawlingJob;
//import com.melting.job.CrawlingDeleteJob;
//import com.melting.service.CrawlingService;
//
//@Configuration
//public class QuartzConfig {
//	private final CrawlingService crawlingService;
//	
//	@Autowired
//    public QuartzConfig(CrawlingService crawlingService) {
//        this.crawlingService = crawlingService;
//    }
//
//    // saveCrawlingDataJob과 saveCrawlingDataTrigger를 추가
//    @Bean
//    public JobDetail saveCrawlingDataJobDetail() {
//        return JobBuilder.newJob(CrawlingJob.class)
//                .withIdentity("saveCrawlingDataJob")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger saveCrawlingDataTrigger() {
//        return TriggerBuilder.newTrigger()
//                .forJob(saveCrawlingDataJobDetail())
//                .withIdentity("saveCrawlingDataTrigger")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")) // 1분마다 실행
//                .build();
//    }
//
//    // deleteCrawlingDataJob과 deleteCrawlingDataTrigger를 추가
//    @Bean
//    public JobDetail deleteCrawlingDataJobDetail() {
//        return JobBuilder.newJob(CrawlingDeleteJob.class)
//                .withIdentity("deleteCrawlingDataJob")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger deleteCrawlingDataTrigger() {
//        return TriggerBuilder.newTrigger()
//                .forJob(deleteCrawlingDataJobDetail())
//                .withIdentity("deleteCrawlingDataTrigger")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 * 1/1 * ? *")) // 2분마다 실행
//                .build();
//    }
//
//    // 스케줄러 설정
//    @Bean
//    public Scheduler scheduler() throws SchedulerException {
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = schedulerFactory.getScheduler();
//
//        scheduler.getContext().put("crawlingService", crawlingService); // crawlingService를 스케줄러 컨텍스트에 저장
//
//        scheduler.scheduleJob(saveCrawlingDataJobDetail(), saveCrawlingDataTrigger());
//        scheduler.scheduleJob(deleteCrawlingDataJobDetail(), deleteCrawlingDataTrigger());
//
//        scheduler.start();
//
//        return scheduler;
//    }
//    
//    
//
//}
