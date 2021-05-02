package tn.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GymProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymProjectApplication.class, args);
	}

}
