package com.example.examenSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;

@SpringBootApplication
public class ExamenSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenSpringApplication.class, args);
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("Zona horaria del servidor: " + zoneId);

	}

}
