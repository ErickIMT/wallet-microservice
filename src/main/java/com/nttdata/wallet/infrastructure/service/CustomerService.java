package com.nttdata.wallet.infrastructure.service;

import com.nttdata.wallet.infrastructure.entity.Customer;
import com.nttdata.wallet.infrastructure.entity.TypeId;
import com.nttdata.wallet.infrastructure.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public Mono<Customer> saveCustomer(Customer customer) {
    if (customer.getId().length() == 8) {
      customer.setTypeId(TypeId.DNI);
    } else {
      customer.setTypeId(TypeId.PASAPORTE);
    }

    return customerRepository.save(customer);
  }

  public Mono<Customer> findCustomerById(String id) {

  return customerRepository.findById(id);
  }
}
