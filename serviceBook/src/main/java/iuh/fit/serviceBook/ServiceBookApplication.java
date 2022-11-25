package iuh.fit.serviceBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@EnableCaching
public class ServiceBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBookApplication.class, args); 
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public String defaultMessage()
    {
        return "There were some error in connecting. Please try again later.";
    }

}
