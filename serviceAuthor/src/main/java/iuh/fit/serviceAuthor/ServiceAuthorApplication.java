package iuh.fit.serviceAuthor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServiceAuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAuthorApplication.class, args);
	}

}
