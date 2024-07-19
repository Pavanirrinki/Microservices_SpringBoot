package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
@CrossOrigin(origins = "*")
public class CloudConfigServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudConfigServerApplication.class, args);

	}

	

}
