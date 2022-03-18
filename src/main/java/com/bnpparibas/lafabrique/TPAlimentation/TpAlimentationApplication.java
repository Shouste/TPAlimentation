package com.bnpparibas.lafabrique.TPAlimentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableCaching
@EnableWebSecurity
public class TpAlimentationApplication {

	private static final Logger logger
			= LoggerFactory.getLogger(TpAlimentationApplication.class);

	public static void main(String[] args) {

		logger.info("Example log from {}", TpAlimentationApplication.class);
		SpringApplication.run(TpAlimentationApplication.class, args);
	}

}
