package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping
    public void regristerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @PutMapping(path = "{customerId}")
    public void updatetCustomer(@PathVariable("customerId") long customerId, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName ){
        customerService.updateCustomer(customerId, firstName, lastName);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomer(customerId);
    }


}
