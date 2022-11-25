package iuh.fit.servershopBook.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class ServerShopBookController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String BOOK_URL = "http://localhost:8801/book";
	private static final String AUTHOR_URL = "http://loclhost:8802/author";
	
	private static final String SERVICE_BOOK = "serviceBook";
	
	@GetMapping ("/displayBook")
	@CircuitBreaker(name = SERVICE_BOOK)
	@Retry(name = SERVICE_BOOK)
	public List<Object> serviceBook() {
		String url = BOOK_URL;
		return restTemplate.getForObject(url,ArrayList.class);
	}
	

	    

}
