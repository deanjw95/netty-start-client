package com.java.nettystartclient.config;

import com.java.nettystartclient.RequestDataEncoder;
import com.java.nettystartclient.ResponseDataDecoder;
import com.java.nettystartclient.handler.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyClientConfig {

    @Bean(destroyMethod = "shutdownGracefully")
    public EventLoopGroup workerGroup() {
        return new NioEventLoopGroup();
    }

    @Bean
    public Bootstrap clientBootstrap() {
        Bootstrap b = new Bootstrap();
        b.group(workerGroup());
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new RequestDataEncoder(), new ResponseDataDecoder(), new ClientHandler());
            }
        });

        return b;
    }
}
