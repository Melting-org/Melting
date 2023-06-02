package com.melting.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import com.melting.domain.Crawling;
import com.melting.service.CrawlingService;

public class CrawlingJob implements Job {

	@Autowired
    private CrawlingService crawlingService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	
    	try {
            CrawlingService crawlingService = (CrawlingService) context.getScheduler().getContext().get("crawlingService");
            // 크롤링 작업 수행
            List<Crawling> crawlingDataList = crawlingService.getDcInsideCrawlingData();

            // 데이터 저장
            for (Crawling crawling : crawlingDataList) {
                crawlingService.saveCrawlingData(crawling);
            }

            // 저장된 데이터 삭제
            crawlingService.deleteCrawlingData();
        } catch (SchedulerException e) {
            // SchedulerException 처리
            throw new JobExecutionException(e);
        }
    }
}
