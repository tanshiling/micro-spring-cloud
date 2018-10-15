package com.bm.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title: ScheduleTask1
 * @Package com.bm.schedule.task
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/9 14:43
 */
@Component
public class ScheduleTask1 {

    private int count = 0;

    @Scheduled(cron = "*/2 * * * * ?")
    private void test1(){
        System.out.println("task 1 running " + (count++));
    }
}
