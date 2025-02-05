package com.fadimekaplan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages=("com.fadimekaplan"))
@ComponentScan(basePackages = {"com.fadimekaplan"})
@EnableJpaRepositories(basePackages = {"com.fadimekaplan"})
public class JavaChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaChallengeApplication.class, args);
	}

}
