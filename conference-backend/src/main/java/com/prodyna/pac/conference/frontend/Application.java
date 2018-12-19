package com.prodyna.pac.conference.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Import(SpringDataRestConfiguration.class) - does currently not work with Spring 2.0, when SpringFox 3.0 is available, try again
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
