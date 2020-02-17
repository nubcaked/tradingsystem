package com.liangwei.tradingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TradingsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(TradingsystemApplication.class, args);
	}
}