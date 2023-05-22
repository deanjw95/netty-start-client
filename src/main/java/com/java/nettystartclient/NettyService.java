package com.java.nettystartclient;

import com.java.nettystartclient.domain.RequestData;
import com.java.nettystartclient.domain.ResponseData;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NettyService {

    private final Bootstrap clientBootstrap;

    public void startClient() throws InterruptedException {
        ChannelFuture future = clientBootstrap.connect("localhost", 8080).sync();
        for (int i = 0; i < 5; i++) {
            try {
                // 5초 동안 실행을 멈춤
                Thread.sleep(5000);
                RequestData msg = new RequestData(i, i + "번째 실행");
                future.channel().writeAndFlush(msg);
                log.info("메세지 전송 : {}", msg);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        future.channel().closeFuture().sync();
    }
}
