package com.melting.config;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AutowiringSpringBeanJobFactory implements JobFactory{

	private final ApplicationContext applicationContext;

    @Autowired
    public AutowiringSpringBeanJobFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = bundle.getJobDetail();
        Class<? extends Job> jobClass = jobDetail.getJobClass();
        try {
            return applicationContext.getBean(jobClass);
        } catch (BeansException e) {
            throw new SchedulerException("Failed to instantiate job class", e);
        }
    }
}
