package com.lucasterra.spring_boot_url_shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootUrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUrlShortenerApplication.class, args);
	}

}
