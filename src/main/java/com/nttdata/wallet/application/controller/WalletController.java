package com.nttdata.wallet.application.controller;

import com.nttdata.wallet.infrastructure.entity.Customer;
import com.nttdata.wallet.infrastructure.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class WalletController {

  @Autowired
  private CustomerService customerService;

  @PostMapping("/customer")
  private Mono<Customer> saveCustomer(@RequestBody Customer customer) {
    return customerService.saveCustomer(customer);
  }

  @GetMapping("/customer/{id}")
  private Mono<ResponseEntity<Customer>> findCustomerById(@PathVariable String id) {
    return  customerService.findCustomerById(id)
      .map(customer -> ResponseEntity.status(HttpStatus.OK).body(customer))
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }


}
