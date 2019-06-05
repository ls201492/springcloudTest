package com.sctoc.microserver.train.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TrainServerApp {

	public static void main(String[] args) {
		SpringApplication.run(TrainServerApp.class);
	}

}
