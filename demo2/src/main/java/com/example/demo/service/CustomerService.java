package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("customer with id "+customerId+" does not exists");
        }
        customerRepository.deleteById(customerId);
    }


    public void updateCustomer(Long customerId, String firstName, String lastName){
        Optional<Customer> result = customerRepository.findById(customerId);
        Customer customer = result.get();
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("customer with id " +customerId+ " does not exists");
        }

        if(firstName != null && firstName.length() > 0 && !Objects.equals(customer.getFirstName(), firstName)){
            customer.setFirstName(firstName);
        }
        if(lastName != null && lastName.length() > 0 && !Objects.equals(customer.getLastName(), lastName)){
            customer.setLastName(lastName);
        }
    }




}
