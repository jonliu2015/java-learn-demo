package edu.zju.liuz.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Liu.Zheng on 2017/7/6.
 */
public class Main {
    private final static SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

    public static void main(String[] args) throws Exception{
        Scheduler sched = schedFact.getScheduler();

        sched.start();


        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("key1", "use key one")
                .usingJobData("jobName", "kfc")
                .build();

        JobDetail job1 = newJob(MyJob.class)
                .withIdentity("myJob1", "group1")
                .usingJobData("key1", "use key two")
                .usingJobData("jobName", "kfcasdf")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        sched.scheduleJob(job1, trigger);
        System.out.println("------------------------------END-------------------------------");
    }


}
