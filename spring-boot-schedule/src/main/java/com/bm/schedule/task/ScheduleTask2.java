package com.bm.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version V1.0
 * @Title: ScheduleTask1
 * @Package com.bm.schedule.task
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/9 14:43
 */
@Component
public class ScheduleTask2 {

    public static final SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    private void test1(){
        System.out.println("task 2 running " + date.format(new Date()));
    }
}
