package com.example.bankserviceoperationsapi;

import com.example.bankserviceoperationsapi.Entity.User;
import com.example.bankserviceoperationsapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
/*
Данный API позволяет манипулировать списком пользователей: добавлять, менять, удалять
 */

@SpringBootApplication
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-authorization.properties")
public class BankServiceOperationsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceOperationsApiApplication.class, args);

	}


	@Bean
	public FlywayMigrationStrategy flywayMigrationStrategy() {
		return flyway -> {
			flyway.baseline();
			flyway.migrate();
		};
	}

}
