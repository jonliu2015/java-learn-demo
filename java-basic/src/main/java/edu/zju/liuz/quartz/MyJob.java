package edu.zju.liuz.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Liu.Zheng on 2017/7/6.
 */
public class MyJob implements Job{
    private String jobName;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("liuz test:" + jobExecutionContext.getMergedJobDataMap().get("key1") + jobName);
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
