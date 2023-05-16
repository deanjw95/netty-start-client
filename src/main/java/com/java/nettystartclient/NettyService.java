package com.java.nettystartclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NettyService {

    private final Bootstrap clientBootstrap;

    public void startClient() throws InterruptedException {
        ChannelFuture future = clientBootstrap.connect("localhost", 8080).sync();
        future.channel().closeFuture().sync();
    }
}
