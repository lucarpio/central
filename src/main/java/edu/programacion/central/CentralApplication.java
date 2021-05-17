package edu.programacion.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentralApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralApplication.class, args);
		System.out.println("Este proyecto se está ejecutando");
	}

}
