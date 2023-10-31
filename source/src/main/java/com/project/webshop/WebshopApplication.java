package com.project.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import com.project.webshop.AppConfig;

@SpringBootApplication
public class WebshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}
}

