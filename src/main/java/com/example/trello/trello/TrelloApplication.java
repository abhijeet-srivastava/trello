package com.example.trello.trello;

import com.example.trello.trello.models.Customer;
import com.example.trello.trello.repository.CustomerRepo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class TrelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrelloApplication.class, args);
	}

	@PostConstruct
	private void setTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	@Bean
	public CommandLineRunner demo(CustomerRepo repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", 21l, "Bauer" ));
			repository.save(new Customer("Chloe", 24l,"O'Brian"));
			repository.save(new Customer("Kim", 32l,"Bauer"));
			repository.save(new Customer("David", 27l,"Palmer"));
			repository.save(new Customer("Michelle", 41l, "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L).get();
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLocation("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}


}
