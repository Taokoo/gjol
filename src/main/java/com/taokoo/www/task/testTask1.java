package com.taokoo.www.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class testTask1 {

    @Scheduled(cron = "*/5 * * * * ?")
    public void handle(){
       System.out.println("定时输出叫伯恩");
    }
}
