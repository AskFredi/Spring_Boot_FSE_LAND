package com.example.demo.data;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer maria = new Customer("Maria", "Hansen");
            Customer stefan = new Customer("Stefan", "Kofler");
            Customer patrick = new Customer("Patrick", "Rietzler");
            Customer frederick = new Customer("Frederick", "Moederndorfer");

            customerRepository.saveAll(List.of(maria, stefan, patrick, frederick));
        };
    }

}
