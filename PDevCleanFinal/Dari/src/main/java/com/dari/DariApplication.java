package com.dari;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EntityScan(basePackages = {"com.dari"})
@EnableAsync
public class DariApplication { 

	public static void main(String[] args) {
		SpringApplication.run(DariApplication.class, args);
	}
}
