/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package quartz.example1;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * This Example will demonstrate how to start and shutdown the Quartz scheduler and how to schedule a job to run in
 * Quartz.
 * 
 * @author Bill Kratzer
 */
public class SimpleExample {

  public void run() throws Exception {
    // 1、创建 Scheduler的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    //2、从工厂中获取调度器
    Scheduler sched = sf.getScheduler();
    // 3、创建JobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    // 时间
    Date runTime = evenSecondDateAfterNow();
    // 4、触发条件
    //Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    Trigger trigger  = newTrigger().withIdentity("trigger1", "group1").startAt(runTime)
        .withSchedule(simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3)).build();
    // 5、注册任务和触发条件
    sched.scheduleJob(job, trigger);

    // 6、启动
    sched.start();


    //
    //
    //try {
    //  // 100秒后停止
    //  Thread.sleep(100L * 1000L);
    //} catch (Exception e) {
    //}
    //sched.shutdown(true);
    //
    //Logger log = LoggerFactory.getLogger(SimpleExample.class);
    //
    //log.info("------- Initializing ----------------------");
    //
    //// First we must get a reference to a scheduler
    //SchedulerFactory sf = new StdSchedulerFactory();
    //Scheduler sched = sf.getScheduler();
    //
    //log.info("------- Initialization Complete -----------");
    //
    //// computer a time that is on the next round minute
    //Date runTime = evenMinuteDate(new Date());
    //
    //log.info("------- Scheduling Job  -------------------");
    //
    //// define the job and tie it to our HelloJob class
    //JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    //
    //// Trigger the job to run on the next round minute
    //Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    //
    //// Tell quartz to schedule the job using our trigger
    //sched.scheduleJob(job, trigger);
    //log.info(job.getKey() + " will run at: " + runTime);
    //
    //// Start up the scheduler (nothing can actually run until the
    //// scheduler has been started)
    //sched.start();
    //
    //log.info("------- Started Scheduler -----------------");
    //
    //// wait long enough so that the scheduler as an opportunity to
    //// run the job!
    //log.info("------- Waiting 65 seconds... -------------");
    //try {
    //  // wait 65 seconds to show job
    //  Thread.sleep(65L * 1000L);
    //  // executing...
    //} catch (Exception e) {
    //  //
    //}
    //
    //// shut down the scheduler
    //log.info("------- Shutting Down ---------------------");
    //sched.shutdown(true);
    //log.info("------- Shutdown Complete -----------------");
  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}
