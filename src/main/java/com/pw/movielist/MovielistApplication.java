package com.pw.movielist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovielistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovielistApplication.class, args);
	}

}
