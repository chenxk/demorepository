package com.test.quartz;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob implements Job {

	private static Logger log = Logger.getLogger(MyJob.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		//log.info("MyJob is running at time :" + Util.formatDate(new Date()));
		System.out.println(context.getJobRunTime());
		log.info("MyJob is running at time :" + Util.formatDate(context.getFireTime()));
		log.info("MyJob will run at next time :" + Util.formatDate(context.getNextFireTime()));
	}

	public static void main(String[] args) {
		
		
		
		
		try {
			//Date now = new Date();
			//System.out.println(Util.formatDate(now));
			
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(2014, 4, 14, 14, 35, 0);
			
			//log.info(calendar.getTime());
			Date start = calendar.getTime();
			System.out.println(Util.formatDate(start));
			/**
			 * 
			 *  1. * 表示所有值. 例如:在分的字段上设置 "*",表示每一分钟都会触发。
			 *  2. ? 表示不指定值。使用的场景为不需要关心当前设置这个字段的值。例如:要在每月的10号触发一个操作，但不关心是周几，
			 *  	    所以需要周位置的那个字段设置为"?" 具体设置为 0 0 0 10 * ?
			 */
			CronExpression exp = new CronExpression("0 30/25 14-20 * * ?");
			System.out.println("time:" + Util.formatDate(exp.getTimeAfter(start)));
			

			/*
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
					.withIdentity("job1_2", "jGroup1").build();

			// ①-1：创建CronTrigger，指定组及名称

			
			CronTrigger cronTrigger = (CronTrigger) TriggerBuilder
					.newTrigger().startAt(new Date(System.currentTimeMillis() + 1000*10))
					.withIdentity("trigger1_2", "tgroup1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
					.build();
			
			System.out.println("cronTrigger:" + Util.formatDate(cronTrigger.getNextFireTime()));
			
			
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();

			Scheduler scheduler = schedulerFactory.getScheduler();

			scheduler.scheduleJob(jobDetail, cronTrigger);
			//Date now = new Date();
			System.out.println("now:" + Util.formatDate(now));
			System.out.println("cronTrigger:" + Util.formatDate(cronTrigger.getNextFireTime()));
			
			//scheduler.start();
			
			//System.out.println("cronTrigger:" + cronTrigger.getNextFireTime());
			scheduler.shutdown();
			// ②
			
			
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
			scheduleBuilder.build();
			
			
			*/
			
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
