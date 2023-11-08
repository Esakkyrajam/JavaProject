package com.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.jpa.*")
@EnableJpaRepositories("com.demo.jpa.*")
@EntityScan("com.demo.jpa.*")
public class MyWebAppJpaH2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebAppJpaH2DbApplication.class, args);
	}

}
