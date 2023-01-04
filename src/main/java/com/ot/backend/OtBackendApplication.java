package com.ot.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Slf4j
@EnableJpaRepositories
public class OtBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtBackendApplication.class, args);
	}

}
