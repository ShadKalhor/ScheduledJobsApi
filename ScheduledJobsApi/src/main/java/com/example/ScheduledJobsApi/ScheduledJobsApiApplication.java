package com.example.ScheduledJobsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledJobsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledJobsApiApplication.class, args);
	}

}
