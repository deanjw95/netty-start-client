package com.java.nettystartclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NettyStartClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyStartClientApplication.class, args);
	}

}
