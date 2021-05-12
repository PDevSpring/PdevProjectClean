package com.dari;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EntityScan(basePackages = {"com.dari"})
@EnableAsync
@CrossOrigin(origins = "*")
public class DariApplication { 

	public static void main(String[] args) {
		SpringApplication.run(DariApplication.class, args);
	}
}
