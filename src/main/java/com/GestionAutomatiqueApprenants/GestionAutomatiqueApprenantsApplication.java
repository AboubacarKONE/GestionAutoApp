package com.GestionAutomatiqueApprenants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestionAutomatiqueApprenantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAutomatiqueApprenantsApplication.class, args);
	}

}
