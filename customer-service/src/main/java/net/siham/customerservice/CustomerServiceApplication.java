package net.siham.customerservice;

import net.siham.customerservice.config.CustomerConfigParams;
import net.siham.customerservice.entities.Customer;
import net.siham.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (CustomerRepository customerRepository){
        return args -> {
            //ajouter des customers donc la communication avec repository qui permet d'acceder a la BD
            Customer customer1 = Customer.builder().name("Customer1").email("customer1@email.com").build();
            customerRepository.save(customer1);
            customerRepository.save(Customer.builder().name("customer2").email("customer2@email.com").build());
            customerRepository.save(Customer.builder().name("customer3").email("customer3@email.com").build());
        };

    }
}
