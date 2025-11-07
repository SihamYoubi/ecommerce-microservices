package net.siham.inventoryservice;

import net.siham.inventoryservice.entities.Product;
import net.siham.inventoryservice.repostory.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
		Product product1 = Product.builder().name("P1").price(4500).quantity(7).build();
		productRepository.save(product1);
		productRepository.save(Product.builder().name("P2").price(6789).quantity(8).build());
		productRepository.save(Product.builder().name("P3").price(9357).quantity(2).build());
		};
	};

}
