package com.lbenvenutoc.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.util.ResourceUtils;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.r2dbc.spi.ConnectionFactory;

@EnableWebFlux
@SpringBootApplication
public class StudentsApplication {

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

		ConnectionFactoryInitializer connectionFactoryInitializer = new ConnectionFactoryInitializer();
		connectionFactoryInitializer.setConnectionFactory(connectionFactory);
		connectionFactoryInitializer
				.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

		return connectionFactoryInitializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

}
