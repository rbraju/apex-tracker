package com.rbrcloud.portfoliosrvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortfolioSrvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioSrvcApplication.class, args);
	}

}
