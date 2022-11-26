package com.wastesoapapi.wastesoapapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class WastesoapapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WastesoapapiApplication.class, args);
	}

}
