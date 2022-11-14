package br.com.rd.ved;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication

public class VedApplication {

	public static void main(String[] args) {
		SpringApplication.run(VedApplication.class, args);
	}

}
