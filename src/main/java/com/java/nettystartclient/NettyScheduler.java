package com.java.nettystartclient;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyScheduler {

    private final NettyService service;

//    @Scheduled(fixedRate = 5000)
//    public void scheduler() throws InterruptedException {
//        service.startClient();
//    }
}
